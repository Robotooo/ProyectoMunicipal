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

    @Query(value = "SELECT licencias.ganancias, declaracion_anual.monto_anual, declaracion_anual.anio " +
            "FROM licencias " +
            "INNER JOIN declaracion_anual ON licencias.id = declaracion_anual.licencias_comerciales_id " +
            "INNER JOIN bienes ON bienes.id = licencias.bienes_id " +
            "INNER JOIN bienes_x_colaboradores ON bienes_x_colaboradores.bien_id = bienes.id " +
            "INNER JOIN colaboradores ON colaboradores.id = bienes_x_colaboradores.colaborador_id " +
            "WHERE licencias.estado = 1 AND colaboradores.cedula = :cedula", nativeQuery = true)
    public List<Licencia> findPendienteTotalLicencias(String cedula);

}