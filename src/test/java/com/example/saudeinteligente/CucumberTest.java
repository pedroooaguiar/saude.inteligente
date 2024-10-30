package com.example.saudeinteligente;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import io.cucumber.spring.CucumberContextConfiguration;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.example.saudeinteligente.steps",
        plugin = {"pretty", "html:target/cucumber"}
)
@ActiveProfiles("test")
@SpringBootTest
@CucumberContextConfiguration
public class CucumberTest {
    // Esta classe serve como ponto de entrada para os testes do Cucumber com integração ao Spring Boot
}
