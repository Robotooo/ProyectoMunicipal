package org.una.proyecto_Municipal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.una.proyecto_Municipal.entities.Ruta;

import java.util.List;

public interface IRutaRepository extends JpaRepository<Ruta, Long> {

    public List<Ruta> findByEstado(boolean estado);

    public List<Ruta> findByBienId(Long id);

//    List<Ruta> findByCantidadSalidasAndFechaDia(Integer, String);
//
    @Query(value = "SELECT rutas.estado, dia_semana.cantidad_salidas, dia_semana.nombre_dia " +
            "FROM rutas " +
            "INNER JOIN dia_semana ON dia_semana.ruta_id = rutas.id " +
            "INNER JOIN bienes ON bienes.id = rutas.bienes_id " +
            "INNER JOIN bienes_x_colaboradores ON bienes_x_colaboradores.bien_id = bienes.id " +
            "INNER JOIN colaboradores ON colaboradores.id = bienes_x_colaboradores.colaborador_id " +
            "WHERE rutas.estado = 1 AND colaboradores.cedula = ?1", nativeQuery = true)
    public Ruta findFormulaWithLikeSQL(String cedula);

}
