package com.example.saudeinteligente.service;

import com.example.saudeinteligente.model.Alerta;
import com.example.saudeinteligente.repository.AlertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertaService {

    @Autowired
    private AlertaRepository alertaRepository;

    public List<Alerta> getAllAlertas() {
        return alertaRepository.findAll();
    }

    public Alerta createAlerta(Alerta alerta) {
        return alertaRepository.save(alerta);
    }

    public Alerta updateAlerta(Long id, Alerta alerta) {
        alerta.setId(id);
        return alertaRepository.save(alerta);
    }

    public void deleteAlerta(Long id) {
        alertaRepository.deleteById(id);
    }
}
