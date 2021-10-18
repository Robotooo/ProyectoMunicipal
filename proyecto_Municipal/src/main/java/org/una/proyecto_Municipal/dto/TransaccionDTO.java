package org.una.proyecto_Municipal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.una.proyecto_Municipal.entities.Funcionario;
import org.una.proyecto_Municipal.entities.Rol;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TransaccionDTO {

    private Long id;
    private String accion;
    private Date fechaCreacion;
    private Rol rolId;
    private Funcionario usuarioId;
    private String objeto;
}
