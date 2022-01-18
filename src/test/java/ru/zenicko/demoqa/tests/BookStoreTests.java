package ru.zenicko.demoqa.tests;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.zenicko.demoqa.config.urls.Urls;
import ru.zenicko.demoqa.helpers.AllureRestAssuredCustomFilter;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

@DisplayName("Testing API https://demoqa.com")
@Tag("BookStoreTests")
public class BookStoreTests extends TestBase {

    @Test
    @DisplayName("Some test uses")
    void noLogTest() {

        RestAssured
                .given()
                .when()
                .get(Urls.urlsConfig.bookstoreGetBooks())
                .then()
                .body("books", Matchers.hasSize(Matchers.greaterThan(0)));
    }

    @Test
    @DisplayName("Some test uses with all log")
    void allLogTest() {

        RestAssured
                .given()
                .log().all()
                .when()
                .get(Urls.urlsConfig.bookstoreGetBooks())
                .then()
                .log().all()
                .body("books", Matchers.hasSize(Matchers.greaterThan(0)));
    }

    @Test
    @DisplayName("Some test uses with some log")
    void someLogTest() {

        RestAssured
                .given()
                .log().uri()
                .log().body()
                .when()
                .get(Urls.urlsConfig.bookstoreGetBooks())
                .then()
                .log().body()
                .body("books", Matchers.hasSize(Matchers.greaterThan(0)));
    }

    @Test
    @DisplayName("Authorized")
    void authorizedTest() {

        String token =
            RestAssured
                    .given()
                    .contentType("application/json")
                    .accept("application/json")
                    .body(userJSONdata)
                    .log().uri()
                    .log().body()
                    .when()
                    .post(Urls.urlsConfig.accountPostGenerateToken())
                    .then()
                    .log().body()
                    .body("token", is( notNullValue()))
                    .body("result", is( "User authorized successfully."))
                    .body("status", is( "Success"))
                    .extract().response().path("token");
        System.out.println(token);
    }

    @Test
    @DisplayName("Allure Test Assured")
    void authorizationWithListenerTest() {

        RestAssured
                .given()
                .filter(new AllureRestAssured())
                .contentType(ContentType.JSON)
                .body(userJSONdata)
                .log().uri()
                .log().body()
                .when()
                .post(Urls.urlsConfig.accountPostGenerateToken())
                .then()
                .log().body()
                .body("result", is( "User authorized successfully."))
                .body("status", is( "Success"))
                .extract().response().path("token");
    }

    @Test
    @DisplayName("Allure Test Assured with custom temptate")
    void authorizationWithCustomTemplatesTest() {

        RestAssured
                .given()
                .filter(AllureRestAssuredCustomFilter.customLogFilter().withCustomTemplates())
                .contentType(ContentType.JSON)
                .body(userJSONdata)
                .log().uri()
                .log().body()
                .when()
                .post(Urls.urlsConfig.accountPostGenerateToken())
                .then()
                .log().body()
                .body("result", is( "User authorized successfully."))
                .body("status", is( "Success"))
                .extract().response().path("token");
    }

    @Test
    @DisplayName("Check the schema JSON of the response api /Account/v1/GenerateToken")
    void authorizationSchemaJSONTest() {

        RestAssured
                .given()
                .filter(new AllureRestAssured())
                .contentType(ContentType.JSON)
                .body(userJSONdata)
                .log().uri()
                .log().body()
                .when()
                .post(Urls.urlsConfig.accountPostGenerateToken())
                .then()
                .log().body()
                .body(matchesJsonSchemaInClasspath("jsonschemes/schema-response-token.json"))
                .body("result", is( "User authorized successfully."))
                .body("status", is( "Success"))
                .extract().response().path("token");
    }

}
