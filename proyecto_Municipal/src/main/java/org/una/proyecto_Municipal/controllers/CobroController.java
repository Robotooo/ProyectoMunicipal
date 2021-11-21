package org.una.proyecto_Municipal.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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


    //findBy...
    @ApiOperation(value = "Obtiene un cobro a partir de su id",
            response = CobroDTO.class, tags = "Cobros")
    @PreAuthorize("  hasRole('GERENTE') or hasRole('GESTOR')")
    @GetMapping("/id/{id}/{funId}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id, @PathVariable(value = "funId") Long funId) {
        Optional<CobroDTO> cobroFound = cobroService.findById(id,funId);
        cobroService.generarCobros();
        return new ResponseEntity<>(cobroFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de todos los bienes",
            response = CobroDTO.class, responseContainer = "List", tags = "Cobros")
    @GetMapping("/{all}")
    @PreAuthorize("  hasRole('GERENTE') or hasRole('GESTOR') or hasRole('BOT')")
    @ResponseBody
    public ResponseEntity<?> findAll(@PathVariable(value = "funId") Long funId) {
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
    @GetMapping("/bien/{bienId}/{funId}")
    public ResponseEntity<?> findByBienId(@PathVariable(value = "bienId") Long bienId, @PathVariable(value = "funId") Long funId) {
        Optional<List<CobroDTO>> cobroFound = cobroService.findByBienId(bienId,funId);
        return new ResponseEntity<>(cobroFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de cobros a partir de su estado",
            responseContainer = "List", response = CobroDTO.class, tags = "Cobros")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @GetMapping("/tipo/{tipo}/{funId}")
    public ResponseEntity<?> findByTipo(@PathVariable(value = "tipo") int tipo, @PathVariable(value = "funId") Long funId) {
        Optional<List<CobroDTO>> cobroFound = cobroService.findByTipo(tipo,funId);
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
    @PreAuthorize("  hasRole('GERENTE') or hasRole('GESTOR') or hasRole('BOT')")
    @GetMapping("/CobroByCedula/{cedula}/{funId}")
    public ResponseEntity<?>findCobroByCedula(@PathVariable(value = "cedula") String cedula, @PathVariable(value = "funId") Long funId) {
        Optional<List<CobroDTO>> cobroFound = cobroService.findCobroByCedula(cedula,funId);
        return new ResponseEntity<>(cobroFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de los cobros pendientes por cedula",
            response = CobroDTO.class, tags = "Cobros")
    @PreAuthorize("  hasRole('GERENTE') or hasRole('GESTOR') or hasRole('BOT')")
    @GetMapping("/CobroByCedulaAndTipo/{cedula}/{tipo}/{funId}")
    public ResponseEntity<?>findCobroByCedulaAndTipo(@PathVariable(value = "cedula") String cedula, @PathVariable(value = "tipo") String tipo, @PathVariable(value = "funId") Long funId) {
        Optional<List<CobroDTO>> cobroFound = cobroService.findCobroByCedulaAndTipo(cedula,tipo, funId);
        return new ResponseEntity<>(cobroFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de los cobros pagados por cedula entre fechas",
            response = CobroDTO.class, tags = "Cobros")
    @PreAuthorize("  hasRole('GERENTE') or hasRole('GESTOR') or hasRole('BOT')")
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
    @PreAuthorize("  hasRole('GERENTE') or hasRole('GESTOR') or hasRole('BOT')")
    @GetMapping("/CobroByCedulaLicencias/{cedula}")
    public ResponseEntity<?>findPendienteTotalLicencias(@PathVariable(value = "cedula") String cedula) {
        Optional<List<CobroDTO>> cobroFound = cobroService.findPendienteTotalLicencias(cedula);
        return new ResponseEntity<>(cobroFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de cobros por propiedades",
            response = CobroDTO.class, tags = "Cobros")
    @PreAuthorize("  hasRole('GERENTE') or hasRole('GESTOR') or hasRole('BOT')")
    @GetMapping("/CobroByCedulaPropiedades/{cedula}")
    public ResponseEntity<?>findPendienteTotalPropiedades(@PathVariable(value = "cedula") String cedula) {
        Optional<List<CobroDTO>> cobroFound = cobroService.findPendienteTotalPropiedades(cedula);
        return new ResponseEntity<>(cobroFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de cobros por rutas",
            response = CobroDTO.class, tags = "Cobros")
    @PreAuthorize("  hasRole('GERENTE') or hasRole('GESTOR') or hasRole('BOT')")
    @GetMapping("/CobroByCedulaRutas/{cedula}")
    public ResponseEntity<?>findPendienteTotalRutas(@PathVariable(value = "cedula") String cedula) {
        Optional<List<CobroDTO>> cobroFound = cobroService.findPendienteTotalRutas(cedula);
        return new ResponseEntity<>(cobroFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Genera cobros de rutas de buses",
            response = CobroDTO.class, tags = "Cobros")
    @PreAuthorize("  hasRole('GERENTE')")
    @GetMapping("/GenerarCobroRuta/{tipo}/{periodo}/{fecha}/{anio}")
    public ResponseEntity<?>generarCobrosRuta(@PathVariable(value = "tipo") int tipo,
                                              @PathVariable(value = "periodo") int periodo,
                                              @PathVariable(value = "fecha") @DateTimeFormat(pattern = "yyyy-MM-dd") String fecha,
                                              @PathVariable(value = "anio") int anio) {
        LocalDate fechaC = LocalDate.parse(fecha);
        Date fp  = convertLocaDateToDate(fechaC);
        Optional<List<CobroDTO>> cobroCreated = cobroService.generarCobrosRuta(tipo, periodo,fp, anio);
        return new ResponseEntity<>(cobroCreated, HttpStatus.OK);
    }

    @ApiOperation(value = "Genera cobros de licencias comerciales",
            response = CobroDTO.class, tags = "Cobros")
    @PreAuthorize("  hasRole('GERENTE')")
    @GetMapping("/GenerarCobroLicencia/{tipo}/{periodo}/{fecha}/{anio}")
    public ResponseEntity<?>generarCobrosLicencia(@PathVariable(value = "tipo") int tipo,
                                                  @PathVariable(value = "periodo") int periodo,
                                                  @PathVariable(value = "fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  Date fecha,
                                                  @PathVariable(value = "anio") int anio) {
        Optional<List<CobroDTO>> cobroCreated = cobroService.generarCobrosLicencia(tipo, periodo,fecha, anio);
        return new ResponseEntity<>(cobroCreated, HttpStatus.OK);
    }

    @ApiOperation(value = "Genera cobros de limpieza de vias",
            response = CobroDTO.class, tags = "Cobros")
    @PreAuthorize("  hasRole('GERENTE')")
    @GetMapping("/GenerarCobroLimpieza/{tipo}/{periodo}/{fecha}/{anio}")
    public ResponseEntity<?>generarCobrosLimpieza(@PathVariable(value = "tipo") int tipo,
                                                  @PathVariable(value = "periodo") int periodo,
                                                  @PathVariable(value = "fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  Date fecha,
                                                  @PathVariable(value = "anio") int anio) {
        Optional<List<CobroDTO>> cobroCreated = cobroService.generarCobrosLimpieza(tipo, periodo,fecha, anio);
        return new ResponseEntity<>(cobroCreated, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/{funId}")
    @PreAuthorize("  hasRole('GERENTE')")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody CobroDTO cobroDto, @PathVariable(value = "funId") Long funId) {
        Optional<CobroDTO> cobroCreated = cobroService.create(cobroDto,funId);
        return new ResponseEntity<>(cobroCreated, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/{funId}")
    @PreAuthorize("  hasRole('GERENTE') or hasRole('GESTOR')")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody CobroDTO cobroModified, @PathVariable(value = "funId") Long funId) {
        Optional<CobroDTO> cobroUpdated = cobroService.update(cobroModified, id,funId);
        return new ResponseEntity<>(cobroUpdated, HttpStatus.OK);
    }
    @PreAuthorize("  hasRole('GERENTE') or hasRole('GESTOR')")
    @DeleteMapping("/{id}/{funId}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id, @PathVariable(value = "funId") Long funId) throws Exception {
        cobroService.delete(id,funId);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() throws Exception {
        cobroService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    // TODO: hacer método createList

}
