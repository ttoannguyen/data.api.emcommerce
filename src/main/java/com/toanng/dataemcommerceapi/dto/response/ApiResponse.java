package com.toanng.dataemcommerceapi.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApiResponse<T> {
    boolean success;
    T data;
    ApiError error;
    MetaData metadata;
    String timestamp;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ApiError {
        String code;
        String message;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MetaData {
        Integer page;
        Integer size;
        Long total;
    }

}
