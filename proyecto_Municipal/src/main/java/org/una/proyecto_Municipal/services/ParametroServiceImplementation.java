package org.una.proyecto_Municipal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.proyecto_Municipal.dto.ParametroDTO;
import org.una.proyecto_Municipal.dto.PropiedadDTO;
import org.una.proyecto_Municipal.entities.Parametro;
import org.una.proyecto_Municipal.entities.Propiedad;
import org.una.proyecto_Municipal.exceptions.NotFoundInformationException;
import org.una.proyecto_Municipal.repositories.IParametroRepository;
import org.una.proyecto_Municipal.utils.MapperUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ParametroServiceImplementation implements IParametroService{

    @Autowired
    private IParametroRepository parametroRepository;


    //findBy...
    @Override
    @Transactional(readOnly = true)
    public Optional<ParametroDTO> findById(Long id) {
        Optional<Parametro> parametro = parametroRepository.findById(id);
        if (parametro.isEmpty()) throw new NotFoundInformationException();
        ParametroDTO parametroDTO = MapperUtils.DtoFromEntity(parametro.get(), ParametroDTO.class);
        return Optional.ofNullable(parametroDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ParametroDTO>> findAll( Long funId) {
        parametroRepository.registrarTransaccion("buscar todos", "Parametro",funId,null);
        List<ParametroDTO> parametroDTOList = MapperUtils.DtoListFromEntityList(parametroRepository.findAll(), ParametroDTO.class);
        return Optional.ofNullable(parametroDTOList);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ParametroDTO>> findByNombre(String nombre, Long funId) {
        List<Parametro> parametroList = parametroRepository.findByNombre(nombre);
        List<ParametroDTO> parametroDTOList =  MapperUtils.DtoListFromEntityList(parametroList, ParametroDTO.class);
        parametroRepository.registrarTransaccion("buscar por nombre", "Parametro",funId,nombre);
        return Optional.ofNullable(parametroDTOList);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ParametroDTO>> findByValor(int valor, Long funId) {
        parametroRepository.registrarTransaccion("buscar por valor", "Parametro",funId,String.valueOf(valor));
        List<Parametro> parametroList = parametroRepository.findByValor(valor);
        List<ParametroDTO> parametroDTOList = MapperUtils.DtoListFromEntityList(parametroList, ParametroDTO.class);
        return Optional.ofNullable(parametroDTOList);
    }

    //get
    private ParametroDTO getSavedParametroDTO(ParametroDTO parametroDTO) {
        Parametro parametro = MapperUtils.EntityFromDto(parametroDTO, Parametro.class);
        Parametro parametroCreated = parametroRepository.save(parametro);
        return MapperUtils.DtoFromEntity(parametroCreated, ParametroDTO.class);
    }

    //create & update
    @Override
    @Transactional
    public Optional<ParametroDTO> create(ParametroDTO parametroDTO, Long funId) throws ParseException {
        parametroRepository.registrarTransaccion("crear", "Parametro",funId,null);
        return Optional.ofNullable(getSavedParametroDTO(parametroDTO));
    }

    @Override
    @Transactional
    public Optional<ParametroDTO> update(ParametroDTO parametroDTO, Long id, Long funId) throws ParseException {
        if (parametroRepository.findById(id).isEmpty()) throw new NotFoundInformationException();
        parametroRepository.registrarTransaccion("actualizar", "Parametro",funId,String.valueOf(id));

        return Optional.ofNullable(getSavedParametroDTO(parametroDTO));

    }

    //detele...
    @Override
    @Transactional
    public void delete(Long id,  Long funId) throws ParseException {
        parametroRepository.registrarTransaccion("eliminar", "Parametro",funId,String.valueOf(id));
        parametroRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() throws ParseException {
        parametroRepository.deleteAll();
    }

    @Override
    public Optional<List<ParametroDTO>> findByEstado(boolean estado, Long funId) {

        List<Parametro> propiedadList = parametroRepository.findByEstado(estado);
        parametroRepository.registrarTransaccion("buscar por estado", "Parametro",funId,String.valueOf(estado));
        List<ParametroDTO> propiedadDTOList = MapperUtils.DtoListFromEntityList(propiedadList, ParametroDTO.class);
        return Optional.ofNullable(propiedadDTOList);
    }

}
