package com.example.weatherapp;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WeatherApiTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    @Test
    @Order(1)
    public void testValidCityWeather() {
        given()
            .queryParam("city", "London")
        .when()
            .get("/weather")
        .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("temperature", notNullValue())
            .body("condition", notNullValue())
            .body("humidity", notNullValue())
            .body("wind_speed", notNullValue());
    }

    @Test
    @Order(2)
    public void testInvalidCityReturns404() {
        given()
            .queryParam("city", "InvalidCity123")
        .when()
            .get("/weather")
        .then()
            .statusCode(404)
            .body("error", equalTo("City not found"));
    }

    @Test
    @Order(3)
    public void testEmptyCityParamReturns400() {
        given()
        .when()
            .get("/weather")
        .then()
            .statusCode(400)
            .body("error", equalTo("City parameter is required"));
    }
}
