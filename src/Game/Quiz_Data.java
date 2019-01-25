package Game;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Quiz_Data {

	public void quizBank() throws Exception {
		// We need to provide file path as the parameter:
		// double backquote is to avoid compiler interpret words
		// like \test as \t (ie. as a escape sequence)

		Quiz_Generator load = new Quiz_Generator();

		Object obj = new JSONParser().parse(new FileReader(".\\src\\Game\\db.json"));
		JSONObject results = (JSONObject) obj;

		JSONArray obj2 = (JSONArray) new JSONParser().parse(results.get("results").toString()); // make it into a

		int randomQuestion = (int) (Math.random() * (obj2.size() - 1) + 1);

		JSONObject getQuestion = (JSONObject) (obj2.get(randomQuestion));
		String readquest = getQuestion.get("question").toString();
		String correctAwnser = getQuestion.get("correct_answer").toString();
		String wrongAwnser = getQuestion.get("incorrect_answers").toString().replaceAll("\\[|\\]", "");
		String genre = getQuestion.get("category").toString();
		load.create_quiestions(readquest, correctAwnser, wrongAwnser, genre);

		// jsonarray

//		for (int i = 0; i < obj2.size(); i++) { // iterate over it
//			JSONObject obj3 = (JSONObject) (obj2.get(i));
//			String tmp = obj3.get("question").toString() + "\n";
//
//			System.out.println(tmp);
//		}

	}
}
