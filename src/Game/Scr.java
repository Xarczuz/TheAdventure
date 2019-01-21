package Game;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Scr {
	public static String inStr() throws java.io.IOException { // Inmating av text // Skapa BurreredReader för inmating
																// av strängen
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine(); // br.close();
		return str;
	}
}
