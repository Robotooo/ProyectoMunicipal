package org.una.proyecto_Municipal.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.proyecto_Municipal.dto.BienxColaboradorDTO;
import org.una.proyecto_Municipal.services.IBienxColaboradorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bienes_colaboradores")
@Api(tags = {"Bienes_Colaboradores"})
public class BienxColaboradorController {

    @Autowired
    private IBienxColaboradorService bienxcolaboradorService;

    @ApiOperation(value = "Obtiene una lista de bienes por colaborador a partir de su bien",
            response = BienxColaboradorDTO.class, tags = "Bienes por Colaborador")
    @GetMapping("/{id}")
    public ResponseEntity<?> findByBienId(@PathVariable(value = "id") Long id) {
        Optional<List<BienxColaboradorDTO>> bienxcolaboradorFound = bienxcolaboradorService.findByBienId(id);
        return new ResponseEntity<>(bienxcolaboradorFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de bienes por colaborador a partir de su colaborador",
            response = BienxColaboradorDTO.class, responseContainer = "List", tags = "Bienes por Colaborador")
    @GetMapping("/colaboradorId/{colaboradorId}")
    public ResponseEntity<?> findByColaboradorId(@PathVariable(value = "id") Long id) {
        Optional<List<BienxColaboradorDTO>> bienxcolaboradorFound = bienxcolaboradorService.findByColaboradorId(id);
        return new ResponseEntity<>(bienxcolaboradorFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene un bien a partir de su id",
            response = BienxColaboradorDTO.class, tags = "Bienes por Colaborador")
    @GetMapping("/id/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<BienxColaboradorDTO> bienFound = bienxcolaboradorService.findById(id);
        return new ResponseEntity<>(bienFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de todos los bienes",
            response = BienxColaboradorDTO.class, responseContainer = "List", tags = "Bienes por Colaborador")
    @GetMapping("/{all}")
    @ResponseBody
    public ResponseEntity<?> findAll() {
        Optional<List<BienxColaboradorDTO>> result = bienxcolaboradorService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody BienxColaboradorDTO bienDto) {
        Optional<BienxColaboradorDTO> bienCreated = bienxcolaboradorService.create(bienDto);
        return new ResponseEntity<>(bienCreated, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody BienxColaboradorDTO bienModified) {
        Optional<BienxColaboradorDTO> bienUpdated = bienxcolaboradorService.update(bienModified, id);
        return new ResponseEntity<>(bienUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        bienxcolaboradorService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() throws Exception {
        bienxcolaboradorService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

}
