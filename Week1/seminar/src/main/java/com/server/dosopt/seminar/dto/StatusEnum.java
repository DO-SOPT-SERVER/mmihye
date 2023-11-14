package com.server.dosopt.seminar.dto;

public enum StatusEnum {

    OK(200,"OK",true),
    BAD_REQUEST(400,"BAD_REQUEST",false),
    NOT_FOUND(404,"NOT_FOUNT",false),
    INTERNAL_SERVER_ERROR(500,"INTERNAL_SERVER_ERROR",false);

    int statusCode;
    String code;

    Boolean success;

    StatusEnum(int statusCode, String code, Boolean success) {
        this.statusCode = statusCode;
        this.code = code;
        this.success=success;
    }
}
