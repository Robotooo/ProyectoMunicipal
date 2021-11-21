package org.una.proyecto_Municipal.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.una.proyecto_Municipal.dto.CobroDTO;
import org.una.proyecto_Municipal.dto.ColaboradorDTO;
import org.una.proyecto_Municipal.dto.FuncionarioDTO;
import org.una.proyecto_Municipal.dto.ParametroDTO;
import org.una.proyecto_Municipal.entities.Parametro;
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
    @PreAuthorize("  hasRole('GERENTE') or hasRole('GESTOR') or hasRole('ADMINISTRADOR')")
    @GetMapping("/id/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<ParametroDTO> parametroFound = parametroService.findById(id);
        return new ResponseEntity<>(parametroFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de todos los parametros",
            response = ParametroDTO.class, responseContainer = "List", tags = "Parametros")
    @PreAuthorize("  hasRole('GERENTE') or hasRole('GESTOR') or hasRole('ADMINISTRADOR')")
    @GetMapping("/{all}/{idFuncionario}")
    @ResponseBody
    public ResponseEntity<?> findAll(@PathVariable(value = "idFuncionario") Long idFuncionario) {
        Optional<List<ParametroDTO>> result = parametroService.findAll(idFuncionario);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @ApiOperation(value = "Obtiene una lista de cobros a partir de su estado",
            responseContainer = "List", response = CobroDTO.class, tags = "Parametros")
    @PreAuthorize("  hasRole('GERENTE') or hasRole('GESTOR') or hasRole('ADMINISTRADOR')")
    @GetMapping("/estado/{estado}/{funId}")
    public ResponseEntity<?> findByEstado(@PathVariable(value = "estado") boolean estado, @PathVariable(value = "funId") Long funId) {
        Optional<List<ParametroDTO>> cobroFound = parametroService.findByEstado(estado,funId);
        return new ResponseEntity<>(cobroFound, HttpStatus.OK);
    }


    @ApiOperation(value = "Obtiene una lista de colaboradors a partir de su nombre",
            response = ColaboradorDTO.class, tags = "Parametros")
    @PreAuthorize("  hasRole('GERENTE') or hasRole('GESTOR') or hasRole('ADMINISTRADOR')")
    @GetMapping("/nombre/{nombre}/{funId}")
    public ResponseEntity<?> findByNombre(@PathVariable(value = "nombre") String nombre, @PathVariable(value = "funId") Long funId) {
        Optional<List<ParametroDTO>> colaboradorFound = parametroService.findByNombre(nombre, funId);
        return new ResponseEntity<>(colaboradorFound, HttpStatus.OK);
    }


    @ApiOperation(value = "Obtiene una lista de parametros a partir de su valor",
            response = ParametroDTO.class, responseContainer = "List", tags = "Parametros")
    @PreAuthorize("  hasRole('GERENTE') or hasRole('GESTOR') or hasRole('ADMINISTRADOR')")
    @GetMapping("/valor/{valor}/{funId}")
    public ResponseEntity<?> findByValor(@PathVariable(value="valor") int valor, @PathVariable(value = "funId") Long funId) {
        Optional<List<ParametroDTO>> parametroFound = parametroService.findByValor(valor,funId);
        return new ResponseEntity<>(parametroFound, HttpStatus.OK);
    }

    @PreAuthorize("  hasRole('GERENTE') or hasRole('GESTOR') or hasRole('ADMINISTRADOR')")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/{funId}")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody ParametroDTO parametroDto, @PathVariable(value = "idFuncionario") Long idFuncionario) {
        try {
            Optional<ParametroDTO> parametroCreated = parametroService.create(parametroDto,idFuncionario);
            return new ResponseEntity<>(parametroCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("  hasRole('GERENTE') or hasRole('GESTOR') or hasRole('ADMINISTRADOR')")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}/{funId}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody ParametroDTO usuarioModified, @PathVariable(value = "funId") Long funId) throws ParseException {
        Optional<ParametroDTO> usuarioUpdated = parametroService.update(usuarioModified, id, funId);
        return new ResponseEntity<>(usuarioUpdated, HttpStatus.OK);
    }

    @PreAuthorize("  hasRole('GERENTE') or hasRole('GESTOR') or hasRole('ADMINISTRADOR')")
    @DeleteMapping("/{id}/{funId}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id, @PathVariable(value = "idFuncionario") Long idFuncionario) throws Exception {
        parametroService.delete(id,idFuncionario);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() throws Exception {
        parametroService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

}
