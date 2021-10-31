package org.una.proyecto_Municipal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.una.proyecto_Municipal.entities.Ruta;

import java.util.List;

public interface IRutaRepository extends JpaRepository<Ruta, Long> {

    public List<Ruta> findByEstado(boolean estado);

    public List<Ruta> findByBienId(Long id);

//    List<Ruta> findByCantidadSalidasAndFechaDia(Integer, String);

}
