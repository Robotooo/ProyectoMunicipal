package org.una.proyecto_Municipal.dto;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class FuncionarioDTO {
    private long id;
    private String usuario;
    private String telefono;
    private String cedula;
    private boolean estado;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private String passwordEncriptado;
    private RolDTO rol;
}
