package com.allmytour.ai.core.common;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum ResponseCode {

    /**
     * 응답 실패처리 common
     */
    SUCCESS(200, true, "요청 성공"),
    // 400 Bad Request
    BAD_REQUEST(404, false, "잘못된 요청입니다."),
    INTERNAL_SERVER_ERROR(500, false, "서버에 오류가 발생하였습니다."),


    /** 4000번대
     *  JWT 토큰 관련 응답 및 에러 코드
     */
    JWT_SUCCESS(4200, true , "success JWT Authorization"),
    JWT_INVALID(4401, false, "Invalid JWT Token"),
    JWT_EXPIRED(4402, false, "Expired JWT Token"),
    JWT_FORBIDDEN(4403, false, "토큰 권한 없음"),
    JWT_UNAUTHORIZED(4404, false, "인가받지 않은 토큰"),
    JWT_EMPTY(4405, false, "JWT claims string is empty."),
    JWT_FAIL_REISSUE(4406, false, "refresh 토큰 정보 없음"),


    /**
     *  1000 번대 -> 회원 관련 응답 및 에러 코드
     */
    // 200 OK
    MEMBER_LOGIN_SUCCESS(1200, true, "로그인 되었습니다."),

    ;


    private final int code;
    private final Boolean success;
    private final String message;

    public int getHttpStatusCode() {
        return code;
    }
}
