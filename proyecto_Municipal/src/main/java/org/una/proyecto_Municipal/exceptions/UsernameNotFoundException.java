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
public class UsernameNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private final HttpStatus errorCode = HttpStatus.BAD_REQUEST;

    private final String errorMessage = "Faltan datos por digitar";
}
