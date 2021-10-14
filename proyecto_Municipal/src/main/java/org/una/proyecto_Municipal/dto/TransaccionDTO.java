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
public class TransaccionDTO {

    private Long id;
    private String objeto;
    private Long usuarioId;
    private String accion;
    private Date fechaCreacion;
}
