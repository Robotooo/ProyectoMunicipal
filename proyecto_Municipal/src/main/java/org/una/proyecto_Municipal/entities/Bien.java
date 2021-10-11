package org.una.proyecto_Municipal.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "bienes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Bien implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinTable(
            name = "bienes_x_colaboradores",
            joinColumns = @JoinColumn(name = "bien_id"),
            inverseJoinColumns = @JoinColumn(name = "colaborador_id"))
    private Colaborador bien_x_colaborador;

    private static final long serialVersionUID = 1L;

}
