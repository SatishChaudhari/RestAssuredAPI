package restAssuredTests;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


/*
Given()
    set cookies, add authorisation, add param, set headers info etc..
When()
    GET, POST, PUT, DELETE....
Then()
    validate status code, extract response, extract headers cookies & response body....
 */
public class Demo1_GET_Request {
    @Test
    public void getProfileDetails() {
        given()
                .when()
                .get("http://mcaindia.bananaapps.co.uk/api/user/Profile?userid=1326")
                .then()
                .statusCode(200)
                .and()
                .assertThat().body("Msg.Message", equalTo("User details retrieved successfully."))
                .and()
                .header("Content-Type", "application/json; charset=utf-8");


    }


}
