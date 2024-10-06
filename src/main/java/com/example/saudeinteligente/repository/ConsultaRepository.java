package com.example.saudeinteligente.repository;

import com.example.saudeinteligente.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
