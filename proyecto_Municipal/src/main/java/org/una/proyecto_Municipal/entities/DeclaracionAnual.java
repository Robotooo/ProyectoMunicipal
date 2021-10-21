package org.una.proyecto_Municipal.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "declaracion_anual")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DeclaracionAnual implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private double montoAnual;

    @Column
    private float anio;

    @ManyToOne
    @JoinColumn(name="licencias_comerciales_id")
    private Licencia licenciaId;

    private static final long serialVersionUID = 1L;

}
