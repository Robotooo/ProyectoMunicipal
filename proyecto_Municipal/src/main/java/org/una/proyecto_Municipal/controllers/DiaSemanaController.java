package org.una.proyecto_Municipal.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.proyecto_Municipal.dto.DiaSemanaDTO;
import org.una.proyecto_Municipal.services.IDiaSemanaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/diasemana")
@Api(tags = {"DiaSemana"})
public class DiaSemanaController {

    @Autowired
    private IDiaSemanaService diasemanaService;

    @ApiOperation(value = "Obtiene un dia de semana a partir de su id",
            response = DiaSemanaDTO.class, tags = "Dia Semanas")
    @GetMapping("/id/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<DiaSemanaDTO> diasemanaFound = diasemanaService.findById(id);
        return new ResponseEntity<>(diasemanaFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de todos los dias de semanas",
            response = DiaSemanaDTO.class, responseContainer = "List", tags = "Dia Semanas")
    @GetMapping("/{all}")
    @ResponseBody
    public ResponseEntity<?> findAll() {
        Optional<List<DiaSemanaDTO>> result = diasemanaService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody DiaSemanaDTO diasemanaDto) {
        Optional<DiaSemanaDTO> diasemanaCreated = diasemanaService.create(diasemanaDto);
        return new ResponseEntity<>(diasemanaCreated, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody DiaSemanaDTO diasemanaModified) {
        Optional<DiaSemanaDTO> diasemanaUpdated = diasemanaService.update(diasemanaModified, id);
        return new ResponseEntity<>(diasemanaUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        diasemanaService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() throws Exception {
        diasemanaService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

}
