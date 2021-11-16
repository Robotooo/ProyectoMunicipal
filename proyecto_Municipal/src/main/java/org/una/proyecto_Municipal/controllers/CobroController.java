package org.una.proyecto_Municipal.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.una.proyecto_Municipal.dto.CobroDTO;
import org.una.proyecto_Municipal.dto.ColaboradorDTO;
import org.una.proyecto_Municipal.dto.LicenciaDTO;
import org.una.proyecto_Municipal.services.ICobroService;
import org.una.proyecto_Municipal.services.IColaboradorService;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cobros")
@Api(tags = {"Cobros"})
public class CobroController {

    @Autowired
    private ICobroService cobroService;

    @Autowired
    private IColaboradorService colaboradorService;

    //findBy...
    @ApiOperation(value = "Obtiene un cobro a partir de su id",
            response = CobroDTO.class, tags = "Cobros")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @GetMapping("/id/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<CobroDTO> cobroFound = cobroService.findById(id);
        cobroService.generarCobros();
        return new ResponseEntity<>(cobroFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de todos los bienes",
            response = CobroDTO.class, responseContainer = "List", tags = "Cobros")
    @GetMapping("/{all}")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @ResponseBody
    public ResponseEntity<?> findAll() {
        Optional<List<CobroDTO>> result = cobroService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de cobros a partir de su estado",
            responseContainer = "List", response = CobroDTO.class, tags = "Cobros")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @GetMapping("/estado/{estado}")
    public ResponseEntity<?> findByEstado(@PathVariable(value = "estado") boolean estado) {
        Optional<List<CobroDTO>> cobroFound = cobroService.findByEstado(estado);
        return new ResponseEntity<>(cobroFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de cobros a partir de su estado",
            responseContainer = "List", response = CobroDTO.class, tags = "Cobros")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @GetMapping("/bien/{bienId}")
    public ResponseEntity<?> findByBienId(@PathVariable(value = "bienId") Long bienId) {
        Optional<List<CobroDTO>> cobroFound = cobroService.findByBienId(bienId);
        return new ResponseEntity<>(cobroFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de cobros a partir de su estado",
            responseContainer = "List", response = CobroDTO.class, tags = "Cobros")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<?> findByTipo(@PathVariable(value = "tipo") int tipo) {
        Optional<List<CobroDTO>> cobroFound = cobroService.findByTipo(tipo);
        return new ResponseEntity<>(cobroFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de cobros a partir de su bien x colaborador",
            responseContainer = "List", response = CobroDTO.class, tags = "Cobros")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @GetMapping("/bienxcolaboradorId/{bienxcolaboradorId}")
    public ResponseEntity<?> findByBienxColaboradorId(@PathVariable(value = "bienxcolaboradorId") Long id) {
        Optional<List<CobroDTO>> cobroFound = cobroService.findByBienxColaboradorId(id);
        return new ResponseEntity<>(cobroFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de los cobros pendientes por cedula",
            response = CobroDTO.class, tags = "Cobros")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @GetMapping("/CobroByCedula/{cedula}")
    public ResponseEntity<?>findCobroByCedula(@PathVariable(value = "cedula") String cedula) {
        Optional<List<CobroDTO>> cobroFound = cobroService.findCobroByCedula(cedula);
        return new ResponseEntity<>(cobroFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de los cobros pendientes por cedula",
            response = CobroDTO.class, tags = "Cobros")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @GetMapping("/CobroByCedulaAndTipo/{cedula}/{tipo}")
    public ResponseEntity<?>findCobroByCedulaAndTipo(@PathVariable(value = "cedula") String cedula,@PathVariable(value = "tipo") String tipo) {
        System.out.println("Controller");
        Optional<List<CobroDTO>> cobroFound = cobroService.findCobroByCedulaAndTipo(cedula,tipo);
        return new ResponseEntity<>(cobroFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de los cobros pagados por cedula entre fechas",
            response = CobroDTO.class, tags = "Cobros")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @GetMapping("/PagosByCedulaAndFechasBetween/{cedula}/{fechaInicio}/{fechaFinal}")
    public ResponseEntity<?>findPagosByCedulaAndFechasBetween(@PathVariable(value = "cedula") String cedula, @PathVariable(value = "fechaInicio") String fechaInicio,  @PathVariable(value = "fechaFinal") String fechaFinal) {
        LocalDate dateini = LocalDate.parse(fechaInicio);
        LocalDate datefin = LocalDate.parse(fechaFinal);
        Date di  = convertLocaDateToDate(dateini);
        Date df  = convertLocaDateToDate(datefin);
        Optional<List<CobroDTO>> cobroFound = cobroService.findPagosByCedulaAndFechasBetween(cedula, di, df);
        return new ResponseEntity<>(cobroFound, HttpStatus.OK);
    }

    private Date convertLocaDateToDate(LocalDate ld) {
        return Date.from(ld.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    @ApiOperation(value = "Obtiene una lista de cobros por licencias comerciales",
            response = CobroDTO.class, tags = "Cobros")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @GetMapping("/CobroByCedulaLicencias/{cedula}")
    public ResponseEntity<?>findPendienteTotalLicencias(@PathVariable(value = "cedula") String cedula) {
        Optional<List<CobroDTO>> cobroFound = cobroService.findPendienteTotalLicencias(cedula);
        return new ResponseEntity<>(cobroFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de cobros por propiedades",
            response = CobroDTO.class, tags = "Cobros")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @GetMapping("/CobroByCedulaPropiedades/{cedula}")
    public ResponseEntity<?>findPendienteTotalPropiedades(@PathVariable(value = "cedula") String cedula) {
        Optional<List<CobroDTO>> cobroFound = cobroService.findPendienteTotalPropiedades(cedula);
        return new ResponseEntity<>(cobroFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de cobros por rutas",
            response = CobroDTO.class, tags = "Cobros")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @GetMapping("/CobroByCedulaRutas/{cedula}")
    public ResponseEntity<?>findPendienteTotalRutas(@PathVariable(value = "cedula") String cedula) {
        Optional<List<CobroDTO>> cobroFound = cobroService.findPendienteTotalRutas(cedula);
        return new ResponseEntity<>(cobroFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Genera cobros de ruta",
            response = CobroDTO.class, tags = "Cobros")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @PostMapping("/GenerarCobroRuta/{fechaP}/{periodo}")
    public ResponseEntity<?>generarCobrosRuta(@PathVariable(value = "fechaP") String fechaP, @PathVariable(value = "periodo") int periodo) {
        LocalDate fecha = LocalDate.parse(fechaP);
        Date fp  = convertLocaDateToDate(fecha);
        Optional<List<CobroDTO>> cobroCreated = cobroService.generarCobrosRuta(fp, periodo);
        return new ResponseEntity<>(cobroCreated, HttpStatus.OK);
    }

    @ApiOperation(value = "Genera cobros de ruta",
            response = CobroDTO.class, tags = "Cobros")
    @PostMapping("/GenerarCobroLicencia/{fechaP}/{periodo}")
    public ResponseEntity<?>generarCobrosLicencia(@PathVariable(value = "fechaP") String fechaP, @PathVariable(value = "periodo") int periodo) {
        LocalDate fecha = LocalDate.parse(fechaP);
        Date fp  = convertLocaDateToDate(fecha);
        Optional<List<CobroDTO>> cobroCreated = cobroService.generarCobrosLicencia(fp, periodo);
        return new ResponseEntity<>(cobroCreated, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody CobroDTO cobroDto) {
        Optional<CobroDTO> cobroCreated = cobroService.create(cobroDto);
        return new ResponseEntity<>(cobroCreated, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody CobroDTO cobroModified) {
        Optional<CobroDTO> cobroUpdated = cobroService.update(cobroModified, id);
        return new ResponseEntity<>(cobroUpdated, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        cobroService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() throws Exception {
        cobroService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    // TODO: hacer método createList

}
