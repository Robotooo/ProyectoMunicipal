package org.una.proyecto_Municipal.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.una.proyecto_Municipal.dto.CobroDTO;
import org.una.proyecto_Municipal.services.ICobroService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cobros")
@Api(tags = {"Cobros"})
public class CobroController {

    @Autowired
    private ICobroService cobroService;

    @PreAuthorize("hasRole('GESTOR')")
    @ApiOperation(value = "Obtiene un cobro a partir de su id",
            response = CobroDTO.class, tags = "Cobros")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<CobroDTO> cobroFound = cobroService.findById(id);
        return new ResponseEntity<>(cobroFound, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('GESTOR')")
    @ApiOperation(value = "Obtiene una lista de todos los bienes",
            response = CobroDTO.class, responseContainer = "List", tags = "Cobros")
    @GetMapping("/{all}")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<CobroDTO>> result = cobroService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('GESTOR')")
    @ApiOperation(value = "Obtiene una lista de cobros a partir de su estado",
            response = CobroDTO.class, tags = "Cobros")
    @GetMapping("/{estado}")
    public ResponseEntity<?> findByEstado(@PathVariable(value = "estado") boolean estado) {
        Optional<List<CobroDTO>> cobroFound = cobroService.findByEstado(estado);
        return new ResponseEntity<>(cobroFound, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('GESTOR')")
    @ApiOperation(value = "Obtiene una lista de cobros a partir de su bien",
            response = CobroDTO.class, tags = "Cobros")
    @GetMapping("/{BienId}")
    public ResponseEntity<?> findByBienId(@PathVariable(value = "id") Long id) {
        Optional<List<CobroDTO>> cobroFound = cobroService.findByBienId(id);
        return new ResponseEntity<>(cobroFound, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('GESTOR')")
    @ApiOperation(value = "Obtiene una lista de cobros a partir de su colaborador",
            response = CobroDTO.class, tags = "Cobros")
    @GetMapping("/{ColaboradorId}")
    public ResponseEntity<?> findByColaboradorId(@PathVariable(value = "id") Long id) {
        Optional<List<CobroDTO>> cobroFound = cobroService.findByColaboradores(id);
        return new ResponseEntity<>(cobroFound, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('GESTOR')")
    @ApiOperation(value = "Obtiene una lista de cobros a partir de su factura",
            response = CobroDTO.class, tags = "Proveedores")
    @GetMapping("/{FacturaIdd}")
    public ResponseEntity<?> findByFacturaId(@PathVariable(value = "id") Long id) {
        Optional<List<CobroDTO>> cobroFound = cobroService.findByFacturaId(id);
        return new ResponseEntity<>(cobroFound, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('GERENTE')")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody CobroDTO cobroDto) {
        Optional<CobroDTO> cobroCreated = cobroService.create(cobroDto);
        return new ResponseEntity<>(cobroCreated, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('GESTOR')")
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody CobroDTO cobroModified) {
        Optional<CobroDTO> cobroUpdated = cobroService.update(cobroModified, id);
        return new ResponseEntity<>(cobroUpdated, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('GESTOR')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        cobroService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @PreAuthorize("hasRole('GESTOR')")
    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() throws Exception {
        cobroService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    //TODO: findByCedulaFechaBetween, findByEstadoCanceladoFechaBetween, findByColaboradorCedula, updateWithColaboradorCedula

    //Cómo generar cobros masivos para un periodo especifico o para todo el año?
    // Crear uno o varios cobros a los contribuyentes dueños de un Bien; según del porcentaje de posesión % %
    //Busqueda de cobros por cedula, nombre o bienId; para posteriormente cancelarlo
    // Generar Factura de Cobro cancelado
    // Calcular vuelto según pago en efectivo
    // Listado exportable en Excel de cobros generados o cancelados; en un rango de fechas (Gerente, Admin, Auditor)
    // Mantenimiento de cobros generados, cancelados y recibos
    // BOT - consulta cobros pendientes de un Colaborador
    // BOT - consulta cobros de un rango de fechas
    // BOT - consulta cobros de un tipo de impuesto
    // BOT - consulta sobre pagos de cliente en un rango de fechas
}
