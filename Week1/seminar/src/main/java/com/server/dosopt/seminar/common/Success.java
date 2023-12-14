package com.server.dosopt.seminar.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum Success {

    /**
     * 201 CREATED
     */
    CREATE_RESERVATION_SUCCESS(HttpStatus.CREATED, "생성에 성공했습니다."),


    /**
     * 200 OK
     */
    GET_SUCESS(HttpStatus.OK, "조회 성공");

    /**
     * 204 NO_CONTENT
     */



    private final HttpStatus httpStatus;
    private final String message;

    public int getHttpStatusCode(){
        return httpStatus.value();
    }

}
