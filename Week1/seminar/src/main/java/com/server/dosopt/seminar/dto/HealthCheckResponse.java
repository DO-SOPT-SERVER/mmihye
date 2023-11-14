package com.server.dosopt.seminar.dto;

import lombok.Data;
import lombok.Getter;

//@Getter
//public class HealthCheckResponse {
//
//    private static final String STATUS = "OK";
//    private String status;
//
//    public HealthCheckResponse() {
//        this.status = STATUS;
//    }
//}

@Getter
public class HealthCheckResponse {

    private Integer code;
    private String status;
    private Boolean success;


    public HealthCheckResponse(StatusEnum status) {
        this.code = status.statusCode;
        this.status = status.code;
        this.success = status.success;
    }
}