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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CobroServiceImplementation implements ICobroService{

    @Autowired
    private ICobroRepository cobroRepository;

    //findBy...
    @Override
    public Optional<CobroDTO> findById(Long id) {
        Optional<Cobro> cobro = cobroRepository.findById(id);
        if (cobro.isEmpty()) throw new NotFoundInformationException();

        CobroDTO cobroDTO = MapperUtils.DtoFromEntity(cobro.get(), CobroDTO.class);
        return Optional.ofNullable(cobroDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<CobroDTO>> findAll() {
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
    public Optional<List<CobroDTO>> findByBienId(Long id) {
        List<CobroDTO> cobroDTOList = MapperUtils.DtoListFromEntityList(cobroRepository.findByBienId(id), CobroDTO.class);
        if (cobroDTOList.isEmpty()) throw new NotFoundInformationException();
        return Optional.ofNullable(cobroDTOList);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<CobroDTO>> findByEstado(boolean estado) {
        List<Cobro> cobroList = cobroRepository.findByEstado(estado);
        List<CobroDTO> cobroDTOList = MapperUtils.DtoListFromEntityList(cobroList, CobroDTO.class);
        return Optional.ofNullable(cobroDTOList);
    }

    @Override
    public Optional<List<CobroDTO>> findByTipo(int tipo) {
        List<Cobro> cobroList = cobroRepository.findByTipo(tipo);
        List<CobroDTO> cobroDTOList = MapperUtils.DtoListFromEntityList(cobroList, CobroDTO.class);
        return Optional.ofNullable(cobroDTOList);
    }

    @Override
    public Optional<List<CobroDTO>> findCobroByCedula(String cedula) {
        List<CobroDTO> cobroDTOList = MapperUtils.DtoListFromEntityList(cobroRepository.findCobroByCedula(cedula), CobroDTO.class);
        if (cobroDTOList.isEmpty()) throw new NotFoundInformationException();
        return Optional.ofNullable(cobroDTOList);
    }

    @Override
    public Optional<List<CobroDTO>> findCobroByCedulaAndTipo(String cedula,String tipo) {

        System.out.println("Service");

        List<CobroDTO> cobroDTOList = new ArrayList<CobroDTO>();
        switch (tipo){
            case "LicenciaComercial":
                System.out.println("into IF");
                cobroDTOList = MapperUtils.DtoListFromEntityList
                        (cobroRepository.findByBienxColaborador_ColaboradorId_CedulaAndTipo("116380047",1), CobroDTO.class);
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
    public Optional<CobroDTO> create(CobroDTO cobroDTO) {
        return Optional.ofNullable(getSavedCobroDTO(cobroDTO));
    }

    @Override
    @Transactional
    public Optional<CobroDTO> update(CobroDTO cobroDTO, Long id) {
        if (cobroRepository.findById(id).isEmpty()) throw new NotFoundInformationException();

        return Optional.ofNullable(getSavedCobroDTO(cobroDTO));

    }

    //detele...
    @Override
    @Transactional
    public void delete(Long id) {
        cobroRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        cobroRepository.deleteAll();
    }

    @Override
    public void generarCobros() {
        String mensaje;
        mensaje = cobroRepository.saveTransaction();
    }

}
