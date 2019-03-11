package com.product.demo.utils;



import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> extends Base {
    private int code = 0;
    private String pvid;
    private String msg = "请求已成功处理";
    private T res;

    public enum Code {
        HANDLE_SUCCESS(0), HANDLE_FAILED(-1), TIME_OUT(-2), NEED_APPROVE_PROTOCOL(-88),
        NEED_LOGIN(-101), MISSING_ARGUMENTS(-102),
        WRONG_SIGN(-103), WRONG_ARGUMENTS(-104), INTERNAL_ERROR(-105),
        UNKOWN_ERROR(-106), ILLEGAL_KEYWORD(-107),SELECT_ERR(-3),
        MAINTENANCE(-108), BLOCKED_USER(-110), CLIENT_ERROR(-400);

        private int code;

        Code(int code) {
            this.code = code;
        }

        public int getCode() {
            return this.code;
        }
    }

    public Response(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response(Code code, String msg) {
        this.code = code.getCode();
        this.msg = msg;
    }

    private Response(T res) {
        this.res = res;
    }

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

    public T getRes() {
        return res;
    }

    public void setRes(T res) {
        this.res = res;
    }

    public String getPvid() {
        return pvid;
    }

    public void setPvid(String pvid) {
        this.pvid = pvid;
    }

    public static <V> Response<V> ok(V res) {
        return new Response(res);
    }
    
    public static <V> Response<V> err(V res) {
        return new Response(Code.SELECT_ERR,res.toString());
    }

    public static <V> Response<V> ok(String pvid, V res) {
        Response response = new Response(res);
        response.setPvid(pvid);

        return response;
    }

    public static Response ok() {
        return new Response(Code.HANDLE_SUCCESS, ResultCodes.HANDLE_SUCCESS.getResultMsg());
    }
    
    public static Response err() {
        return new Response(Code.SELECT_ERR, ResultCodes.HANDLE_FAILED.getResultMsg());
    }

}
