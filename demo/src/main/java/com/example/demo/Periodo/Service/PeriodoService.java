package com.example.demo.Periodo.Service;

import com.example.demo.Periodo.model.Periodo;
import com.example.demo.Periodo.repository.PeriodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeriodoService {

    private final PeriodoRepository periodoRepository;

    @Autowired
    public PeriodoService(PeriodoRepository periodoRepository) {
        this.periodoRepository = periodoRepository;
    }

    public List<Periodo> getAllPeriodos() {
        return periodoRepository.findAll();
    }

    public Periodo createPeriodo(Periodo periodo) {
        return periodoRepository.save(periodo);
    }
}
