package org.una.proyecto_Municipal.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import org.una.proyecto_Municipal.dto.CobroDTO;
import org.una.proyecto_Municipal.dto.FuncionarioDTO;

import org.una.proyecto_Municipal.dto.SolicitudDTO;
import org.una.proyecto_Municipal.exceptions.PasswordIsBlankException;
import org.una.proyecto_Municipal.services.IFuncionarioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionarios")
@Api(tags = {"Funcionarios"})
public class FuncionarioController {

    @Autowired
    private IFuncionarioService funcionarioService;

    @ApiOperation(value = "Obtiene una funcionario a partir de su id",
            response = FuncionarioDTO.class, tags = "Funcionarios")
    @PreAuthorize("hasRole('ADMINISTRADOR') or hasRole('AUDITOR') or hasRole('GESTOR') or hasRole('GERENTE')")
    @GetMapping("/id/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<FuncionarioDTO> funcionarioFound = funcionarioService.findById(id);
        return new ResponseEntity<>(funcionarioFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de funcionarios a partir de su estado",
            response = FuncionarioDTO.class, responseContainer = "List", tags = "Funcionarios")
    @PreAuthorize("hasRole('ADMINISTRADOR') or hasRole('AUDITOR')")
    @GetMapping("/estado/{estado}")
    public ResponseEntity<?> findByEstado(@PathVariable(value = "estado") boolean estado) {
        Optional<List<FuncionarioDTO>> funcionarioFound = funcionarioService.findByEstado(estado);
        return new ResponseEntity<>(funcionarioFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de todos los funcionarios",
            response = FuncionarioDTO.class, responseContainer = "List", tags = "Funcionarios")
    @GetMapping("/{all}")
    public ResponseEntity<?> findAll() {
        Optional<List<FuncionarioDTO>> result = funcionarioService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una funcionario a partir de su nombre usuario",
            response = FuncionarioDTO.class, tags = "Funcionarios")
    @GetMapping("/usuario/{usuario}")
    public ResponseEntity<?> findByUsuario(@PathVariable(value = "usuario") String usuario) {
        Optional<List<FuncionarioDTO>> funcionarioFound = funcionarioService.findByUsuario(usuario);
        return new ResponseEntity<>(funcionarioFound, HttpStatus.OK);
    }


    @ApiOperation(value = "Obtiene un funcionario a partir de su cedula",
            response = FuncionarioDTO.class, tags = "Funcionarios")
    @GetMapping("/cedula/{cedula}")
    public ResponseEntity<?> findByCedula(@PathVariable(value = "cedula") String cedula) {
        Optional<FuncionarioDTO> funcionarioFound = funcionarioService.findByCedula(cedula);
        return new ResponseEntity<>(funcionarioFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de funcionarios a partir de su rol",
            response = FuncionarioDTO.class, tags = "Funcionarios")
    @GetMapping("/rolId/{rol}")
    public ResponseEntity<?> findByRolId(@PathVariable(value = "rol") Long rol) {
        Optional<List<FuncionarioDTO>> funcionarioFound = funcionarioService.findByRolId(rol);
        return new ResponseEntity<>(funcionarioFound, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody FuncionarioDTO funcionarioDTO) {
        try {
            Optional<FuncionarioDTO> usuarioCreated = funcionarioService.create(funcionarioDTO);
            return new ResponseEntity<>(usuarioCreated, HttpStatus.CREATED);
        } catch (Exception | PasswordIsBlankException e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/solicitud/")
    public ResponseEntity<?> createSolicitud(@RequestBody SolicitudDTO solicitud) {
        try {
            Optional<SolicitudDTO> usuarioCreated = null;// = funcionarioService.create(solicitud);
            return new ResponseEntity<>(usuarioCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody FuncionarioDTO usuarioModified) throws PasswordIsBlankException {
        Optional<FuncionarioDTO> usuarioUpdated = funcionarioService.update(usuarioModified, id);
        return new ResponseEntity<>(usuarioUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        funcionarioService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @DeleteMapping("/")
    @ResponseBody
    public ResponseEntity<?> deleteAll() throws Exception {
        funcionarioService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

}
