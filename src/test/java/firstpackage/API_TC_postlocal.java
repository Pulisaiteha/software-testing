package firstpackage;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;

public class API_TC_postlocal {

    int id;  // Declare id at the class level
    HashMap<String, String> data = new HashMap<>(); // Declare data at the class level

    @Test(priority = 1)
    void postdata() throws InterruptedException {
        data.put("company", "ARK");
        data.put("location", "Hybrid");

        Response response = given()
                .contentType("application/json")
                .body(data)
        .when()
                .post("http://localhost:3000/studentdata");

        // Debugging: Print Response
        System.out.println("Response Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.asString());
        
        Thread.sleep(3000);

        // Extract and Print ID
        try {
            id = response.jsonPath().getInt("id");
            System.out.println("Extracted ID: " + id);
        } catch (Exception e) {
            System.out.println("Error extracting ID: " + e.getMessage());
        }

        // Verify response status
        response.then().statusCode(201);
        
        Thread.sleep(3000);
    }


    @Test(dependsOnMethods = {"postdata"})
    void updatedata() throws InterruptedException {
    	Thread.sleep(3000);

        data.put("company", "ICT360");
        data.put("location", "HOME");

        Thread.sleep(3000);
        given()
                .contentType("application/json")
                .body(data)
                
        .when()
                .put("http://localhost:3000/studentdata/" + id)
        .then()
                .statusCode(200)  // Verify update success
                .body("company", equalTo("ICT360"))  // Verify updated values
                .body("location", equalTo("HOME"))
               .log().all();
    }
}
