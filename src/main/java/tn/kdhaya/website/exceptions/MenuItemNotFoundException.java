package tn.kdhaya.website.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class MenuItemNotFoundException extends Exception {

    public MenuItemNotFoundException(Long id) {
        super("MenuItem with id = " + id + " not found !");
    }
}
