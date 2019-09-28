package tn.kdhaya.website.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ShoreCategoryNotFoundException extends Exception {

    public ShoreCategoryNotFoundException(Long id) {
        super("Shore Category with id = " + id + " is not found !");
    }
}
