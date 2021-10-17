package org.una.proyecto_Municipal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.una.proyecto_Municipal.entities.BienxColaborador;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CobroDTO {
    private Long id;
    private Boolean estado;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private BienxColaborador bienxColaboradorId;
}
