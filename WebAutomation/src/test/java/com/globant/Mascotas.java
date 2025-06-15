package com.globant;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Mascotas {

    @Test(description = "ver mascotas disponibles")
    public void testListAvailablePets() {
        RestAssured.baseURI = "https://petstore.swagger.io/";

        given()
            .queryParam("status", "available")
        .when()
            .get("/pet/findByStatus")
        .then()
            .statusCode(200)
            .body("status", everyItem(equalTo("available")));
    }

    @Test(description = "datos de una mascota específica")
    public void testGetPetById() {
        RestAssured.baseURI = "https://petstore.swagger.io/";

        
        int petId = 2;

        when()
            .get("/pet/" + petId)
        .then()
            .statusCode(200)
            .body("id", equalTo(petId));
    }
}