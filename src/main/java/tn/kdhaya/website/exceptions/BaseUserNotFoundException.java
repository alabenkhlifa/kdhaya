package tn.kdhaya.website.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class BaseUserNotFoundException extends Exception {
    public BaseUserNotFoundException(Long id) {
        super("Base User with id = " + id + " is not found !");
    }

}
