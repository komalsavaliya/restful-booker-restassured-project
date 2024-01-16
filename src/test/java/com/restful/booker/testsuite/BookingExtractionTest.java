package com.restful.booker.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class BookingExtractionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        response = given()
                .when()
                .get("/booking")
                .then().statusCode(200);
    }

    //Extract all bookingId
    @Test
    public void test001() {
        List<Integer> allIds = response.extract().path("bookingid");
        System.out.println("------------------Test start---------------------------");
        System.out.println("List of bookingIds are : " + allIds);
        System.out.println("------------------End of Test---------------------------");

    }

    //Extract the all Firstnames
    @Test
    public void test002() {
        List<String> allNames = response.extract().path("firstname");
        System.out.println("------------------List of all names---------------------------");
        System.out.println("List of all names are : " + allNames);
        System.out.println("------------------End of Test---------------------------");

    }

    //Extract the all Lastnames
    @Test
    public void test003() {
        List<String> allNames = response.extract().path("lastname");
        System.out.println("------------------List of all names---------------------------");
        System.out.println("List of all names are : " + allNames);
        System.out.println("------------------End of Test---------------------------");

    }

    //Verify Total Price
    @Test
    public void test004() {
        int price = response.extract().path("totalprice");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value is : " + price);
        System.out.println("------------------End of Test---------------------------");

    }
    //Verify Deposited Paid
    @Test
    public void test005() {
        boolean depositpaid = response.extract().path("depositpaid");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value is : " + depositpaid);
        System.out.println("------------------End of Test---------------------------");

    }

    //Verify Booking Dates
    @Test
    public void test006() {
        HashMap<String , Object> dates = response.extract().path("bookingdates");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value is : " + dates);
        System.out.println("------------------End of Test---------------------------");

    }

    //Verify Additional Needs
    @Test
    public void test007() {
        String needs = response.extract().path("additionalneeds");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value is : " + needs);
        System.out.println("------------------End of Test---------------------------");
    }

}