package firstpackage;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

public class API_TC_POST {
	
	@Test
	void postUser() {
		
		
		HashMap hm=new HashMap();
		hm.put("name", "pavan");
		hm.put("job", "trainer");
		hm.put("age", 25);
		
		given()
		.contentType("application/json")
		.body(hm)
		
		.when()
		 .post("https://reqres.in/api/users")
		
		.then()
		  .statusCode(201)
		  .log().all();						
	}

}
