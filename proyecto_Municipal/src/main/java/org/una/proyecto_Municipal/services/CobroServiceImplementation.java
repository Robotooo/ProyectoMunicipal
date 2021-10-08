package org.una.proyecto_Municipal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.una.proyecto_Municipal.dto.CobroDTO;
import org.una.proyecto_Municipal.dto.ParametroDTO;
import org.una.proyecto_Municipal.entities.Cobro;
import org.una.proyecto_Municipal.entities.Parametro;
import org.una.proyecto_Municipal.exceptions.NotFoundInformationException;
import org.una.proyecto_Municipal.repositories.ICobroRepository;
import org.una.proyecto_Municipal.repositories.IParametroRepository;
import org.una.proyecto_Municipal.utils.MapperUtils;

import java.util.Optional;

public class CobroServiceImplementation implements ICobroService{

    @Autowired
    private ICobroRepository cobroRepository;

    @Override
    public Optional<CobroDTO> findById(Long id) {
        Optional<Cobro> cobro = cobroRepository.findById(id);
        if (cobro.isEmpty()) throw new NotFoundInformationException();

        CobroDTO cobroDTO = MapperUtils.DtoFromEntity(cobro.get(), CobroDTO.class);
        return Optional.ofNullable(cobroDTO);
    }
}
