package org.una.proyecto_Municipal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.proyecto_Municipal.entities.BienxColaborador;

import java.util.List;

public interface IBienxColaboradorRepository  extends JpaRepository<BienxColaborador, Long> {

    public List<BienxColaborador> findByBienId(Long id);

    public List<BienxColaborador> findByColaboradorId(Long id);

}