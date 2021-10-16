package org.una.proyecto_Municipal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.una.proyecto_Municipal.entities.Colaborador;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CobroDTO {
    private Long id;
    private boolean estado;
    private Date fecha_creacion;
    private Date fecha_modificacion;
    private Colaborador colaborador;
}
