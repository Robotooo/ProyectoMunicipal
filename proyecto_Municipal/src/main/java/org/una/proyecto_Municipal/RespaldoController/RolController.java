package org.una.proyecto_Municipal.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.proyecto_Municipal.dto.RolDTO;
import org.una.proyecto_Municipal.services.IRolService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class RolController {

    private IRolService rolService;

    @ApiOperation(value = "Obtiene un Rol a partir de su id",
            response = RolDTO.class, tags = "Roles")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<RolDTO> rolFound = rolService.findById(id);
        return new ResponseEntity<>(rolFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene un rol a partir de un rango de tiempo con dos fechas",
            response = RolDTO.class, tags = "Roles")
    @GetMapping("/{startDate}")
    public ResponseEntity<?> findByFechaCreacionBetween(@PathVariable(value = "startDate") Date startDate, Date endDate) {
        Optional<List<RolDTO>> rolFound = rolService.findByFechaCreacionBetween(startDate, endDate);
        return new ResponseEntity<>(rolFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Crea un Rol",
            response = RolDTO.class, responseContainer = "List", tags = "Roles")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody RolDTO rolDto) {
        Optional<RolDTO> rolCreated = rolService.create(rolDto); //just Rol
        return new ResponseEntity<>(rolCreated, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody RolDTO rolModified) {
        Optional<RolDTO> rolUpdated = rolService.update(rolModified, id);
        return new ResponseEntity<>(rolUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        rolService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() throws Exception {
        rolService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }
}
