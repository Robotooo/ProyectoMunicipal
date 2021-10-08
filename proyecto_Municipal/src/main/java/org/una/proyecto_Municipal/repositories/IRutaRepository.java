package org.una.proyecto_Municipal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRutaRepository extends JpaRepository<Ruta, Long> {

    public List<Ruta> findByEstado(boolean estado);

}
