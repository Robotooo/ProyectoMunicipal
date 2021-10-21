package org.una.proyecto_Municipal.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.proyecto_Municipal.dto.CobroDTO;
import org.una.proyecto_Municipal.dto.RolDTO;
import org.una.proyecto_Municipal.dto.RutaDTO;
import org.una.proyecto_Municipal.dto.TransaccionDTO;
import org.una.proyecto_Municipal.exceptions.PasswordIsBlankException;
import org.una.proyecto_Municipal.services.ICobroService;
import org.una.proyecto_Municipal.services.ITransaccionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transacciones")
@Api(tags = {"Transacciones"})
public class TransaccionesController {

    @Autowired
    private ITransaccionService transaccionService;

    @ApiOperation(value = "Obtiene un cobro a partir de su id",
            response = TransaccionDTO.class, tags = "Transacciones")
    @GetMapping("/id/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<TransaccionDTO> transaccionFound = transaccionService.findById(id);
        return new ResponseEntity<>(transaccionFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de todas las transacciones",
            response = TransaccionDTO.class, responseContainer = "List", tags = "Transacciones")
    @GetMapping("/{all}")
    @ResponseBody
    public ResponseEntity<?> findAll() {
        Optional<List<TransaccionDTO>> result = transaccionService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody TransaccionDTO transaccionDto) {
        try {
            Optional<TransaccionDTO> transaccionCreated = transaccionService.create(transaccionDto);
            return new ResponseEntity<>(transaccionCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody TransaccionDTO transaccionModified) throws PasswordIsBlankException {
        Optional<TransaccionDTO> transaccionUpdated = transaccionService.update(transaccionModified, id);
        return new ResponseEntity<>(transaccionUpdated, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        transaccionService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() throws Exception {
        transaccionService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    //TODO: findByUsuarioIdAndFechaCreacionBetween, findByRolIdAndFechaCreacionBetween, findByObjetoAndFechaCreacionBetween,
    // findByFechaCreacionBetween
    //El Auditor debe poder ver listados generales de información o transacciones

}