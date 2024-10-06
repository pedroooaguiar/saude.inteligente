package com.example.saudeinteligente.controller;

import com.example.saudeinteligente.model.Consulta;
import com.example.saudeinteligente.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @GetMapping
    public List<Consulta> getAllConsultas() {
        return consultaService.getAllConsultas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consulta> getConsultaById(@PathVariable Long id) {
        Consulta consulta = consultaService.getConsultaById(id);
        return consulta != null ? ResponseEntity.ok(consulta) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Consulta createConsulta(@RequestBody Consulta consulta) {
        return consultaService.createConsulta(consulta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consulta> updateConsulta(@PathVariable Long id, @RequestBody Consulta consultaDetails) {
        Consulta updatedConsulta = consultaService.updateConsulta(id, consultaDetails);
        return updatedConsulta != null ? ResponseEntity.ok(updatedConsulta) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsulta(@PathVariable Long id) {
        consultaService.deleteConsulta(id);
        return ResponseEntity.noContent().build();
    }
}
