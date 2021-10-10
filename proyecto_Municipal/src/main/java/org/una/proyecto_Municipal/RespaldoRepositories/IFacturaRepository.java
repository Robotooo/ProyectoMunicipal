package org.una.proyecto_Municipal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.proyecto_Municipal.entities.Factura;

import java.util.List;
import java.util.Optional;

public interface IFacturaRepository extends JpaRepository<Factura, Long> {

    public List<Factura> findByNombreContainingIgnoreCase(String nombre);

    public List<Factura>  findByCajeroId(Long id);

}
