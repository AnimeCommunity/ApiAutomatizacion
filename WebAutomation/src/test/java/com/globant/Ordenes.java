package com.globant;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Ordenes {

    @Test(description = "crear una orden")
    public void testCreateOrder() {
        RestAssured.baseURI = "https://petstore.swagger.io/";

        String body = "{"
            + "\"id\": 1,"
            + "\"petId\": 1,"
            + "\"quantity\": 1,"
            + "\"shipDate\": \"2025-06-08T12:00:00Z\","
            + "\"status\": \"placed\","
            + "\"complete\": true"
            + "}";
              

        given()
            .contentType(ContentType.JSON)
            .body(body)
        .when()
            .post("/store/order")
        .then()
            .statusCode(200)
            .body("status", equalTo("placed"));
    }
}
