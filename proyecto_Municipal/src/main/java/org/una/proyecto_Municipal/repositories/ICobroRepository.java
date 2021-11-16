package org.una.proyecto_Municipal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.una.proyecto_Municipal.entities.Cobro;
import org.una.proyecto_Municipal.entities.Licencia;

import java.lang.invoke.ConstantBootstraps;
import java.util.Date;
import java.util.List;

public interface ICobroRepository extends JpaRepository<Cobro, Long> {

    public List<Cobro> findByEstado(boolean estado);

    public List<Cobro> findByBienxColaboradorId(Long id);

    public List<Cobro> findByTipo(int tipo);

//    public List<Cobro> findByFacturaId(Long id);

     //TODO: procedimiento almacenado

    @Query(value= "INSERT INTO cobros (tipo,monto)"+
            "VALUES(1,(SELECT p.valor_terreno FROM propiedades p JOIN bienes b ON p.bienes_id.id = b.id)" +
                    " * (SELECT p.valor FROM parametros p WHERE p.nombre = montoPorMetroFrenteLicencia))", nativeQuery = true)
    public void generarCobroLicencia();

    @Query(value = "SELECT cobros.* FROM cobros"
            + "INNER JOIN bienes_x_colaboradores ON cobros.bienx_colaborador_id = bienes_x_colaboradores.id"
            + "INNER JOIN bienes ON bienes.bienx_colaborador_id = bienes_colaboradores.id"
            + "WHERE bienes.id = :id"   ,nativeQuery = true)
    public List<Cobro> findByBienId(Long id);

    @Query(value = "SELECT cobros.* " +
            "FROM cobros " +
            "INNER JOIN bienes_x_colaboradores ON cobros.bienx_colaborador_id = bienes_x_colaboradores.id " +
            "INNER JOIN colaboradores ON bienes_x_colaboradores.colaborador_id = colaboradores.id " +
            "WHERE cobros.estado = 1 AND colaboradores.cedula = :cedula ", nativeQuery = true)
    public List<Cobro> findCobroByCedula(String cedula);

    @Query(value = "SELECT cobros.* " +
            "FROM cobros " +
            "INNER JOIN bienes_x_colaboradores ON cobros.bienx_colaborador_id = bienes_x_colaboradores.id " +
            "INNER JOIN colaboradores ON bienes_x_colaboradores.colaborador_id = colaboradores.id " +
            "WHERE cobros.estado = 0 AND colaboradores.cedula = :cedula " +
            "AND cobros.fecha_modificacion BETWEEN :fechaInicio AND :fechaFinal ", nativeQuery = true)
    public List<Cobro> findPagosByCedulaAndFechasBetween(String cedula, Date fechaInicio, Date fechaFinal);

    @Query(value = "SELECT cobros.* " +
            "FROM cobros " +
            "INNER JOIN bienes_x_colaboradores ON cobros.bienx_colaborador_id = bienes_x_colaboradores.id " +
            "INNER JOIN colaboradores ON bienes_x_colaboradores.colaborador_id = colaboradores.id " +
            "WHERE cobros.estado = 1 AND cobros.tipo = 1 AND colaboradores.cedula = :cedula ", nativeQuery = true)
    public List<Cobro> findPendienteTotalLicencias(String cedula);

    public List<Cobro> findByBienxColaborador_ColaboradorId_CedulaAndTipo(String cedula, int tipo);

    @Query(value = "SELECT cobros.* " +
            "FROM cobros " +
            "INNER JOIN bienes_x_colaboradores ON cobros.bienx_colaborador_id = bienes_x_colaboradores.id " +
            "INNER JOIN colaboradores ON bienes_x_colaboradores.colaborador_id = colaboradores.id " +
            "WHERE cobros.estado = 1 AND cobros.tipo = 2 AND colaboradores.cedula = :cedula ", nativeQuery = true)
    public List<Cobro> findPendienteTotalPropiedades(String cedula);

    @Query(value = "SELECT cobros.* " +
            "FROM cobros " +
            "INNER JOIN bienes_x_colaboradores ON cobros.bienx_colaborador_id = bienes_x_colaboradores.id " +
            "INNER JOIN colaboradores ON bienes_x_colaboradores.colaborador_id = colaboradores.id " +
            "WHERE cobros.estado = 1 AND cobros.tipo = 3 AND colaboradores.cedula = :cedula ", nativeQuery = true)
    public List<Cobro> findPendienteTotalRutas(String cedula);

    @Query(value = "{call saveTransaction(:funId_in)}", nativeQuery=true)
    public String saveTransaction(@Param("funId_in") String funId_in);


//    @Query(value=”{call valuate_actives_for_inventory(/*:id_in*/)}”)
//    Boolean calculateValuesOfActivesForInventory(Long inventoryId);


    }