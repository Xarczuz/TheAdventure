package Game;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Quiz_Data {

	public void quizBank(Quiz_Generator qg1) {
		// We need to provide file path as the parameter:
		// double backquote is to avoid compiler interpret words
		// like \test as \t (ie. as a escape sequence)
		try {
			URL url = new URL("https://opentdb.com/api.php?amount=50");
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			String s = "";
			while (true) {
				String tmp = in.readLine();
				if (tmp == null) {
					break;
				}
				s += tmp;
			}
			// Object obj = new JSONParser().parse(new FileReader(".\\src\\Game\\db.json"));
			Object obj = new JSONParser().parse(s);
			JSONObject results = (JSONObject) obj;

			JSONArray obj2 = (JSONArray) new JSONParser().parse(results.get("results").toString()); // make it into a

			for (int i = 0; i < obj2.size(); i++) { // iterate over it

				JSONObject getQuestion = (JSONObject) (obj2.get(i));
				String readquest = getQuestion.get("question").toString().replaceAll("&quot;", "\"")
						.replaceAll("[&][#0-9]+[;]", "");
				String correctAwnser = getQuestion.get("correct_answer").toString().replaceAll("[&#][0-9]+[;]", "");
				// String wrongAwnser =
				// getQuestion.get("incorrect_answers").toString().replaceAll("\\[|\\]", "");
				JSONArray j = (JSONArray) getQuestion.get("incorrect_answers");
				String genre = getQuestion.get("category").toString();
				ArrayList<String> arr = new ArrayList<String>();
				for (Object object : j) {
					arr.add(object.toString());
				}
				arr.add(correctAwnser);

				qg1.create_quiestions(readquest, correctAwnser, arr, genre);

			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
