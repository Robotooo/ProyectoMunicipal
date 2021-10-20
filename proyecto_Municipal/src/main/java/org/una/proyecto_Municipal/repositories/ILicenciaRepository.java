package org.una.proyecto_Municipal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.una.proyecto_Municipal.entities.Licencia;
import org.una.proyecto_Municipal.entities.Parametro;
import org.una.proyecto_Municipal.entities.Rol;

import java.util.List;

public interface ILicenciaRepository extends JpaRepository<Licencia, Long> {

    public List<Licencia> findByNombre(String nombre);

    public Licencia findByTelefono(String telefono);

    public Licencia findByEmail(String email);

    public List<Licencia> findByDistrito(String distrito);

    public List<Licencia> findByEstado(Boolean estado);

    //public List<Licencia>  findByBienId(Long id);

//    @Query("SELECT licencias.estado, licencias.ganancias, declaracion_anual.monto_anual, declaracion_anual.anio " +
//            "FROM licencias " +
//            "INNER JOIN declaracion_anual ON licencias.id = dia_semana.licencias_comerciales_id " +
//            "WHERE rutas_buses.estado = 1")
    //public Licencia findFormulaWithLikeSQL(@Param("licencia"));
}





