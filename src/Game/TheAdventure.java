package Game;

import java.io.IOException;

public class TheAdventure {

	public static void main(String[] args) throws IOException {

		System.out.print("The Adventure Quiz Game!\n");
		String tmp = "";
		// Generate Questions
		Quiz_Generator qg1 = new Quiz_Generator();
		qg1.create_quiestions();
		// ******************

		Player p1 = new Player();
		System.out.print("Input name: ");
		p1.setName(Scr.inStr());
		p1.player_stats();
		System.out.println("Game Menu");
		System.out.println("-----------------------\n");
		System.out.println("Start game, Y/N: ");
		tmp = Scr.inStr();
		if (tmp.equalsIgnoreCase("n")) {
			System.out.println("The End!");
		} else {
			while (tmp != "q") {
				qg1.publish_question();
				tmp = Scr.inStr();
				int score = qg1.checkAnswer(tmp.toLowerCase());

				if (score == qg1.getActiveQuiz().getQuiz_score()) {
					System.out.println("Correct: " + qg1.getActiveQuiz().getAnswer());
					p1.setPlayer_score(p1.getPlayer_score() + score);
				} else {
					p1.setPlayer_lives(p1.getPlayer_lives() - 1);
					p1.setPlayer_score(p1.getPlayer_score() - score);
					System.out.println("Wrong!");
				}
				p1.player_stats();
				if (p1.getPlayer_lives()==0||qg1.getQuestions().isEmpty() || tmp.equalsIgnoreCase("q")) {
					System.out.println("The End!");
					break;
				}
			}
		}
	}

}
