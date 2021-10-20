package org.una.proyecto_Municipal.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.proyecto_Municipal.dto.BienDTO;
import org.una.proyecto_Municipal.services.IBienService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bienes")
@Api(tags = {"Bienes"})
public class BienController {

    @Autowired
    private IBienService bienService;

    @ApiOperation(value = "Obtiene un bien a partir de su id",
            response = BienDTO.class, tags = "Cobros")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<BienDTO> bienFound = bienService.findById(id);
        return new ResponseEntity<>(bienFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de todos los bienes",
            response = BienDTO.class, responseContainer = "List", tags = "Bienes")
    @GetMapping("/{all}")
    @ResponseBody
    public ResponseEntity<?> findAll() {
        Optional<List<BienDTO>> result = bienService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody BienDTO bienDto) {
        Optional<BienDTO> bienCreated = bienService.create(bienDto);
        return new ResponseEntity<>(bienCreated, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody BienDTO bienModified) {
        Optional<BienDTO> bienUpdated = bienService.update(bienModified, id);
        return new ResponseEntity<>(bienUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        bienService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() throws Exception {
        bienService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

}
