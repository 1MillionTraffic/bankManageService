package com.onemillion.bankmanager.model.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Getter
@Builder
public class ResultDto {
    private final Object result;
    private final String message;
    @Builder.Default
    private final HttpStatus code = HttpStatus.OK;
    private final Instant responseTime = Instant.now();
}
