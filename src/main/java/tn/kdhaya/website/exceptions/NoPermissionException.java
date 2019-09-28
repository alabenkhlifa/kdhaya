package tn.kdhaya.website.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class NoPermissionException extends Exception {

    public NoPermissionException(String explanation) {
        super("You don't have permission to " + explanation + " !");
    }
}
