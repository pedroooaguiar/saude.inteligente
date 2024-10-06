package com.example.saudeinteligente.service;

import com.example.saudeinteligente.model.Paciente;
import com.example.saudeinteligente.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> getAllPacientes() {
        return pacienteRepository.findAll();
    }

    public Paciente getPacienteById(Long id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    public Paciente createPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Paciente updatePaciente(Long id, Paciente pacienteDetails) {
        return pacienteRepository.findById(id)
                .map(paciente -> {
                    paciente.setNome(pacienteDetails.getNome());
                    paciente.setEmail(pacienteDetails.getEmail());
                    paciente.setTelefone(pacienteDetails.getTelefone());
                    paciente.setDataNascimento(pacienteDetails.getDataNascimento());
                    return pacienteRepository.save(paciente);
                })
                .orElse(null);
    }

    public void deletePaciente(Long id) {
        pacienteRepository.deleteById(id);
    }
}
