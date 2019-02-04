package com.weasel.secret.common.protocol;

/**
 * Created by dell on 2017/11/14.
 */
public class CommonResponse<T> {

    private String code;
    private String message;
    private T body;

    public CommonResponse() {
    }

    public CommonResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public CommonResponse(String code, String message, T body) {
        this.code = code;
        this.message = message;
        this.body = body;
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

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
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

    public static <T> CommonResponse<T> buildSuccess(String message,T body){
        return new CommonResponse("0000",message,body);
    }

    public static CommonResponse buildFail(String message){
        return new CommonResponse("0001",message);
    }

    public static <T> CommonResponse<T> buildFail(String message,T body){
        return new CommonResponse("0001",message,body);
    }
}
