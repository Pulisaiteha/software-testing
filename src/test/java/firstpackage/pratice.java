package firstpackage;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;

import org.testng.annotations.Test;


public class pratice {
	
	int id;
	
//	@Test
//	void getUser() {
//		when()
//		  .get("https://reqres.in/api/users/2");
//		
////		.then()
////		  .statusCode(200)
////		  .log().all();
//	}
	
//	@Test
//	void postUser() {		
//		HashMap data=new HashMap();
//		data.put("name", "puli teja");
//		data.put("age", 25);
//		
//		
//		given()
//		 .contentType("application/json")
//		 .body(data)
//		 
//		 .when()
//		   .post("https://reqres.in/api/users")
//		   
//		   .then()
//		    .statusCode(201)
//		    .log().all();
//	}
	
	@Test
	void postUser() {
		
		HashMap data=new HashMap();
		data.put("name", "puli teja");
		data.put("age", 25);
		
		
		id=given()
		 .contentType("application/json")
		 .body(data)
		 
		 .when()
		   .post("https://reqres.in/api/users")
		   .jsonPath().getInt("id");   
		
	}
	
	@Test(dependsOnMethods= {"postUser"})
	void updateUser() {
		
		HashMap data=new HashMap();
		data.put("name", "puli sindhuja");
		data.put("age", 33);
		
		
		given()
		 .contentType("application/json")
		 .body(data)
		 
		 .when()
		   .put("https://reqres.in/api/users/"+id)
		   
		   .then()
		    .statusCode(200)
		    .log().all();
		  
	}
	
	@Test(priority=4)
	void delete() {
		
		when()
		 .delete("https://reqres.in/api/users/"+id)
		 
		 .then()
		   .statusCode(204)
		     .log().all();
	}

}
