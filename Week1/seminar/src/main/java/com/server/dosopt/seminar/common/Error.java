package com.server.dosopt.seminar.common;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Error {

    /**
     * 404 NOT FOUND
     */
    NOT_FOUND(HttpStatus.NOT_FOUND, "정보를 찾을 수 없어요"),
    /**
     * 500 INTERNAL_SERVER_ERROR
     */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "알 수 없는 서버 에러가 발생했습니다")
    ;

    private final HttpStatus httpStatus;
    private final String message;

    public int getErrorCode() {
        return httpStatus.value();
    }
}
