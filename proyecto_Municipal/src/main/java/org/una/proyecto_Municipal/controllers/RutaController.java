package org.una.proyecto_Municipal.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.proyecto_Municipal.dto.*;
import org.una.proyecto_Municipal.exceptions.PasswordIsBlankException;
import org.una.proyecto_Municipal.services.ICobroService;
import org.una.proyecto_Municipal.services.IColaboradorService;
import org.una.proyecto_Municipal.services.IRutaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rutas")
@Api(tags = {"Rutas"})
public class RutaController {

    @Autowired
    private IRutaService rutaService;

    @Autowired
    private IColaboradorService colaboradorService;

    @Autowired
    private ICobroService cobroService;

    @ApiOperation(value = "Obtiene una ruta a partir de su id",
            response = RutaDTO.class, tags = "Rutas")
    @GetMapping("/id/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<RutaDTO> rutaFound = rutaService.findById(id);
        return new ResponseEntity<>(rutaFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de todas las rutas",
            response = RutaDTO.class, responseContainer = "List", tags = "Rutas")
    @GetMapping("/{all}")
    @ResponseBody
    public ResponseEntity<?> findAll() {
        Optional<List<RutaDTO>> result = rutaService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de rutas a partir de su estado",
            response = RutaDTO.class, tags = "Rutas")
    @GetMapping("/estado/{estado}")
    public ResponseEntity<?> findByEstado(@PathVariable(value = "estado") boolean estado) {
        Optional<List<RutaDTO>> rutaFound = rutaService.findByEstado(estado);
        return new ResponseEntity<>(rutaFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de rutas a partir de su bien",
            response = RutaDTO.class, tags = "Rutas")
    @GetMapping("/bienes_id/{bienes_id}")
    public ResponseEntity<?> findByBienId(@PathVariable(value = "bienes_id") Long id) {
        Optional<List<RutaDTO>> bienFound = rutaService.findByBienId(id);
        return new ResponseEntity<>(bienFound, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody RutaDTO rutaDto) {
        try {
            Optional<RutaDTO> rutaCreated = rutaService.create(rutaDto);
            return new ResponseEntity<>(rutaCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody RutaDTO usuarioModified) throws PasswordIsBlankException {
        Optional<RutaDTO> usuarioUpdated = rutaService.update(usuarioModified, id);
        return new ResponseEntity<>(usuarioUpdated, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        rutaService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() throws Exception {
        rutaService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

}
