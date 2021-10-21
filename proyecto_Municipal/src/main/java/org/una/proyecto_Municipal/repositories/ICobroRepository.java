package org.una.proyecto_Municipal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.proyecto_Municipal.entities.Cobro;

import java.util.List;

public interface ICobroRepository extends JpaRepository<Cobro, long> {

    public List<Cobro> findByEstado(boolean estado);

//    public List<Cobro> findByBienId(long id);

    public List<Cobro> findByBienxColaboradorId(long id);

    public List<Cobro> findByFacturaId(long id);

}
