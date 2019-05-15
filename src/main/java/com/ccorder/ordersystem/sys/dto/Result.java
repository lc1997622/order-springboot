package com.ccorder.ordersystem.sys.dto;/**
 * Created by zqb on 2017/7/21.
 */

import java.util.List;

/**
 * @author zqb
 * @decription 返回数据格式类
 * @create 2017/7/21
 */
public class Result<T> {
    private int code;

    private String msg;

    //这样才会转换成JSONArray对象[{...}]，方便客户端解析，否则只有jQ能够完成解析
    private List<T> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

}
