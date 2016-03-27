package logic;

import java.net.URL;

public class move {
private String name;
private String type;
private String effect;
private String skill;
private String explanation;
private double power;
private double healthCost;
private double staminaCost;
private double essenceCost;
String soundEffect;

public String getSoundEffect() {
	return soundEffect;
}

public void setSoundEffect(String soundEffect) {
	this.soundEffect = soundEffect;
}

move(String n,String t, String e, String sk, double p, double hc, double sc, double ec, URL sound){
	soundEffect=sound.toString();
	name =n;
	setSkill(sk);
	setType(t);
	setPower(p);
	setEffect(e);
	healthCost=hc;
	staminaCost=sc;
	essenceCost=ec;
}

public double getHealthCost() {
	return healthCost;
}

public void setHealthCost(double healthCost) {
	this.healthCost = healthCost;
}

public double getStaminaCost() {
	return staminaCost;
}

public void setStaminaCost(double staminaCost) {
	this.staminaCost = staminaCost;
}

public double getEssenceCost() {
	return essenceCost;
}

public void setEssenceCost(double essenceCost) {
	this.essenceCost = essenceCost;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public double getPower() {
	return power;
}

public void setPower(double power) {
	this.power = power;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEffect() {
	return effect;
}

public void setEffect(String effect) {
	this.effect = effect;
}

public String getSkill() {
	return skill;
}

public void setSkill(String skill) {
	this.skill = skill;
}

public String getExplanation() {
	return explanation;
}

public void setExplanation(String explanation) {
	this.explanation = explanation;
}

}
