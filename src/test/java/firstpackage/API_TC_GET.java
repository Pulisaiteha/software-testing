package firstpackage;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import static io.restassured.matcher.RestAssuredMatchers.*;

public class API_TC_GET {
	
	
		@Test
		void getUser() {
			
			given()
			
			.when()
			   .get("https://reqres.in/api/users?page=2")
			
			.then()
			  .statusCode(200)
			  .body("page", equalTo(2))
			  .log().all(); 
			
		}
}