package org.una.proyecto_Municipal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.una.proyecto_Municipal.entities.Cobro;

import java.util.Date;
import java.util.List;

public interface ICobroRepository extends JpaRepository<Cobro, Long> {

    public List<Cobro> findByEstado(boolean estado);

//    public List<Cobro> findByBienId(Long id);

//    public List<Cobro> findByBienxColaboradorId(Long id);

    public List<Cobro> findByFacturaId(Long id);

    @Query(value = "SELECT cobros.monto " +
        "FROM cobros " +
        "INNER JOIN bienes_x_colaboradores ON bienes_x_colaboradores.colaborador_id = cobros.colaborador_id " +
        "INNER JOIN colaboradores ON colaboradores.id = bienes_x_colaboradores.colaborador_id " +
        "WHERE cobros.estado = 1 AND colaboradores.cedula = ?1", nativeQuery = true)
    public List<Cobro> findCobroByCedula(String cedula);

    @Query(value = "SELECT cobros.monto, cobros.fecha_modificacion " +
            "FROM cobros " +
            "INNER JOIN bienes_x_colaboradores ON bienes_x_colaboradores.colaborador_id = cobros.colaborador_id " +
            "INNER JOIN colaboradores ON colaboradores.id = bienes_x_colaboradores.colaborador_id " +
            "WHERE cobros.estado = 1 AND colaboradores.cedula = ?1 AND cobros.fecha_modificacion BETWEEN ?2 AND ?3", nativeQuery = true)
    public List<Cobro> findCobroByCedulaAndFechasBeetwen(String cedula, Date fechaInicio, Date fechaFinal);

}