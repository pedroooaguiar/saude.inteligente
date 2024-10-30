package com.example.saudeinteligente.controller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class AlertaController {

    @Test
    public void testCreateAlertaSuccess() {
        String alertaJson = "{ \"mensagem\": \"Teste de alerta\" }";

        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(alertaJson)
                .when()
                .post("/api/alertas")
                .then()
                .statusCode(201)
                .body("id", notNullValue())
                .body("mensagem", equalTo("Teste de alerta"))
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schemas/alerta-schema.json"));
    }

    @Test
    public void testCreateAlertaMissingFields() {
        String alertaJson = "{ }";

        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(alertaJson)
                .when()
                .post("/api/alertas")
                .then()
                .statusCode(400)
                .body("error", notNullValue());
    }
}
