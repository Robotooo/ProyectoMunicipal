package org.una.proyecto_Municipal.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @ApiOperation(value = "Obtiene un cobro a partir de su id",
            response = CobroDTO.class, tags = "Cobros")
    @GetMapping("/id/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<CobroDTO> cobroFound = cobroService.findById(id);
        return new ResponseEntity<>(cobroFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de todos los bienes",
            response = CobroDTO.class, responseContainer = "List", tags = "Cobros")
    @GetMapping("/{all}")
    @ResponseBody
    public ResponseEntity<?> findAll() {
        Optional<List<CobroDTO>> result = cobroService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de cobros a partir de su estado",
            responseContainer = "List", response = CobroDTO.class, tags = "Cobros")
    @GetMapping("/estado/{estado}")
    public ResponseEntity<?> findByEstado(@PathVariable(value = "estado") boolean estado) {
        Optional<List<CobroDTO>> cobroFound = cobroService.findByEstado(estado);
        return new ResponseEntity<>(cobroFound, HttpStatus.OK);
    }

//    @ApiOperation(value = "Obtiene una lista de cobros a partir de su bien",
//            response = CobroDTO.class, tags = "Cobros")
//    @GetMapping("/{id}")
//    public ResponseEntity<?> findByBienId(@PathVariable(value = "id") Long id) {
//        Optional<List<CobroDTO>> cobroFound = cobroService.findByBienId(id);
//        return new ResponseEntity<>(cobroFound, HttpStatus.OK);
//    }

    @ApiOperation(value = "Obtiene una lista de cobros a partir de su colaborador",
            response = CobroDTO.class, responseContainer = "List", tags = "Cobros")
    @GetMapping("/colaboradorId/{colaboradorId}")
    public ResponseEntity<?> findByColaboradorId(@PathVariable(value = "id") Long id) {
        Optional<List<CobroDTO>> cobroFound = cobroService.findByBienxColaboradorId(id);
        return new ResponseEntity<>(cobroFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de cobros a partir de su factura",
            response = CobroDTO.class, responseContainer = "List", tags = "Proveedores")
    @GetMapping("/factura_id/{factura_id}")
    public ResponseEntity<?> findByFacturaId(@PathVariable(value = "id") Long id) {
        Optional<List<CobroDTO>> cobroFound = cobroService.findByFacturaId(id);
        return new ResponseEntity<>(cobroFound, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
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
    //El gestor debe poder Buscar y Cancelar cobros
    //El Gestor debe solicitar al Gerente una autorización para eliminar info
    //El gerente debe generar cobros para un periodo o para todo el año
    //El gerente debe autorizar solicitudes del gestor
    //El gerente debe poder emitir listados generales
    //El Cobro debe hacerse a uno o más contribuyentes según el porcentaje de posesión del bien % %
    //El Pago o Cancelación de cobro se puede hacer mediante cedula o nombre del colaborador o con la referencia al valor impositivo
    //Un cobro cancelado debe permitir generar Factura del mismo, también el vuelto
    //Una función para exportar a Excel una lista de los cobros activos o cancelados; en un rango de fechas
    //Funciones para dar mantenimiento a cobos generados, cancelados y recibos

    //TODO: El BOT debe poder consultar la formula de licencias comerciales, limpieza de vías y rutas de buses
    //El BOT debe consultar cobros pendientes de colaborador
    // El BOT debe consultar los cobros de cierta fecha
    // El BOT debe consultar los cobros de un tipo de impuesto
    // El BOT debe consultar sobre los pagos de un cliente en un rango de fechas dado

}
