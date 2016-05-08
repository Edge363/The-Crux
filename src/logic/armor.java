package logic;

import java.util.Arrays;
import java.util.List;

public class armor {
public String name;
private int defense;
private effect effect;

armor(String inputText){
	
	List<String> results = game.keywordTagSearch(inputText,
			(List<String>) Arrays.asList(new String[] {"armorname", "defense","effect" }));
	name=results.get(0);
	defense=Integer.parseInt(results.get(1));
	effect=new effect(results.get(2));
	
}

public int getArmor() {
	return defense;
}
public void setArmor(int armor) {
	this.defense = armor;
}
public int getEffect() {
	return defense;
}

}
