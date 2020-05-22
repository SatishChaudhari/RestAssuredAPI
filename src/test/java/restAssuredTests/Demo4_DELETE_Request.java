package restAssuredTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.given;

public class Demo4_DELETE_Request {
    @Test
    public void deleteEmpRecord() {
        RestAssured.baseURI = "https://postman-echo.com";
        RestAssured.basePath = "/delete";

        Response response =

                given()
                        .when()
                        .delete()
                        .then()
                        .statusCode(200)
                        .and()
                        .statusLine("HTTP/1.1 200 OK")
                        .log().all()
                        .extract().response(); // this method store full response in response variable

        String jsonAsString = response.asString(); // response convert into json
        Assert.assertEquals(jsonAsString.contains("https://postman-echo.com/delete"), true);


    }
}
