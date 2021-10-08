package org.una.proyecto_Municipal.services;

import org.una.proyecto_Municipal.dto.TransaccionDTO;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class TransaccionServiceImplementation implements ITransaccionService{


    ITransaccionRepository transaccionRepository;

    @Override
    public Optional<TransaccionDTO> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<List<TransaccionDTO>> findByUsuarioIdAndFechaCreacionBetween(Long usuarioId, Date startDate, Date endDate) {
        return Optional.empty();
    }

    @Override
    public Optional<List<TransaccionDTO>> findByRolIdAndFechaCreacionBetween(Long rolId, Date startDate, Date endDate) {
        return Optional.empty();
    }

    @Override
    public Optional<List<TransaccionDTO>> findByObjetoAndFechaCreacionBetween(String objetoId, Date startDate, Date endDate) {
        return Optional.empty();
    }

    @Override
    public Optional<List<TransaccionDTO>> findByFechaCreacionBetween(Date startDate, Date endDate) {
        return Optional.empty();
    }

    @Override
    public TransaccionDTO create(TransaccionDTO transaccionDTO) {
        return null;
    }
}
