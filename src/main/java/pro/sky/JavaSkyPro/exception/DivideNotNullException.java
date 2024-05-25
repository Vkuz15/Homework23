package pro.sky.JavaSkyPro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DivideNotNullException extends IllegalArgumentException {
    public DivideNotNullException() {
        super("На ноль делить нельзя");
    }
}


