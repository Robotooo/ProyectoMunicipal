package org.una.proyecto_Municipal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.proyecto_Municipal.dto.BienxColaboradorDTO;
import org.una.proyecto_Municipal.entities.BienxColaborador;
import org.una.proyecto_Municipal.exceptions.NotFoundInformationException;
import org.una.proyecto_Municipal.repositories.IBienxColaboradorRepository;
import org.una.proyecto_Municipal.utils.MapperUtils;

import java.util.List;
import java.util.Optional;

@Service
public class BienxColaboradorServiceImplementation implements IBienxColaboradorService{

    @Autowired
    private IBienxColaboradorRepository bienxcolaboradorRepository;

    @Override
    public Optional<List<BienxColaboradorDTO>> findByBienId(Long id) {
        List<BienxColaboradorDTO> bienxcolaboradorDTOList = MapperUtils.DtoListFromEntityList(bienxcolaboradorRepository.findByBienId(id), BienxColaboradorDTO.class);
        if (bienxcolaboradorDTOList.isEmpty()) throw new NotFoundInformationException();
        return Optional.ofNullable(bienxcolaboradorDTOList);
    }

    @Override
    public Optional<List<BienxColaboradorDTO>> findByColaboradorId(Long id) {
        List<BienxColaboradorDTO> bienxcolaboradorDTOList = MapperUtils.DtoListFromEntityList(bienxcolaboradorRepository.findByColaboradorId(id), BienxColaboradorDTO.class);
        if (bienxcolaboradorDTOList.isEmpty()) throw new NotFoundInformationException();
        return Optional.ofNullable(bienxcolaboradorDTOList);
    }

    //findBy...
    @Override
    public Optional<BienxColaboradorDTO> findById(Long id) {
        Optional<BienxColaborador> bienxcolaborador = bienxcolaboradorRepository.findById(id);
        if (bienxcolaborador.isEmpty()) throw new NotFoundInformationException();

        BienxColaboradorDTO bienDTO = MapperUtils.DtoFromEntity(bienxcolaborador.get(), BienxColaboradorDTO.class);
        return Optional.ofNullable(bienDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<BienxColaboradorDTO>> findAll() {
        List<BienxColaboradorDTO> bienDTOList = MapperUtils.DtoListFromEntityList(bienxcolaboradorRepository.findAll(), BienxColaboradorDTO.class);
        return Optional.ofNullable(bienDTOList);
    }

    //get
    private BienxColaboradorDTO getSavedBienxColaboradorDTO(BienxColaboradorDTO bienxcolaboradorDTO) {
        BienxColaborador bien = MapperUtils.EntityFromDto(bienxcolaboradorDTO, BienxColaborador.class);
        BienxColaborador bienCreated = bienxcolaboradorRepository.save(bien);
        return MapperUtils.DtoFromEntity(bienCreated, BienxColaboradorDTO.class);
    }

    //create & update
    @Override
    @Transactional
    public Optional<BienxColaboradorDTO> create(BienxColaboradorDTO bienDTO) {
        return Optional.ofNullable(getSavedBienxColaboradorDTO(bienDTO));
    }

    //@Override
    @Transactional
    public Optional<BienxColaboradorDTO> update(BienxColaboradorDTO bienxcolaboradorDTO, Long id) {
        if (bienxcolaboradorRepository.findById(id).isEmpty()) throw new NotFoundInformationException();

        return Optional.ofNullable(getSavedBienxColaboradorDTO(bienxcolaboradorDTO));

    }

    //detele...
    @Override
    @Transactional
    public void delete(Long id) {
        bienxcolaboradorRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        bienxcolaboradorRepository.deleteAll();
    }

}
