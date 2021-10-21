package org.una.proyecto_Municipal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.proyecto_Municipal.entities.Transaccion;

import java.util.Date;
import java.util.List;

public interface ITransaccionRepository extends JpaRepository<Transaccion, long> {

    public List<Transaccion> findByFuncionarioIdAndFechaCreacionBetween(long usuarioId, Date startDate, Date endDate);

    public List<Transaccion> findByRolIdAndFechaCreacionBetween(long rolId, Date startDate, Date endDate);

    public List<Transaccion> findByObjetoAndFechaCreacionBetween(String objetoId, Date startDate, Date endDate);

    public List<Transaccion> findByFechaCreacionBetween(Date startDate, Date endDate);

    public List<Transaccion> findByFuncionarioId(long id);
}
