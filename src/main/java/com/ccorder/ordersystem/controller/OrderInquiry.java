package com.ccorder.ordersystem.orderOpterations;

import com.ccorder.ordersystem.entity.Food;
import com.ccorder.ordersystem.entity.OrderTable;
import com.ccorder.ordersystem.entity.SysRole;
import com.ccorder.ordersystem.entity.SysUser;
import com.ccorder.ordersystem.entity.mapEntity.MapOrderFood;
import com.ccorder.ordersystem.entity.mapEntity.MapUserFood;
import com.ccorder.ordersystem.entity.mapEntity.MapUserRole;
import com.ccorder.ordersystem.mapper.FoodMapper;
import com.ccorder.ordersystem.mapper.OrderTableMapper;
import com.ccorder.ordersystem.mapper.SysRoleMapper;
import com.ccorder.ordersystem.mapper.SysUserMapper;
import com.ccorder.ordersystem.mapper.mapMapper.MapOrderFoodMapper;
import com.ccorder.ordersystem.mapper.mapMapper.MapUserFoodMapper;
import com.ccorder.ordersystem.mapper.mapMapper.MapUserRoleMapper;
import com.ccorder.ordersystem.sys.dto.AjaxMessage;
import com.ccorder.ordersystem.sys.dto.MsgType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/order")
@Api(tags = "订单查询API")
public class OrderInquiry {
    @Autowired
    private MapUserRoleMapper mapUserRoleMapper;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private MapUserFoodMapper mapUserFoodMapper;

    @Autowired
    private FoodMapper foodMapper;

    @Autowired
    private OrderTableMapper orderTableMapper;

    @Autowired
    private MapOrderFoodMapper mapOrderFoodMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    private String orderNum;
    private List<String> foodList=null;
    private List<Integer> statusList=null;

    @ApiOperation(value = "商家进行的总的订单的查询")
    @GetMapping("/inquiry")
    @ResponseBody
    public Object inquiry(
            @ApiParam(name = "userId", value = "微信用户的id", required = true,type = "String")
            @RequestParam
                    String userId
    ){
        /*
         * 订单状态：
         * 0 代表未支付
         * 1 代表等待接单
         * 2 配送中
         * 3 已完成
         */
        //查询数据库找到对象的role_id
        MapUserRole mapUserRole= mapUserRoleMapper.selectByUserId(userId);
        String roleId=mapUserRole.getRoleId();
        //通过role_id找到对应的code
        SysRole sysRole= sysRoleMapper.selectByPrimaryKey(roleId);
        String code=sysRole.getCode();
        //通过code判断是商家还是用户
        if(!code.equals("")){
            return new AjaxMessage().Set(MsgType.Error,"你没有此权限");
        }
        //返回查询到某个商家的所有记录
        MapUserFood[] userFoodList=mapUserFoodMapper.selctByuserId(userId);
        //将该商家的所有出售的食品存放在一个foodlist中
        foodList=new ArrayList<String>();
        //将该商家所有订单的订单状态存放在statusList中
        statusList=new ArrayList<Integer>();
       //进行list的填充
        for (MapUserFood mapUserFood : userFoodList) {
            statusList.add(mapUserFood.getStatus());
            foodList.add(foodMapper.selectByPrimaryKey(mapUserFood.getFoodId()).getFoodName());
        }

        try {
            return new AjaxMessage().Set(MsgType.Success,"查询成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        return new AjaxMessage().Set(MsgType.Success,"查询失败");
    }

    //确切的订单查询
    @ApiOperation(value = "商家进行的总的订单的查询")
    @GetMapping("/which")
    @ResponseBody
    public Object inquiry(
            @ApiParam(name = "id", value = "订单顺序的id", required = true,type = "String")
            @RequestParam
                    String id,
            @ApiParam(name = "userId", value = "微信用户的id", required = true,type = "String")
            @RequestParam
                    String userId,
            @ApiParam(name = "orderNum", value = "订单的编号", required = true,type = "String")
            @RequestParam
                    String orderNum

    ){
        OrderTable orderTable=orderTableMapper.selectByPrimaryKey(id);
        MapOrderFood mapOrderFood=mapOrderFoodMapper.selectByPrimaryKey(id);
        Food food=foodMapper.selectByPrimaryKey(mapOrderFood.getFoodId());
        SysUser sysUser=sysUserMapper.selectByPrimaryKey(orderTable.getCreateUserId());
        //返回订单状态
        orderTable.getStatus();
        //返回商品数量
        mapOrderFood.getAmount();
        //返回商品的价格
        orderTable.getActualPayment();
        //返回商品的名称
        food.getFoodName();
        //返回用户（收货人）名称
        sysUser.getNickName();
        //返回电话号
        sysUser.getTelephone();
        //返回收货地址
        orderTable.getAddress();
        //返回送达时间
        try {
            return new AjaxMessage().Set(MsgType.Success,"查询成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        return new AjaxMessage().Set(MsgType.Success,"查询失败");
    }
}
