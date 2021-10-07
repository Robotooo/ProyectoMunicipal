package org.una.proyecto_Municipal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.proyecto_Municipal.entities.Funcionario;


import java.util.List;

public interface IFuncionarioRepository extends JpaRepository<Funcionario, Long> {

    public List<Funcionario> findByUsuario(String nombre);

    public List<Funcionario> findByEstado(boolean estado);
}
