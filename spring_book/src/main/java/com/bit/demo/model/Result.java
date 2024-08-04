package com.bit.demo.model;


import lombok.Data;

@Data
public class Result {
    //业务码
    private ResultStatus status;
    private String errorMessage;
    private Object data;

    /**
     * 业务执行成功时返回的方法
     *
     * */
    public static Result success(Object data){
        Result result = new Result();
        result.setStatus(ResultStatus.SUCCESS);
        result.setErrorMessage("");
        result.setData(data);
        return result;
    }

    /*
    * 业务执行失败时返回的方法
    * */
    public static Result fail(String message){
        Result result = new Result();
        result.setStatus(ResultStatus.FAIL);
        result.setErrorMessage(message);
        result.setData("");
        return result;
    }

    /*
     * 业务执行失败时返回的方法
     * */
    public static Result unlogin(){
        Result result = new Result();
        result.setStatus(ResultStatus.UNLOGIN);
        result.setErrorMessage("用户未登录");
        result.setData(null);
        return result;
    }
}
