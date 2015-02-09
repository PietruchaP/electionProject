package handlers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by ldrygala on 2015-01-28.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClassCastException.class)
    public String handleException() {
        return "error";
    }
}
