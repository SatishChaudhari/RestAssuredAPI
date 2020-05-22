package restAssuredTests;

import io.restassured.RestAssured;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Demo3_PUT_Request {

    public static HashMap map = new HashMap();

    @BeforeClass
    public void putData() {
        map.put("employee_name", RestUtils.getEmpName()); // Using RestUtils class to pass random name.
        map.put("employee_salary", RestUtils.getSalary());
        map.put("employee_age", RestUtils.getAge());

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        RestAssured.basePath = "/update/11254";
    }
    @Test
    public void testPUT() {
        given()
                .contentType("application/json")
                .body(map)
                .when()
                .put()
                .then()
                .statusCode(200)
                .log().all();


    }


}
