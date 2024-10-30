package com.example.saudeinteligente.controller;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class PacienteController {

    @Test
    public void testGetPacienteNotFound() {
        RestAssured.given()
                .when()
                .get("/pacientes/999")
                .then()
                .statusCode(404)
                .body(emptyOrNullString());
    }

    @Test
    public void testCreatePacienteSuccess() {
        String pacienteJson = "{ \"nome\": \"João Silva\", \"email\": \"joao@example.com\", \"telefone\": \"123456789\", \"dataNascimento\": \"1980-01-01\" }";

        RestAssured.given()
                .contentType("application/json")
                .body(pacienteJson)
                .when()
                .post("/pacientes")
                .then()
                .statusCode(200)
                .body("id", notNullValue())
                .body("nome", equalTo("João Silva"))
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schemas/paciente-schema.json"));
    }
}
