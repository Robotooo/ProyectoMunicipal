package org.una.proyecto_Municipal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.proyecto_Municipal.entities.Funcionario;
import org.una.proyecto_Municipal.entities.Parametro;

import java.util.List;

public interface IParametroRepository extends JpaRepository<Parametro, long>{

    public List<Parametro> findByNombre(String nombre);

    public List<Parametro> findByEstado(boolean estado);
}
