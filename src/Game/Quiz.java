package Game;

import java.util.ArrayList;

public class Quiz {

	private String question, answer, selectAnswer, subject;
	private ArrayList<String> wrong_answers;
	private int quiz_score;

	public Quiz(String question, String answer, ArrayList<String> incorrect_answer, int quiz_score, String subject) {
		this.question = question;
		this.answer = answer;
		this.wrong_answers = incorrect_answer;
		this.quiz_score = quiz_score;
		this.subject = subject;
	}

	public String getQuestion() {
		return question;
	}

	public String getAnswer() {
		return answer;
	}

	public ArrayList<String> getWrong_answers() {
		return wrong_answers;
	}

	public int getQuiz_score() {
		return quiz_score;
	}

	public String getSelectAnswer() {
		return selectAnswer;
	}

	public void setSelectAnswer(String selectAnswer) {
		this.selectAnswer = selectAnswer;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
