package tn.kdhaya.website.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class MenuNotFoundException extends Exception {

    public MenuNotFoundException(Long id) {
        super("Menu with id = " + id + " is not found !");
    }
}
