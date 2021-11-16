package org.una.proyecto_Municipal.services;

import org.una.proyecto_Municipal.dto.CobroDTO;
import org.una.proyecto_Municipal.dto.LicenciaDTO;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ICobroService {

    public Optional<CobroDTO> findById(Long id);

    public Optional<List<CobroDTO>> findAll();

    public Optional<List<CobroDTO>> findByEstado(boolean estado);

    public Optional<List<CobroDTO>> findByTipo(int tipo);

    public Optional<List<CobroDTO>> findByBienxColaboradorId(Long id);

    public Optional<List<CobroDTO>> findByBienId(Long id);

    public Optional<List<CobroDTO>> findCobroByCedula(String cedula);

    public Optional<List<CobroDTO>> findCobroByCedulaAndTipo(String cedula,String tipo);

    public Optional<List<CobroDTO>> findPagosByCedulaAndFechasBetween(String cedula, Date fechaInicio, Date fechaFinal);

    public Optional<List<CobroDTO>> findPendienteTotalLicencias(String cedula);

    public Optional<List<CobroDTO>> findPendienteTotalPropiedades(String cedula);

    public Optional<List<CobroDTO>> findPendienteTotalRutas(String cedula);

    public Optional<List<CobroDTO>> generarCobrosRuta(Date fechaP, int periodo);

    public Optional<List<CobroDTO>> generarCobrosLicencia(Date fechaP, int periodo);

    public Optional<CobroDTO> create(CobroDTO cobroDTO);

    public Optional<CobroDTO> update(CobroDTO cobroDTO, Long id);

    public void delete(Long id);

    public void deleteAll();

    public void generarCobros();

    //TODO: Función para buscar cobro con número de cédula o número de activo

}
