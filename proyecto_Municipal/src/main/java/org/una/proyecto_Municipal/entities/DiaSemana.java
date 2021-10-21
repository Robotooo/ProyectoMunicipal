package org.una.proyecto_Municipal.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "dia_semana")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class DiaSemana implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cantidad_salidas")
    private Integer cantidadSalidas;

    @Column(name = "nombre_dia")
    private String nombreDia;

    @ManyToOne
    @JoinColumn(name="ruta_id")
    private Ruta rutaId;

    private static final long serialVersionUID = 1L;

}
