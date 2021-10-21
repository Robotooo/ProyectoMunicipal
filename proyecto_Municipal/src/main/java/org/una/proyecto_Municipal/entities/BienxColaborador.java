package org.una.proyecto_Municipal.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bienes_x_colaboradores")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BienxColaborador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="colaboradores_id")
    private Colaborador colaboradorId;

    @ManyToOne
    @JoinColumn(name="bienes_id")
    private Bien bienId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bienxColaboradorId")
    private List<Cobro> cobro = new ArrayList<>();

    @Column(name = "porcentaje")
    private float porcentaje;

    private static final long serialVersionUID = 1L;

}
