package com.weasel.secret.common.protocol;

/**
 * Created by dell on 2017/11/14.
 */
public class CommonResponse {

    private String code;
    private String message;

    public CommonResponse() {
    }

    public CommonResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

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

    public boolean success(){
        return "0000" == getCode();
    }
    public boolean notSuccess(){
        return !success();
    }

    public static CommonResponse buildSuccess(String message){
        return new CommonResponse("0000",message);
    }

    public static CommonResponse buildFail(String message){
        return new CommonResponse("0001",message);
    }
}
