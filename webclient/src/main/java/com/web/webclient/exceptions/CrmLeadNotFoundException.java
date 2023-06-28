package com.web.webclient.exceptions;

public class CrmLeadNotFoundException extends RuntimeException {

    public CrmLeadNotFoundException(String message){
        super(message);
    }
}
