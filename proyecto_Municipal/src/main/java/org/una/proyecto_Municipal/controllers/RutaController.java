package org.una.proyecto_Municipal.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.una.proyecto_Municipal.dto.RutaDTO;
import org.una.proyecto_Municipal.services.IRutaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rutas")
@Api(tags = {"Rutas"})
public class RutaController {

    private IRutaService rutaService;

    @ApiOperation(value = "Obtiene una ruta a partir de su id",
            response = RutaDTO.class, tags = "Rutas")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<RutaDTO> rutaFound = rutaService.findById(id);
        return new ResponseEntity<>(rutaFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de rutas a partir de su estado",
            response = RutaDTO.class, tags = "Rutas")
    @GetMapping("/{estado}")
    public ResponseEntity<?> findByEstado(@PathVariable(value = "estado") boolean estado) {
        Optional<List<RutaDTO>> rutaFound = rutaService.findByEstado(estado);
        return new ResponseEntity<>(rutaFound, HttpStatus.OK);
    }

//    @ApiOperation(value = "Obtiene una lista de rutas a partir de su bien",
//            response = RutaDTO.class, tags = "Rutas")
//    @GetMapping("/{id}")
//    public ResponseEntity<?> findByBienId(@PathVariable(value = "estado") boolean estado) {
//        Optional<List<RutaDTO>> rutaFound = rutaService.findByBien(estado);
//        return new ResponseEntity<>(rutaFound, HttpStatus.OK);
//    }

    //TODO: create, update, delete, findAll
}
