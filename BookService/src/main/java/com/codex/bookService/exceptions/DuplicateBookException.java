package com.codex.bookService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DuplicateBookException extends RuntimeException{
    public DuplicateBookException(String msg) {
        super(msg);
    }

}
