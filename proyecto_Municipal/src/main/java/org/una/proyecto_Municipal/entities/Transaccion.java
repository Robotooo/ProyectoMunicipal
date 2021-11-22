package org.una.proyecto_Municipal.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.una.proyecto_Municipal.dto.SolicitudDTO;
import org.una.proyecto_Municipal.dto.TransaccionDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "transacciones")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Transaccion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="funcionarios_id")
    private Funcionario funcionarioId;

   /* @ManyToOne
    @JoinColumn(name="roles_id")
    private Rol rolId;*/

    @Column(name = "accion", length = 150)
    private String accion;

    @Column(name = "objeto", length = 50)
    private String objeto;

    @Column(name = "parametro", length = 50)
    private String parametro;



    @Column(name = "fecha_creacion", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaCreacion;

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
        fechaCreacion = new Date();
    }

}