package Game;

public class Player {

	private String name;
	private int player_score, player_lives;
	
	public Player() {
		
		this.player_score = 0;
		this.player_lives = 3;
	}
	
	public void player_stats() {
		System.out.println("******************************");
		System.out.println("Player -> " + name);
		System.out.println("Your Points: " + player_score);
		System.out.println("Your lives: " + player_lives);
		System.out.println("******************************");
		
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
