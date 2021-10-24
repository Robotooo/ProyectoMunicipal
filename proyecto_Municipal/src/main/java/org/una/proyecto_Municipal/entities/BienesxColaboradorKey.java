package org.una.proyecto_Municipal.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class BienesxColaboradorKey implements Serializable {

    @Column(name = "bien_id")
    private Long bienId;

    @Column(name = "colaborador_id")
    private Long colaboradorId;

}
