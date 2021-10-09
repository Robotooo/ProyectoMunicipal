package org.una.proyecto_Municipal.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Component
public class InvalidCredentialsException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private final HttpStatus errorCode = HttpStatus.UNAUTHORIZED;

    private final String errorMessage = "Usuario o Contrasenia incorrecta";
}
