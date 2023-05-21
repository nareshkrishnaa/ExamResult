/* (C)2023 */
package com.naresh.examresult.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class PasswordNotMatchingException extends RuntimeException {
    public PasswordNotMatchingException(String message) {
        super(message);
    }
}
