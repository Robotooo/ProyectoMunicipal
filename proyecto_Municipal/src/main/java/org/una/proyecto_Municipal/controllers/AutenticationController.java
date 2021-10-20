package org.una.proyecto_Municipal.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.http.auth.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.una.proyecto_Municipal.dto.AuthenticationRequest;
import org.una.proyecto_Municipal.dto.AuthenticationResponse;
import org.una.proyecto_Municipal.dto.FuncionarioDTO;
import org.una.proyecto_Municipal.exceptions.MissingInputsException;
import org.una.proyecto_Municipal.services.IAutenticationService;

import javax.validation.Valid;

@RestController
@RequestMapping("/autentication")
@Api(tags = {"Autentication"})
public class AutenticationController {

    @Autowired
    private IAutenticationService autenticationService;

    @ApiOperation(value = "Inicio de sesión para conseguir un token de acceso",
            response = FuncionarioDTO.class, tags = "Seguridad")
    @PostMapping("")
    @ResponseBody
    public ResponseEntity<?> login(@Valid @RequestBody AuthenticationRequest authenticationRequest, BindingResult bindingResult) throws InvalidCredentialsException {
        if (bindingResult.hasErrors()) { throw new MissingInputsException();  }
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        AuthenticationResponse token = autenticationService.login(authenticationRequest);
        if (token.getJwt() != null) {
            return new ResponseEntity(autenticationService.login(authenticationRequest), HttpStatus.OK);
        } else {
            throw new InvalidCredentialsException();
        }
    }
}