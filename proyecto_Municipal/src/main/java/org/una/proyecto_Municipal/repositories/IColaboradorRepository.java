package org.una.proyecto_Municipal.repositories;

import org.una.proyecto_Municipal.entities.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IColaboradorRepository extends JpaRepository<Colaborador, long> {

    public List<Colaborador> findByNombre(String nombre);

    public List<Colaborador> findByTelefono(String telefono);

    public List<Colaborador> findByEstado(boolean estado);

    public List<Colaborador> findByCedulaContaining(String cedula);

//  TODO: find Colaboradores by CobroId, BienId

}
