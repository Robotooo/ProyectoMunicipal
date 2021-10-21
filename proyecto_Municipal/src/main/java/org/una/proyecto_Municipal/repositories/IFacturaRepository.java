package org.una.proyecto_Municipal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.proyecto_Municipal.entities.Factura;

import java.util.List;

public interface IFacturaRepository extends JpaRepository<Factura, long> {

    public List<Factura> findByNombre(String nombre);

    public List<Factura> findByCajeroId(long id);

}
