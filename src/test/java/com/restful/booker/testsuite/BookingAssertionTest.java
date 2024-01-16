package com.restful.booker.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class BookingAssertionTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void start() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        response = given()
                .when()
                .get("/booking/15")
                .then().statusCode(200);
    }

    // Verify fristname = Josh
    @Test
    public void test001() {
        response.body("firstname", equalTo("Josh"));
    }

    // Verify lastname = Josh
    @Test
    public void test002() {
        response.body("firstname", equalTo("Josh"));
    }

    //Verify totalprice is greater than 100
    @Test
    public void test003() {
        response.body("totalprice", greaterThan(100));
    }

    @Test
    public void test004() {
        response.body("depositpaid", equalTo(true));
    }

    // Verify checkin is on 2018-01-01
    @Test
    public void test005() {
        response.body("bookingdates.checkin", equalTo("2018-01-01"));
    }

    // Verify checkout is on 2018-01-01
    @Test
    public void test006() {
        response.body("bookingdates.checkout", equalTo("2019-01-01"));
    }

    // Verify that the additionalneeds is superbowls
    @Test
    public void test007() {
        response.body("additionalneeds", equalTo("super bowls"));
    }






}