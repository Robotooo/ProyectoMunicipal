package org.una.proyecto_Municipal.dto;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class TransaccionDTO {

    private Long id;
    private String accion;
    private String objeto;
    private String parametro;
    private Date fechaCreacion;
    private FuncionarioDTO funcionarioId;
}
