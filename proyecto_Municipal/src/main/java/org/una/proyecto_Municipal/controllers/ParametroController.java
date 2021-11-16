package org.una.proyecto_Municipal.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.una.proyecto_Municipal.dto.FuncionarioDTO;
import org.una.proyecto_Municipal.dto.ParametroDTO;
import org.una.proyecto_Municipal.exceptions.PasswordIsBlankException;
import org.una.proyecto_Municipal.services.IParametroService;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/parametros")
@Api(tags = {"Parametros"})
public class ParametroController {

    @Autowired
    private IParametroService parametroService;

    @ApiOperation(value = "Obtiene un parametro a partir de su id",
            response = ParametroDTO.class, tags = "Parametros")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @GetMapping("/id/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<ParametroDTO> parametroFound = parametroService.findById(id);
        return new ResponseEntity<>(parametroFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de todos los parametros",
            response = ParametroDTO.class, responseContainer = "List", tags = "Parametros")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @GetMapping("/{all}")
    @ResponseBody
    public ResponseEntity<?> findAll() {
        Optional<List<ParametroDTO>> result = parametroService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de parametros a partir de su valor",
            response = ParametroDTO.class, responseContainer = "List", tags = "Parametros")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @GetMapping("/valor/{valor}")
    public ResponseEntity<?> findByValor(@RequestParam(value="valor") int valor) {
        Optional<List<ParametroDTO>> parametroFound = parametroService.findByValor(valor);
        return new ResponseEntity<>(parametroFound, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody ParametroDTO parametroDto) {
        try {
            Optional<ParametroDTO> parametroCreated = parametroService.create(parametroDto);
            return new ResponseEntity<>(parametroCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody ParametroDTO usuarioModified) throws ParseException {
        Optional<ParametroDTO> usuarioUpdated = parametroService.update(usuarioModified, id);
        return new ResponseEntity<>(usuarioUpdated, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        parametroService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() throws Exception {
        parametroService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

}
