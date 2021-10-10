package org.una.proyecto_Municipal.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.una.proyecto_Municipal.dto.ContribuyenteDTO;
import org.una.proyecto_Municipal.services.IContribuyenteService;

import java.util.List;
import java.util.Optional;

public class ContribuyenteController {

    private IContribuyenteService contribuyenteService;

    @ApiOperation(value = "Obtiene un contribuyente a partir de su id",
            response = ContribuyenteDTO.class, tags = "Contribuyentes")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<ContribuyenteDTO> contribuyenteFound = contribuyenteService.findById(id);
        return new ResponseEntity<>(contribuyenteFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de contribuyentes a partir de su estado",
            response = ContribuyenteDTO.class, tags = "Contribuyentes")
    @GetMapping("/{estado}")
    public ResponseEntity<?> findByEstado(@PathVariable(value = "estado") boolean estado) {
        Optional<List<ContribuyenteDTO>> contribuyenteFound = contribuyenteService.findByEstado(estado);
        return new ResponseEntity<>(contribuyenteFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de contribuyentes a partir de su nomnbre",
            response = ContribuyenteDTO.class, tags = "Contribuyentes")
    @GetMapping("/{proveedorNombre}")
    public ResponseEntity<?> findByNombre(@PathVariable(value = "nombre") String departamentoName) {
        Optional<List<ContribuyenteDTO>> contribuyenteFound = contribuyenteService.findByNombre(departamentoName);
        return new ResponseEntity<>(contribuyenteFound, HttpStatus.OK);

    }

    @ApiOperation(value = "Obtiene una lista de contribuyentes a partir de su telefono",
            response = ContribuyenteDTO.class, tags = "Contribuyentes")
    @GetMapping("/{telefono}")
    public ResponseEntity<?> findByTelefono(@PathVariable(value = "telefono") String telefono) {
        Optional<ContribuyenteDTO> contribuyenteFound = contribuyenteService.findByTelefono(telefono);
        return new ResponseEntity<>(contribuyenteFound, HttpStatus.OK);
    }
}
