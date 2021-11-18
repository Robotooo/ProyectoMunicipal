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
import org.una.proyecto_Municipal.services.IColaboradorService;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/colaboradores")
@Api(tags = {"Colaboradores"})
public class ColaboradorController {

    @Autowired
    private IColaboradorService colaboradorService;

    @ApiOperation(value = "Obtiene un colaborador a partir de su id",
            response = ColaboradorDTO.class, tags = "Colaboradores")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @GetMapping("/id/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) throws ParseException {
        Optional<ColaboradorDTO> colaboradorFound = colaboradorService.findById(id);
        return new ResponseEntity<>(colaboradorFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de todos los colaboradores",
            response = ColaboradorDTO.class, responseContainer = "List", tags = "Colaboradores")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @GetMapping("/{all}")
    @ResponseBody
    public ResponseEntity<?> findAll() throws ParseException {
        Optional<List<ColaboradorDTO>> result = colaboradorService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de colaboradors a partir de su estado",
            response = ColaboradorDTO.class, tags = "Colaboradores")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @GetMapping("/estado/{estado}")
    public ResponseEntity<?> findByEstado(@PathVariable(value = "estado") boolean estado) throws ParseException {
        Optional<List<ColaboradorDTO>> colaboradorFound = colaboradorService.findByEstado(estado);
        return new ResponseEntity<>(colaboradorFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de colaboradors a partir de su nombre",
            response = ColaboradorDTO.class, tags = "Colaboradores")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<?> findByNombre(@PathVariable(value = "nombre") String departamentoName) {
        Optional<List<ColaboradorDTO>> colaboradorFound = colaboradorService.findByNombre(departamentoName);
        return new ResponseEntity<>(colaboradorFound, HttpStatus.OK);

    }

    @ApiOperation(value = "Obtiene una lista de colaboradors a partir de su telefono",
            response = ColaboradorDTO.class, tags = "Colaboradores")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @GetMapping("/telefono/{telefono}")
    public ResponseEntity<?> findByTelefono(@PathVariable(value = "telefono") String telefono) {
        Optional<List<ColaboradorDTO>> colaboradorFound = colaboradorService.findByTelefono(telefono);
        return new ResponseEntity<>(colaboradorFound, HttpStatus.OK);

    }

    @ApiOperation(value = "Obtiene una lista de colaboradors a partir de su cedula",
            response = ColaboradorDTO.class, tags = "Colaboradores")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @GetMapping("/cedula/{cedula}")
    public ResponseEntity<?> findByCedulaAproximate(@PathVariable(value = "cedula") String cedula) {
        Optional<List<ColaboradorDTO>> colaboradorFound = colaboradorService.findByCedulaAproximate(cedula);
        return new ResponseEntity<>(colaboradorFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de cobros a partir de su estado",
            responseContainer = "List", response = CobroDTO.class, tags = "Colaboradores")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @GetMapping("/bien/{bienId}")
    public ResponseEntity<?> findByBienId(@PathVariable(value = "bienId") Long bienId) {
        Optional<List<ColaboradorDTO>> cobroFound = colaboradorService.findByBienId(bienId);
        return new ResponseEntity<>(cobroFound, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Se crea un colaborador", response = ColaboradorDTO.class, tags = "Colaboradores")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody ColaboradorDTO colaboradorDTO) throws ParseException {
        Optional<ColaboradorDTO> colaboradorCreated = colaboradorService.create(colaboradorDTO);
        return new ResponseEntity<>(colaboradorCreated, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody ColaboradorDTO colaboradorModified) throws ParseException {
        Optional<ColaboradorDTO> colaboradorUpdated = colaboradorService.update(colaboradorModified, id);
        return new ResponseEntity<>(colaboradorUpdated, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        colaboradorService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() throws Exception {
        colaboradorService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    //TODO: findByValorImpositivo

    // Cómo autorizar la petición de "eliminación" de un Gestor?
    // El Gerente debe emitir listados generales...?
    // El Admin debe consultar pantallas en desarrollo
    // El Auditor debe ver listados de información o de transacciones
}
