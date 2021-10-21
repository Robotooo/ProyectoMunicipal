package org.una.proyecto_Municipal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.proyecto_Municipal.entities.Propiedad;

import java.util.List;

public interface IPropiedadRepository extends JpaRepository<Propiedad, Long> {

//    public List<Propiedad> findByNombre(String nombre);

    public List<Propiedad> findByProvincia(String provincia);

    public List<Propiedad> findByEstado(boolean estado);
}
