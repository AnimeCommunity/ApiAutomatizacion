package com.globant;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class User {

    @Test(description = "crear usuario")
    public void createUser() {
        RestAssured.baseURI = "https://petstore.swagger.io/";

        String requestBody = "{"
        + "\"id\": 0,"
        + "\"username\": \"usuarioTest1\","
        + "\"firstName\": \"sara\","
        + "\"lastName\": \"perez\","
        + "\"email\": \"sara@test.com\","
        + "\"password\": \"1234\","
        + "\"phone\": \"123456789\","
        + "\"userStatus\": 0"
        + "}";
        
        given()
            .contentType(ContentType.JSON)
            .body(requestBody)
        .when()
            .post("/user")
            .then()
            .statusCode(200)
            .body("message", equalTo("0"));
    }

    @Test(description = "login usuario")
    public void loginUser() {
        RestAssured.baseURI = "https://petstore.swagger.io/";
        given()
            .queryParam("username", "usuarioTest1")
            .queryParam("password", "1234")
        .when()
            .get("/user/login")
        .then()
            .statusCode(200)
            .body("message", containsString("logged in user session"));
    }

    @Test(description = "Logout del usuario")
    public void testLogoutUser() {
        RestAssured.baseURI = "https://petstore.swagger.io/";

        when()
            .get("/user/logout")
        .then()
            .statusCode(200);
    }

}  