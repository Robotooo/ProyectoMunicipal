package org.una.proyecto_Municipal.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
            response = BienDTO.class, tags = "Bienes")
    @PreAuthorize(" hasRole('AUDITOR') or hasRole('GERENTE') or hasRole('GESTOR')")
    @GetMapping("/id/{id}/{funId}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id, @PathVariable(value = "funId") Long funId) {
        Optional<BienDTO> bienFound = bienService.findById(id,funId);
        return new ResponseEntity<>(bienFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de todos los bienes",
            response = BienDTO.class, responseContainer = "List", tags = "Bienes")
    @PreAuthorize(" hasRole('AUDITOR') or hasRole('GERENTE') or hasRole('GESTOR')")
    @GetMapping("/{all}")
    @ResponseBody
    public ResponseEntity<?> findAll() {
        Optional<List<BienDTO>> result = bienService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('GERENTE') or hasRole('GESTOR')")
    @PostMapping("/{funId}")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody BienDTO bienDto, @PathVariable(value = "funId") Long funId) {
        Optional<BienDTO> bienCreated = bienService.create(bienDto,funId);
        return new ResponseEntity<>(bienCreated, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/{funId}")
    @PreAuthorize(" hasRole('GERENTE') or hasRole('GESTOR')")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody BienDTO bienModified, @PathVariable(value = "funId") Long funId) {
        Optional<BienDTO> bienUpdated = bienService.update(bienModified, id, funId);
        return new ResponseEntity<>(bienUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}/{funId}")
    @PreAuthorize("  hasRole('GERENTE') or hasRole('GESTOR')")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id, @PathVariable(value = "funId") Long funId) throws Exception {
        bienService.delete(id,funId);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() throws Exception {
        bienService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

}
