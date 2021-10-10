package org.una.proyecto_Municipal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.proyecto_Municipal.entities.Transaccion;

import java.util.Date;
import java.util.List;

public interface ITransaccionRepository extends JpaRepository<Transaccion, Long> {

    public List<Transaccion> findByUsuarioIdAndFechaCreacionBetween(Long usuarioId, Date startDate, Date endDate);

    public List<Transaccion> findByRolIdAndFechaCreacionBetween(Long rolId, Date startDate, Date endDate);

    public List<Transaccion> findByObjetoAndFechaCreacionBetween(String objetoId, Date startDate, Date endDate);

    public List<Transaccion> findByFechaCreacionBetween(Date startDate, Date endDate);

    public List<Transaccion> findByEstado(boolean estado);

    public List<Transaccion>  findByFuncionarioId(Long id);

}
