package org.una.proyecto_Municipal.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.proyecto_Municipal.dto.CategoriaBasuraDTO;
import org.una.proyecto_Municipal.services.ICategoriaBasuraService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoriabasura")
@Api(tags = {"CategoriaBasura"})
public class CategoriaBasuraController {

    @Autowired
    private ICategoriaBasuraService categoriabasuraService;

    @ApiOperation(value = "Obtiene una categoria de basura a partir de su id",
            response = CategoriaBasuraDTO.class, tags = "Categorias Basura")
    @GetMapping("/id/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<CategoriaBasuraDTO> categoriaFound = categoriabasuraService.findById(id);
        return new ResponseEntity<>(categoriaFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de todos las categorias de basura",
            response = CategoriaBasuraDTO.class, responseContainer = "List", tags = "Categorias Basura")
    @GetMapping("/{all}")
    @ResponseBody
    public ResponseEntity<?> findAll() {
        Optional<List<CategoriaBasuraDTO>> result = categoriabasuraService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody CategoriaBasuraDTO categoriabasuraDto) {
        Optional<CategoriaBasuraDTO> categoriabasuraCreated = categoriabasuraService.create(categoriabasuraDto);
        return new ResponseEntity<>(categoriabasuraCreated, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody CategoriaBasuraDTO categoriabasuraModified) {
        Optional<CategoriaBasuraDTO> categoriabasuraUpdated = categoriabasuraService.update(categoriabasuraModified, id);
        return new ResponseEntity<>(categoriabasuraUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        categoriabasuraService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() throws Exception {
        categoriabasuraService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

}
