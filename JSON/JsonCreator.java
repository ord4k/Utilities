import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class JsonCreator {


	   public static void main(String[] args) throws JSONException, IOException{
	      JSONObject obj = new JSONObject();

	      try {
			obj.put("name", "foo");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      obj.put("num", new Integer(100));
	      obj.put("balance", new Double(1000.21));
	      obj.put("is_vip", new Boolean(true));


	      ;
			try (FileWriter file = new FileWriter("/home/ord4k/Documents/json.txt")) {
				file.write(obj.toString());
				System.out.println("Successfully Copied JSON Object to File...");
				System.out.println("\nJSON Object: " + obj);
			}
			
	   }
	}


