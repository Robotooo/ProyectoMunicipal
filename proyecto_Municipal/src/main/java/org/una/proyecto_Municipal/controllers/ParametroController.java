package org.una.proyecto_Municipal.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.proyecto_Municipal.dto.ParametroDTO;
import org.una.proyecto_Municipal.services.IParametroService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/parametros")
@Api(tags = {"Parametros"})
public class ParametroController {

    @Autowired
    private IParametroService parametroService;

    @ApiOperation(value = "Obtiene un parametro a partir de su id",
            response = ParametroDTO.class, tags = "Parametros")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<ParametroDTO> parametroFound = parametroService.findById(id);
        return new ResponseEntity<>(parametroFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de parametros a partir de su estado",
            response = ParametroDTO.class, tags = "Parametros")
    @GetMapping("/{estado}")
    public ResponseEntity<?> findByEstado(@PathVariable(value = "estado") boolean estado) {
        Optional<List<ParametroDTO>> parametroFound = parametroService.findByEstado(estado);
        return new ResponseEntity<>(parametroFound, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody ParametroDTO parametroDto) {
        try {
            Optional<ParametroDTO> parametroCreated = parametroService.create(parametroDto);
            return new ResponseEntity<>(parametroCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //TODO: create, update, delete, findAll

}
