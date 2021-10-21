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
public class RutaDTO {
    private Long id;
    private String inicioRuta;
    private String finalRuta;
    private boolean estado;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private BienDTO bienId;
    private DiaSemanaDTO dia;
}
