package com.productDept.productApi.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoObjectFound  extends RuntimeException{
    private String resource;

    public NoObjectFound(String resource, String feildName, int feildValue) {
        super(String.format("%s is not found with %s: %s",resource,feildName,feildValue));
        this.resource = resource;
        this.feildName = feildName;
        this.feildValue = feildValue;
    }

    public int getFeildValue() {
        return feildValue;
    }

    public String getFeildName() {
        return feildName;
    }

    public String getResource() {
        return resource;
    }

    private String feildName;
    private int feildValue;
}
