package logic;

import java.util.Arrays;
import java.util.List;

public class weapon {
	
	public String name;
	public int damage;
	public effect effect;
	
	public weapon(String inputText) {
		
		List<String> results = game.keywordTagSearch(inputText,
				(List<String>) Arrays.asList(new String[] {"weaponname", "damage","effect" }));
		name=results.get(0);
		damage=Integer.parseInt(results.get(1));
		effect=new effect(results.get(2));
		
		// TODO Auto-generated constructor stub
		
	}

}