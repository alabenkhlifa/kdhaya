package tn.kdhaya.website.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ShoreNotFoundException extends Exception {
    public ShoreNotFoundException(Long id) {
        super("Shore with id = " + id + " is not found !");
    }
}
