package org.una.proyecto_Municipal.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.una.proyecto_Municipal.dto.FuncionarioDTO;
import org.una.proyecto_Municipal.dto.SolicitudDTO;
import org.una.proyecto_Municipal.exceptions.PasswordIsBlankException;
import org.una.proyecto_Municipal.services.IFuncionarioService;
import org.una.proyecto_Municipal.services.ISolicitudService;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/solicitudes")
@Api(tags = {"Solicitudes"})
public class SolicitudController {

    @Autowired
    private ISolicitudService solicitudService;


    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("  hasRole('GERENTE') or hasRole('GESTOR') or hasRole('ADMINISTRADOR')")
    @PostMapping("/{funId}")
    public ResponseEntity<?> create(@RequestBody SolicitudDTO solicitud, @PathVariable(value = "funId") Long funId) {
        try {
            Optional<SolicitudDTO> usuarioCreated = solicitudService.create(solicitud,funId);
            return new ResponseEntity<>(usuarioCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("  hasRole('GERENTE') or hasRole('GESTOR') or hasRole('ADMINISTRADOR')")
    @PutMapping("/{id}/{funId}")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody SolicitudDTO usuarioModified, @PathVariable(value = "funId") Long funId) throws PasswordIsBlankException, ParseException {
        Optional<SolicitudDTO> usuarioUpdated = solicitudService.update(usuarioModified, id,funId);
        return new ResponseEntity<>(usuarioUpdated, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de todos los funcionarios",
            response = FuncionarioDTO.class, responseContainer = "List", tags = "Solicitudes")
    @PreAuthorize("  hasRole('GERENTE') or hasRole('GESTOR') or hasRole('ADMINISTRADOR')")
    @GetMapping("/{all}/{funId}")
    public ResponseEntity<?> findAll(@PathVariable(value = "funId") Long funId) {
        Optional<List<SolicitudDTO>> result = solicitudService.findAll(funId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de todos los funcionarios",
            response = FuncionarioDTO.class, responseContainer = "List", tags = "Solicitudes")
    @PreAuthorize("  hasRole('GERENTE') or hasRole('GESTOR') or hasRole('ADMINISTRADOR')")
    @GetMapping("/findByRegistroId/{registroId}/{funId}")
    public ResponseEntity<?> findByRegistroId(@PathVariable(value = "registroId") Long registroId,@PathVariable(value = "funId") Long funId) {
        Optional<List<SolicitudDTO>> result = solicitudService.findByRegistroId(registroId,funId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
