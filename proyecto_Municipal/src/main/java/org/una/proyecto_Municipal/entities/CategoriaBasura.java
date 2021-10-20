package org.una.proyecto_Municipal.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "categorias_basura")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoriaBasura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String descripcion;

    private static final long serialVersionUID = 1L;

}
