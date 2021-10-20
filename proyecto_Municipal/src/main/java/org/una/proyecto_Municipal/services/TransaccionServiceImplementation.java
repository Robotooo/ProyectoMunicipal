package org.una.proyecto_Municipal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.proyecto_Municipal.dto.RutaDTO;
import org.una.proyecto_Municipal.dto.TransaccionDTO;
import org.una.proyecto_Municipal.entities.Transaccion;
import org.una.proyecto_Municipal.exceptions.NotFoundInformationException;
import org.una.proyecto_Municipal.repositories.ITransaccionRepository;
import org.una.proyecto_Municipal.utils.MapperUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransaccionServiceImplementation implements ITransaccionService{

    @Autowired
    ITransaccionRepository transaccionRepository;

    @Override
    public Optional<TransaccionDTO> findById(Long id) {
        Optional<Transaccion> transaccion = transaccionRepository.findById(id);
        if (transaccion.isEmpty()) throw new NotFoundInformationException();

        TransaccionDTO transaccionDTO = MapperUtils.DtoFromEntity(transaccion.get(), TransaccionDTO.class);
        return Optional.ofNullable(transaccionDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<TransaccionDTO>> findAll() {
        List<TransaccionDTO> transaccionDTOList = MapperUtils.DtoListFromEntityList(transaccionRepository.findAll(), TransaccionDTO.class);
        return Optional.ofNullable(transaccionDTOList);
    }

    @Override
    public Optional<List<TransaccionDTO>> findByFuncionarioIdAndFechaCreacionBetween(Long usuarioId, Date startDate, Date endDate) {
        List<Transaccion> transacciones = transaccionRepository.findByFuncionarioIdAndFechaCreacionBetween(usuarioId, startDate, endDate);
        List<TransaccionDTO> transaccionDTOList = MapperUtils.DtoListFromEntityList(transacciones, TransaccionDTO.class);
        return Optional.ofNullable(transaccionDTOList);
    }

    @Override
    public Optional<List<TransaccionDTO>> findByRolIdAndFechaCreacionBetween(Long rolId, Date startDate, Date endDate) {
        List<Transaccion> transacciones = transaccionRepository.findByRolIdAndFechaCreacionBetween(rolId, startDate, endDate);
        List<TransaccionDTO> transaccionDTOList = MapperUtils.DtoListFromEntityList(transacciones, TransaccionDTO.class);
        return Optional.ofNullable(transaccionDTOList);
    }

    @Override
    public Optional<List<TransaccionDTO>> findByObjetoAndFechaCreacionBetween(String objeto, Date startDate, Date endDate) {
        List<Transaccion> transacciones = transaccionRepository.findByObjetoAndFechaCreacionBetween(objeto, startDate, endDate);
        List<TransaccionDTO> transaccionDTOList = MapperUtils.DtoListFromEntityList(transacciones, TransaccionDTO.class);
        return Optional.ofNullable(transaccionDTOList);
    }

    @Override
    public Optional<List<TransaccionDTO>> findByFechaCreacionBetween(Date startDate, Date endDate) {
        List<Transaccion> transacciones = transaccionRepository.findByFechaCreacionBetween(startDate, endDate);
        List<TransaccionDTO> transaccionDTOList = MapperUtils.DtoListFromEntityList(transacciones, TransaccionDTO.class);
        return Optional.ofNullable(transaccionDTOList);
    }

    //get
    private TransaccionDTO getSavedTransaccionDTO(TransaccionDTO transaccionDTO) {
        Transaccion transaccion = MapperUtils.EntityFromDto(transaccionDTO, Transaccion.class);
        Transaccion transaccionCreated = transaccionRepository.save(transaccion);
        return MapperUtils.DtoFromEntity(transaccionCreated, TransaccionDTO.class);
    }

    //create & update
    @Override
    @Transactional
    public Optional<TransaccionDTO> create(TransaccionDTO transaccionDTO) {
        return Optional.ofNullable(getSavedTransaccionDTO(transaccionDTO));
    }

    @Override
    @Transactional
    public Optional<TransaccionDTO> update(TransaccionDTO transaccionDTO, Long id) {
        if (transaccionRepository.findById(id).isEmpty()) throw new NotFoundInformationException();

        return Optional.ofNullable(getSavedTransaccionDTO(transaccionDTO));

    }

    //delete
    @Override
    @Transactional
    public void delete(Long id) {
        transaccionRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        transaccionRepository.deleteAll();
    }

//    @Override
//    public Optional<List<TransaccionDTO>> findByFuncionarioId(Long id) {
//        List<TransaccionDTO> transaccionDTOList = MapperUtils.DtoListFromEntityList(transaccionRepository.findByFuncionarioId(id), TransaccionDTO.class);
//        if (transaccionDTOList.isEmpty()) throw new NotFoundInformationException();
//        return Optional.ofNullable(transaccionDTOList);
//    }
//
//    @Override
//    public Optional<List<TransaccionDTO>> findByUsuarioIdAndFechaCreacionBetween(Long usuarioId, Date startDate, Date endDate) {
//        List<Transaccion> transaccionList = transaccionRepository.findByUsuarioIdAndFechaCreacionBetween(usuarioId,startDate,endDate);
//        List<TransaccionDTO> transaccionDTOList =  MapperUtils.DtoListFromEntityList(transaccionList, TransaccionDTO.class);
//        return Optional.ofNullable(transaccionDTOList);    }
//
//    @Override
//    public Optional<List<TransaccionDTO>> findByRolIdAndFechaCreacionBetween(Long rolId, Date startDate, Date endDate) {
//        List<Transaccion> transaccionList = transaccionRepository.findByRolIdAndFechaCreacionBetween(rolId,startDate,endDate);
//        List<TransaccionDTO> transaccionDTOList =  MapperUtils.DtoListFromEntityList(transaccionList, TransaccionDTO.class);
//        return Optional.ofNullable(transaccionDTOList);    }
//
//    @Override
//    public Optional<List<TransaccionDTO>> findByObjetoAndFechaCreacionBetween(String objetoId, Date startDate, Date endDate) {
//        List<Transaccion> transaccionList = transaccionRepository.findByObjetoAndFechaCreacionBetween(objetoId,startDate,endDate);
//        List<TransaccionDTO> transaccionDTOList =  MapperUtils.DtoListFromEntityList(transaccionList, TransaccionDTO.class);
//        return Optional.ofNullable(transaccionDTOList);    }
//
//    @Override
//    public Optional<List<TransaccionDTO>> findByFechaCreacionBetween(Date startDate, Date endDate) {
//        List<Transaccion> transaccionList = transaccionRepository.findByFechaCreacionBetween(startDate,endDate);
//        List<TransaccionDTO> transaccionDTOList =  MapperUtils.DtoListFromEntityList(transaccionList, TransaccionDTO.class);
//        return Optional.ofNullable(transaccionDTOList);    }

}
