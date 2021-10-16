package org.una.proyecto_Municipal.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.proyecto_Municipal.exceptions.MissingInputsException;
import org.una.proyecto_Municipal.exceptions.InformationNotSavedException;
import org.una.proyecto_Municipal.exceptions.NotFoundInformationException;
import org.una.proyecto_Municipal.exceptions.NotImplementedException;

@ControllerAdvice
public class ExceptionHandlerController {


    @ExceptionHandler(MissingInputsException.class)
    public ResponseEntity<?> handleMissingInputsException(MissingInputsException emptyInputException) {
        return new ResponseEntity<>(emptyInputException.getErrorMessage(), emptyInputException.getErrorCode());
    }

    @ExceptionHandler(InformationNotSavedException.class)
    public ResponseEntity<?> handleInformationNotSavedException(InformationNotSavedException noSuchElementException) {
        return new ResponseEntity<>(noSuchElementException.getErrorMessage(), noSuchElementException.getErrorCode());
    }

    @ExceptionHandler(NotFoundInformationException.class)
    public ResponseEntity<?> handleNoFoundInformationException(NotFoundInformationException noSuchElementException) {
        return new ResponseEntity<>(noSuchElementException.getErrorMessage(), noSuchElementException.getErrorCode());
    }

    @ExceptionHandler(NotImplementedException.class)
    public ResponseEntity<?> handleNotImplementedException(NotImplementedException noSuchElementException) {
        return new ResponseEntity<>(noSuchElementException.getErrorMessage(), noSuchElementException.getErrorCode());
    }
}
