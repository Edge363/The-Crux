package logic;

import java.util.Arrays;
import java.util.List;

public class effect {

	private String effect;
	private int strength;

	effect(String inputText) {
		
		List<String> results = game.keywordTagSearch(inputText,
				(List<String>) Arrays.asList(new String[] { "effectID","strength" }));
		effect=results.get(0);
		strength=Integer.parseInt(results.get(1));
		
	}

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}
}
