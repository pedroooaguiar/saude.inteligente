package com.example.saudeinteligente.service;

import com.example.saudeinteligente.model.Consulta;
import com.example.saudeinteligente.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public List<Consulta> getAllConsultas() {
        return consultaRepository.findAll();
    }

    public Consulta getConsultaById(Long id) {
        return consultaRepository.findById(id).orElse(null);
    }

    public Consulta createConsulta(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    public Consulta updateConsulta(Long id, Consulta consultaDetails) {
        return consultaRepository.findById(id)
                .map(consulta -> {
                    consulta.setDataHora(consultaDetails.getDataHora());
                    consulta.setDescricao(consultaDetails.getDescricao());
                    return consultaRepository.save(consulta);
                })
                .orElse(null);
    }

    public void deleteConsulta(Long id) {
        consultaRepository.deleteById(id);
    }
}
