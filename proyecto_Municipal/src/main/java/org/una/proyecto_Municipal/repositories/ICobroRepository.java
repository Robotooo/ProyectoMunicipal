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

    public List<Cobro> findByTipo(int tipo);

    //public List<Cobro> findByFacturaId(Long id);

    @Query(value = "SELECT cobros.* " +
            "FROM cobros " +
            "INNER JOIN colaboradores ON cobros.colaborador_id = colaboradores.id " +
            "WHERE cobros.estado = 1 AND colaboradores.cedula = :cedula ", nativeQuery = true)
    public List<Cobro> findCobroByCedula(String cedula);

    @Query(value = "SELECT cobros.* " +
            "FROM cobros " +
            "INNER JOIN colaboradores ON cobros.colaborador_id = colaboradores.id " +
            "WHERE cobros.estado = 0 AND colaboradores.cedula = :cedula " +
            "AND cobros.fecha_modificacion BETWEEN :fechaInicio AND :fechaFinal ", nativeQuery = true)
    public List<Cobro> findCobroByCedulaAndFechasBetween(String cedula, Date fechaInicio, Date fechaFinal);

}