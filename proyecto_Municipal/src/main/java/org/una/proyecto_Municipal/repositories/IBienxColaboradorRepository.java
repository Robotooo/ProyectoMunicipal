package org.una.proyecto_Municipal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.una.proyecto_Municipal.entities.BienxColaborador;
import org.una.proyecto_Municipal.entities.Cobro;

import java.util.List;

public interface IBienxColaboradorRepository  extends JpaRepository<BienxColaborador, Long> {

    public List<BienxColaborador> findByBienId(Long id);

    public List<BienxColaborador> findByColaboradorId(Long id);

//    @Query(value = "SELECT *" +
//            "FROM bienes_x_colaboradores" +
//            "WHERE bienes_x_colaboradores.id = :id", nativeQuery = true)
//    public List<Cobro> findBienId(Long id);

}