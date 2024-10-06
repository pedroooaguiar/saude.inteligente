package com.example.saudeinteligente.service;

import com.example.saudeinteligente.model.Monitoramento;
import com.example.saudeinteligente.repository.MonitoramentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitoramentoService {

    @Autowired
    private MonitoramentoRepository monitoramentoRepository;

    public List<Monitoramento> getAllMonitoramentos() {
        return monitoramentoRepository.findAll();
    }

    public Monitoramento getMonitoramentoById(Long id) {
        return monitoramentoRepository.findById(id).orElse(null);
    }

    public Monitoramento createMonitoramento(Monitoramento monitoramento) {
        return monitoramentoRepository.save(monitoramento);
    }

    public Monitoramento updateMonitoramento(Long id, Monitoramento monitoramentoDetails) {
        return monitoramentoRepository.findById(id)
                .map(monitoramento -> {
                    monitoramento.setTipo(monitoramentoDetails.getTipo());
                    monitoramento.setValor(monitoramentoDetails.getValor());
                    monitoramento.setDataHora(monitoramentoDetails.getDataHora());
                    return monitoramentoRepository.save(monitoramento);
                })
                .orElse(null);
    }

    public void deleteMonitoramento(Long id) {
        monitoramentoRepository.deleteById(id);
    }
}
