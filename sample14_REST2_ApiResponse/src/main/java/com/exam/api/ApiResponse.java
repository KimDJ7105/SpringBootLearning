package com.exam.api;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ApiResponse<T> {
    boolean success;
    String message;
    T data;

    public static <T> ApiResponse<T> ok(String message,T data) {
        return ApiResponse.<T>builder().data(data).success(true).message(message).build();
    }

    public static <T> ApiResponse<T> fail(String message, T data) {
        return ApiResponse.<T>builder().data(data).success(false).message(message).build();
    }
}
