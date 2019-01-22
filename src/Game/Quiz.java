package Game;

public class Quiz {
	
	private String question, answer,selectAnswer;
	private String[] wrong_answers;
	private int quiz_score;

	public Quiz(String question, String answer, String[] wrong_answers, int quiz_score) {
		this.question = question;
		this.answer = answer;
		this.wrong_answers = wrong_answers;
		this.quiz_score = quiz_score;
	}

	public String getQuestion() {
		return question;
	}

	public String getAnswer() {
		return answer;
	}

	public String[] getWrong_answers() {
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
	
	
}
