package org.una.proyecto_Municipal.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.una.proyecto_Municipal.dto.*;
import org.una.proyecto_Municipal.exceptions.PasswordIsBlankException;
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
            response = TransaccionDTO.class, tags = "Transacciones")
    @PreAuthorize("  hasRole('GERENTE') or hasRole('GESTOR') or hasRole('ADMINISTRADOR')")
    @GetMapping("/id/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id, @PathVariable(value = "idFuncionario") Long idFuncionario) {
        Optional<TransaccionDTO> transaccionFound = transaccionService.findById(id);
        return new ResponseEntity<>(transaccionFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de todas las transacciones",
            response = TransaccionDTO.class, responseContainer = "List", tags = "Transacciones")
    @PreAuthorize("  hasRole('GERENTE') or hasRole('GESTOR') or hasRole('ADMINISTRADOR')")
    @GetMapping("/{all}")
    @ResponseBody
    public ResponseEntity<?> findAll() {
        Optional<List<TransaccionDTO>> result = transaccionService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("  hasRole('GERENTE') or hasRole('GESTOR') or hasRole('ADMINISTRADOR')")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/{idFuncionario}")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody TransaccionDTO transaccionDto, @PathVariable(value = "idFuncionario") Long idFuncionario) {
        try {
            Optional<TransaccionDTO> transaccionCreated = transaccionService.create(transaccionDto,idFuncionario);
            return new ResponseEntity<>(transaccionCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("  hasRole('GERENTE') or hasRole('GESTOR') or hasRole('ADMINISTRADOR')")
    @PutMapping("/{id}/{idFuncionario}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @PathVariable(value = "idFuncionario") Long idFuncionario , @RequestBody TransaccionDTO transaccionModified) throws PasswordIsBlankException {
        Optional<TransaccionDTO> transaccionUpdated = transaccionService.update(transaccionModified, id,idFuncionario);
        return new ResponseEntity<>(transaccionUpdated, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de transacciones a partir del id de Funcionario",
            response = FuncionarioDTO.class, tags = "Transacciones")
    @PreAuthorize("  hasRole('GERENTE') or hasRole('GESTOR') or hasRole('ADMINISTRADOR')")
    @GetMapping("/byFuncionarioId/{idFun}/{idFuncionario}")
    public ResponseEntity<?> findByFuncionarioId(@PathVariable(value = "idFun") Long idFun, @PathVariable(value = "idFuncionario") Long idFuncionario) {
        Optional<List<TransaccionDTO>> transaccionFound = transaccionService.findByFuncionarioId(idFun,idFuncionario);
        return new ResponseEntity<>(transaccionFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de transacciones a partir del id de Funcionario",
            response = FuncionarioDTO.class, tags = "Transacciones")
    @PreAuthorize("  hasRole('GERENTE') or hasRole('GESTOR') or hasRole('ADMINISTRADOR')")
    @GetMapping("/byFuncionarioIdAndFechaCreacionBetween/{idFun}/{startDate}/{endDate}/{idFuncionario}")
    public ResponseEntity<?> findByFuncionarioIdAndFechaCreacionBetween(@PathVariable(value = "idFun") Long idFun, @PathVariable(value = "idFuncionario") Long idFuncionario, @PathVariable(value = "startDate") Date startDate, @PathVariable(value = "endDate")  Date endDate) {
        Optional<List<TransaccionDTO>> transaccionFound = transaccionService.findByFuncionarioIdAndFechaCreacionBetween(idFun,startDate,endDate,idFuncionario);
        return new ResponseEntity<>(transaccionFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de transacciones a partir del id de Funcionario",
            response = FuncionarioDTO.class, tags = "Transacciones")
    @PreAuthorize("  hasRole('GERENTE') or hasRole('GESTOR') or hasRole('ADMINISTRADOR')")
    @GetMapping("/findByObjetoAndFechaCreacionBetween/{objeto}/{startDate}/{endDate}/{idFuncionario}")
    public ResponseEntity<?> findByObjetoAndFechaCreacionBetween(@PathVariable(value = "objeto") String objeto, @PathVariable(value = "idFuncionario") Long idFuncionario, @PathVariable(value = "startDate") Date startDate, @PathVariable(value = "endDate")  Date endDate) {
        Optional<List<TransaccionDTO>> transaccionFound = transaccionService.findByObjetoAndFechaCreacionBetween(objeto,startDate,endDate,idFuncionario);
        return new ResponseEntity<>(transaccionFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de transacciones a partir del id de Funcionario",
            response = FuncionarioDTO.class, tags = "Transacciones")
    @PreAuthorize("  hasRole('GERENTE') or hasRole('GESTOR') or hasRole('ADMINISTRADOR')")
    @GetMapping("/byFechaCreacionBetween/{startDate}/{endDate}/{idFuncionario}")
    public ResponseEntity<?> findByFechaCreacionBetween( @PathVariable(value = "idFuncionario") Long idFuncionario, @PathVariable(value = "startDate") Date startDate, @PathVariable(value = "endDate")  Date endDate) {
        Optional<List<TransaccionDTO>> transaccionFound = transaccionService.findByFechaCreacionBetween(startDate,endDate,idFuncionario);
        return new ResponseEntity<>(transaccionFound, HttpStatus.OK);
    }

    @PreAuthorize("  hasRole('GERENTE') or hasRole('GESTOR') or hasRole('ADMINISTRADOR')")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}/{idFuncionario}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id, @PathVariable(value = "idFuncionario") Long idFuncionario) throws Exception {
        transaccionService.delete(id,idFuncionario);
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