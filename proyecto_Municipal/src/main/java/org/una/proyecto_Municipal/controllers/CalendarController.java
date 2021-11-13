package org.una.proyecto_Municipal.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.una.proyecto_Municipal.dto.CalendarioDTO;
import org.una.proyecto_Municipal.dto.ParametroDTO;
import org.una.proyecto_Municipal.services.ICalendarioService;
import org.una.proyecto_Municipal.services.IParametroService;

import java.util.Optional;

@RestController
@RequestMapping("/calendarios")
@Api(tags = {"Calendarios"})
public class CalendarController {
    @Autowired
    private ICalendarioService calendarioService;

    @ApiOperation(value = "Obtiene un calendario a partir de su id",
            response = ParametroDTO.class, tags = "Parametros")
    @GetMapping("/id/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<CalendarioDTO> calendarioFound = calendarioService.findById(id);
        return new ResponseEntity<>(calendarioFound, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody CalendarioDTO calendarioDto) {
        try {
            Optional<CalendarioDTO> calendarioCreated = calendarioService.create(calendarioDto);
            return new ResponseEntity<>(calendarioCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody CalendarioDTO calendarioModified) {
        Optional<CalendarioDTO> calendarioUpdated = calendarioService.update(calendarioModified, id);
        return new ResponseEntity<>(calendarioUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        calendarioService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() throws Exception {
        calendarioService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

}
