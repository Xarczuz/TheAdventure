package Game;

public class Player {

	private String name;
	private int player_score, player_lives;
	
	public Player(String name, int player_score, int player_lives) {
		this.name = name;
		this.player_score = player_score;
		this.player_lives = player_lives;
	}
	
	public void player_stats(String name, int player_score, int player_lives) {
		System.out.println("Player -> " + name);
		System.out.println("Your Points: " + player_score);
		System.out.println("Your lives: " + player_lives);
	}
}