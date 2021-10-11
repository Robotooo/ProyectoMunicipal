package org.una.proyecto_Municipal.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.proyecto_Municipal.dto.ColaboradorDTO;
import org.una.proyecto_Municipal.services.IColaboradorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/colaboradores")
@Api(tags = {"Colaboradores"})
public class ColaboradorController {

    private IColaboradorService colaboradorService;

    @ApiOperation(value = "Obtiene un contribuyente a partir de su id",
            response = ColaboradorDTO.class, tags = "Colaboradores")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<ColaboradorDTO> colaboradorFound = colaboradorService.findById(id);
        return new ResponseEntity<>(colaboradorFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de contribuyentes a partir de su estado",
            response = ColaboradorDTO.class, tags = "Colaboradores")
    @GetMapping("/{estado}")
    public ResponseEntity<?> findByEstado(@PathVariable(value = "estado") boolean estado) {
        Optional<List<ColaboradorDTO>> colaboradorFound = colaboradorService.findByEstado(estado);
        return new ResponseEntity<>(colaboradorFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de contribuyentes a partir de su nombre",
            response = ColaboradorDTO.class, tags = "Colaboradores")
    @GetMapping("/{nombre}")
    public ResponseEntity<?> findByNombre(@PathVariable(value = "nombre") String departamentoName) {
        Optional<List<ColaboradorDTO>> colaboradorFound = colaboradorService.findByNombre(departamentoName);
        return new ResponseEntity<>(colaboradorFound, HttpStatus.OK);

    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Se crea un colaborador", response = ColaboradorDTO.class, tags = "Colaborador")
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody ColaboradorDTO colaboradorDTO) {
        Optional<ColaboradorDTO> colaboradorCreated = colaboradorService.create(colaboradorDTO);
        return new ResponseEntity<>(colaboradorCreated, HttpStatus.CREATED);
    }

    //TODO: create, update, delete, findAll, findByEstado, findByCedula, findByValorImpositivo

}
