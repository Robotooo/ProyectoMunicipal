package org.una.proyecto_Municipal.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.proyecto_Municipal.dto.FuncionarioDTO;
import org.una.proyecto_Municipal.dto.PropiedadDTO;
import org.una.proyecto_Municipal.exceptions.PasswordIsBlankException;
import org.una.proyecto_Municipal.services.IPropiedadService;

import java.util.Optional;


@RestController
@RequestMapping("/propiedades")
@Api(tags = {"Propiedades"})
public class PropiedadController {

    @Autowired
    private IPropiedadService propiedadService;

    @ApiOperation(value = "Obtiene una propiedad a partir de su id",
            response = PropiedadDTO.class, tags = "Propiedades")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<PropiedadDTO> proveedorFound = propiedadService.findById(id);
        return new ResponseEntity<>(proveedorFound, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody PropiedadDTO propiedadDto) {
        try {
            Optional<PropiedadDTO> propiedadCreated = propiedadService.create(propiedadDto);
            return new ResponseEntity<>(propiedadCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
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



    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody PropiedadDTO usuarioModified) throws PasswordIsBlankException {
        Optional<PropiedadDTO> usuarioUpdated = propiedadService.update(usuarioModified, id);
        return new ResponseEntity<>(usuarioUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        propiedadService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    //TODO: create, update, delete, findAll, findByEstado, findByZona

}
