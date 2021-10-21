package org.una.proyecto_Municipal.dto;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
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
