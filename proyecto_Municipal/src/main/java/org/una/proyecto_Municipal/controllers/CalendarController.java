package org.una.proyecto_Municipal.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.una.proyecto_Municipal.dto.CalendarioDTO;
import org.una.proyecto_Municipal.services.ICalendarioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/calendarios")
@Api(tags = {"Calendarios"})
public class CalendarController {
    @Autowired
    private ICalendarioService calendarioService;

    @ApiOperation(value = "Obtiene un calendario a partir de su id",
            response = CalendarioDTO.class, tags = "Calendario")
    @PreAuthorize(" hasRole('AUDITOR') or hasRole('GERENTE') or hasRole('GESTOR') or hasRole('ADMINISTRADOR')")
    @GetMapping("/id/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<CalendarioDTO> calendarioFound = calendarioService.findById(id);
        return new ResponseEntity<>(calendarioFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de calendario a partir de su tipo y año",
            responseContainer = "List", response = CalendarioDTO.class, tags = "Calendario")
    @PreAuthorize(" hasRole('AUDITOR') or hasRole('GERENTE') or hasRole('GESTOR') or hasRole('ADMINISTRADOR')")
    @GetMapping("/tipo/{tipo}/{anio}")
    public ResponseEntity<?> findByTipoAndAnio(@PathVariable(value = "tipo") Integer tipo, @PathVariable(value = "anio") Integer anio) {
        Optional<List<CalendarioDTO>> calendarioFound = calendarioService.findByTipoAndAnio(tipo, anio);
        return new ResponseEntity<>(calendarioFound, HttpStatus.OK);
    }

    @PreAuthorize("  hasRole('GERENTE') or hasRole('ADMINISTRADOR')")
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

    @PreAuthorize("  hasRole('GERENTE') or hasRole('GESTOR')")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody CalendarioDTO calendarioModified) {
        Optional<CalendarioDTO> calendarioUpdated = calendarioService.update(calendarioModified, id);
        return new ResponseEntity<>(calendarioUpdated, HttpStatus.OK);
    }

    @PreAuthorize("  hasRole('GERENTE') or hasRole('ADMINISTRADOR')")
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
