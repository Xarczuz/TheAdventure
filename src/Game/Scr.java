package Game;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Scr {
	public static String inStr() throws java.io.IOException { // Inmating av text // Skapa BurreredReader f�r inmating
																// av str�ngen
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine(); // br.close();
		return str;
	}
}
