package com.test.bankaccount.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserAccountException extends RuntimeException {


    public UserAccountException(String exception) {
        super(exception);
    }
}
