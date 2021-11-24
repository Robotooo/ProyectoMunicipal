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
import org.una.proyecto_Municipal.dto.LicenciaDTO;
import org.una.proyecto_Municipal.dto.PropiedadDTO;
import org.una.proyecto_Municipal.entities.Propiedad;
import org.una.proyecto_Municipal.exceptions.PasswordIsBlankException;
import org.una.proyecto_Municipal.services.ICobroService;
import org.una.proyecto_Municipal.services.IColaboradorService;
import org.una.proyecto_Municipal.services.IPropiedadService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/propiedades")
@Api(tags = {"Propiedades"})
public class PropiedadController {

    @Autowired
    private IPropiedadService propiedadService;

    @Autowired
    private IColaboradorService colaboradorService;

    @Autowired
    private ICobroService cobroService;

    @ApiOperation(value = "Obtiene una propiedad a partir de su id",
            response = PropiedadDTO.class, tags = "Propiedades")
    @GetMapping("/id/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<PropiedadDTO> propiedadFound = propiedadService.findById(id);
        return new ResponseEntity<>(propiedadFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de todos los propiedades",
            response = PropiedadDTO.class, responseContainer = "List", tags = "Propiedades")
    @GetMapping("/{all}")
    @PreAuthorize("hasRole('GERENTE') or hasRole('GESTOR') or hasRole('BOT') or hasRole('ADMINISTRADOR') or hasRole('AUDITOR')")
    @ResponseBody
    public ResponseEntity<?> findAll() {
        Optional<List<PropiedadDTO>> result = propiedadService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de propiedades a partir de su estado",
            response = PropiedadDTO.class, tags = "Propiedades")
    @GetMapping("/estado/{estado}")
    public ResponseEntity<?> findByEstado(@PathVariable(value = "estado") boolean estado) {
        Optional<List<PropiedadDTO>> propiedadFound = propiedadService.findByEstado(estado);
        return new ResponseEntity<>(propiedadFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de licencias a partir de su bien",
            response = LicenciaDTO.class, tags = "Licencias")
    @GetMapping("/bienId/{bienId}")
    public ResponseEntity<?> findByBienId(@PathVariable(value = "bienId") Long bienId) {
        Optional<List<PropiedadDTO>> licenciaFound = propiedadService.findByBienId(bienId);
        return new ResponseEntity<>(licenciaFound, HttpStatus.OK);
    }

//    @ApiOperation(value = "Obtiene una lista de propiedades a partir de su nombre",
//            response = PropiedadDTO.class, tags = "Propiedades")
//    @GetMapping("/{nombre}")
//    public ResponseEntity<?> findByNombre(@PathVariable(value = "nombre") String departamentoName) {
//        Optional<List<PropiedadDTO>> propiedadFound = propiedadService.findByNombre(departamentoName);
//        return new ResponseEntity<>(propiedadFound, HttpStatus.OK);
//
//    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody PropiedadDTO propiedadDto) {
        try {
            Optional<PropiedadDTO> propiedadCreated = propiedadService.create(propiedadDto);
            return new ResponseEntity<>(propiedadCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody PropiedadDTO usuarioModified) throws PasswordIsBlankException {
        Optional<PropiedadDTO> propiedadUpdated = propiedadService.update(usuarioModified, id);
        return new ResponseEntity<>(propiedadUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        propiedadService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() throws Exception {
        propiedadService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    //TODO: findByZona

}
