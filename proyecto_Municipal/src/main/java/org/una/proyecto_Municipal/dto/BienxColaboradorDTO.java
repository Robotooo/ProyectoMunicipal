package org.una.proyecto_Municipal.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BienxColaboradorDTO {
    private Long id;
    private ColaboradorDTO colaboradorId;
    private BienDTO bienId;
//    private CobroDTO cobro;
    private float porcentaje;
}
