package com.example.saudeinteligente.controller;

import com.example.saudeinteligente.model.Alerta;
import com.example.saudeinteligente.service.AlertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alertas")
public class AlertaController {

    @Autowired
    private AlertaService alertaService;

    @GetMapping
    public List<Alerta> getAllAlertas() {
        return alertaService.getAllAlertas();
    }

    @PostMapping
    public Alerta createAlerta(@RequestBody Alerta alerta) {
        return alertaService.createAlerta(alerta);
    }

    @PutMapping("/{id}")
    public Alerta updateAlerta(@PathVariable Long id, @RequestBody Alerta alerta) {
        return alertaService.updateAlerta(id, alerta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlerta(@PathVariable Long id) {
        alertaService.deleteAlerta(id);
        return ResponseEntity.noContent().build();
    }
}
