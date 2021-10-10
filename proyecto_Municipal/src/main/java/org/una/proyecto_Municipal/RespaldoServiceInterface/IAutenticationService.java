package org.una.proyecto_Municipal.services;

import org.apache.http.auth.InvalidCredentialsException;
import org.una.proyecto_Municipal.AuthenticationRequest;
import org.una.proyecto_Municipal.AuthenticationResponse;

public interface IAutenticationService {

    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) throws InvalidCredentialsException;

}
