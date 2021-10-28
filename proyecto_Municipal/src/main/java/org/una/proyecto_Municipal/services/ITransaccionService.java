package org.una.proyecto_Municipal.services;

import org.una.proyecto_Municipal.dto.RutaDTO;
import org.una.proyecto_Municipal.dto.TransaccionDTO;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ITransaccionService {

    public Optional<TransaccionDTO> findById(Long id);

    public Optional<List<TransaccionDTO>> findAll();

    public Optional<List<TransaccionDTO>> findByFuncionarioIdAndFechaCreacionBetween(Long usuarioId, Date startDate, Date endDate);

    //public Optional<List<TransaccionDTO>> findByRolIdAndFechaCreacionBetween(Long rolId, Date startDate, Date endDate);

    public Optional<List<TransaccionDTO>> findByObjetoAndFechaCreacionBetween(String objetoId, Date startDate, Date endDate);

    public Optional<List<TransaccionDTO>> findByFechaCreacionBetween(Date startDate, Date endDate);

    public Optional<List<TransaccionDTO>> findByFuncionarioId(Long funcionarioId);

    public Optional<TransaccionDTO> create(TransaccionDTO transaccionDTO);

    public Optional<TransaccionDTO> update(TransaccionDTO transaccionDTO, Long id);

    public void delete(Long id);

    public void deleteAll();
}
