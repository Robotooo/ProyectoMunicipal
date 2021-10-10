package org.una.proyecto_Municipal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.proyecto_Municipal.dto.ContribuyenteDTO;
import org.una.proyecto_Municipal.entities.Contribuyente;
import org.una.proyecto_Municipal.exceptions.NotFoundInformationException;
import org.una.proyecto_Municipal.repositories.IContribuyenteRepository;
import org.una.proyecto_Municipal.utils.MapperUtils;

import java.util.List;
import java.util.Optional;

@Service
public class ContribuyenteServiceImplementation implements IContribuyenteService {

    @Autowired
    private IContribuyenteRepository contribuyenteRepository;

    //findBy...
    @Override
    public Optional<ContribuyenteDTO> findById(Long id) {
        Optional<Contribuyente> contribuyente = contribuyenteRepository.findById(id);
        if (contribuyente.isEmpty()) throw new NotFoundInformationException();

        ContribuyenteDTO contribuyenteDTO = MapperUtils.DtoFromEntity(contribuyente.get(), ContribuyenteDTO.class);
        return Optional.ofNullable(contribuyenteDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ContribuyenteDTO>> findAll() {
        List<ContribuyenteDTO> contribuyenteDTOList = MapperUtils.DtoListFromEntityList(contribuyenteRepository.findAll(), ContribuyenteDTO.class);
        return Optional.ofNullable(contribuyenteDTOList);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ContribuyenteDTO>> findByNombreAproximateIgnoreCase(String nombreCompleto) {
        List<Contribuyente> contribuyenteList = contribuyenteRepository.findByNombreContainingIgnoreCase(nombreCompleto);
        List<ContribuyenteDTO> contribuyenteDTOList = MapperUtils.DtoListFromEntityList(contribuyenteList, ContribuyenteDTO.class);
        return Optional.ofNullable(contribuyenteDTOList);

    }

    @Override
    public Optional<List<ContribuyenteDTO>> findByCedulaAproximate(String cedula) {
        if (cedula.trim().isEmpty()) throw new NotFoundInformationException();
        List<Contribuyente> contribuyenteList = contribuyenteRepository.findByCedulaContaining(cedula);
        if (contribuyenteList.isEmpty()) throw new NotFoundInformationException();

        List<ContribuyenteDTO> contribuyenteDTOList = MapperUtils.DtoListFromEntityList(contribuyenteList, ContribuyenteDTO.class);
        if (contribuyenteDTOList.isEmpty()) throw new NotFoundInformationException();

        return Optional.ofNullable(contribuyenteDTOList);
    }

    @Override
    public Optional<List<ContribuyenteDTO>> findByEstado(boolean estado) {
        List<Contribuyente> contribuyenteList = contribuyenteRepository.findByEstado(estado);
        List<ContribuyenteDTO> contribuyenteDTOList = MapperUtils.DtoListFromEntityList(contribuyenteList, ContribuyenteDTO.class);
        return Optional.ofNullable(contribuyenteDTOList);
    }

    @Override
    public Optional<List<ContribuyenteDTO>> findByNombre(String nombre) {
        List<Contribuyente> contribuyenteList = contribuyenteRepository.findByNombre(nombre);
        List<ContribuyenteDTO> contribuyenteDTOList = MapperUtils.DtoListFromEntityList(contribuyenteList, ContribuyenteDTO.class);
        return Optional.ofNullable(contribuyenteDTOList);
    }

    @Override
    public Optional<ContribuyenteDTO> findByTelefono(String telefono) {
        Contribuyente contribuyente = (Contribuyente) contribuyenteRepository.findByTelefono(telefono);
        ContribuyenteDTO contribuyenteDTO = MapperUtils.DtoFromEntity(contribuyente, ContribuyenteDTO.class);
        return Optional.ofNullable(contribuyenteDTO);
    }

    //detele...
    @Override
    @Transactional
    public void delete(Long id) {
        contribuyenteRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        contribuyenteRepository.deleteAll();
    }

    //get
    private ContribuyenteDTO getSavedContribuyenteDTO(ContribuyenteDTO usuarioDTO) {
        Contribuyente contribuyente = MapperUtils.EntityFromDto(usuarioDTO, Contribuyente.class);
        Contribuyente contribuyenteCreated = contribuyenteRepository.save(contribuyente);
        return MapperUtils.DtoFromEntity(contribuyenteCreated, ContribuyenteDTO.class);
    }

    //create & update
    @Override
    @Transactional
    public Optional<ContribuyenteDTO> create(ContribuyenteDTO contribuyenteDTO) {
        return Optional.ofNullable(getSavedContribuyenteDTO(contribuyenteDTO));
    }

    @Override
    @Transactional
    public Optional<ContribuyenteDTO> update(ContribuyenteDTO contribuyenteDTO, Long id) {
        if (contribuyenteRepository.findById(id).isEmpty()) throw new NotFoundInformationException();

        return Optional.ofNullable(getSavedContribuyenteDTO(contribuyenteDTO));

    }

}

