package org.una.proyecto_Municipal.repositories;

import org.una.proyecto_Municipal.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface  IClienteRepository  extends JpaRepository<Cliente, Long> {

    public List<Cliente> findByNombre(String nombre);

    public Cliente findByTelefono(String telefono);

    public List<Cliente> findByEstado(boolean estado);
}
