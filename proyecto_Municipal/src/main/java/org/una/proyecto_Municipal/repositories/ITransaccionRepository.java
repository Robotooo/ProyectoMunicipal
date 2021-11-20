package org.una.proyecto_Municipal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.una.proyecto_Municipal.entities.Transaccion;

import java.util.Date;
import java.util.List;

public interface ITransaccionRepository extends JpaRepository<Transaccion, Long> {

    public List<Transaccion> findByFuncionarioIdAndFechaCreacionBetween(Long usuarioId, Date startDate, Date endDate);

    //public List<Transaccion> findByRolIdAndFechaCreacionBetween(Long rolId, Date startDate, Date endDate);

    public List<Transaccion> findByObjetoAndFechaCreacionBetween(String objetoId, Date startDate, Date endDate);

    public List<Transaccion> findByFechaCreacionBetween(Date startDate, Date endDate);

    public List<Transaccion> findByFuncionarioId(Long funcionarioId);

    @Query(value = "{call registrarTransaccion(:accion_in, :objeto_in, :funId_in, :parametro_in)}", nativeQuery=true)
    public void registrarTransaccion(
            @Param("accion_in") String accion_in,
            @Param("objeto_in") String objeto_in,
            @Param("funId_in") Long funId_in,
            @Param("parametro_in") String parametro_in
    );
}
