package com.studentCore.app.main.controllers.test;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponseOptions;
import io.restassured.specification.RequestSpecification;

import org.json.JSONArray;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.basePath;

/**
 * This is a REST-Assured test class for my project
 */
public class StudentRecordControllerTest extends BaseControllerTestAPI {
        
        @BeforeAll
        public static void init() {
                basePath = "/studentRecords";
        }
        
        @DisplayName("All Student Records from H2")
        @Test
        public void fetchAllStudentData(){
                RequestSpecification reqSpec = RestAssured.given();
                Response response = reqSpec.get("/fetchAll");
                response.print();
                String responseStr =  response.print();
                JSONArray jsonArray = new JSONArray(responseStr);
                System.out.println("The Size of JSON Array"+jsonArray.length());
//                JSONObject jsonObj =
//                        new JSONObject(responseStr);
//                System.out.println(jsonObj.keySet().size());
                ValidatableResponseOptions validateResponse = response.then();
                validateResponse.statusCode(200);
//                Assert.assertEquals(true,jsonArray.length()==5);
        
        }
        
        @DisplayName("All Student That have valid passport")
        @Test
        public void fetchStudentWithoutPassport(){
                RequestSpecification reqSpec = RestAssured.given();
                Response response = reqSpec.get("/fetchAllStudentWithoutPassport");
                response.print();
                String responseStr = response.print().toString();
                JSONArray jsonArray = new JSONArray(responseStr);
                System.out.println("The Size of JSON Array"+jsonArray.length());
                ValidatableResponseOptions validateResponse = response.then();
                validateResponse.statusCode(200);
//                Assert.assertFalse("No of records are in correct",jsonObjtest.keySet().size()==5);
        }
        
        
        
        
}
