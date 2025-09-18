package com.hotelera.reserva.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelera.reserva.model.Reserva;

@Repository
public interface ReservaReposity extends JpaRepository<Reserva, Long>{

	boolean existsByIdHuesped(Long idHuesped);
	
	boolean existsByIdHabitacion(Long idHabitacion);
}
