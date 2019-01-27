package Game;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Quiz_Data {

	public void quizBank(Quiz_Generator qg1) {
		// We need to provide file path as the parameter:
		// double backquote is to avoid compiler interpret words
		// like \test as \t (ie. as a escape sequence)
		try {

			Object obj = new JSONParser().parse(new FileReader(".\\src\\Game\\db.json"));
			JSONObject results = (JSONObject) obj;

			JSONArray obj2 = (JSONArray) new JSONParser().parse(results.get("results").toString()); // make it into a

			for (int i = 0; i < obj2.size(); i++) { // iterate over it

				JSONObject getQuestion = (JSONObject) (obj2.get(i));
				String readquest = getQuestion.get("question").toString();
				String correctAwnser = getQuestion.get("correct_answer").toString();
				String wrongAwnser = getQuestion.get("incorrect_answers").toString().replaceAll("\\[|\\]", "");
				String genre = getQuestion.get("category").toString();
				qg1.create_quiestions(readquest, correctAwnser, wrongAwnser, genre);

			}

		} catch (Exception e) {
			System.out.println("Error");
		}

	}
}
