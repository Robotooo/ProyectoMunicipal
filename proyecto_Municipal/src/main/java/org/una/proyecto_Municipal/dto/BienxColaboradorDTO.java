package org.una.proyecto_Municipal.dto;

import lombok.*;
import org.una.proyecto_Municipal.entities.Bien;
import org.una.proyecto_Municipal.entities.Cobro;
import org.una.proyecto_Municipal.entities.Colaborador;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BienxColaboradorDTO {
//    private Long id;
    private ColaboradorDTO colaboradorId;
    private BienDTO bienId;
    private CobroDTO cobro;
    private float porcentaje;
}
