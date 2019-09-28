package tn.kdhaya.website.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PromotionNotFoundException extends Exception {

    public PromotionNotFoundException(Long id) {
        super("Promotion with id " + id + " is not found !");
    }
}
