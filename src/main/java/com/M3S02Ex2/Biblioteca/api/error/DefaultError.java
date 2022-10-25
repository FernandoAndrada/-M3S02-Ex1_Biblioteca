package com.M3S02Ex2.Biblioteca.api.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DefaultError {

    private LocalDateTime timestamp;
    private HttpStatus status;
    private String message;




}
