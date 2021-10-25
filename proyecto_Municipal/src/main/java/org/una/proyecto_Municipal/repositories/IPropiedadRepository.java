package org.una.proyecto_Municipal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.una.proyecto_Municipal.entities.Propiedad;

import java.util.List;

public interface IPropiedadRepository extends JpaRepository<Propiedad, Long> {

//    public List<Propiedad> findByNombre(String nombre);

    public List<Propiedad> findByProvincia(String provincia);

    public List<Propiedad> findByEstado(boolean estado);

    @Query(value = "SELECT propiedades.metros, propiedades.zona " +
            "FROM propiedades " +
            "INNER JOIN bienes ON bienes.id = propiedades.bienes_id " +
            "INNER JOIN bienes_x_colaboradores ON bienes_x_colaboradores.bien_id = bienes.id " +
            "INNER JOIN colaboradores ON colaboradores.id = bienes_x_colaboradores.colaborador_id " +
            "WHERE propiedades.zona = 1 OR propiedades.zona = 2 AND colaboradores.cedula = :cedula", nativeQuery = true)
    public List<Propiedad> findPendienteTotalPropiedad(String cedula);

}