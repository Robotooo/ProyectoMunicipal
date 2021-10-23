package org.una.proyecto_Municipal.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.proyecto_Municipal.dto.CategoriaxPropiedadDTO;
import org.una.proyecto_Municipal.services.ICategoriaxPropiedadService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoriaxpropiedad")
@Api(tags = {"CategoriaxPropiedad"})
public class CategoriaxPropiedadController {

    @Autowired
    private ICategoriaxPropiedadService categoriaxpropiedadService;

    @ApiOperation(value = "Obtiene una categoria de una propiedad a partir de su id",
            response = CategoriaxPropiedadDTO.class, tags = "Categorias Propiedades")
    @GetMapping("/id/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<CategoriaxPropiedadDTO> categoriaFound = categoriaxpropiedadService.findById(id);
        return new ResponseEntity<>(categoriaFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de todos las categorias por propiedades",
            response = CategoriaxPropiedadDTO.class, responseContainer = "List", tags = "Categorias Propiedades")
    @GetMapping("/{all}")
    @ResponseBody
    public ResponseEntity<?> findAll() {
        Optional<List<CategoriaxPropiedadDTO>> result = categoriaxpropiedadService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody CategoriaxPropiedadDTO categoriapropiedadDto) {
        Optional<CategoriaxPropiedadDTO> categoriapropiedadCreated = categoriaxpropiedadService.create(categoriapropiedadDto);
        return new ResponseEntity<>(categoriapropiedadCreated, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody CategoriaxPropiedadDTO categoriapropiedadModified) {
        Optional<CategoriaxPropiedadDTO> categoriapropiedadUpdated = categoriaxpropiedadService.update(categoriapropiedadModified, id);
        return new ResponseEntity<>(categoriapropiedadUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        categoriaxpropiedadService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() throws Exception {
        categoriaxpropiedadService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

}
