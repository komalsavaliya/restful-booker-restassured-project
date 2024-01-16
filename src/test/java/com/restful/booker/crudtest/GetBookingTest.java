package com.restful.booker.crudtest;

import com.restful.booker.model.BookingPojo;
import com.restful.booker.testbase.TestBase;
import com.restful.booker.utils.TestUtils;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetBookingTest extends TestBase {
    static ValidatableResponse response;
    static String token;
    static int bookingId;
    static String firstName = "John" + TestUtils.getRandomValue();
    static String lastName = "Smith" + TestUtils.getRandomValue();
    static String checkIn = "2024-02-01";
    static String checkOut = "2024-02-08";
    static int totalPrice = 250;
    static boolean depositPaid = true;
    static String additionalNeeds = "Breakfast";


    @Test
    public void getAllBookingIds() {
        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setBookingID(7894);
        bookingPojo.setFirstName(firstName);
        bookingPojo.setLastName(lastName);
        bookingPojo.setCheckIn(checkIn);
        bookingPojo.setCheckOut(checkOut);
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .body(bookingPojo)
                .when().get("https://restful-booker.herokuapp.com/booking");
        response.then().log().all().statusCode(200);
    }


    @Test
    public void getBookingIds() {
        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstName(firstName);
        bookingPojo.setLastName(lastName);
        bookingPojo.setTotalPrice(totalPrice);
        bookingPojo.setDepositPaid(depositPaid);
        bookingPojo.setCheckIn(checkIn);
        bookingPojo.setCheckOut(checkOut);
        bookingPojo.setAdditionalNeeds(additionalNeeds);
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .body(bookingPojo)
                .when()
                .get("https://restful-booker.herokuapp.com/booking");
        response.then().log().all().statusCode(200);
    }

    @Test
    public void getBookingWithFirstName() {
        BookingPojo bookingPojo = new BookingPojo();
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .body(bookingPojo)
                .param("firstname", firstName)
                .when().get("https://restful-booker.herokuapp.com/booking");
        response.then().log().all().statusCode(200);
    }
}



