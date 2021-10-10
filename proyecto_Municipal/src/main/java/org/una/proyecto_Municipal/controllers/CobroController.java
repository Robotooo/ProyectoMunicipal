package org.una.proyecto_Municipal.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.una.proyecto_Municipal.dto.CobroDTO;
import org.una.proyecto_Municipal.services.ICobroService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cobros")
@Api(tags = {"Cobros"})
public class CobroController {

    private ICobroService cobroService;

    @ApiOperation(value = "Obtiene un cobro a partir de su id",
            response = CobroDTO.class, tags = "Cobros")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<CobroDTO> cobroFound = cobroService.findById(id);
        return new ResponseEntity<>(cobroFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de cobros a partir de su bien",
            response = CobroDTO.class, tags = "Cobros")
    @GetMapping("/{id}")
    public ResponseEntity<?> findByBienId(@PathVariable(value = "id") Long id) {
        Optional<List<CobroDTO>> cobroFound = cobroService.findByBienId(id);
        return new ResponseEntity<>(cobroFound, HttpStatus.OK);
    }

//    @ApiOperation(value = "Obtiene una lista de cobros a partir de su contribuyente",
//            response = CobroDTO.class, tags = "Cobros")
//    @GetMapping("/{id}")
//    public ResponseEntity<?> findByContribuyenteId(@PathVariable(value = "id") Long id) {
//        Optional<List<CobroDTO>> cobroFound = cobroService.findByColaboradorId(id);
//        return new ResponseEntity<>(cobroFound, HttpStatus.OK);
//    }

//    @ApiOperation(value = "Obtiene una lista de cobros a partir de su factura",
//            response = CobroDTO.class, tags = "Proveedores")
//    @GetMapping("/{id}")
//    public ResponseEntity<?> findByFacturaId(@PathVariable(value = "id") Long id) {
//        Optional<List<CobroDTO>> cobroFound = cobroService.findByFacturaId(id);
//        return new ResponseEntity<>(cobroFound, HttpStatus.OK);
//    }

    @ApiOperation(value = "Obtiene una lista de cobros a partir de su estado",
            response = CobroDTO.class, tags = "Cobros")
    @GetMapping("/{id}")
    public ResponseEntity<?> findByEstado(@PathVariable(value = "estado") boolean estado) {
        Optional<List<CobroDTO>> cobroFound = cobroService.findByEstado(estado);
        return new ResponseEntity<>(cobroFound, HttpStatus.OK);
    }

}
