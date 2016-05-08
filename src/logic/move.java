package logic;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class move {

	private String name;
	private String type;
	private effect effect;
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

	move(String n, String t, String e, String sk, double p, double hc, double sc, double ec, URL sound) {
		soundEffect = sound.toString();
		name = n;
		setSkill(sk);
		setType(t);
		setPower(p);
		healthCost = hc;
		staminaCost = sc;
		essenceCost = ec;
	}

	move(String inputText) {

		List<String> results = game.keywordTagSearch(inputText, (List<String>) Arrays.asList(new String[] { "movename",
				"moveskill", "movetype", "power", "effect", "healthcost", "staminacost", "essencecost", "sound","explanation" }));
		
		name = results.get(0);
		setSkill(results.get(1));
		setType(results.get(2));
		setPower(Integer.parseInt(results.get(3)));
		setEffect(new effect(results.get(4)));
		healthCost = (Integer.parseInt(results.get(5)));
		staminaCost =(Integer.parseInt(results.get(6)));
		essenceCost =(Integer.parseInt(results.get(7)));
		
		try {
			soundEffect = new URL(results.get(8)).toString();
		} catch (MalformedURLException e) {
			System.out.println("Error when forming sound for a move.");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		explanation=results.get(9);
		
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

	public effect getEffect() {
		return effect;
	}

	public void setEffect(effect effect) {
		this.effect = effect;
	}

}
