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
    @GetMapping("/id/{id}/{funId}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id,
                                      @PathVariable(value = "funId") Long funId) throws ParseException {
        Optional<ColaboradorDTO> colaboradorFound = colaboradorService.findById(id,funId);
        return new ResponseEntity<>(colaboradorFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de todos los colaboradores",
            response = ColaboradorDTO.class, responseContainer = "List", tags = "Colaboradores")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @GetMapping("/{all}/{funId}")
    @ResponseBody
    public ResponseEntity<?> findAll(@PathVariable(value = "funId") Long funId) throws ParseException {
        Optional<List<ColaboradorDTO>> result = colaboradorService.findAll(funId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de colaboradors a partir de su estado",
            response = ColaboradorDTO.class, tags = "Colaboradores")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @GetMapping("/estado/{estado}/{funId}")
    public ResponseEntity<?> findByEstado(@PathVariable(value = "estado") boolean estado, @PathVariable(value = "funId") Long funId) throws ParseException {
        Optional<List<ColaboradorDTO>> colaboradorFound = colaboradorService.findByEstado(estado, funId);
        return new ResponseEntity<>(colaboradorFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de colaboradors a partir de su nombre",
            response = ColaboradorDTO.class, tags = "Colaboradores")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @GetMapping("/nombre/{nombre}/{funId}")
    public ResponseEntity<?> findByNombre(@PathVariable(value = "nombre") String nombre, @PathVariable(value = "funId") Long funId) {
        Optional<List<ColaboradorDTO>> colaboradorFound = colaboradorService.findByNombre(nombre, funId);
        return new ResponseEntity<>(colaboradorFound, HttpStatus.OK);

    }

    @ApiOperation(value = "Obtiene una lista de colaboradors a partir de su telefono",
            response = ColaboradorDTO.class, tags = "Colaboradores")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @GetMapping("/telefono/{telefono}/{funId}")
    public ResponseEntity<?> findByTelefono(@PathVariable(value = "telefono") String telefono, @PathVariable(value = "funId") Long funId) {
        Optional<List<ColaboradorDTO>> colaboradorFound = colaboradorService.findByTelefono(telefono,funId);
        return new ResponseEntity<>(colaboradorFound, HttpStatus.OK);

    }

    @ApiOperation(value = "Obtiene una lista de colaboradors a partir de su cedula",
            response = ColaboradorDTO.class, tags = "Colaboradores")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @GetMapping("/cedula/{cedula}/{funId}")
    public ResponseEntity<?> findByCedulaAproximate(@PathVariable(value = "cedula") String cedula,
                                                    @PathVariable(value = "funId") Long funId) {
        Optional<List<ColaboradorDTO>> colaboradorFound = colaboradorService.findByCedulaAproximate(cedula,funId);
        return new ResponseEntity<>(colaboradorFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de cobros a partir de su estado",
            responseContainer = "List", response = CobroDTO.class, tags = "Colaboradores")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @GetMapping("/bien/{bienId}/{funId}")
    public ResponseEntity<?> findByBienId(@PathVariable(value = "bienId") Long bienId, @PathVariable(value = "funId") Long funId) {
        Optional<List<ColaboradorDTO>> cobroFound = colaboradorService.findByBienId(bienId,funId);
        return new ResponseEntity<>(cobroFound, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Se crea un colaborador", response = ColaboradorDTO.class, tags = "Colaboradores")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @PostMapping("/{funId}")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody ColaboradorDTO colaboradorDTO, @PathVariable(value = "funId") Long funId) throws ParseException {
        Optional<ColaboradorDTO> colaboradorCreated = colaboradorService.create(colaboradorDTO,funId);
        return new ResponseEntity<>(colaboradorCreated, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @PutMapping("/{id}/{funId}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody ColaboradorDTO colaboradorModified, @PathVariable(value = "funId") Long funId) throws ParseException {
        Optional<ColaboradorDTO> colaboradorUpdated = colaboradorService.update(colaboradorModified, id,funId);
        return new ResponseEntity<>(colaboradorUpdated, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @DeleteMapping("/{id}/{funId}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id, @PathVariable(value = "funId") Long funId) throws Exception {
        colaboradorService.delete(id,funId);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @DeleteMapping("/{funId}")
    public ResponseEntity<?> deleteAll( @PathVariable(value = "funId") Long funId) throws Exception {
        colaboradorService.deleteAll(funId);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    //TODO: findByValorImpositivo

    // Cómo autorizar la petición de "eliminación" de un Gestor?
    // El Gerente debe emitir listados generales...?
    // El Admin debe consultar pantallas en desarrollo
    // El Auditor debe ver listados de información o de transacciones
}
