package org.una.proyecto_Municipal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.proyecto_Municipal.entities.Bien;
import org.una.proyecto_Municipal.entities.Calendar;

public interface ICalendarRepository  extends JpaRepository<Calendar, Long> {
}
