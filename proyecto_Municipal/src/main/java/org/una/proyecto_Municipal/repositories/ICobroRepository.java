package org.una.proyecto_Municipal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.una.proyecto_Municipal.entities.Cobro;
import org.una.proyecto_Municipal.entities.Licencia;

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
            "INNER JOIN colaboradores ON cobros.colaboradores_id = colaboradores.id " +
            "WHERE cobros.estado = 1 AND colaboradores.cedula = :cedula ", nativeQuery = true)
    public List<Cobro> findCobroByCedula(String cedula);

    @Query(value = "SELECT cobros.* " +
            "FROM cobros " +
            "INNER JOIN colaboradores ON cobros.colaboradores_id = colaboradores.id " +
            "WHERE cobros.estado = 0 AND colaboradores.cedula = :cedula " +
            "AND cobros.fecha_modificacion BETWEEN :fechaInicio AND :fechaFinal ", nativeQuery = true)
    public List<Cobro> findPagosByCedulaAndFechasBetween(String cedula, Date fechaInicio, Date fechaFinal);

    @Query(value = "SELECT cobros.* " +
            "FROM cobros " +
            "INNER JOIN colaboradores ON cobros.bienx_colaborador_id.colaboradores_id = colaboradores.id " +
            "WHERE cobros.estado = 1 AND cobros.tipo = 1 AND colaboradores.cedula = :cedula ", nativeQuery = true)
    public List<Cobro> findPendienteTotalLicencias(String cedula);

    @Query(value = "SELECT cobros.* " +
            "FROM cobros " +
            "INNER JOIN colaboradores ON cobros.colaboradores_id = colaboradores.id " +
            "WHERE cobros.estado = 1 AND cobros.tipo = 2 AND colaboradores.cedula = :cedula ", nativeQuery = true)
    public List<Cobro> findPendienteTotalPropiedades(String cedula);

    @Query(value = "SELECT cobros.* " +
            "FROM cobros " +
            "INNER JOIN colaboradores ON cobros.colaboradores_id = colaboradores.id " +
            "WHERE cobros.estado = 1 AND cobros.tipo = 3 AND colaboradores.cedula = :cedula ", nativeQuery = true)
    public List<Cobro> findPendienteTotalRutas(String cedula);

    @Query(value = "{call generarCobros(/*:tipo_in*/)}", nativeQuery=true)
    public String generarCobros(/*@Param("tipo_in") String tipo_in*/);

//    @Query(value=”{call valuate_actives_for_inventory(/*:id_in*/)}”)
//    Boolean calculateValuesOfActivesForInventory(Long inventoryId);


        }