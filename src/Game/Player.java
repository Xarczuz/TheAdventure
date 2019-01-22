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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPlayer_score() {
		return player_score;
	}

	public void setPlayer_score(int player_score) {
		this.player_score = player_score;
	}

	public int getPlayer_lives() {
		return player_lives;
	}

	public void setPlayer_lives(int player_lives) {
		this.player_lives = player_lives;
	}
	
}
