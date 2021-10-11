package org.una.proyecto_Municipal.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.una.proyecto_Municipal.dto.BienDTO;
import org.una.proyecto_Municipal.dto.CobroDTO;
import org.una.proyecto_Municipal.dto.FuncionarioDTO;
import org.una.proyecto_Municipal.entities.Funcionario;
import org.una.proyecto_Municipal.services.ICobroService;
import org.una.proyecto_Municipal.utils.MapperUtils;

import java.util.List;
import java.util.Optional;

//@RestController
//@RequestMapping("/cobros")
//@Api(tags = {"Cobros"})
public class CobroController {

    private ICobroService cobroService;

    @ApiOperation(value = "Obtiene un cobro a partir de su id",
            response = CobroDTO.class, tags = "Cobros")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<CobroDTO> cobroFound = cobroService.findById(id);
        return new ResponseEntity<>(cobroFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de todos los bienes",
            response = CobroDTO.class, responseContainer = "List", tags = "Cobros")
    @GetMapping("/{all}")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<CobroDTO>> result = cobroService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de cobros a partir de su estado",
            response = CobroDTO.class, tags = "Cobros")
    @GetMapping("/{estado}")
    public ResponseEntity<?> findByEstado(@PathVariable(value = "estado") boolean estado) {
        Optional<List<CobroDTO>> cobroFound = cobroService.findByEstado(estado);
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

    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody CobroDTO cobroDto) {
        Optional<CobroDTO> cobroCreated = cobroService.create(cobroDto);
        return new ResponseEntity<>(cobroCreated, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody CobroDTO cobroModified) {
        Optional<CobroDTO> cobroUpdated = cobroService.update(cobroModified, id);
        return new ResponseEntity<>(cobroUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        cobroService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() throws Exception {
        cobroService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    //TODO: findByCedulaFechaBetween, findByEstadoCanceladoFechaBetween

}
