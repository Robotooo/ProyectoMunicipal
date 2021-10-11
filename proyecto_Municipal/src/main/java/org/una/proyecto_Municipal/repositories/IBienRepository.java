package org.una.proyecto_Municipal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.proyecto_Municipal.entities.Bien;

public interface IBienRepository  extends JpaRepository<Bien, Long> {

}
