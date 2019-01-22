package Game;

import java.io.IOException;

public class TheAdventure {

	public static void main(String[] args) throws IOException {
		
		System.out.print("The Adventure Quiz Game!\n");
		String tmp = "";
		//Generate Questions
		Quiz_Generator qg1 = new Quiz_Generator();
		qg1.create_quiestions();
		//******************
		
		Player p1 = new Player();
		System.out.print("Input name: ");
		p1.setName(Scr.inStr());
		p1.player_stats();
		while(tmp != "q") {
			System.out.println("Game Menu");
			System.out.println("-----------------------\n");
			System.out.println("Start game, Y/N: ");
			tmp = Scr.inStr();
			qg1.publish_question();

			if(tmp.equalsIgnoreCase("q")) {
				System.out.println("The End!");
				break;
			}
		}
	}

}
