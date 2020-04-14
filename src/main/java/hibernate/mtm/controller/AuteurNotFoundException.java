package hibernate.mtm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason = "cet auteur not found")
public class AuteurNotFoundException extends Exception {
}
