package org.una.proyecto_Municipal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.proyecto_Municipal.entities.Ruta;

import java.util.List;

public interface IRutaRepository extends JpaRepository<Ruta, Long> {

    public List<Ruta> findByEstado(boolean estado);

    public List<Ruta> findByBienId(Long id);

//    List<Ruta> findByCantidadSalidasAndFechaDia(Integer, String);
//
//    @Query("SELECT rutas_buses.estado, dia_semana.cantidad_salidas, dia_semana.fecha_dia " +
//            "FROM rutas_buses " +
//            "INNER JOIN dia_semana ON rutas_buses.id = dia_semana.rutas_buses_id " +
//            "WHERE rutas_buses.estado = 1", nativeQuery=true)
//
//    public Ruta findFormulaWithLikeSQL(@Param("ruta"));

}
