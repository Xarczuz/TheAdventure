package Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Quiz_Generator {

	private ArrayList<Quiz> questions = new ArrayList<Quiz>();

	private Quiz activeQuiz;

	public void create_quiestions() {
		Quiz q1 = new Quiz("Sveriges huvudstad?", "Stockholm",
				new String[] { "Stockholm", "Oslo", "Helsingfors", "Köpehamn" }, 100, "Sweden");
		Quiz q2 = new Quiz("Vad heter USA's president?", "Donald Trump",
				new String[] { "Donald Trump", "Donald Duck", "Donald Hump", "Donald Gump" }, 100, "USA");
		Quiz q3 = new Quiz("Vem är sveriges Statsminister år 2019?", "Stefan löfven",
				new String[] { "Stefan löfven", "Stefan lööfven", "Stefan löfvenn", "Stefan löfeven" }, 100, "Sweden");
		Quiz q4 = new Quiz("Sveriges huvudstad?", "Stockholm",
				new String[] { "Stockholm", "Oslo", "Helsingfors", "Köpehamn" }, 100, "Sweden");
		Quiz q5 = new Quiz("Vad heter USA's president?", "Donald Trump",
				new String[] { "Donald Trump", "Donald Duck", "Donald Hump", "Donald Gump" }, 100, "USA");
		Quiz q6 = new Quiz("Vem är sveriges Statsminister år 2019?", "Stefan löfven",
				new String[] { "Stefan löfven", "Stefan lööfven", "Stefan löfvenn", "Stefan löfeven" }, 100, "Sweden");

		questions.add(q1);
		questions.add(q2);
		questions.add(q3);
		questions.add(q4);
		questions.add(q5);
		questions.add(q6);
		
		Collections.shuffle(questions);
	}

	public Quiz getQuestion() {
		return questions.remove(0);
	}

	public void publish_question() {

		if (questions.size() > 0) {

			this.activeQuiz = getQuestion();
			System.out.println("*********************************************************************************");
			System.out.println(this.activeQuiz.getQuestion());
			String[] answers = this.activeQuiz.getWrong_answers();
			Collections.shuffle(Arrays.asList(answers));
			for (int i = 0; i < answers.length; i++) {
				if (this.activeQuiz.getAnswer().equalsIgnoreCase(answers[i]) && i == 0) {
					this.activeQuiz.setSelectAnswer("a");
				} else if (this.activeQuiz.getAnswer().equalsIgnoreCase(answers[i]) && i == 1) {
					this.activeQuiz.setSelectAnswer("b");
				} else if (this.activeQuiz.getAnswer().equalsIgnoreCase(answers[i]) && i == 2) {
					this.activeQuiz.setSelectAnswer("c");
				} else if (this.activeQuiz.getAnswer().equalsIgnoreCase(answers[i]) && i == 3) {
					this.activeQuiz.setSelectAnswer("d");
				}
			}
			System.out.println();
			System.out.printf("A: %-10s\tB: %-10s\tC: %-10s\tD: %-10s\n", answers[0], answers[1], answers[2],
					answers[3]);
			System.out.println();
			System.out.println("*********************************************************************************");
			
			
		}
	}

	public int checkAnswer(String answer) {

		if (answer.equalsIgnoreCase(activeQuiz.getSelectAnswer())) {
			return activeQuiz.getQuiz_score();
		} else {
			return activeQuiz.getQuiz_score() / 2;
		}
	}

	public ArrayList<Quiz> getQuestions() {
		return questions;
	}

	public Quiz getActiveQuiz() {
		return activeQuiz;
	}
}
