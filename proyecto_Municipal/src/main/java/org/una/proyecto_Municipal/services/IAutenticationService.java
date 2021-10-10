package org.una.proyecto_Municipal.services;

import org.apache.http.auth.InvalidCredentialsException;
import org.una.proyecto_Municipal.dto.AuthenticationRequest;
import org.una.proyecto_Municipal.dto.AuthenticationResponse;

public interface IAutenticationService {

    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) throws InvalidCredentialsException;

}
