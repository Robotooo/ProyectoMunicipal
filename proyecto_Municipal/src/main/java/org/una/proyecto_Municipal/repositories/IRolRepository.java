package org.una.proyecto_Municipal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
/*******/
import org.springframework.beans.factory.BeanCreationException;
/*******/
import org.una.proyecto_Municipal.entities.Rol;

import java.util.Date;
import java.util.List;

public interface IRolRepository extends JpaRepository<Rol, Long> {

    //public List<Rol> findByNombreContainingIgnoreCase(String nombre);

    public List<Rol> findByFechacreacionBetween(Date startDate, Date endDate);

}
