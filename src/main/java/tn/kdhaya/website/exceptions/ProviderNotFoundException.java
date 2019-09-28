package tn.kdhaya.website.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ProviderNotFoundException extends Exception {

    public ProviderNotFoundException(Long id) {
        super("Provider with id = " + id + " is not found !");
    }
}
