package firstpackage;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;

public class prac {
	
	int id;
	
	HashMap data=new HashMap();
	
//	@Test
//	void getd() {
//		Response res= given()
//		
//		.when()
//		.get("http://localhost:3000/employeeData");
//		System.out.println(res.statusCode());
//		
//		res.then()
//		 .statusCode(200)
////		 .body("EmplID", equalTo("4011"))
////		 .body("Location", equalTo("hyderabad"))
//		 .log().all();
//		
//	}
	
	@Test(priority=1)
    void post() throws InterruptedException {
        // Preparing test data
        data.put("empname", "puliteja");
        data.put("empage", 25);

        // Sending POST request
        Response response = given()
            .contentType("application/json")
            .body(data)
        .when()
            .post("http://localhost:3000/employeeData")
        .then()
            .statusCode(201)  // Ensure the request was successful
            .body("empname", equalTo("puliteja"))
            .body("empage", equalTo(25))
            .log().all() // Log the full response
        .extract()
            .response(); // Extract the response for further processing

        Thread.sleep(2000);
        // Extract ID from the response
        try {
            id = response.jsonPath().getInt("id");
            System.out.println("Extracted ID: " + id);
        } catch (Exception e) {
            System.out.println("ID not found: " + e.getLocalizedMessage());
        }
    }

    @Test(dependsOnMethods = {"post"})
    void update() throws InterruptedException {
        // Wait for consistency
        Thread.sleep(2000);

        // Check if id is valid
        if (id <= 0) {
            System.out.println("Invalid ID, skipping update.");
            return; // Skip the test if ID is not valid
        }

        // Prepare new data for update
        data.put("empname", "pulisindhuja");
        data.put("empage", 35);

        // Sending PUT request to update the record
        given()
            .contentType("application/json")
            .body(data)
        .when()
            .put("http://localhost:3000/employeeData/" + id)
        .then()
            .statusCode(200)  // Ensure update was successful
            .body("empname", equalTo("pulisindhuja"))
            .body("empage", equalTo(35))
            .log().all(); // Log the response
    }

}
