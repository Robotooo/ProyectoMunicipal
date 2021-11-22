package org.una.proyecto_Municipal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.proyecto_Municipal.dto.TransaccionDTO;
import org.una.proyecto_Municipal.entities.Transaccion;
import org.una.proyecto_Municipal.exceptions.NotFoundInformationException;
import org.una.proyecto_Municipal.repositories.ITransaccionRepository;
import org.una.proyecto_Municipal.utils.MapperUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransaccionServiceImplementation implements ITransaccionService {

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
    public Optional<List<TransaccionDTO>> findByFuncionarioIdAndFechaCreacionBetween(Long usuarioId, Date startDate, Date endDate, Long idFuncionario) {
        List<Transaccion> transacciones = transaccionRepository.findByFuncionarioIdAndFechaCreacionBetween(usuarioId, startDate, endDate);
        List<TransaccionDTO> transaccionDTOList = MapperUtils.DtoListFromEntityList(transacciones, TransaccionDTO.class);
        transaccionRepository.registrarTransaccion("Buscar Por FuncionarioId y Fecha Creacion Between", "Transaccion", idFuncionario, String.valueOf(usuarioId));
        return Optional.ofNullable(transaccionDTOList);
    }


    @Override
    public Optional<List<TransaccionDTO>> findByObjetoAndFechaCreacionBetween(String objeto, Date startDate, Date endDate, Long idFuncionario) {
        List<Transaccion> transacciones = transaccionRepository.findByObjetoAndFechaCreacionBetween(objeto, startDate, endDate);
        List<TransaccionDTO> transaccionDTOList = MapperUtils.DtoListFromEntityList(transacciones, TransaccionDTO.class);
        transaccionRepository.registrarTransaccion("Buscar Por FuncionarioId y Fecha Creacion Between", "Transaccion", idFuncionario, objeto);
        return Optional.ofNullable(transaccionDTOList);
    }

    @Override
    public Optional<List<TransaccionDTO>> findByFechaCreacionBetween(Date startDate, Date endDate, Long idFuncionario) {
        List<Transaccion> transacciones = transaccionRepository.findByFechaCreacionBetween(startDate, endDate);
        List<TransaccionDTO> transaccionDTOList = MapperUtils.DtoListFromEntityList(transacciones, TransaccionDTO.class);
        transaccionRepository.registrarTransaccion("Buscar Por FuncionarioId y Fecha Creacion Between", "Transaccion", idFuncionario, String.valueOf(startDate));
        return Optional.ofNullable(transaccionDTOList);
    }

    @Override
    public Optional<List<TransaccionDTO>> findByFuncionarioId(Long funcionarioId, Long idFuncionario) {
        List<Transaccion> transacciones = transaccionRepository.findByFuncionarioId(funcionarioId);
        List<TransaccionDTO> transaccionDTOList = MapperUtils.DtoListFromEntityList(transacciones, TransaccionDTO.class);
        transaccionRepository.registrarTransaccion("Buscar Por FuncionarioId y Fecha Creacion Between", "Transaccion", idFuncionario, String.valueOf(funcionarioId));
        return Optional.ofNullable(transaccionDTOList);
    }

    private TransaccionDTO getSavedTransaccionDTO(TransaccionDTO transaccionDTO) {
        Transaccion transaccion = MapperUtils.EntityFromDto(transaccionDTO, Transaccion.class);
        Transaccion transaccionCreated = transaccionRepository.save(transaccion);
        return MapperUtils.DtoFromEntity(transaccionCreated, TransaccionDTO.class);
    }

    @Override
    @Transactional
    public Optional<TransaccionDTO> create(TransaccionDTO transaccionDTO, Long idFuncionario) {
        transaccionRepository.registrarTransaccion("Crear Transaccion", "Transaccion", idFuncionario, null);
        return Optional.ofNullable(getSavedTransaccionDTO(transaccionDTO));
    }

    @Override
    @Transactional
    public Optional<TransaccionDTO> update(TransaccionDTO transaccionDTO, Long id, Long idFuncionario) {
        if (transaccionRepository.findById(id).isEmpty()) throw new NotFoundInformationException();
        transaccionRepository.registrarTransaccion("Actualizar Transaccion", "Transaccion", idFuncionario, String.valueOf(transaccionDTO.getId()));

        return Optional.ofNullable(getSavedTransaccionDTO(transaccionDTO));

    }

    //delete
    @Override
    @Transactional
    public void delete(Long id, Long idFuncionario) {

        transaccionRepository.registrarTransaccion("Eliminar Transaccion", "Transaccion", idFuncionario, String.valueOf(id));
        transaccionRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        transaccionRepository.deleteAll();
    }

}