package com.restful.booker.crudtest;

import com.restful.booker.model.AuthPojo;
import com.restful.booker.model.BookingPojo;
import com.restful.booker.testbase.TestBase;
import com.restful.booker.utils.TestUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PostBookingTest extends TestBase {
    static String username = "admin";
    static String password = "password123";
    static int bookingId = 7894;
    static String firstName = "Mary" + TestUtils.getRandomValue();
    static String lastName = "John" + TestUtils.getRandomValue();
    static int totalPrice = 150;
    static boolean depositPaid = true;
    static HashMap<String, Object> bookingDates;
    static String checkIn = "2024-02-01";
    static String checkOut = "2024-02-08";
    static String token = "Basic YWRtaW46cGFzc3dvcmQxMjM=";
    static String additionalNeeds = "Breakfast";
    static String newId;

    static int userId;

    @Test
    public void createToken() {
        AuthPojo authPojo = new AuthPojo();
        authPojo.setUsername(username);
        authPojo.setPassword(password);
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(authPojo)
                .post("https://restful-booker.herokuapp.com/auth");
        response.then().log().all().statusCode(200);

    }

    @Test
    public void createBooking() {
        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setBookingID(bookingId);
        bookingPojo.setFirstName(firstName);
        bookingPojo.setLastName(lastName);
        bookingPojo.setTotalPrice(totalPrice);
        bookingPojo.setDepositPaid(depositPaid);
        bookingPojo.setCheckIn(checkIn);
        bookingPojo.setCheckOut(checkOut);
        bookingPojo.setAdditionalNeeds(additionalNeeds);

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer b5f2ee3fca5b4efacce265745546d4fd7f1501611b151cf408ac45f7648bb5d0")
                .when()
                .body(bookingPojo)
                .post("/booking");
        response.then().statusCode(404);
        response.prettyPrint();
    }
//        Response response = given()
////                //.header("Content-Type", "application/json")
////                .contentType(ContentType.JSON)
////                .header("Cookie", "token=" + token)
////                .when()
////                .body(bookingPojo)
////                .post("https://restful-booker.herokuapp.com/booking");
////        response.prettyPrint();
////        response.then().statusCode(200);

//        Response response = given().log().all()
//                .header("Content-Type", "application/json")
//                //.headers("Cookie","token=abc123")
//                .header("Cookie", "token = Basic YWRtaW46cGFzc3dvcmQxMjM=")
//                .pathParam("id", 564)
//                .when()
//                .body(bookingPojo)
//                .post("https://restful-booker.herokuapp.com/booking/{id}");
//        response.then().log().all().statusCode(200);
//        response.prettyPrint();

//        Response responseBody = given().log().all()
//                .contentType(ContentType.JSON)
//                .header("Accept", "application/json")
//                .header("cookies", "token")
//                .body(bookingPojo)
//                .when()
//                .post().then().extract().response();
//
//        responseBody.then().statusCode(200).log().all();
//
//        System.out.println("response printing ======" + responseBody.asString());
//        newId = responseBody.jsonPath().get("bookingid");
//        System.out.println("myID ------> " + newId);

}


