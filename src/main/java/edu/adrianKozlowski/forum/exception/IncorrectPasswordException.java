/**
 * Created by Adrian Kozłowski on 06.08.2018
 */
package edu.adrianKozlowski.forum.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Incorrect password!")
public class IncorrectPasswordException extends RuntimeException {
    
    private static final long serialVersionUID = -5692096819031290349L;
    
}
