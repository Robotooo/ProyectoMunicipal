package org.una.proyecto_Municipal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FuncionarioDTO {
    private Long id;
    private String usuario;
    private String contrasenia
    private Integer telefono;
    private boolean estado;
    private Date fecha_creacion;
    private Date fecha_modificacion;
}
