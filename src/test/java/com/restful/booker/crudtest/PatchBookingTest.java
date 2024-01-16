package com.restful.booker.crudtest;

import com.restful.booker.model.AuthPojo;
import com.restful.booker.model.BookingPojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PatchBookingTest extends TestBase {
    static String username = "admin";
    static String password = "password123";
    static String token;


    @BeforeClass
    public static void inIt() {
        AuthPojo authPojo = new AuthPojo();
        authPojo.setUsername(username);
        authPojo.setPassword(password);
        token = given()
                .header("Content-Type", "application/json")
                .when()
                .body(authPojo)
                .post("https://restful-booker.herokuapp.com/auth")
                .then().statusCode(200).extract().path("token");
    }

    @Test
    public void updateARecordPartially() {
        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setCheckIn("2024-02-01");
        bookingPojo.setCheckOut("2024-02-08");
        bookingPojo.setFirstName("Josh");
        bookingPojo.setLastName("Allen");
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .pathParam("id", 25)
                .body(bookingPojo)
                .when().patch("https://restful-booker.herokuapp.com/booking/{id}");
        response.then().log().all().statusCode(200);
        response.prettyPrint();
    }

}
