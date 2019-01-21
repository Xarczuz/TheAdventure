package Game;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Scr {
	public static String inStr() throws java.io.IOException { 

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		//br.close();
		return str;
		
	}
}
