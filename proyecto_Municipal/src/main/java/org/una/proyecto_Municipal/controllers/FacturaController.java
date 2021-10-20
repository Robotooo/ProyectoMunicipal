package org.una.proyecto_Municipal.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.proyecto_Municipal.dto.CobroDTO;
import org.una.proyecto_Municipal.dto.FacturaDTO;
import org.una.proyecto_Municipal.services.IFacturaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/facturas")
@Api(tags = {"Facturas"})
public class FacturaController {

    @Autowired
    private IFacturaService facturaService;

    @ApiOperation(value = "Obtiene una factura a partir de su id",
            response = CobroDTO.class, tags = "Facturas")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<FacturaDTO> facturaFound = facturaService.findById(id);
        return new ResponseEntity<>(facturaFound, HttpStatus.OK);
    }

    /*@ApiOperation(value = "Obtiene una factura a partir del id del cajero",
            response = CobroDTO.class, tags = "Facturas")
    @GetMapping("/{id}")
    public ResponseEntity<?> findByCajeroId(@PathVariable(value = "id") Long id) {
        Optional<List<FacturaDTO>> facturaFound = facturaService.findByCajeroId(id);
        return new ResponseEntity<>(facturaFound, HttpStatus.OK);
    }*/

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Se crea una Factura", response = FacturaDTO.class, tags = "Facturas")
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody FacturaDTO facturaDTO) {
        Optional<FacturaDTO> facturaCreated = facturaService.create(facturaDTO);
        return new ResponseEntity<>(facturaCreated, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody FacturaDTO facturaModified) {
        Optional<FacturaDTO> facturaUpdated = facturaService.update(facturaModified, id);
        return new ResponseEntity<>(facturaUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        facturaService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() throws Exception {
        facturaService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    //TODO: findByColaboradorFechaBetween, findByValorImpositvoFechaBetween, revisar findByCajeroId

    // Ver reportes de recibos de un Bien, un Contribuyente o un Funcionario, en un rango de fechas

}
