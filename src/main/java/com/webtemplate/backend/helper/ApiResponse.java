package com.webtemplate.backend.helper;

import java.io.Serializable;
import com.webtemplate.backend.enums.ResponseType;

public class ApiResponse implements Serializable {

    ResponseType responseType;
    Object returnObject;

    public ApiResponse(ResponseType responseType, Object returnObject) {
        this.responseType = responseType;
        this.returnObject = returnObject;
    }
    

    public ResponseType getResponseType() {
        return this.responseType;
    }

    public void setResponseType(ResponseType responseType) {
        this.responseType = responseType;
    }

    public Object getReturnObject() {
        return this.returnObject;
    }

    public void setReturnObject(Object returnObject) {
        this.returnObject = returnObject;
    }


    public ApiResponse responseType(ResponseType responseType) {
        setResponseType(responseType);
        return this;
    }

    public ApiResponse returnObject(Object returnObject) {
        setReturnObject(returnObject);
        return this;
    }

}
