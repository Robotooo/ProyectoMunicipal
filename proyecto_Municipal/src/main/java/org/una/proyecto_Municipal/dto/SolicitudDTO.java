package org.una.proyecto_Municipal.dto;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SolicitudDTO {
    private Long id;
    private String tipo;
    private boolean respuesta;
    private boolean estado;
    private Date fechaSolicitud;
    private FuncionarioDTO gestor;
    private FuncionarioDTO gerente;
}
