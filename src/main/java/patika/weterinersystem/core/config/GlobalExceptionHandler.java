package patika.weterinersystem.core.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import patika.weterinersystem.core.exception.AlreadyExistException;
import patika.weterinersystem.core.exception.NotFoundException;
import patika.weterinersystem.core.result.Result;
import patika.weterinersystem.core.result.ResultData;
import patika.weterinersystem.core.utilies.ResultHelper;

import java.util.List;
import java.util.stream.Collectors;
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Result> handleNotFoundException(NotFoundException e){
        return new ResponseEntity<>(ResultHelper.notFoundError(e.getMessage()), HttpStatus.NOT_FOUND);
    }
    // Değerlendirme Formu 25
    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<Result> handleAlreadyExistException(AlreadyExistException e){
        return new ResponseEntity<>(ResultHelper.alreadyExist(e.getMessage()), HttpStatus.ALREADY_REPORTED);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResultData<List<String>>> handleValidationErrors(MethodArgumentNotValidException e){
        List<String> validationErrorList = e.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());
        return new ResponseEntity<>(ResultHelper.validateError(validationErrorList), HttpStatus.BAD_REQUEST);
    }
}
