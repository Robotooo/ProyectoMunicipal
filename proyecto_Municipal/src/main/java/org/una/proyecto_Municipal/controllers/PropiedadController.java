package org.una.proyecto_Municipal.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.una.proyecto_Municipal.dto.PropiedadDTO;
import org.una.proyecto_Municipal.services.IPropiedadService;

import java.util.Optional;


@RestController
@RequestMapping("/propiedades")
@Api(tags = {"Propiedades"})
public class PropiedadController {

    private IPropiedadService propiedadService;

    @ApiOperation(value = "Obtiene una propiedad a partir de su id",
            response = PropiedadDTO.class, tags = "Propiedades")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<PropiedadDTO> proveedorFound = propiedadService.findById(id);
        return new ResponseEntity<>(proveedorFound, HttpStatus.OK);
    }

/*
    @ApiOperation(value = "Obtiene una lista de propiedades a partir de su nombre",
            response = PropiedadDTO.class, tags = "Propiedades")
    @GetMapping("/{nombre}")
    public ResponseEntity<?> findByNombre(@PathVariable(value = "nombre") String departamentoName) {
        Optional<List<PropiedadDTO>> proveedorFound = propiedadService.findByNombre(departamentoName);
        return new ResponseEntity<>(proveedorFound, HttpStatus.OK);

    }
*/
    //TODO: create, update, delete, findAll, findByEstado, findByZona

}
