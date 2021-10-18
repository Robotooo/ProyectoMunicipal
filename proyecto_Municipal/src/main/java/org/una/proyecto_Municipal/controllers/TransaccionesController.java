package org.una.proyecto_Municipal.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.proyecto_Municipal.dto.CobroDTO;
import org.una.proyecto_Municipal.dto.RolDTO;
import org.una.proyecto_Municipal.dto.TransaccionDTO;
import org.una.proyecto_Municipal.services.ICobroService;
import org.una.proyecto_Municipal.services.ITransaccionService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transacciones")
@Api(tags = {"Transacciones"})
public class TransaccionesController {

    @Autowired
    private ITransaccionService transaccionService;

    @ApiOperation(value = "Obtiene un cobro a partir de su id",
            response = CobroDTO.class, tags = "Transacciones")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<TransaccionDTO> transaccionFound = transaccionService.findById(id);
        return new ResponseEntity<>(transaccionFound, HttpStatus.OK);
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

    @ApiOperation(value = "Obtiene una transaccion a partir de un rango de tiempo con dos fechas",
            response = TransaccionDTO.class, tags = "Transacciones")
    @GetMapping("/{startDate}")
    public ResponseEntity<?> findByFechaCreacionBetween(@PathVariable(value = "startDate") Date startDate, Date endDate) {
        Optional<List<TransaccionDTO>> transaccionFound = transaccionService.findByFechaCreacionBetween(startDate, endDate);
        return new ResponseEntity<>(transaccionFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una transaccion a partir de un rango de tiempo con dos fechas",
            response = TransaccionDTO.class, tags = "Transacciones")
    @GetMapping("/{usuarioId}")
    public ResponseEntity<?> findByUsuarioIdAndFechaCreacionBetween(@PathVariable(value = "usuarioId") Long usuarioId, Date startDate, Date endDate) {
        Optional<List<TransaccionDTO>> transaccionFound = transaccionService.findByUsuarioIdAndFechaCreacionBetween(usuarioId,startDate, endDate);
        return new ResponseEntity<>(transaccionFound, HttpStatus.OK);
    }
    @ApiOperation(value = "Obtiene una transaccion a partir de un rango de tiempo con dos fechas",
            response = TransaccionDTO.class, tags = "Transacciones")
    @GetMapping("/{rolId}")
    public ResponseEntity<?> findByRolIdAndFechaCreacionBetween(@PathVariable(value = "rolId") Long rolId, Date startDate, Date endDate) {
        Optional<List<TransaccionDTO>> transaccionFound = transaccionService.findByRolIdAndFechaCreacionBetween(rolId,startDate, endDate);
        return new ResponseEntity<>(transaccionFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una transaccion a partir de un rango de tiempo con dos fechas",
            response = TransaccionDTO.class, tags = "Transacciones")
    @GetMapping("/{objeto}")
    public ResponseEntity<?> findByObjetoAndFechaCreacionBetween(@PathVariable(value = "objeto") String objeto, Date startDate, Date endDate) {
        Optional<List<TransaccionDTO>> transaccionFound = transaccionService.findByObjetoAndFechaCreacionBetween(objeto,startDate, endDate);
        return new ResponseEntity<>(transaccionFound, HttpStatus.OK);
    }


    //TODO:
}