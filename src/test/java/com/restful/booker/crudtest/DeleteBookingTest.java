package com.restful.booker.crudtest;

import com.restful.booker.testbase.TestBase;
import com.restful.booker.utils.TestUtils;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteBookingTest extends TestBase {
    static int id = Integer.parseInt(TestUtils.getRandomValue());
    static ValidatableResponse response;
    static String token;

    @Test
        public void verifyBookingDeletedSuccessfully() {
            Response response = given().log().all()
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                    .when()
                    .delete("https://restful-booker.herokuapp.com/booking/1");

            response.then().log().all().statusCode(201);
            response.prettyPrint();
        }
    }

