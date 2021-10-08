package org.una.proyecto_Municipal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.una.proyecto_Municipal.dto.ColaboradorDTO;
import org.una.proyecto_Municipal.dto.RolDTO;
import org.una.proyecto_Municipal.entities.Colaborador;
import org.una.proyecto_Municipal.entities.Rol;
import org.una.proyecto_Municipal.exceptions.NotFoundInformationException;
import org.una.proyecto_Municipal.repositories.IColaboradorRepository;
import org.una.proyecto_Municipal.repositories.IRolRepository;
import org.una.proyecto_Municipal.utils.MapperUtils;

import java.util.List;
import java.util.Optional;

public class ColaboradorServiceImplementation implements IColaboradorService {

    @Autowired
    private IColaboradorRepository colaboradorRepository;


    @Override
    public Optional<ColaboradorDTO> findById(Long id) {
        Optional<Colaborador> colaborador = colaboradorRepository.findById(id);
        if (colaborador.isEmpty()) throw new NotFoundInformationException();

        ColaboradorDTO colaboradorDTO = MapperUtils.DtoFromEntity(colaborador.get(), ColaboradorDTO.class);
        return Optional.ofNullable(colaboradorDTO);
    }

    @Override
    public Optional<List<ColaboradorDTO>> findByEstado(boolean estado) {
        return Optional.empty();
    }

    @Override
    public Optional<List<ColaboradorDTO>> findByNombre(String nombre) {
        return Optional.empty();
    }

    @Override
    public Optional<List<ColaboradorDTO>> findByTelefono(String telefono) {
        return Optional.empty();
    }
}
