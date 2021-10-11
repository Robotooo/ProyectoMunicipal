package org.una.proyecto_Municipal.repositories;

import org.una.proyecto_Municipal.entities.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IColaboradorRepository extends JpaRepository<Colaborador, Long> {

    public List<Colaborador> findByNombre(String nombre);

    public Colaborador findByTelefono(String telefono);

    public List<Colaborador> findByEstado(boolean estado);

    public List<Colaborador> findByCedulaContaining(String cedula);

    //public List<Colaborador> findByCedulaContaining(String cedula);

    //public List<Colaborador> findByNombreCompletoContainingIgnoreCase(String nombreCompleto);
}
