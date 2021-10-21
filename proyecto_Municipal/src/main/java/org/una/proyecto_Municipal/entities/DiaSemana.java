package org.una.proyecto_Municipal.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "dia_semana")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DiaSemana implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer cantidadSalidas;

    @Column
    private String nombreDia;

    @ManyToOne
    @JoinColumn(name="ruta_id")
    private Ruta rutaId;

    private static final long serialVersionUID = 1L;

}
