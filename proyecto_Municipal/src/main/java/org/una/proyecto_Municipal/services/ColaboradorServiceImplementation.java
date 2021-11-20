package org.una.proyecto_Municipal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.proyecto_Municipal.dto.ColaboradorDTO;
import org.una.proyecto_Municipal.entities.Colaborador;
import org.una.proyecto_Municipal.exceptions.NotFoundInformationException;
import org.una.proyecto_Municipal.repositories.IColaboradorRepository;
import org.una.proyecto_Municipal.utils.MapperUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ColaboradorServiceImplementation implements IColaboradorService {

    @Autowired
    private IColaboradorRepository colaboradorRepository;

    public ColaboradorServiceImplementation() throws ParseException {
    }


    @Override
    public Optional<ColaboradorDTO> findById(Long id,Long funId) throws ParseException {
        Optional<Colaborador> colaborador = colaboradorRepository.findById(id);
        if (colaborador.isEmpty()) throw new NotFoundInformationException();
        colaboradorRepository.registrarTransaccion("buscar por id","Colaborador",funId,String.valueOf(id));
        ColaboradorDTO colaboradorDTO = MapperUtils.DtoFromEntity(colaborador.get(), ColaboradorDTO.class);
        return Optional.ofNullable(colaboradorDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ColaboradorDTO>> findAll(Long funId) throws ParseException {
        List<ColaboradorDTO> colaboradorDTOList = MapperUtils.DtoListFromEntityList(colaboradorRepository.findAll(), ColaboradorDTO.class);
        colaboradorRepository.registrarTransaccion("buscar todos","Colaborador",funId,null);
        return Optional.ofNullable(colaboradorDTOList);
    }

    @Override
    public Optional<List<ColaboradorDTO>> findByEstado(boolean estado,Long funId) throws ParseException {
        colaboradorRepository.registrarTransaccion("buscar por cedula","Colaborador",funId,String.valueOf(estado));
        List<Colaborador> colaboradorList = colaboradorRepository.findByEstado(estado);
        List<ColaboradorDTO> colaboradorDTOList = MapperUtils.DtoListFromEntityList(colaboradorList, ColaboradorDTO.class);

        return Optional.ofNullable(colaboradorDTOList);
    }

    @Override
    public Optional<List<ColaboradorDTO>> findByNombre(String nombre,Long funId) {
        List<Colaborador> colaboradorList = colaboradorRepository.findByNombre(nombre);
        colaboradorRepository.registrarTransaccion("buscar por nombre","Colaborador",funId,nombre);
        List<ColaboradorDTO> colaboradorDTOList = MapperUtils.DtoListFromEntityList(colaboradorList, ColaboradorDTO.class);
        return Optional.ofNullable(colaboradorDTOList);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ColaboradorDTO>> findByCedulaAproximate(String cedula,Long funId) {
        colaboradorRepository.registrarTransaccion("buscar por cedula","Colaborador",funId,cedula);
        List<Colaborador> colaboradorList = colaboradorRepository.findByCedulaContaining(cedula);
        List<ColaboradorDTO> colaboradorDTOList = MapperUtils.DtoListFromEntityList(colaboradorList, ColaboradorDTO.class);
        return Optional.ofNullable(colaboradorDTOList);
    }

    @Override
    public Optional<List<ColaboradorDTO>> findByTelefono(String telefono,Long funId) {
        List<Colaborador> colaboradorList = colaboradorRepository.findByTelefono(telefono);
        List<ColaboradorDTO> colaboradorDTOList = MapperUtils.DtoListFromEntityList(colaboradorList, ColaboradorDTO.class);
        colaboradorRepository.registrarTransaccion("buscar por telefono","Colaborador",funId,telefono);
        return Optional.ofNullable(colaboradorDTOList);
    }

    //get
    private ColaboradorDTO getSavedColaboradorDTO(ColaboradorDTO colaboradorDTO) {
        Colaborador colaborador = MapperUtils.EntityFromDto(colaboradorDTO, Colaborador.class);
        Colaborador colaboradorCreated = colaboradorRepository.save(colaborador);
        return MapperUtils.DtoFromEntity(colaboradorCreated, ColaboradorDTO.class);
    }

    //create & update
    @Override
    @Transactional
    public Optional<ColaboradorDTO> create(ColaboradorDTO colaboradorDTO,Long funId) throws ParseException {
        colaboradorRepository.registrarTransaccion("crear","Colaborador",funId,null);
        return Optional.ofNullable(getSavedColaboradorDTO(colaboradorDTO));
    }

    @Override
    @Transactional
    public Optional<ColaboradorDTO> update(ColaboradorDTO colaboradorDTO, Long id,Long funId) throws ParseException {
        if (colaboradorRepository.findById(id).isEmpty()) throw new NotFoundInformationException();
        colaboradorRepository.registrarTransaccion("actualizar","Colaborador",funId,String.valueOf(id));
        return Optional.ofNullable(getSavedColaboradorDTO(colaboradorDTO));

    }

    @Override
    @Transactional
    public void delete(Long id,Long funId) throws ParseException {
        colaboradorRepository.registrarTransaccion("eliminar","Colaborador",funId,String.valueOf(id));
        colaboradorRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll(Long funId) throws ParseException {
        colaboradorRepository.registrarTransaccion("eliminar todos","Colaborador",funId,null);
        colaboradorRepository.deleteAll();
    }

    @Override
    public Optional<List<ColaboradorDTO>> findByBienId(Long bienId,Long funId) {
        return Optional.empty();
    }

}
