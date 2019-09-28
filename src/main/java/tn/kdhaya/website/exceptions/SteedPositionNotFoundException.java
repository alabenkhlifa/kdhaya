package tn.kdhaya.website.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class SteedPositionNotFoundException extends Exception {

    public SteedPositionNotFoundException(Long id) {
        super("Steed Position with id = " + id + " is not found !");
    }
}
