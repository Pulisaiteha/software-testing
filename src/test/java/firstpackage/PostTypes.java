package firstpackage;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class PostTypes {
	
	@Test
	void post() {
		
		Response res=(Response) given()
//		.pathParam("edata", "employeeData")
//		.queryParam("EmplID", "4011")
		
		.when()
		 .get("https://www.google.com/");
		 
		 String cookie=res.getCookie("AEC");
		Map<String,String> allcookies=res.getCookies();
		 System.out.println("This is printed Cookie"+cookie);
		 System.out.println("This is all key"+allcookies);
		 System.out.println("All keys only"+allcookies.keySet());
		 
		 res.then()
//		 .statusCode(200)
		 .cookie("AEC")
		 .log().all();	
	}
	

}
