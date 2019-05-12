package com.ccorder.ordersystem.sys.dto;

/**
 * Created by xcd on 2017/4/20.
 */
public class AjaxMessage {
    private String code;
    private String message;
    private Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public AjaxMessage()
    {
        Set(MsgType.Success, "");
    }

    public AjaxMessage Set(MsgType msgtype, String msg, Object obj)
    {
        code = msgtype.toString().toLowerCase();
        message = msg;
        data = obj;

        return this;
    }

    public AjaxMessage Set(MsgType msgtype, Object obj)
    {
        code = msgtype.toString().toLowerCase();
        message = "";
        data = obj;

        return this;
    }

    public AjaxMessage Set(String txtcode, String msg, Object obj)
    {
        code = txtcode;
        message = msg;
        data = obj;

        return this;
    }

    @Override
    public String toString() {
        return "AjaxMessage{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}

