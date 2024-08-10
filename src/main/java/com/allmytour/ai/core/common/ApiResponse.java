package com.allmytour.ai.core.common;

import lombok.Getter;
import org.springframework.http.HttpStatusCode;

@Getter
public class ApiResponse<T> {

    private final int responseCode;
    private final String message;
    private T data;

    private static final int SUCCESS = 200;

    private ApiResponse(int responseCode, String message, T data) {
        this.responseCode = responseCode;
        this.message = message;
        this.data = data;
    }
    public ApiResponse(int httpStatusCode, String message) {
        this.responseCode = httpStatusCode;
        this.message = message;
    }

    // 성공 시
    public static <T> ApiResponse<T> okMessage(String message) {
        return new ApiResponse<>(SUCCESS, message);
    }
    public static <T> ApiResponse<T> success(ResponseCode code) {
        return new ApiResponse<>(code.getHttpStatusCode(), code.getMessage(), null);
    }
    public static <T> ApiResponse<T> success(ResponseCode code, T data) {
        return new ApiResponse<>(code.getHttpStatusCode(), code.getMessage(), data);
    }

    // 실패 시
    public static <T> ApiResponse<T> fail(ResponseCode responseCode) {
        return new ApiResponse<>(responseCode.getHttpStatusCode(), responseCode.getMessage());
    }

    public static <T> ApiResponse<T> fail(HttpStatusCode code, String responseMessage) {
        return new ApiResponse<>(code.value(), responseMessage);
    }

    public static <T> ApiResponse<T> fail(ResponseCode responseCode, String responseMessage) {
        return new ApiResponse<>(responseCode.getHttpStatusCode(), responseMessage);
    }
}
