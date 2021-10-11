package org.una.proyecto_Municipal.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private IColaboradorService colaboradorService;

    @ApiOperation(value = "Obtiene un colaborador a partir de su id",
            response = ColaboradorDTO.class, tags = "Colaboradores")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<ColaboradorDTO> colaboradorFound = colaboradorService.findById(id);
        return new ResponseEntity<>(colaboradorFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de todos los colaboradores",
            response = ColaboradorDTO.class, responseContainer = "List", tags = "Colaboradores")
    @GetMapping("/{all}")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<ColaboradorDTO>> result = colaboradorService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de colaboradors a partir de su estado",
            response = ColaboradorDTO.class, tags = "Colaboradores")
    @GetMapping("/{estado}")
    public ResponseEntity<?> findByEstado(@PathVariable(value = "estado") boolean estado) {
        Optional<List<ColaboradorDTO>> colaboradorFound = colaboradorService.findByEstado(estado);
        return new ResponseEntity<>(colaboradorFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de colaboradors a partir de su nombre",
            response = ColaboradorDTO.class, tags = "Colaboradores")
    @GetMapping("/{nombre}")
    public ResponseEntity<?> findByNombre(@PathVariable(value = "nombre") String departamentoName) {
        Optional<List<ColaboradorDTO>> colaboradorFound = colaboradorService.findByNombre(departamentoName);
        return new ResponseEntity<>(colaboradorFound, HttpStatus.OK);

    }

    @ApiOperation(value = "Obtiene una lista de colaboradors a partir de su telefono",
            response = ColaboradorDTO.class, tags = "Colaboradores")
    @GetMapping("/{telefono}")
    public ResponseEntity<?> findByTelefono(@PathVariable(value = "telefono") String telefono) {
        Optional<List<ColaboradorDTO>> colaboradorFound = colaboradorService.findByTelefono(telefono);
        return new ResponseEntity<>(colaboradorFound, HttpStatus.OK);

    }

    @ApiOperation(value = "Obtiene una lista de colaboradors a partir de su cedula",
            response = ColaboradorDTO.class, tags = "Colaboradores")
    @GetMapping("/{cedula}")
    public ResponseEntity<?> findByCedulaAproximate(@PathVariable(value = "cedula") String cedula) {
        Optional<List<ColaboradorDTO>> colaboradorFound = colaboradorService.findByCedulaAproximate(cedula);
        return new ResponseEntity<>(colaboradorFound, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Se crea un colaborador", response = ColaboradorDTO.class, tags = "Colaboradores")
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody ColaboradorDTO colaboradorDTO) {
        Optional<ColaboradorDTO> colaboradorCreated = colaboradorService.create(colaboradorDTO);
        return new ResponseEntity<>(colaboradorCreated, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody ColaboradorDTO colaboradorModified) {
        Optional<ColaboradorDTO> colaboradorUpdated = colaboradorService.update(colaboradorModified, id);
        return new ResponseEntity<>(colaboradorUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        colaboradorService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() throws Exception {
        colaboradorService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    //TODO: findByValorImpositivo

}
