package faheem.microservices.springcustomvalidations.exceptionhandlers;

import faheem.microservices.springcustomvalidations.exceptions.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST) //when bad request occurs
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String , String> handleInvalideArguments(MethodArgumentNotValidException e){
        Map<String ,String> errorMap = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(error->
                errorMap.put(error.getField(),error.getDefaultMessage()));
        return errorMap;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public String userNotFound(UserNotFoundException e){
        log.error("UserNotFoundException occured!");
        log.info("Exception message : {}",e.getMessage());
       return e.getMessage();
    }
}
