package Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Quiz_Generator {

	ArrayList<Quiz> questions = new ArrayList<Quiz>();

	Quiz activeQuiz;
	
	public void create_quiestions() {
		Quiz q1 = new Quiz("Sveriges huvudstad?", "Stockholm", new String[] { "Stockholm", "Oslo", "Helsingfors", "Köpehamn" }, 100);
		Quiz q2 = new Quiz("Vad heter USA's president?", "Donald Trump",new String[] { "Donald Trump", "Donald Duck", "Donald Hump", "Donald Gump" }, 100);

		questions.add(q1);
		questions.add(q2);

		Collections.shuffle(questions);
	}

	public Quiz getQuestion() {
		return questions.remove(0);
	}

	public void publish_question() {
		
		if (questions.size() > 0) {
			
			this.activeQuiz = getQuestion();
			System.out.println(this.activeQuiz.question);
			String[] answers = this.activeQuiz.getWrong_answers();
			Collections.shuffle(Arrays.asList(answers));
			System.out.printf("A: %-10s\tB: %-10s\tC: %-10s\tD: %-10s",answers[0],answers[1],answers[2],answers[3]);
		}
	}
}
