package org.una.proyecto_Municipal.entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "declaracion_anual")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class DeclaracionAnual implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "monto_anual")
    private double montoAnual;

    @Column(name = "anio")
    private float anio;

    @ManyToOne
    @JoinColumn(name="licencias_comerciales_id")
    private Licencia licenciaId;

    private static final long serialVersionUID = 1L;

}
