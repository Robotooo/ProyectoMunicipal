package org.una.proyecto_Municipal.dto;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class RolDTO {
    private Long id;
    private String nombre;
    private Date fechaCreacion;
    private FuncionarioDTO funcionarios;
}
