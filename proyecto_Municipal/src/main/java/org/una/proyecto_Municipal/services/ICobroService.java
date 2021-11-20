package org.una.proyecto_Municipal.services;

import org.una.proyecto_Municipal.dto.CobroDTO;
import org.una.proyecto_Municipal.dto.LicenciaDTO;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ICobroService {

    public Optional<CobroDTO> findById(Long id, Long funId);

    public Optional<List<CobroDTO>> findAll();

    public Optional<List<CobroDTO>> findByEstado(boolean estado);

    public Optional<List<CobroDTO>> findByTipo(int tipo, Long funId);

    public Optional<List<CobroDTO>> findByBienxColaboradorId(Long id);

    public Optional<List<CobroDTO>> findByBienId(Long id, Long funId);

    public Optional<List<CobroDTO>> findCobroByCedula(String cedula, Long funId);

    public Optional<List<CobroDTO>> findCobroByCedulaAndTipo(String cedula,String tipo,Long funId);

    public Optional<List<CobroDTO>> findPagosByCedulaAndFechasBetween(String cedula, Date fechaInicio, Date fechaFinal);

    public Optional<List<CobroDTO>> findPendienteTotalLicencias(String cedula);

    public Optional<List<CobroDTO>> findPendienteTotalPropiedades(String cedula);

    public Optional<List<CobroDTO>> findPendienteTotalRutas(String cedula);

    public Optional<List<CobroDTO>> generarCobrosRuta(int tipo, int periodo, Date fecha, int anio);

    public Optional<List<CobroDTO>> generarCobrosLicencia(int tipo, int periodo, Date fecha, int anio);

    public Optional<CobroDTO> create(CobroDTO cobroDTO,  Long funId);

    public Optional<CobroDTO> update(CobroDTO cobroDTO, Long id, Long funId);

    public void delete(Long id, Long funId);

    public void deleteAll();

    public void generarCobros();

    //TODO: Función para buscar cobro con número de cédula o número de activo

}
