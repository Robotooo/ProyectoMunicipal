package org.una.proyecto_Municipal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
/*******/
import org.springframework.beans.factory.BeanCreationException;
/*******/
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.una.proyecto_Municipal.entities.Rol;

import java.util.Date;
import java.util.List;

public interface IRolRepository extends JpaRepository<Rol, Long> {

    public List<Rol> findByNombre(String nombre);

    public List<Rol> findByFechaCreacionBetween(Date startDate, Date endDate);

    public List<Rol> findByNombreContainingIgnoreCase(String nombre);

    @Query(value = "{call registrarTransaccion(:accion_in, :objeto_in, :funId_in, :parametro_in)}", nativeQuery=true)
    public void registrarTransaccion(
            @Param("accion_in") String accion_in,
            @Param("objeto_in") String objeto_in,
            @Param("funId_in") Long funId_in,
            @Param("parametro_in") String parametro_in
    );
}
