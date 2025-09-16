package com.example.habitaciones.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.habitaciones.models.Habitacion;

@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Long>{

}
