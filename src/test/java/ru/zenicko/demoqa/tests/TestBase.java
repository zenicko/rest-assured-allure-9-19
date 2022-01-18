package ru.zenicko.demoqa.tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.zenicko.demoqa.config.urls.Urls;
import ru.zenicko.demoqa.config.users.DemoQaUserData;

import static java.lang.Thread.sleep;

public class TestBase {
    protected static String userJSONdata;

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = Urls.urlsConfig.urlApiBase();

        userJSONdata = String.format("{\"userName\": \"%s\",\"password\": \"%s\"}",
                DemoQaUserData.demoQaUserDataConfig.userName(),
                DemoQaUserData.demoQaUserDataConfig.password());
    }

    @BeforeEach
    void sleepUp() throws InterruptedException {

        sleep(500);
    }
}
