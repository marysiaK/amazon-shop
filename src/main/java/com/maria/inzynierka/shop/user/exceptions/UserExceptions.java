package com.maria.inzynierka.shop.user.exceptions;

import lombok.extern.log4j.Log4j2;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

@ControllerAdvice
@Log4j2
public class UserExceptions {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NoSuchElementException.class, EmptyResultDataAccessException.class})
    public void handleNotFound() {
        log.warn("Smb. try to call un-existing user - let's ignore...");
    }

}
