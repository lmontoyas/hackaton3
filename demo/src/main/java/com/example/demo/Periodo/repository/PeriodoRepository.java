package com.example.demo.Periodo.repository;

import com.example.demo.Periodo.model.Periodo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeriodoRepository extends JpaRepository<Periodo, Long> {
}
