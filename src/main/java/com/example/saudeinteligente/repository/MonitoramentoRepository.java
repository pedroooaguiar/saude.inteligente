package com.example.saudeinteligente.repository;

import com.example.saudeinteligente.model.Monitoramento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitoramentoRepository extends JpaRepository<Monitoramento, Long> {
}
