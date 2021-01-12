package com.jeevan.bank.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private T resultData;
    private String message;
    private Boolean success;
    private Long totalCount;

}
