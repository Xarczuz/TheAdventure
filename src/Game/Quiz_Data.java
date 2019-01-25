package Game;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Quiz_Data {

	public static void main(String[] args) throws Exception {
		// We need to provide file path as the parameter:
		// double backquote is to avoid compiler interpret words
		// like \test as \t (ie. as a escape sequence)

		Object obj = new JSONParser().parse(new FileReader(".\\src\\Game\\db.json"));
		JSONObject results = (JSONObject) obj;

		JSONArray obj2 = (JSONArray) new JSONParser().parse(results.get("results").toString()); // make it into a
																								// jsonarray

		for (int i = 0; i < obj2.size(); i++) { // iterate over it
			JSONObject obj3 = (JSONObject) (obj2.get(i));
			String tmp = obj3.get("category").toString() + ", " + obj3.get("type").toString() + ", "
					+ obj3.get("question");// etc....
			System.out.println(tmp);
		}

	}
}
