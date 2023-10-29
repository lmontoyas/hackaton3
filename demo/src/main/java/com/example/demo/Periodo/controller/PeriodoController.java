package com.example.demo.Periodo.controller;

import com.example.demo.Periodo.model.Periodo;
import com.example.demo.Periodo.Service.PeriodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/periodos")
public class PeriodoController {

    private final PeriodoService periodoService;

    @Autowired
    public PeriodoController(PeriodoService periodoService) {
        this.periodoService = periodoService;
    }

    @GetMapping
    public List<Periodo> getAllPeriodos() {
        return periodoService.getAllPeriodos();
    }

    @PostMapping
    public Periodo createPeriodo(@RequestBody Periodo periodo) {
        return periodoService.createPeriodo(periodo);
    }
}
