package tech.devinhouse.labschoolapi.config;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import tech.devinhouse.labschoolapi.web.ErroResponse;
import tech.devinhouse.labschoolapi.exception.Found;
import tech.devinhouse.labschoolapi.exception.NotFound;

import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Found.class)
    public ResponseEntity<Object> handleRegistroExistenteException(Found e) {
        ErroResponse erro = new ErroResponse(e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }

    @ExceptionHandler(NotFound.class)
    public ResponseEntity<Object> handleRegistroNaoEncontradoException(NotFound e) {
        ErroResponse erro = new ErroResponse(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex) {
        Map<String, String> fieldErrors = new HashMap<>();
        ex.getConstraintViolations().forEach(e -> {
            Iterator<Path.Node> iterator = e.getPropertyPath().iterator();
            String fieldName = null;
            while(iterator.hasNext()) {
                fieldName = iterator.next().getName();
            }
            String errorMessage = e.getMessage();
            fieldErrors.put(fieldName, errorMessage);
        });
        ErroResponse erro = new ErroResponse("Erro de validação", fieldErrors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, String> fieldErrors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            fieldErrors.put(fieldName, errorMessage);
        });
        ErroResponse erro = new ErroResponse("Erro de validação", fieldErrors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }


    @Override   // catch any other exception for standard error message handling
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErroResponse erro = new ErroResponse(ex.getMessage());
        return new ResponseEntity<>(erro, headers, status);
    }

}
