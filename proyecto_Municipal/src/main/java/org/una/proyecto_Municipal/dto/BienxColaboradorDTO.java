package org.una.proyecto_Municipal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.una.proyecto_Municipal.entities.Bien;
import org.una.proyecto_Municipal.entities.Cobro;
import org.una.proyecto_Municipal.entities.Colaborador;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BienxColaboradorDTO {
    private Long id;
    private ColaboradorDTO colaboradorId;
    private BienDTO bienId;
    private CobroDTO cobro;
    private float porcentaje;
}
