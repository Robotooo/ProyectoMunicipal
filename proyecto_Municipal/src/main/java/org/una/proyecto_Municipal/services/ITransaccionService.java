package org.una.proyecto_Municipal.services;

import org.una.proyecto_Municipal.dto.RutaDTO;
import org.una.proyecto_Municipal.dto.TransaccionDTO;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ITransaccionService {

    public Optional<TransaccionDTO> findById(long id);

    public Optional<List<TransaccionDTO>> findAll();

    public Optional<List<TransaccionDTO>> findByFuncionarioIdAndFechaCreacionBetween(long usuarioId, Date startDate, Date endDate);

//    public Optional<List<TransaccionDTO>> findByRolIdAndFechaCreacionBetween(long rolId, Date startDate, Date endDate);

    public Optional<List<TransaccionDTO>> findByObjetoAndFechaCreacionBetween(String objetoId, Date startDate, Date endDate);

    public Optional<List<TransaccionDTO>> findByFechaCreacionBetween(Date startDate, Date endDate);

    public Optional<TransaccionDTO> create(TransaccionDTO transaccionDTO);

    public Optional<TransaccionDTO> update(TransaccionDTO transaccionDTO, long id);

    public void delete(long id);

    public void deleteAll();
}
