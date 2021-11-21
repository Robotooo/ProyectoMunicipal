package org.una.proyecto_Municipal.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.proyecto_Municipal.dto.FuncionarioDTO;
import org.una.proyecto_Municipal.dto.SolicitudDTO;
import org.una.proyecto_Municipal.exceptions.PasswordIsBlankException;
import org.una.proyecto_Municipal.services.IFuncionarioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/solicitudes")
@Api(tags = {"Solicitudes"})
public class SolicitudController {

    @Autowired
    private IFuncionarioService funcionarioService;


    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/{funId}")
    public ResponseEntity<?> create(@RequestBody SolicitudDTO solicitud, @PathVariable(value = "funId") Long funId) {
        try {
            Optional<SolicitudDTO> usuarioCreated = funcionarioService.createSolicitud(solicitud,funId);
            return new ResponseEntity<>(usuarioCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}/{funId}")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody SolicitudDTO usuarioModified, @PathVariable(value = "funId") Long funId) throws PasswordIsBlankException {
        Optional<SolicitudDTO> usuarioUpdated = funcionarioService.updateSolicitud(usuarioModified, id,funId);
        return new ResponseEntity<>(usuarioUpdated, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de todos los funcionarios",
            response = FuncionarioDTO.class, responseContainer = "List", tags = "Solicitudes")
    @GetMapping("/{all}/{funId}")
    public ResponseEntity<?> findAll(@PathVariable(value = "funId") Long funId) {
        Optional<List<SolicitudDTO>> result = funcionarioService.findAllSolicitud(funId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
