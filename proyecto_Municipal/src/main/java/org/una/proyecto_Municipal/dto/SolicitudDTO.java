package org.una.proyecto_Municipal.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SolicitudDTO {
    private Long id;
    private Long registroId;
    private String accion;
    private boolean respuesta;
    private boolean estado;
    private Date fechaSolicitud;
    //@JsonIgnore
    private FuncionarioDTO gestor;
    @JsonIgnore
    private FuncionarioDTO gerente;
}
