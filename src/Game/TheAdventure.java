package Game;

import java.io.IOException;

public class TheAdventure {

	public static void main(String[] args) throws IOException {
		
		System.out.print("The Adventure Quiz Game!\n");
		String tmp = "";
		Quiz_Generator qg1 = new Quiz_Generator();
		qg1.create_quiestions();
		
		while(tmp != "q") {
			tmp = Scr.inStr();
			System.out.println("Game Menu");
			System.out.println("-----------------------\n");
			System.out.println("Start game, Y/N: ");
			qg1.questions.get(0).getQuestion();
			qg1.publish_question();
			if(tmp.equalsIgnoreCase("q")) {
				System.out.println("The End!");
				break;
			}
		}
	}

}
