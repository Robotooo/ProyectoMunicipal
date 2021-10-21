package org.una.proyecto_Municipal.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.proyecto_Municipal.dto.FuncionarioDTO;
import org.una.proyecto_Municipal.dto.LicenciaDTO;
import org.una.proyecto_Municipal.exceptions.PasswordIsBlankException;
import org.una.proyecto_Municipal.services.ILicenciaService;
//import org.una.proyecto_Municipal.services.ILicenciaService;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/licencias")
@Api(tags = {"Licencias"})
public class LicenciaController {

    @Autowired
    private ILicenciaService licenciaService;

    @ApiOperation(value = "Obtiene una liciencia a partir de su id",
                response = LicenciaDTO.class, tags = "Licencias")
    @GetMapping("/id/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<LicenciaDTO> proveedorFound = licenciaService.findById(id);
        return new ResponseEntity<>(proveedorFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de licencias a partir de su estado",
            response = LicenciaDTO.class, responseContainer = "List", tags = "Licencias")
    @GetMapping("/estado/{estado}")
    public ResponseEntity<?> findByEstado(@PathVariable(value = "estado") boolean estado) {
        Optional<List<LicenciaDTO>> proveedorFound = licenciaService.findByEstado(estado);
        return new ResponseEntity<>(proveedorFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de licencias a partir de su nombre",
            response = LicenciaDTO.class, tags = "Licencias")
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<?> findByNombre(@PathVariable(value = "nombre") String nombre) {
        Optional<List<LicenciaDTO>> licenciaFound = licenciaService.findByNombre(nombre);
        return new ResponseEntity<>(licenciaFound, HttpStatus.OK);

    }

    @ApiOperation(value = "Obtiene una lista de licencias a partir de su telefono",
            response = LicenciaDTO.class, tags = "Licencias")
    @GetMapping("/telefono/{telefono}")
    public ResponseEntity<?> findByTelefono(@PathVariable(value = "telefono") String telefono) {
        Optional<LicenciaDTO> licenciaFound = licenciaService.findByTelefono(telefono);
        return new ResponseEntity<>(licenciaFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de licencias a partir de su email",
            response = LicenciaDTO.class, tags = "Licencias")
    @GetMapping("/email/{email}")
    public ResponseEntity<?> findByEmail(@PathVariable(value = "email") String email) {
        Optional<LicenciaDTO> licenciaFound = licenciaService.findByEmail(email);
        return new ResponseEntity<>(licenciaFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de licencias a partir de su bien",
            response = LicenciaDTO.class, tags = "Licencias")
    @GetMapping("/bien_id/{bien_id}")
    public ResponseEntity<?> findByBienId(@PathVariable(value = "bien") Long id) {
        Optional<List<LicenciaDTO>> licenciaFound = licenciaService.findByBienId(id);
        return new ResponseEntity<>(licenciaFound, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody LicenciaDTO licenciaDTO) {
        try {
            Optional<LicenciaDTO> licenciaCreated = licenciaService.create(licenciaDTO);
            return new ResponseEntity<>(licenciaCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody LicenciaDTO licenciaModified) {
        Optional<LicenciaDTO> licenciaUpdated = licenciaService.update(licenciaModified, id);
        return new ResponseEntity<>(licenciaUpdated, HttpStatus.OK);
    }

    //TODO: create, update, delete, findAll, findByEstado

}
