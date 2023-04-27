package com.studentCore.app.main.controllers.test;

import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

/**
 * This is the base class for initialisation of local variables.
 **/
public class BaseControllerTestAPI {
        
        
        @BeforeAll
        public static void init() {
                baseURI = "http://localhost";
                port = 8000;
        }
}
