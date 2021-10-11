package org.una.proyecto_Municipal.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.una.proyecto_Municipal.dto.LicenciaDTO;
//import org.una.proyecto_Municipal.services.ILicenciaService;


import java.util.List;
import java.util.Optional;

public class LicenciaController {

    //@Autowired
//    private ILicenciaService licenciaService;
//
//    @ApiOperation(value = "Obtiene una liciencia a partir de su id",
//                response = LicenciaDTO.class, tags = "Licencias")
//    @GetMapping("/{id}")
//    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
//        Optional<LicenciaDTO> proveedorFound = licenciaService.findById(id);
//        return new ResponseEntity<>(proveedorFound, HttpStatus.OK);
//    }
//
//    @ApiOperation(value = "Obtiene una lista de licencias a partir de su estado",
//            response = LicenciaDTO.class, tags = "Licencias")
//    @GetMapping("/{estado}")
//    public ResponseEntity<?> findByEstado(@PathVariable(value = "estado") boolean estado) {
//        Optional<List<LicenciaDTO>> proveedorFound = licenciaService.findByEstado(estado);
//        return new ResponseEntity<>(proveedorFound, HttpStatus.OK);
//    }
//
//    @ApiOperation(value = "Obtiene una lista de licencias a partir de su nombre",
//            response = LicenciaDTO.class, tags = "Licencias")
//    @GetMapping("/{nombre}")
//    public ResponseEntity<?> findByNombre(@PathVariable(value = "departamentoName") String nombre) {
//        Optional<List<LicenciaDTO>> licenciaFound = licenciaService.findByNombre(nombre);
//        return new ResponseEntity<>(licenciaFound, HttpStatus.OK);
//
//    }
//
//    @ApiOperation(value = "Obtiene una lista de licencias a partir de su telefono",
//            response = LicenciaDTO.class, tags = "Licencias")
//    @GetMapping("/{telefono}")
//    public ResponseEntity<?> findByTelefono(@PathVariable(value = "telefono") String telefono) {
//        Optional<LicenciaDTO> licenciaFound = licenciaService.findByTelefono(telefono);
//        return new ResponseEntity<>(licenciaFound, HttpStatus.OK);
//    }
//
//    @ApiOperation(value = "Obtiene una lista de licencias a partir de su email",
//            response = LicenciaDTO.class, tags = "Licencias")
//    @GetMapping("/{email}")
//    public ResponseEntity<?> findByEmail(@PathVariable(value = "email") String email) {
//        Optional<LicenciaDTO> licenciaFound = licenciaService.findByEmail(email);
//        return new ResponseEntity<>(licenciaFound, HttpStatus.OK);
//    }
//
//    @ApiOperation(value = "Obtiene una lista de licencias a partir de su bien",
//            response = LicenciaDTO.class, tags = "Licencias")
//    @GetMapping("/{email}")
//    public ResponseEntity<?> findByBienId(@PathVariable(value = "bien") Long id) {
//        Optional<List<LicenciaDTO>> licenciaFound = licenciaService.findByBienId(id);
//        return new ResponseEntity<>(licenciaFound, HttpStatus.OK);
//    }

    //TODO: create, update, delete, findAll, findByEstado

}
