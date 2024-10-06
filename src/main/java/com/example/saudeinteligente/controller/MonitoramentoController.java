package com.example.saudeinteligente.controller;

import com.example.saudeinteligente.model.Monitoramento;
import com.example.saudeinteligente.service.MonitoramentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monitoramento")
public class MonitoramentoController {

    @Autowired
    private MonitoramentoService monitoramentoService;

    @GetMapping
    public List<Monitoramento> getAllMonitoramentos() {
        return monitoramentoService.getAllMonitoramentos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Monitoramento> getMonitoramentoById(@PathVariable Long id) {
        Monitoramento monitoramento = monitoramentoService.getMonitoramentoById(id);
        return monitoramento != null ? ResponseEntity.ok(monitoramento) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Monitoramento createMonitoramento(@RequestBody Monitoramento monitoramento) {
        return monitoramentoService.createMonitoramento(monitoramento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Monitoramento> updateMonitoramento(@PathVariable Long id, @RequestBody Monitoramento monitoramentoDetails) {
        Monitoramento updatedMonitoramento = monitoramentoService.updateMonitoramento(id, monitoramentoDetails);
        return updatedMonitoramento != null ? ResponseEntity.ok(updatedMonitoramento) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMonitoramento(@PathVariable Long id) {
        monitoramentoService.deleteMonitoramento(id);
        return ResponseEntity.noContent().build();
    }
}
