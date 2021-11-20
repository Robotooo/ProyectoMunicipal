package org.una.proyecto_Municipal.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ISolicitudRepository {

    @Query(value = "{call registrarTransaccion(:accion_in, :objeto_in, :funId_in, :parametro_in)}", nativeQuery=true)
    public void registrarTransaccion(
            @Param("accion_in") String accion_in,
            @Param("objeto_in") String objeto_in,
            @Param("funId_in") Long funId_in,
            @Param("parametro_in") String parametro_in
    );
}
