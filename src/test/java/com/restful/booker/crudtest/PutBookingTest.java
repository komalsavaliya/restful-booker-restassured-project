package com.restful.booker.crudtest;

import com.restful.booker.model.BookingPojo;
import com.restful.booker.testbase.TestBase;
import com.restful.booker.utils.TestUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PutBookingTest extends TestBase {
    static String username = "admin";
    static String password = "password123";
    static String firstName = "Mary" + TestUtils.getRandomValue();
    static String lastName = "John" + TestUtils.getRandomValue();
    static int totalPrice = 150;
    static boolean depositPaid = true;
    static String checkIn = "2024-02-01";
    static String checkOut = "2024-02-08";
    static String additionalNeeds = "Breakfast";
    static String token = "Basic YWRtaW46cGFzc3dvcmQxMjM=";
    static String cookie = "token=<token_value>";
    static int bookingId;
    private String newId;

//    @BeforeClass
//    public static void inIt() {
//        AuthPojo authPojo = new AuthPojo();
//        authPojo.setUsername(username);
//        authPojo.setPassword(password);
//        //token = given()
//        Response response = given().log().all()
//                .header("Authorization", token)
//                .contentType(ContentType.JSON)
//                .when()
//                .body(authPojo)
//                .post("/auth")
//                .then().statusCode(200).extract().path("token");
//    }

    @Test
    public void updateBooking() {
        BookingPojo bookingPojo = new BookingPojo();
        List<String> bookingDate = new ArrayList<>();
        bookingPojo.setFirstName(firstName);
        bookingPojo.setLastName(lastName);
        bookingPojo.setTotalPrice(totalPrice);
        bookingPojo.setDepositPaid(depositPaid);
        bookingPojo.setCheckIn(checkIn);
        bookingPojo.setCheckOut(checkOut);
        bookingPojo.setAdditionalNeeds(additionalNeeds);
        RequestSpecification request = RestAssured.given().log().all();
        request.header("Content-Type", "application/json")
                .header("cookie", "token=" + token)
                .log().all();
        //.header("authorization", "bearer" + token)
        Response response = request.body(bookingPojo)
                .put("/" + newId);
        response.then().statusCode(200).log().all();
        System.out.println("put----> " + response.asString());

    }

//        Response response = given()
//                .header("Authorization",token)
//                .contentType(ContentType.JSON)
//                .when()
//                .body(bookingPojo)
//                .post("/booking");
//        bookingId = response.then().contentType(ContentType.JSON).extract().path("bookingid");
//        response.then().statusCode(201);
//        System.out.println(bookingId);

//        Response response = given().log().all()
//                .header("Content-Type", "application/json")
//                .header("Accept", "application/json")
//                .header("Authorization",token)
//                .header("Cookie",cookie)
 //                  .when()
//                .body(bookingPojo)
//                .put("/booking/555");
//
//        response.then().log().all().statusCode(200);
//        response.prettyPrint();

//        Response response = given()
//                .header("Content-Type", "application/json")
//                .header("Accept", "application/json")
//                .header("Cookie", "token=" + token)
//                .pathParam("id", 10)
//                .body(bookingPojo)
//                .when().put("https://restful-booker.herokuapp.com/booking/{id}");
//        response.then().log().all().statusCode(200);


    }






