package firstpackage;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

public class API_TC_UPDATE {
	
	int id;
	
	@Test(priority=1)
	void postUser() {
		
		HashMap hm=new HashMap();
		hm.put("name", "pavan");
		hm.put("job", "trainer");
		hm.put("age", 25);
		
		id=given()
		.contentType("application/json")
		.body(hm)
		
		.when()
		 .post("https://reqres.in/api/users")
		 .jsonPath().getInt("id");
		 
		
//		.then()
//		  .statusCode(201)
//		  .log().all();						
	}
	
	@Test(priority=2,dependsOnMethods={"postUser"})
	void updateData() {
		
		HashMap hm=new HashMap();
		hm.put("name", "saiteja");
		hm.put("job", "coding trainer");
		hm.put("age", 25);
		
		given()
		.contentType("application/json")
		.body(hm)
		
		.when()
		 .put("https://reqres.in/api/users/"+id)
//		 .jsonPath().getInt("id");
		
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
	@Test(priority=3)
	void delete() {
		
		given()
		
		.when()
		.delete("https://reqres.in/api/users/"+id)
		
		.then()
		.statusCode(204)
		.log().all();
		
	}

}
