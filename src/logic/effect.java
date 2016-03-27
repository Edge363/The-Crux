package logic;

public class effect {
private String effect;
private int strength;

effect(String e , int s){
	effect = e;
	strength =s;
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
