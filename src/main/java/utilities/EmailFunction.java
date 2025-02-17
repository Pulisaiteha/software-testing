package utilities;

import java.util.Date;

public class EmailFunction {
		
		public static String generateUniqueEmail() {
	        Date date = new Date();
	        String timestamp = date.toString().replaceAll("\\s", "").replaceAll(":", "");
	        return timestamp + "@gmail.com";
	    }

	}
