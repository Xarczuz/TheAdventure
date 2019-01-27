package Game;

import java.io.IOException;

public class TheAdventure {

	public static void main(String[] args) throws IOException {

		System.out.print("The Adventure Quiz Game!\n");
		String tmp = "";
		// Generate Questions
		Quiz_Generator qg1 = new Quiz_Generator();
		Quiz_Data data = new Quiz_Data();

		data.quizBank(qg1);

		// ******************

		Player p1 = new Player();
		System.out.print("Input name: ");
		p1.setName(Scr.inStr());
		p1.player_stats();
		System.out.println("Game Menu");
		System.out.println("-----------------------\n");

		while (true) {
			System.out.println("Start game, Y/N: ");
			System.out.println("1. Start Game");
			System.out.println("2. End Game");
			System.out.println("3. Change Name");
			tmp = Scr.inStr();

			if (tmp.equalsIgnoreCase("1")) {
				break;
			}
			if (tmp.equalsIgnoreCase("2")) {
				System.out.println("The End!");
				return;
			}
			if (tmp.equalsIgnoreCase("3")) {
				System.out.print("Input name: ");
				String name = Scr.inStr();
				p1.setName(name);
				p1.player_stats();
			}
		}
		System.out.println("Hit q to exit\n");

		while (tmp != "q") {

			qg1.publish_question();
			tmp = Scr.inStr();
			int score = qg1.checkAnswer(tmp.toLowerCase());

			if (score == qg1.getActiveQuiz().getQuiz_score()) {
				System.out.println("Correct: " + qg1.getActiveQuiz().getAnswer() + ", Score: " + score);
				p1.setPlayer_score(p1.getPlayer_score() + score);
			} else {
				p1.setPlayer_lives(p1.getPlayer_lives() - 1);
				p1.setPlayer_score(p1.getPlayer_score() - score);
				System.out.println("Wrong!, Score: -" + score);
			}
			p1.player_stats();
			if (p1.getPlayer_lives() == 0 || qg1.getQuestions().isEmpty() || tmp.equalsIgnoreCase("q")) {
				System.out.println("The End!");
				break;
			}
		}

	}

}
