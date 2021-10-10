package org.una.proyecto_Municipal.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.http.auth.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.una.proyecto_Municipal.AuthenticationRequest;
import org.una.proyecto_Municipal.AuthenticationResponse;
import org.una.proyecto_Municipal.dto.CobroDTO;
import org.una.proyecto_Municipal.dto.FuncionarioDTO;
import org.una.proyecto_Municipal.exceptions.MissingInputsException;
import org.una.proyecto_Municipal.services.IFuncionarioService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionarios")
@Api(tags = {"Funcionarios"})
public class FuncionarioController {

    @Autowired
    private IFuncionarioService funcionarioService;

    @ApiOperation(value = "Obtiene una lista de todos los funcionarios",
            response = FuncionarioDTO.class, responseContainer = "List", tags = "Funcionarios")
    @GetMapping()
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<FuncionarioDTO>> result = funcionarioService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una funcionario a partir de su id",
            response = FuncionarioDTO.class, tags = "Funcionarios")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<FuncionarioDTO> funcionarioFound = funcionarioService.findById(id);
        return new ResponseEntity<>(funcionarioFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de funcionarios a partir de su estado",
            response = FuncionarioDTO.class, tags = "Funcionarios")
    @GetMapping("/{id}")
    public ResponseEntity<?> findByEstado(@PathVariable(value = "estado") boolean estado) {
        Optional<List<FuncionarioDTO>> funcionarioFound = funcionarioService.findByEstado(estado);
        return new ResponseEntity<>(funcionarioFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Inicio de sesión para conseguir un token de acceso",
            response = FuncionarioDTO.class, tags = "Seguridad")
    @PostMapping("/login")
    @ResponseBody
    @PreAuthorize("hasRole('ADMINISTRADOR') or hasRole('AUDITOR')")
    public ResponseEntity<?> login(@Valid @RequestBody AuthenticationRequest authenticationRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) { throw new MissingInputsException();  }

        AuthenticationResponse authenticationResponse = null;
        try {
            authenticationResponse = funcionarioService.login(authenticationRequest);
        } catch (InvalidCredentialsException e) {
            e.printStackTrace();
        }
        return new ResponseEntity(authenticationResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de funcionarios a partir de su rol",
            response = CobroDTO.class, tags = "Funcionarios")
    @GetMapping("/{id}")
    public ResponseEntity<?> findByRolId(@PathVariable(value = "id") Long id) {
        Optional<List<FuncionarioDTO>> funcionarioFound = funcionarioService.findByRolId(id);
        return new ResponseEntity<>(funcionarioFound, HttpStatus.OK);
    }

}
