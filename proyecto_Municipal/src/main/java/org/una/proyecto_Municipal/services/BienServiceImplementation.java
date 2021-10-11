package org.una.proyecto_Municipal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.una.proyecto_Municipal.dto.BienDTO;
import org.una.proyecto_Municipal.entities.Bien;
import org.una.proyecto_Municipal.exceptions.NotFoundInformationException;
import org.una.proyecto_Municipal.repositories.IBienRepository;
import org.una.proyecto_Municipal.utils.MapperUtils;

import java.util.Optional;

@Service
public class BienServiceImplementation implements IBienService{

    @Autowired
    private IBienRepository bienRepository;

    @Override
    public Optional<BienDTO> findById(Long id) {
        Optional<Bien> bien = bienRepository.findById(id);
        if (bien.isEmpty()) throw new NotFoundInformationException();

        BienDTO bienDTO = MapperUtils.DtoFromEntity(bien.get(), BienDTO.class);
        return Optional.ofNullable(bienDTO);
    }

}
