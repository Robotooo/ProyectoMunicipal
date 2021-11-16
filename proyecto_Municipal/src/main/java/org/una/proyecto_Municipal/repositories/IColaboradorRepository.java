package org.una.proyecto_Municipal.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.una.proyecto_Municipal.entities.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IColaboradorRepository extends JpaRepository<Colaborador, Long> {

    public List<Colaborador> findByNombre(String nombre);

    public List<Colaborador> findByTelefono(String telefono);

    public List<Colaborador> findByEstado(boolean estado);

    public List<Colaborador> findByCedulaContaining(String cedula);

    @Query(value = "{call saveTransaction(:accion_in, :objeto_in, :funId_in)}", nativeQuery=true)
    public String saveTransaction(
            @Param("accion_in") String accion_in,
            @Param("objeto_in") String objeto_in,
            @Param("funId_in") String funId_in
    );

//  TODO: find Colaboradores by CobroId, BienId

}
