package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
    private Integer errorCode;
    private String errorMessage;
    private String succesMessage;
    private Object obj;
public  static ResponseDTO of(Object  obj){
    ResponseDTO resp=new ResponseDTO();
    resp.setObj(obj);
    return resp;
}
    public  static ResponseDTO of(Object  obj,String succesMessage){
        ResponseDTO resp=new ResponseDTO();
        resp.setObj(obj);
        resp.setSuccesMessage(succesMessage);
        return resp;
    }
    public  static ResponseDTO of(Object  obj,Integer errorCode, String errorMessage){
        ResponseDTO resp=new ResponseDTO();
        resp.setObj(obj);
        resp.setErrorCode(errorCode);
        resp.setErrorMessage(errorMessage);
        return resp;
    }

}
