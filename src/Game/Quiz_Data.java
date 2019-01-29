package Game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Quiz_Data {

	public void quizBank(Quiz_Generator qg1) throws FileNotFoundException, IOException, ParseException {

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
		//Object obj = new JSONParser().parse(new FileReader(".\\src\\Game\\db.json"));
		 Object obj = new JSONParser().parse(s);
		JSONObject results = (JSONObject) obj;

		JSONArray obj2 = (JSONArray) new JSONParser().parse(results.get("results").toString());

		for (int i = 0; i < obj2.size(); i++) {

			JSONObject getQuestion = (JSONObject) (obj2.get(i));
			String readquest = getQuestion.get("question").toString().replaceAll("&quot;", "\"")
					.replaceAll("[&][#0-9]+[;]", "").replaceAll("&amp;","&");
			String correctAwnser = getQuestion.get("correct_answer").toString().replaceAll("[&#][0-9]+[;]", "");
			JSONArray j = (JSONArray) getQuestion.get("incorrect_answers");
			String genre = getQuestion.get("category").toString();
			ArrayList<String> arr = new ArrayList<String>();
			for (Object object : j) {
				arr.add(object.toString());
			}
			arr.add(correctAwnser);
			Collections.shuffle(arr);
			String difficulty = getQuestion.get("difficulty").toString();

			int diffPoint = 0;
			switch (difficulty) {
			case "easy":
				diffPoint = 100;
				break;
			case "medium":
				diffPoint = 150;
				break;
			case "hard":
				diffPoint = 200;
				break;

			}
			qg1.create_quiestions(readquest, correctAwnser, arr, diffPoint, genre);

		}

	}
}
