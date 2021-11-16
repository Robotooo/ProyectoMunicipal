package org.una.proyecto_Municipal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.una.proyecto_Municipal.entities.Funcionario;
import org.una.proyecto_Municipal.entities.Parametro;

import java.util.List;

public interface IParametroRepository extends JpaRepository<Parametro, Long>{

    public List<Parametro> findByNombre(String nombre);

    public List<Parametro> findByValor(int valor);

    @Query(value = "{call saveTransaction(:accion_in, :objeto_in, :funId_in)}", nativeQuery=true)
    public String saveTransaction(
            @Param("accion_in") String accion_in,
            @Param("objeto_in") String objeto_in,
            @Param("funId_in") String funId_in
    );

}
