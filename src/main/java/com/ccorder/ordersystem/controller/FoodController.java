package com.ccorder.ordersystem.controller;


import com.ccorder.ordersystem.sys.dto.AjaxMessage;
import com.ccorder.ordersystem.sys.dto.MsgType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zm
 * @description
 * @data 2019/5/12
 */
@Controller
@RequestMapping(value = "/food")
@ResponseBody
public class FoodController {

    @GetMapping("getFoodName")
    public Object getFoodName(){

        return new AjaxMessage().Set(MsgType.Success, "个人中心加载完毕", "hello");
    }
}
