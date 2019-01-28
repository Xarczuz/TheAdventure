package Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Quiz_Generator {

	private ArrayList<Quiz> questions = new ArrayList<Quiz>();

	private Quiz activeQuiz;

	public void create_quiestions(String question, String answer, ArrayList<String> incorrect_answer, String genre) {

		Quiz q1 = new Quiz(question, answer,  incorrect_answer , 100, genre);

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
			ArrayList<String> answers = this.activeQuiz.getWrong_answers();
			Collections.shuffle(Arrays.asList(answers));
			for (int i = 0; i < answers.size(); i++) {
				if (this.activeQuiz.getAnswer().equalsIgnoreCase(answers.get(i)) && i == 0) {
					this.activeQuiz.setSelectAnswer("a");
				} else if (this.activeQuiz.getAnswer().equalsIgnoreCase(answers.get(i)) && i == 1) {
					this.activeQuiz.setSelectAnswer("b");
				} else if (this.activeQuiz.getAnswer().equalsIgnoreCase(answers.get(i)) && i == 2) {
					this.activeQuiz.setSelectAnswer("c");
				} else if (this.activeQuiz.getAnswer().equalsIgnoreCase(answers.get(i)) && i == 3) {
					this.activeQuiz.setSelectAnswer("d");
				}
			}
			System.out.println();
			if (answers.size()<4) {
				System.out.printf("A: %-10s\tB: %-10s", answers.get(0), answers.get(1));
				
			}else {
				System.out.printf("A: %-10s\tB: %-10s\tC: %-10s\tD: %-10s\n", answers.get(0), answers.get(1), answers.get(2),
						answers.get(3));
				
			}
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
