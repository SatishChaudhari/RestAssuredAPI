package restAssuredTests;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import io.restassured.RestAssured;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Demo2_Post_Request {

    public static HashMap map = new HashMap();


    @BeforeClass
    public void postData(){
        Fairy fairy = Fairy.create();
        Person person = fairy.person();


        map.put("Firstname", person.getFirstName());
        map.put("Lastname", person.getLastName());
        map.put("Email", person.getEmail());
        map.put("Phone", person.getTelephoneNumber());

        RestAssured.baseURI = "http://mcaindia.bananaapps.co.uk";
        RestAssured.basePath = "/api/user/Register";
    }
    @Test
    public void testPost(){
        given()
                .contentType("application/json")
                .body(map)
                .when()
                .post()
                .then()
                .statusCode(200)
                .and()
                .assertThat()
                .body("Message.Message", equalTo("User registration successfully completed."))
                .and()
                .header("Content-Type", equalTo("application/json; charset=utf-8"));
    }

}
