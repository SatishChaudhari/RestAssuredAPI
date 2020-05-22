package restAssuredTests;


import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class Demo5_BasicValidation_JSON {
    //1) Test Status Code
    @Test(priority = 1)
    public void testStatusCode() {
        given()
                .param("Organisationid", "3")
                .when().get("http://mcaindia.bananaapps.co.uk/api/Organization/OrganizationById")
                .then().statusCode(200);
    }

    //   2) Log Response
    @Test(priority = 2)
    public void logResponse() {
         given().when().get("http://mcaindia.bananaapps.co.uk/api/Common/Categories?communityid=2")
                .then().statusCode(200).log().all();

    }

    //3) Verifying Single content in Response body
    @Test(priority = 3)
    public void verifySingleContent() {
        given().when().get("http://mcaindia.bananaapps.co.uk/api/user/Profile?userid=1326")
                .then().statusCode(200)
                .body("Msg.Message", equalTo("User details retrieved successfully."));

    }

    //4) Verifying Multiple contents in Response body
    @Test(priority = 4)
    public void verifyMultipleContents() {
        given().when().get("http://mcaindia.bananaapps.co.uk/api/Common/Categories?communityid=2")
                .then().statusCode(200)
                .body("CategoriesDetails.Category_name", hasItems("Home Services ", "Saloon and Spa", "Health", "Cabs"));

    }

    //5) Setting Parameters & Headers
    @Test(priority = 5)
    public void testParametersAndHeaders() {
        given()
                .param("title", "Vasu Digitals")
                .param("communityid", "2")
                //       .header("MyHeader", "testHeader")
                .when().get("http://mcaindia.bananaapps.co.uk/api/Services")
                .then().statusCode(200).log().all();

    }


}