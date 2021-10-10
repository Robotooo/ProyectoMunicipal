package org.una.proyecto_Municipal.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.proyecto_Municipal.dto.TransaccionDTO;
import org.una.proyecto_Municipal.exceptions.NotFoundInformationException;
import org.una.proyecto_Municipal.services.ITransaccionService;
import org.una.proyecto_Municipal.utils.MapperUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class TransaccionController {

    private ITransaccionService transaccionService;

    @ApiOperation(value = "Obtiene una transaccion a partir de su id",
            response = TransaccionDTO.class, tags = "Transacciones")
    @GetMapping("/{id}")
    public Optional<TransaccionDTO> findById(@PathVariable(value = "id") Long id) {
        Optional<TransaccionDTO> transaccion = transaccionService.findById(id);
        if (transaccion.isEmpty()) throw new NotFoundInformationException();

        TransaccionDTO transaccionDTO = MapperUtils.DtoFromEntity(transaccion.get(), TransaccionDTO.class);
        return Optional.ofNullable(transaccionDTO);
    }

    @ApiOperation(value = "Obtiene una lista de transacciones a partir de su fecha de creacion",
            response = TransaccionDTO.class, tags = "Transacciones")
    @GetMapping("/{id}")
    public ResponseEntity<?> findByUsuarioIdAndFechaCreacionBetween(@PathVariable(value = "id") Long usuarioId, Date startDate, Date endDate) {
        Optional<List<TransaccionDTO>> transaccionFound = transaccionService.findByUsuarioIdAndFechaCreacionBetween(usuarioId,startDate,endDate);
        return new ResponseEntity<>(transaccionFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de transacciones a partir de su rol y fecha de creacion",
            response = TransaccionDTO.class, tags = "Transacciones")
    @GetMapping("/{id}")
    public ResponseEntity<?> findByRolIdAndFechaCreacionBetween(@PathVariable(value = "id") Long rolId, Date startDate, Date endDate) {
        Optional<List<TransaccionDTO>> transaccionFound = transaccionService.findByRolIdAndFechaCreacionBetween(rolId,startDate,endDate);
        return new ResponseEntity<>(transaccionFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de transacciones a partir de su fecha de creacion y objeto",
            response = TransaccionDTO.class, tags = "Transacciones")
    @GetMapping("/{id}")
    public ResponseEntity<?> findByObjetoAndFechaCreacionBetween(@PathVariable(value = "id") String objetoId, Date startDate, Date endDate) {
        Optional<List<TransaccionDTO>> transaccionFound = transaccionService.findByObjetoAndFechaCreacionBetween(objetoId,startDate,endDate);
        return new ResponseEntity<>(transaccionFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de transacciones a partir de su fecha de creacion",
            response = TransaccionDTO.class, tags = "Transacciones")
    @GetMapping("/{id}")
    public ResponseEntity<?> findByFechaCreacionBetween(@PathVariable(value = "id") Date startDate, Date endDate) {
        Optional<List<TransaccionDTO>> transaccionFound = transaccionService.findByFechaCreacionBetween(startDate,endDate);
        return new ResponseEntity<>(transaccionFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Crea una Transaccion",
            response = TransaccionDTO.class, responseContainer = "List", tags = "Transacciones")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody TransaccionDTO transaccionDTO) {
        Optional<TransaccionDTO> transaccionCreated = transaccionService.create(transaccionDTO);
        return new ResponseEntity<>(transaccionCreated, HttpStatus.CREATED);
    }
}
