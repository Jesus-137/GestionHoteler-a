package com.example.huespedes.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.huespedes.models.Huesped;

@Repository
public interface HuespedRepository extends JpaRepository<Huesped, Long> {

}
