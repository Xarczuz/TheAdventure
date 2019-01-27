package Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Quiz_Generator {

	private ArrayList<Quiz> questions = new ArrayList<Quiz>();

	private Quiz activeQuiz;

	public void create_quiestions(String question, String answer, String incorrect_answer, String genre) {

		Quiz q1 = new Quiz(question, answer, new String[] { incorrect_answer }, 100, genre);

		questions.add(q1);

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
