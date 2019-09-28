package tn.kdhaya.website.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class SteedNotFoundException extends Exception {
    public SteedNotFoundException(Long id) {
        super("Steed with id = " + id + " is not found !");
    }
}
