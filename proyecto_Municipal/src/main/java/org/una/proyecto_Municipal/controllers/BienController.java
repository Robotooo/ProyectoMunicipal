package org.una.proyecto_Municipal.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.una.proyecto_Municipal.dto.BienDTO;
import org.una.proyecto_Municipal.services.IBienService;

import java.util.Optional;

public class BienController {

    private IBienService bienService;

    @ApiOperation(value = "Obtiene un bien a partir de su id",
            response = BienDTO.class, tags = "Cobros")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<BienDTO> bienFound = bienService.findById(id);
        return new ResponseEntity<>(bienFound, HttpStatus.OK);
    }


}
