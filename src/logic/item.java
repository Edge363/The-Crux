package logic;

public class item {
private int armor;
private String effect;

item(int a, String e){
	armor=a;
	effect=e;
}

public int getArmor() {
	return armor;
}
public void setArmor(int armor) {
	this.armor = armor;
}
public String getEffect() {
	return effect;
}
public void setEffect(String effect) {
	this.effect = effect;
}
}
