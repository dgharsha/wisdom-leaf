package com.wisdomleaf.codetest.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ErrorDetails {

    private LocalDateTime timestamp;
    private String messages;
    private String details;

}
