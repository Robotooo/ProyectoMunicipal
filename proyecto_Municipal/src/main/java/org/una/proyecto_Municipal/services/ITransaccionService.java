package org.una.proyecto_Municipal.services;

import org.una.proyecto_Municipal.dto.TransaccionDTO;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ITransaccionService {

    public Optional<TransaccionDTO> findById(Long id);

    public Optional<List<TransaccionDTO>> findAll();

    public Optional<List<TransaccionDTO>> findByFuncionarioIdAndFechaCreacionBetween(Long usuarioId, Date startDate, Date endDate,Long idFuncionario);

    public Optional<List<TransaccionDTO>> findByObjetoAndFechaCreacionBetween(String objetoId, Date startDate, Date endDate, Long idFuncionario);

    public Optional<List<TransaccionDTO>> findByFechaCreacionBetween(Date startDate, Date endDate, Long idFuncionario);

    public Optional<List<TransaccionDTO>> findByFuncionarioId(Long funcionarioId, Long idFuncionario);

    public Optional<TransaccionDTO> create(TransaccionDTO transaccionDTO, Long idFuncionario);

    public Optional<TransaccionDTO> update(TransaccionDTO transaccionDTO,  Long id, Long idFuncionario);

    public void delete(Long id, Long idFuncionario);

    public void deleteAll();
}
