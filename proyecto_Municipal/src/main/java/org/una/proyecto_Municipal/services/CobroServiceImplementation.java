package org.una.proyecto_Municipal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.proyecto_Municipal.dto.CobroDTO;
import org.una.proyecto_Municipal.dto.LicenciaDTO;
import org.una.proyecto_Municipal.dto.PropiedadDTO;
import org.una.proyecto_Municipal.entities.Cobro;
import org.una.proyecto_Municipal.entities.Licencia;
import org.una.proyecto_Municipal.exceptions.NotFoundInformationException;
import org.una.proyecto_Municipal.repositories.ICobroRepository;
import org.una.proyecto_Municipal.utils.MapperUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CobroServiceImplementation implements ICobroService{

    @Autowired
    private ICobroRepository cobroRepository;

    Date date = new SimpleDateFormat("yyyy-mm-dd").parse("2021-11-16");

    public CobroServiceImplementation() throws ParseException {
    }


    //findBy...
    @Override
    public Optional<CobroDTO> findById(Long id, Long funId) {
        Optional<Cobro> cobro = cobroRepository.findById(id);
        if (cobro.isEmpty()) throw new NotFoundInformationException();
        cobroRepository.saveTransaction("buscar por Id","Cobro","2",date);
        CobroDTO cobroDTO = MapperUtils.DtoFromEntity(cobro.get(), CobroDTO.class);
        return Optional.ofNullable(cobroDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<CobroDTO>> findAll() {
        cobroRepository.saveTransaction("buscar todos","Cobro","2",date);
        List<CobroDTO> cobroDTOList = MapperUtils.DtoListFromEntityList(cobroRepository.findAll(), CobroDTO.class);
        return Optional.ofNullable(cobroDTOList);
    }

    @Override
    public Optional<List<CobroDTO>> findByBienxColaboradorId(Long id) {
        List<CobroDTO> cobroDTOList = MapperUtils.DtoListFromEntityList(cobroRepository.findByBienxColaboradorId(id), CobroDTO.class);
        if (cobroDTOList.isEmpty()) throw new NotFoundInformationException();
        return Optional.ofNullable(cobroDTOList);
    }

    @Override
    public Optional<List<CobroDTO>> findByBienId(Long id, Long funId) {
        cobroRepository.saveTransaction("buscar por bien Id","Cobro","2",date);
        List<CobroDTO> cobroDTOList = MapperUtils.DtoListFromEntityList(cobroRepository.findByBienId(id), CobroDTO.class);
        if (cobroDTOList.isEmpty()) throw new NotFoundInformationException();
        return Optional.ofNullable(cobroDTOList);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<CobroDTO>> findByEstado(boolean estado) {
        cobroRepository.saveTransaction("buscar por estado","Cobro","2",date);
        List<Cobro> cobroList = cobroRepository.findByEstado(estado);
        List<CobroDTO> cobroDTOList = MapperUtils.DtoListFromEntityList(cobroList, CobroDTO.class);
        return Optional.ofNullable(cobroDTOList);
    }

    @Override
    public Optional<List<CobroDTO>> findByTipo(int tipo, Long funId) {
        cobroRepository.saveTransaction("buscar por tipo","Cobro","2",date);
        List<Cobro> cobroList = cobroRepository.findByTipo(tipo);
        List<CobroDTO> cobroDTOList = MapperUtils.DtoListFromEntityList(cobroList, CobroDTO.class);
        return Optional.ofNullable(cobroDTOList);
    }

    @Override
    public Optional<List<CobroDTO>> findCobroByCedula(String cedula,Long funId) {
        List<CobroDTO> cobroDTOList = MapperUtils.DtoListFromEntityList(cobroRepository.findCobroByCedula(cedula), CobroDTO.class);
        if (cobroDTOList.isEmpty()) throw new NotFoundInformationException();
        return Optional.ofNullable(cobroDTOList);
    }

    @Override
    public Optional<List<CobroDTO>> findCobroByCedulaAndTipo(String cedula,String tipo,Long funId) {

        cobroRepository.registrarTransaccion("buscar por cedula y tipo","Cobro",funId,cedula);

        List<CobroDTO> cobroDTOList = new ArrayList<CobroDTO>();
        switch (tipo){
            case "LicenciaComercial":
                cobroDTOList = MapperUtils.DtoListFromEntityList
                        (cobroRepository.findPendienteTotalLicencias(cedula), CobroDTO.class);
                break;
            case "Limpiezadevías":
                cobroDTOList = MapperUtils.DtoListFromEntityList
                        (cobroRepository.findPendienteTotalPropiedades(cedula), CobroDTO.class);
                break;
            case "Rutasdebuses":
                cobroDTOList = MapperUtils.DtoListFromEntityList
                        (cobroRepository.findPendienteTotalRutas(cedula), CobroDTO.class);
                break;
            case "Cobrostotales":
                cobroDTOList = MapperUtils.DtoListFromEntityList
                        (cobroRepository.findCobroByCedula(cedula), CobroDTO.class);

        }

        if (cobroDTOList.isEmpty()) throw new NotFoundInformationException();
        return Optional.ofNullable(cobroDTOList);
    }

    @Override
    public Optional<List<CobroDTO>> findPagosByCedulaAndFechasBetween(String cedula, Date fechaInicio, Date fechaFinal) {
        List<CobroDTO> cobroDTOList = MapperUtils.DtoListFromEntityList(cobroRepository.findPagosByCedulaAndFechasBetween(cedula, fechaInicio, fechaFinal), CobroDTO.class);
        if (cobroDTOList.isEmpty()) throw new NotFoundInformationException();
        return Optional.ofNullable(cobroDTOList);
    }

    @Override
    @Transactional
    public Optional< List<CobroDTO>> findPendienteTotalLicencias(String cedula){
        List<Cobro> cobroList = cobroRepository.findPendienteTotalLicencias(cedula);
        List<CobroDTO> cobroDTOList =  MapperUtils.DtoListFromEntityList(cobroList, CobroDTO.class);
        return Optional.ofNullable(cobroDTOList);
    }

    @Override
    @Transactional
    public Optional< List<CobroDTO>> findPendienteTotalPropiedades(String cedula){
        List<Cobro> cobroList = cobroRepository.findPendienteTotalPropiedades(cedula);
        List<CobroDTO> cobroDTOList =  MapperUtils.DtoListFromEntityList(cobroList, CobroDTO.class);
        return Optional.ofNullable(cobroDTOList);
    }

    @Override
    @Transactional
    public Optional< List<CobroDTO>> findPendienteTotalRutas(String cedula){
        List<Cobro> cobroList = cobroRepository.findPendienteTotalRutas(cedula);
        List<CobroDTO> cobroDTOList =  MapperUtils.DtoListFromEntityList(cobroList, CobroDTO.class);
        return Optional.ofNullable(cobroDTOList);
    }

    //get
    private CobroDTO getSavedCobroDTO(CobroDTO cobroDTO) {
        Cobro cobro = MapperUtils.EntityFromDto(cobroDTO, Cobro.class);
        Cobro cobroCreated = cobroRepository.save(cobro);
        return MapperUtils.DtoFromEntity(cobroCreated, CobroDTO.class);
    }

    //create & update
    @Override
    @Transactional
    public Optional<CobroDTO> create(CobroDTO cobroDTO, Long funId) {
        cobroRepository.registrarTransaccion("crear","Cobro",funId,null);
        return Optional.ofNullable(getSavedCobroDTO(cobroDTO));
    }

    @Override
    @Transactional
    public Optional<CobroDTO> update(CobroDTO cobroDTO, Long id, Long funId) {
        if (cobroRepository.findById(id).isEmpty()) throw new NotFoundInformationException();
        cobroRepository.registrarTransaccion("actualizar","Cobro",funId,String.valueOf(cobroDTO.getId()));
        return Optional.ofNullable(getSavedCobroDTO(cobroDTO));

    }

    //detele...
    @Override
    @Transactional
    public void delete(Long id, Long funId) {
        cobroRepository.registrarTransaccion("eliminar","Cobro",funId,String.valueOf(id));
        cobroRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        cobroRepository.deleteAll();
    }

    @Override
    @Transactional
    public Optional< List<CobroDTO>> generarCobrosRuta(int tipo, int periodo, Date fecha, int anio){
        cobroRepository.generarCobrosRuta(tipo,periodo,fecha,anio);
        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<List<CobroDTO>> generarCobrosLicencia(int tipo, int periodo, Date fecha, int anio){
        cobroRepository.generarCobrosLicencia(tipo,periodo,fecha,anio);
        return Optional.empty();
    }

    @Override
    public void generarCobros() {
        String mensaje;
        mensaje = cobroRepository.saveTransaction("GenerarCobros","Cobro","1",date);
    }

}
