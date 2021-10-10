package org.una.proyecto_Municipal.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.una.proyecto_Municipal.dto.ColaboradorDTO;
import org.una.proyecto_Municipal.services.IColaboradorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/colaboradores")
@Api(tags = {"Colaboradores"})
public class ColaboradorController {

    private IColaboradorService contribuyenteService;

    @ApiOperation(value = "Obtiene un contribuyente a partir de su id",
            response = ColaboradorDTO.class, tags = "Contribuyentes")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<ColaboradorDTO> contribuyenteFound = contribuyenteService.findById(id);
        return new ResponseEntity<>(contribuyenteFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de contribuyentes a partir de su estado",
            response = ColaboradorDTO.class, tags = "Contribuyentes")
    @GetMapping("/{estado}")
    public ResponseEntity<?> findByEstado(@PathVariable(value = "estado") boolean estado) {
        Optional<List<ColaboradorDTO>> contribuyenteFound = contribuyenteService.findByEstado(estado);
        return new ResponseEntity<>(contribuyenteFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de contribuyentes a partir de su nomnbre",
            response = ColaboradorDTO.class, tags = "Contribuyentes")
    @GetMapping("/{proveedorNombre}")
    public ResponseEntity<?> findByNombre(@PathVariable(value = "nombre") String departamentoName) {
        Optional<List<ColaboradorDTO>> contribuyenteFound = contribuyenteService.findByNombre(departamentoName);
        return new ResponseEntity<>(contribuyenteFound, HttpStatus.OK);

    }

}
