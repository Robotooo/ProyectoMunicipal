package org.una.proyecto_Municipal.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.proyecto_Municipal.dto.DeclaracionAnualDTO;
import org.una.proyecto_Municipal.services.IDeclaracionAnualService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/declaracionanual")
@Api(tags = {"DeclaracionAnual"})
public class DeclaracionAnualController {

    @Autowired
    private IDeclaracionAnualService declaracionanualService;

    @ApiOperation(value = "Obtiene una decalracion anual a partir de su id",
            response = DeclaracionAnualDTO.class, tags = "Declaraciones Anuales")
    @GetMapping("/id/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<DeclaracionAnualDTO> declaracionanualFound = declaracionanualService.findById(id);
        return new ResponseEntity<>(declaracionanualFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de todos las declaraciones anuales",
            response = DeclaracionAnualDTO.class, responseContainer = "List", tags = "Declaraciones Anuales")
    @GetMapping("/{all}")
    @ResponseBody
    public ResponseEntity<?> findAll() {
        Optional<List<DeclaracionAnualDTO>> result = declaracionanualService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody DeclaracionAnualDTO declaracionanualDto) {
        Optional<DeclaracionAnualDTO> declaracionanualCreated = declaracionanualService.create(declaracionanualDto);
        return new ResponseEntity<>(declaracionanualCreated, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody DeclaracionAnualDTO declaracionanualModified) {
        Optional<DeclaracionAnualDTO> declaracionanualUpdated = declaracionanualService.update(declaracionanualModified, id);
        return new ResponseEntity<>(declaracionanualUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        declaracionanualService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() throws Exception {
        declaracionanualService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

}
