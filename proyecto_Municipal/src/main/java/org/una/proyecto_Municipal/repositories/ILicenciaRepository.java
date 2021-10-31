package org.una.proyecto_Municipal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.una.proyecto_Municipal.entities.Licencia;

import java.util.List;

public interface ILicenciaRepository extends JpaRepository<Licencia, Long> {

    public List<Licencia> findByNombre(String nombre);

    public Licencia findByTelefono(String telefono);

    public Licencia findByEmail(String email);

    public List<Licencia> findByDistrito(String distrito);

    public List<Licencia> findByEstado(boolean estado);

    //public List<Licencia>  findByBienId(Long id);

}