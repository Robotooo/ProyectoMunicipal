package org.una.proyecto_Municipal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.proyecto_Municipal.dto.ParametroDTO;
import org.una.proyecto_Municipal.entities.Parametro;
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

    Date date = new SimpleDateFormat("yyyy-mm-dd").parse("2021-11-16");

    public ParametroServiceImplementation() throws ParseException {
    }

    //findBy...
    @Override
    @Transactional(readOnly = true)
    public Optional<ParametroDTO> findById(Long id) {
        Optional<Parametro> parametro = parametroRepository.findById(id);
        if (parametro.isEmpty()) throw new NotFoundInformationException();
        parametroRepository.saveTransaction("buscar por Id","Parametro","2",date);

        ParametroDTO parametroDTO = MapperUtils.DtoFromEntity(parametro.get(), ParametroDTO.class);
        return Optional.ofNullable(parametroDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ParametroDTO>> findAll() {
        parametroRepository.saveTransaction("buscar todos","Parametro","2",date);
        List<ParametroDTO> parametroDTOList = MapperUtils.DtoListFromEntityList(parametroRepository.findAll(), ParametroDTO.class);
        return Optional.ofNullable(parametroDTOList);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ParametroDTO>> findByNombre(String nombre) {
        List<Parametro> parametroList = parametroRepository.findByNombre(nombre);
        List<ParametroDTO> parametroDTOList =  MapperUtils.DtoListFromEntityList(parametroList, ParametroDTO.class);
        return Optional.ofNullable(parametroDTOList);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ParametroDTO>> findByValor(int valor) {
        parametroRepository.saveTransaction("buscar por valor","Parametro","2",date);
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
    public Optional<ParametroDTO> create(ParametroDTO parametroDTO) throws ParseException {
        //parametroRepository.saveTransaction("crear","Parametro","2",date);
        return Optional.ofNullable(getSavedParametroDTO(parametroDTO));
    }

    @Override
    @Transactional
    public Optional<ParametroDTO> update(ParametroDTO parametroDTO, Long id) throws ParseException {
        if (parametroRepository.findById(id).isEmpty()) throw new NotFoundInformationException();
        parametroRepository.saveTransaction("actualizar","Parametro","2",date);

        return Optional.ofNullable(getSavedParametroDTO(parametroDTO));

    }

    //detele...
    @Override
    @Transactional
    public void delete(Long id) throws ParseException {
        parametroRepository.saveTransaction("eliminacion","Parametro","2",date);
        parametroRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() throws ParseException {
        parametroRepository.saveTransaction("eliminacion de todos los elementos","Parametro","2",date);
        parametroRepository.deleteAll();
    }

}
