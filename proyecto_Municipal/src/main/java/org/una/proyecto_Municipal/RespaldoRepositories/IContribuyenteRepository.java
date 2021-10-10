package org.una.proyecto_Municipal.repositories;

import org.una.proyecto_Municipal.entities.Contribuyente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IContribuyenteRepository extends JpaRepository<Contribuyente, Long> {

    public List<Contribuyente> findByNombreContainingIgnoreCase(String nombre);

    public List<Contribuyente> findByCedulaContaining(String cedula);

    public List<Contribuyente> findByEstado(boolean estado);

    public List<Contribuyente> findByTelefono(String telefono);

    List<Contribuyente> findByNombre(String nombre);
}