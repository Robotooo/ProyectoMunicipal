package org.una.proyecto_Municipal.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "categorias_x_propiedad")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoriaxPropiedad implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="categorias_basura_id")
    private CategoriaBasura categoriaBasuraId;

    @ManyToOne
    @JoinColumn(name="propiedades_id")
    private Propiedad propiedad;

    @Column
    private Integer cantidad;

    private static final long serialVersionUID = 1L;

}
