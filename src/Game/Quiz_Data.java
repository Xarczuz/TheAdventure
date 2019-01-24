package Game;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Quiz_Data {

	public static void main(String[] args) throws Exception {
		// We need to provide file path as the parameter:
		// double backquote is to avoid compiler interpret words
		// like \test as \t (ie. as a escape sequence)

		Object obj = new JSONParser().parse(new FileReader("C:\\Users\\Perham\\git\\TheAdventure\\src\\Game\\db.json"));
		JSONObject results = (JSONObject) obj;

		String question = (String) results.get("type");

		System.out.println(question);

	}
}
