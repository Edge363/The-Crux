/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.scene.image.Image;

public class character implements Serializable {
	protected static final long serialVersionUID = 1L;
	
	protected String name;
	protected double level;
	Image selfy;

	protected double HP;// health
	protected double ST;// stamina
	protected double MP;// mana
	protected double XP;// experience

	protected double STR;// Improves base physical damage, and stamina
	protected double AG;// improves dodge chance.
	protected double smallArms = (int) (Math.random() * 5);
	protected double throwing = (int) (Math.random() * 5);
	protected double lightArmor = (int) (Math.random() * 5);
	protected double SP;// determines if you or the enemy goes first
	protected double running = (int) (Math.random() * 5);// increases the passive
														// recovery of all flat
														// regens.
	
	protected double archery = (int) (Math.random() * 5);
	protected double swordfighting = (int) (Math.random() * 5);
	protected double PRE;// improves crit chance
	protected double largeArms = (int) (Math.random() * 5);
	protected double aim = (int) (Math.random() * 5);// Higher percentage to hit
	protected double dodging = (int) (Math.random() * 5);// flat dodge chance
														// increase

	public double INT;// improves base magic damage, and mana.
	protected double CHAR; // Improves allies damage and defense.
	protected double taming = (int) (Math.random() * 5); // can tame better
														// creatures
	protected double speechcraft = (int) (Math.random() * 5);// better dialogue
															// options
	protected double leadership = (int) (Math.random() * 5);// can have more
															// allies.
	protected double WIS;// enhances mana regen
	protected double alchemy = (int) (Math.random() * 5);
	protected double magicCasting = (int) (Math.random() * 5);
	protected double summoning = (int) (Math.random() * 5);// More available
															// summons
	protected double ECO; // More gold
	protected double barter = (int) (Math.random() * 5); // lower prices, higher
														// sell values.
	protected double investing = (int) (Math.random() * 5); // better shop
															// investment
															// returns.
	protected double appraisal = (int) (Math.random() * 5); // Allows you to
														// identify
															// artifacts.
	
	protected double END;// Improves base defense and health
	protected double VIT;// more health regen
	protected double magicTolerance = (int) (Math.random() * 5);// can cast more
																// spells
	protected double weaponSmithing = (int) (Math.random() * 5);
	protected double pugulism = (int) (Math.random() * 5);// hand to hand
	protected double DEF;// more flat defense
	protected double heavyArmor = (int) (Math.random() * 5);
	protected double firstAid = (int) (Math.random() * 5);// better healing on you
														// in general
	protected double survival = (int) (Math.random() * 5);// recipes n stuff
	protected double CON; // stamina regen
	protected double armorSmithing = (int) (Math.random() * 5);
	protected double hunting = (int) (Math.random() * 5); // deal more damage on
														// first hit
	protected double mining = (int) (Math.random() * 5); // slowly rev up to deal
														// more damage over long
														// fights

	protected double HPR;// health regen
	protected double MPR;// mana regen
	protected double MS;// manasteal
	protected double ARM;// armor
	protected double MR;// magic resistance
	protected double LS;// lifesteal
	protected double SS;// staminasteal
	protected double DC; // Dodge chance
	protected double CC; // Crit chance
	protected double STREG;// Stamina regeneration
	protected double SR;// Action podouble regeneration
	protected double SPP;// Action podouble pool
	protected double LSB;// Leader ship bonus
	protected double M;// Momentum, which is how much extra % damage you deal each
						// turn the battle continues.
	protected double FS;// first strike, a percentage of how much you will deal
						// extra the first turn.
	protected double ACC;// accuracy
	protected double ATT;// Attack
	protected double MATT;// MagicAttack

	protected ArrayList<move> moves = new ArrayList<move>();
	
	protected ArrayList<Double> currentStats = new ArrayList<Double>();

	public character(String inputText) {
		
		List<String> results = game.keywordTagSearch(inputText,
			(List<String>) Arrays.asList(new String[] { "name","level","experience","cruxrandom","sattelliterandom","skillrandom","strength","agility","speed","precision","intelligence","charisma","wisdom","economics","endurance","vitality","defense","constitution","smallarms","throwing","lightarmor","running","archery","swordfighting","largearms","aim","dodging","taming","speechcraft","leadership","alchemy","magiccasting","summoning","barter","investing","appraisal","magictolerance","weaponsmithing","pugulism","heavyarmor","firstaid","survival","armorsmithing","hunting","mining","job","image" }));
		
		name=results.get(0);
		level = Integer.parseInt(results.get(1));
		XP = Integer.parseInt(results.get(2));
		int cruxRandom =Integer.parseInt(results.get(3));
		int sattelliteRandom =Integer.parseInt(results.get(4));
		int skillRandom =Integer.parseInt(results.get(5));

		// dynamic values
		STR = Integer.parseInt(results.get(6))+ (int) (Math.random() * cruxRandom);
		AG = Integer.parseInt(results.get(7)) + (int) (Math.random() * sattelliteRandom);
		SP = Integer.parseInt(results.get(8)) + (int) (Math.random() * sattelliteRandom);
		PRE = Integer.parseInt(results.get(9)) + (int) (Math.random() * sattelliteRandom);
		INT = Integer.parseInt(results.get(10)) + (int) (Math.random() * cruxRandom);
		CHAR = Integer.parseInt(results.get(11)) + (int) (Math.random() * sattelliteRandom);
		WIS = Integer.parseInt(results.get(12)) + (int) (Math.random() * sattelliteRandom);
		ECO = Integer.parseInt(results.get(13)) + (int) (Math.random() * sattelliteRandom);
		END = Integer.parseInt(results.get(14)) + (int) (Math.random() * cruxRandom);
		VIT = Integer.parseInt(results.get(15)) + (int) (Math.random() * sattelliteRandom);
		DEF = Integer.parseInt(results.get(16)) + (int) (Math.random() * sattelliteRandom);
		CON = Integer.parseInt(results.get(17)) + (int) (Math.random() * sattelliteRandom);
		
		smallArms=Integer.parseInt(results.get(18)) + (int) (Math.random() * skillRandom);
		throwing=Integer.parseInt(results.get(19)) + (int) (Math.random() * skillRandom);
		lightArmor=Integer.parseInt(results.get(20)) + (int) (Math.random() * skillRandom);
		running=Integer.parseInt(results.get(21)) + (int) (Math.random() * skillRandom);
		archery=Integer.parseInt(results.get(22)) + (int) (Math.random() * skillRandom);
		swordfighting=Integer.parseInt(results.get(23)) + (int) (Math.random() * skillRandom);
		largeArms=Integer.parseInt(results.get(24)) + (int) (Math.random() * skillRandom);
		aim=Integer.parseInt(results.get(25)) + (int) (Math.random() * skillRandom);
		dodging=Integer.parseInt(results.get(26)) + (int) (Math.random() * skillRandom);
		taming=Integer.parseInt(results.get(27)) + (int) (Math.random() * skillRandom);
		speechcraft=Integer.parseInt(results.get(28)) + (int) (Math.random() * skillRandom);
		leadership=Integer.parseInt(results.get(29)) + (int) (Math.random() * skillRandom);
		alchemy=Integer.parseInt(results.get(30)) + (int) (Math.random() * skillRandom);
		magicCasting=Integer.parseInt(results.get(31)) + (int) (Math.random() * skillRandom);
		summoning=Integer.parseInt(results.get(32)) + (int) (Math.random() * skillRandom);
		barter=Integer.parseInt(results.get(33)) + (int) (Math.random() * skillRandom);
		investing=Integer.parseInt(results.get(34)) + (int) (Math.random() * skillRandom);
		appraisal=Integer.parseInt(results.get(35)) + (int) (Math.random() * skillRandom);
		magicTolerance=Integer.parseInt(results.get(36)) + (int) (Math.random() * skillRandom);
		weaponSmithing=Integer.parseInt(results.get(37)) + (int) (Math.random() * skillRandom);
		pugulism=Integer.parseInt(results.get(38)) + (int) (Math.random() * skillRandom);
		heavyArmor=Integer.parseInt(results.get(39)) + (int) (Math.random() * skillRandom);
		firstAid=Integer.parseInt(results.get(41)) + (int) (Math.random() * skillRandom);
		survival=Integer.parseInt(results.get(42)) + (int) (Math.random() * skillRandom);
		armorSmithing=Integer.parseInt(results.get(43)) + (int) (Math.random() * skillRandom);
		hunting=Integer.parseInt(results.get(44)) + (int) (Math.random() * skillRandom);
		mining=Integer.parseInt(results.get(45)) + (int) (Math.random() * skillRandom);
		
		selfy= new Image(results.get(46));
		
		// actual parametric determined by stats
		setATT(STR + 3);// base attack
		setMATT(INT + 3);// base magic attack
		LSB = (CHAR * 3 + leadership);// leadership bonus
		DC = 5 + (int) (AG / 2); // Dodge chance
		CC = 5 + (int) (PRE); // Crit chance
		STREG = 1 + (int) (CON / 2.5);// Stamina regeneration
		SR = 1 + (int) running / 6;// Action podouble regeneration
		SPP = 10 + SP;// Action podouble pool

		HPR = 1 + (int) (VIT / 2);
		MPR = 2 + (int) (WIS);
		ARM = 0 + DEF;
		MR = 0 + magicTolerance;
		LS = 0;
		MS = 0;
		SS = 0;
		ACC =100 + aim;
		M = (int) (mining / 5) + 1;
		FS = (int) (hunting * 2);

		HP = END * 10;
		MP = INT * 10;
		ST = STR * 10;

		currentStats.add(HP);
		currentStats.add(MP);
		currentStats.add(ST);

		currentStats.add(STR);
		currentStats.add(AG);
		currentStats.add(SP);
		currentStats.add(PRE);

		currentStats.add(INT);
		currentStats.add(CHAR);
		currentStats.add(WIS);
		currentStats.add(ECO);

		currentStats.add(END);
		currentStats.add(VIT);
		currentStats.add(DEF);
		currentStats.add(CON);

		currentStats.add(HPR);
		currentStats.add(MPR);
		currentStats.add(ARM);
		currentStats.add(MR);
		currentStats.add(LS);
		currentStats.add(MS);
		currentStats.add(SS);

		currentStats.add(DC);
		currentStats.add(CC);
		currentStats.add(STREG);
		currentStats.add(SR);
		currentStats.add(SPP);
		currentStats.add(M);
		currentStats.add(FS);
		currentStats.add(ACC);
		currentStats.add(LSB);
		currentStats.add(100.0);

		// add base moves
		final URL resource1 = getClass().getResource("hit.wav");
		move hit = new move("Hit", "attack", "", "pugulism", 8, 0, 10, 0, resource1);
		hit.setExplanation(
				" \"The most common form of hurting another person is probably just slinging your body into them however you can. This has been...common ever since multicellular creatures evolved, and quite possibly, long before that. \" \n \n ~Weiler Gox, The Body Horror. \n \n");
		this.addMove(hit);
		final URL resource = getClass().getResource("strike.wav");
		move strike = new move("Strike", "attack", "", "swordFighting", 18, 0, 15, 5, resource);
		strike.setExplanation(
				" \"Somehow it always seems to boil down to two men beating each other to death with something. A rock, a stick, a gun...the largest difference between now and then is how monstrous some men can become...\" \n \n ~Kelcio, Peacekeeper of the South.. \n \n");

		this.addMove(strike);
		final URL resource2 = getClass().getResource("badIntentions.wav");
		 move badIntentions = new move("Bad Intentions", "spell", "",
		 "magicCasting", 8, 0, 3, 15, resource2);
		 badIntentions.setExplanation(
		 " \"The most common form of hurting another person, hitting has been a common occurence ever since multicellular creatures evolved, and quite possibly, long before that.\" \n \n ~Weiler Gox, The BodyHorror. \n \n");

		this.addMove(badIntentions);
		final URL resource3 = getClass().getResource("psychicWarp.wav");
		move psychicWarp = new move("Psychic Warp", "spell", "", "magicCasting", 20, 2, 10, 40, resource3);
		psychicWarp.setExplanation(
				" \"The most common form of hurting anotherhe most common form of hurting another person, hitting has been a commhe most common form of hurting another person, hitting has been a commhe most common form of hurting another person, hitting has been a commhe most common form of hurting another person, hitting has been a commhe most common form of hurting another person, hitting has been a commhe most common form of hurting another person, hitting has been a commhe most common form of hurting another person, hitting has been a commhe most common form of hurting another person, hitting has been a comm person, hitting has been a common occurence ever since multicellular creatures evolved, and quite possibly, long before that.\" \n \n ~Weiler Gox, The Body Horror. \n \n");

		this.addMove(psychicWarp);

	}

	public void resetCurrentValues() {

		currentStats.set(0, HP);
		currentStats.set(1, MP);
		currentStats.set(2, ST);

		currentStats.set(3, STR);
		currentStats.set(4, AG);
		currentStats.set(5, SP);
		currentStats.set(6, PRE);

		currentStats.set(7, INT);
		currentStats.set(8, CHAR);
		currentStats.set(9, WIS);
		currentStats.set(10, ECO);

		currentStats.set(11, END);
		currentStats.set(12, VIT);
		currentStats.set(13, DEF);
		currentStats.set(14, CON);

		currentStats.set(15, HPR);
		currentStats.set(16, MPR);
		currentStats.set(17, ARM);
		currentStats.set(18, MR);
		currentStats.set(19, LS);
		currentStats.set(20, MS);
		currentStats.set(21, SS);

		currentStats.set(22, DC);
		currentStats.set(23, CC);
		currentStats.set(24, STREG);
		currentStats.set(25, SR);
		currentStats.set(26, SPP);
		currentStats.set(27, M);
		currentStats.set(28, FS);
		currentStats.set(29, ACC);
		currentStats.set(30, LSB);
		currentStats.set(31, XP);

	}
	public double cHealth() {
		return this.getCurrentStats().get(0);
	}

	public double ccHealth(double x) {
		return this.getCurrentStats().set(0, x);
	}

	public double cExperience() {
		return this.getCurrentStats().get(31);
	}

	public double ccExperience(double x) {
		return this.getCurrentStats().set(31, x);
	}

	public double cEssence() {
		return this.getCurrentStats().get(1);
	}

	public double ccEssence(double x) {
		return this.getCurrentStats().set(1, x);
	}

	public double cStamina() {
		return this.getCurrentStats().get(2);
	}

	public double ccStamina(double x) {
		return this.getCurrentStats().set(2, x);
	}

	public double cStrength() {
		return this.getCurrentStats().get(3);
	}

	public double ccStrength(double x) {
		return this.getCurrentStats().set(3, x);
	}

	public double cAgility() {
		return this.getCurrentStats().get(4);
	}

	public double ccAgility(double x) {
		return this.getCurrentStats().set(4, x);
	}

	public double cSpeed() {
		return this.getCurrentStats().get(5);
	}

	public double ccSpeed(double x) {
		return this.getCurrentStats().set(5, x);
	}

	public double cPrecision() {
		return this.getCurrentStats().get(6);
	}

	public double ccPrecision(double x) {
		return this.getCurrentStats().set(6, x);
	}

	public double cIntelligence() {
		return this.getCurrentStats().get(7);
	}

	public double ccIntelligence(double x) {
		return this.getCurrentStats().set(7, x);
	}

	public double cCharisma() {
		return this.getCurrentStats().get(8);
	}

	public double ccCharisma(double x) {
		return this.getCurrentStats().set(8, x);
	}

	public double cWisdom() {
		return this.getCurrentStats().get(9);
	}

	public double ccWisdom(double x) {
		return this.getCurrentStats().set(9, x);
	}

	public double cEconomics() {
		return this.getCurrentStats().get(10);
	}

	public double ccEconomics(double x) {
		return this.getCurrentStats().set(10, x);
	}

	public double cEndurance() {
		return this.getCurrentStats().get(11);
	}

	public double ccEndurance(double x) {
		return this.getCurrentStats().set(11, x);
	}

	public double cVitality() {
		return this.getCurrentStats().get(12);
	}

	public double ccVitality(double x) {
		return this.getCurrentStats().set(12, x);
	}

	public double cDefense() {
		return this.getCurrentStats().get(13);
	}

	public double ccDefense(double x) {
		return this.getCurrentStats().set(13, x);
	}

	public double cConstitution() {
		return this.getCurrentStats().get(14);
	}

	public double ccConstitution(double x) {
		return this.getCurrentStats().set(14, x);
	}

	public double cHealthRegen() {
		return this.getCurrentStats().get(15);
	}

	public double ccHealthRegen(double x) {
		return this.getCurrentStats().set(15, x);
	}

	public double cEssenceRegen() {
		return this.getCurrentStats().get(16);
	}

	public double ccEssenceRegen(double x) {
		return this.getCurrentStats().set(16, x);
	}

	public double cArmor() {
		return this.getCurrentStats().get(17);
	}

	public double ccArmor(double x) {
		return this.getCurrentStats().set(17, x);
	}

	public double cMagicResistance() {
		return this.getCurrentStats().get(18);
	}

	public double ccMagicResistance(double x) {
		return this.getCurrentStats().set(18, x);
	}

	public double cLifesteal() {
		return this.getCurrentStats().get(19);
	}

	public double ccLifesteal(double x) {
		return this.getCurrentStats().set(19, x);
	}

	public double cManasteal() {
		return this.getCurrentStats().get(20);
	}

	public double ccManasteal(double x) {
		return this.getCurrentStats().set(20, x);
	}

	public double cStaminaSteal() {
		return this.getCurrentStats().get(21);
	}

	public double ccStaminaSteal(double x) {
		return this.getCurrentStats().set(21, x);
	}

	public double cDodgeChance() {
		return this.getCurrentStats().get(22);
	}

	public double ccDodgeChance(double x) {
		return this.getCurrentStats().set(22, x);
	}

	public double cCritChance() {
		return this.getCurrentStats().get(23);
	}

	public double ccCritChance(double x) {
		return this.getCurrentStats().set(23, x);
	}

	public double cStaminaRegen() {
		return this.getCurrentStats().get(24);
	}

	public double ccStaminaRegen(double x) {
		return this.getCurrentStats().set(24, x);
	}

	public double cActionPointRegen() {
		return this.getCurrentStats().get(25);
	}

	public double ccActionPointRegen(double x) {
		return this.getCurrentStats().set(25, x);
	}

	public double cActionPointPool() {
		return this.getCurrentStats().get(26);
	}

	public double ccActionPointPool(double x) {
		return this.getCurrentStats().set(26, x);
	}

	public double cMomentum() {
		return this.getCurrentStats().get(27);
	}

	public double ccMomentum(double x) {
		return this.getCurrentStats().set(27, x);
	}

	public double cFirstStrike() {
		return this.getCurrentStats().get(28);
	}

	public double ccFirstStrike(double x) {
		return this.getCurrentStats().set(28, x);
	}

	public double cAccuracy() {
		return this.getCurrentStats().get(29);
	}

	public double ccAccuracy(double x) {
		return this.getCurrentStats().set(29, x);
	}

	public double cLeadingBonus() {
		return this.getCurrentStats().get(30);
	}

	public double ccLeadingBonus(double x) {
		return this.getCurrentStats().set(30, x);
	}
	/**
	 * <p>
	 * This method always returns immediately, whether or not the 
	 * image exists. When this applet attempts to draw the image on
	 * the screen, the data will be loaded. The graphics primitives 
	 * that draw the image will incrementally paint on the screen. 
	 *</p>
	 * @param  url  an absolute URL giving the base location of the image
	 * @param  name the location of the image, relative to the url argument
	 * @return      the image at the specified URL
	 * @see         Image
	 */
	public double fight(enemy enemy, move move, double turnNumber) {
		this.ccStamina(this.cStamina() - move.getStaminaCost());
		this.ccHealth(this.cHealth() - move.getHealthCost());
		this.ccEssence(this.cEssence() - move.getEssenceCost());
		double random = Math.random();
		double damage = 0;
		if (random > ((this.cAccuracy() - enemy.cDodgeChance()) / 100)) {
			this.recover();
			return 0.0;
		} else {
			if (move.getType().equals("attack")) {
				double defense = enemy.cDefense();
				if (turnNumber == 0) {
					damage = (int) (this.getATT() + move.getPower()) * (this.cFirstStrike() / 100 + 1);
					if (Math.random() < (this.cCritChance() / 100)) {
						if (damage * 2 > defense) {
							
							damage*=2;
							damage-=defense;
							enemy.ccHealth(enemy.cHealth() - damage);
						} else {
							// 1218058850
							damage=1;
							enemy.ccHealth(enemy.cHealth() - 1);
						}
					} else {
						if (damage > defense) {
							damage-=defense;
							enemy.ccHealth(enemy.cHealth() - damage);
						} else {
							damage=1;
							enemy.ccHealth(enemy.cHealth() - 1);
						}
					}
				} else {

					damage = (int) ((this.getATT() + move.getPower())
							* ((this.cMomentum() * turnNumber) / 100 + 1));
					if (Math.random() < (this.cCritChance() / 100)) {
						if (damage * 2 > defense) {
							damage*=2;
							damage-=defense;
							enemy.ccHealth(enemy.cHealth() - damage);
						} else {
							damage=1;
							enemy.ccHealth(enemy.cHealth() - 1);
						}
					} else if (damage - defense > 0) {
						
						damage-=defense;
						enemy.ccHealth(enemy.cHealth() - damage);
					} else {
						damage=1;
						enemy.ccHealth(enemy.cHealth() - 1);
					}
				}
			}
			if (move.getType().equals("spell")) {
				double defense = enemy.cMagicResistance();
				if (turnNumber == 0) {
					damage = (int) ((this.getMATT() + move.getPower()) * (this.cFirstStrike() / 100 + 1));
					if (Math.random() < (this.cCritChance() / 100)) {
						if (damage * 2 > defense) {
							damage*=2;
							damage=(damage-defense);
							enemy.ccHealth(enemy.cHealth() - damage);
						} else {
							damage=1;
							enemy.ccHealth(enemy.cHealth() - 1);
						}
					} else {
						if (damage > defense) {
							damage-=defense;
							enemy.ccHealth(enemy.cHealth() - damage);
						} else {
							damage=1;
							enemy.ccHealth(enemy.cHealth() - 1);
						}
					}
				} else {
					damage = (int) ((this.getMATT() + move.getPower())
							* (((this.cMomentum() * turnNumber) / 100 + 1)));

					if (Math.random() < (this.cCritChance() / 100)) {
						if (damage * 2 > defense) {
							damage*=2;
							damage=(damage-defense);
							enemy.ccHealth(enemy.cHealth() - damage);
						} else {
							damage=1;
							enemy.ccHealth(enemy.cHealth() - 1);
						}
					} else if (damage - defense > 0) {
						damage-=defense;
						enemy.ccHealth(enemy.cHealth() - damage);
					} else {
						damage=1;
						enemy.ccHealth(enemy.cHealth() - 1);
					}
				}
			}
		}
		this.recover();
		return damage;
	}

	//
	public void addMove(move move) {
		if (move.getSkill().equals("smallArms")) {
			move.setPower(move.getPower() * (this.smallArms / 100 + 1));
		} else if (move.getSkill().equals("throwing")) {
			move.setPower(move.getPower() * (this.throwing / 100 + 1));
		} else if (move.getSkill().equals("lightArmor")) {
			move.setPower(move.getPower() * (this.lightArmor / 100 + 1));
		}
		if (move.getSkill().equals("running")) {
			move.setPower(move.getPower() * (this.running / 100 + 1));
		} else if (move.getSkill().equals("archery")) {
			move.setPower(move.getPower() * (this.archery / 100 + 1));
		} else if (move.getSkill().equals("swordFighting")) {
			move.setPower(move.getPower() * (this.swordfighting / 100 + 1));
		}
		if (move.getSkill().equals("largeArms")) {
			move.setPower(move.getPower() * (this.largeArms / 100 + 1));
		} else if (move.getSkill().equals("aim")) {
			move.setPower(move.getPower() * (this.aim / 100 + 1));
		} else if (move.getSkill().equals("dodging")) {
			move.setPower(move.getPower() * (this.dodging / 100 + 1));
		} else if (move.getSkill().equals("taming")) {
			move.setPower(move.getPower() * (this.taming / 100 + 1));
		} else if (move.getSkill().equals("speechcraft")) {
			move.setPower(move.getPower() * (this.speechcraft / 100 + 1));
		} else if (move.getSkill().equals("leadership")) {
			move.setPower(move.getPower() * (this.leadership / 100 + 1));
		} else if (move.getSkill().equals("alchemy")) {
			move.setPower(move.getPower() * (this.alchemy / 100 + 1));
		} else if (move.getSkill().equals("magicCasting")) {
			move.setPower(move.getPower() * (this.magicCasting / 100 + 1));
		} else if (move.getSkill().equals("summoning")) {
			move.setPower(move.getPower() * (this.summoning / 100 + 1));
		} else if (move.getSkill().equals("barter")) {
			move.setPower(move.getPower() * (this.barter / 100 + 1));
		} else if (move.getSkill().equals("investing")) {
			move.setPower(move.getPower() * (this.investing / 100 + 1));
		} else if (move.getSkill().equals("appraisal")) {
			move.setPower(move.getPower() * (this.appraisal / 100 + 1));
		} else if (move.getSkill().equals("magicTolerance")) {
			move.setPower(move.getPower() * (this.magicTolerance / 100 + 1));
		} else if (move.getSkill().equals("weaponSmithing")) {
			move.setPower(move.getPower() * (this.weaponSmithing / 100 + 1));
		} else if (move.getSkill().equals("pugulism")) {
			move.setPower(move.getPower() * (this.pugulism / 100 + 1));
		} else if (move.getSkill().equals("heavyArmor")) {
			move.setPower(move.getPower() * (this.heavyArmor / 100 + 1));
		} else if (move.getSkill().equals("firstAid")) {
			move.setPower(move.getPower() * (this.firstAid / 100 + 1));
		} else if (move.getSkill().equals("survival")) {
			move.setPower(move.getPower() * (this.survival / 100 + 1));
		} else if (move.getSkill().equals("armorSmithing")) {
			move.setPower(move.getPower() * (this.armorSmithing / 100 + 1));
		} else if (move.getSkill().equals("hunting")) {
			move.setPower(move.getPower() * (this.hunting / 100 + 1));
		} else if (move.getSkill().equals("mining")) {
			move.setPower(move.getPower() * (this.mining / 100 + 1));
		}
		this.getMoves().add(move);
	}

	public void recover() {

		if ((this.cHealth() + this.cHealthRegen()) * (this.getRunning() / 50 + 1) < this.getHP()) {
			this.ccHealth(this.cHealth() + this.cHealthRegen() * (this.getRunning() / 50 + 1));
		}

		else {
			this.ccHealth(this.getHP());
		}

		if ((this.cStamina() + this.cStaminaRegen()) * (this.getRunning() / 50 + 1) < this.getST()) {
			this.ccStamina((this.cStamina() + this.cStaminaRegen()) * (this.getRunning() / 50 + 1));
		}

		else {
			this.ccStamina(this.getST());
		}

		if ((this.cEssence() + this.cEssenceRegen()) * (this.getRunning() / 50 + 1) < this.getMP()) {
			this.ccEssence((this.cEssence() + this.cEssenceRegen()) * (this.getRunning() / 50 + 1));
		}

		else {
			this.ccEssence(this.getMP());
		}

		if ((this.cActionPointPool() + this.cActionPointRegen()) * (this.getRunning() / 50 + 1) < this.getSPP()) {
			this.ccActionPointPool((this.cActionPointPool() + this.cActionPointRegen()) * (this.getRunning() / 50 + 1));
		}

		else {
			this.ccActionPointPool(this.getSPP());
		}

	}

	public void battleEnemy(character A) {

	}

	public void battlePerson(character A) {

	}

	public void addPerk(character A) {

	}

	public void setCurrentStats(ArrayList<Double> currentStats) {
		this.currentStats = currentStats;
	}

	public double getLevel() {
		return level;
	}

	public void setLevel(double level) {
		this.level = level;
	}

	public double getHP() {
		return HP;
	}

	public void setHP(double hP) {
		HP = hP;
	}

	public double getST() {
		return ST;
	}

	public void setST(double sT) {
		ST = sT;
	}

	public double getMP() {
		return MP;
	}

	public void setMP(double mP) {
		MP = mP;
	}

	public double getXP() {
		return XP;
	}

	public void setXP(double xP) {
		XP = xP;
	}

	public double getSTR() {
		return STR;
	}

	public void setSTR(double sTR) {
		STR = sTR;
	}

	public double getAG() {
		return AG;
	}

	public void setAG(double aG) {
		AG = aG;
	}

	public double getSS() {
		return SS;
	}

	public void setSS(double Ss) {
		SS = Ss;
	}

	public double getSmallArms() {
		return smallArms;
	}

	public void setSmallArms(double smallArms) {
		this.smallArms = smallArms;
	}

	public double getThrowing() {
		return throwing;
	}

	public void setThrowing(double throwing) {
		this.throwing = throwing;
	}

	public double getLightArmor() {
		return lightArmor;
	}

	public void setLightArmor(double lightArmor) {
		this.lightArmor = lightArmor;
	}

	public double getSP() {
		return SP;
	}

	public void setSP(double sP) {
		SP = sP;
	}

	public double getRunning() {
		return running;
	}

	public void setRunning(double running) {
		this.running = running;
	}

	public double getArchery() {
		return archery;
	}

	public void setArchery(double archery) {
		this.archery = archery;
	}

	public double getSwordfighting() {
		return swordfighting;
	}

	public void setSwordfighting(double swordfighting) {
		this.swordfighting = swordfighting;
	}

	public double getPRE() {
		return PRE;
	}

	public void setPRE(double bUR) {
		PRE = bUR;
	}

	public double getLargeArms() {
		return largeArms;
	}

	public void setLargeArms(double largeArms) {
		this.largeArms = largeArms;
	}

	public double getAim() {
		return aim;
	}

	public void setAim(double aim) {
		this.aim = aim;
	}

	public double getDodging() {
		return dodging;
	}

	public void setDodging(double dodging) {
		this.dodging = dodging;
	}

	public double getINT() {
		return INT;
	}

	public void setINT(double iNT) {
		INT = iNT;
	}

	public double getCHAR() {
		return CHAR;
	}

	public double getLSB() {
		return LSB;
	}

	public void setLSB(double lSB) {
		LSB = lSB;
	}

	public double getM() {
		return M;
	}

	public void setM(double m) {
		M = m;
	}

	public double getFS() {
		return FS;
	}

	public void setFS(double fS) {
		FS = fS;
	}

	public double getACC() {
		return ACC;
	}

	public void setACC(double aCC) {
		ACC = aCC;
	}

	public void setCHAR(double cHAR) {
		CHAR = cHAR;
	}

	public double getTaming() {
		return taming;
	}

	public void setTaming(double taming) {
		this.taming = taming;
	}

	public double getSpeechcraft() {
		return speechcraft;
	}

	public void setSpeechcraft(double speechcraft) {
		this.speechcraft = speechcraft;
	}

	public double getLeadership() {
		return leadership;
	}

	public void setLeadership(double leadership) {
		this.leadership = leadership;
	}

	public double getWIS() {
		return WIS;
	}

	public void setWIS(double wIS) {
		WIS = wIS;
	}

	public double getAlchemy() {
		return alchemy;
	}

	public void setAlchemy(double alchemy) {
		this.alchemy = alchemy;
	}

	public double getMagicCasting() {
		return magicCasting;
	}

	public void setMagicCasting(double magicCasting) {
		this.magicCasting = magicCasting;
	}

	public double getSummoning() {
		return summoning;
	}

	public void setSummoning(double summoning) {
		this.summoning = summoning;
	}

	public double getECO() {
		return ECO;
	}

	public void setECO(double eCO) {
		ECO = eCO;
	}

	public double getBarter() {
		return barter;
	}

	public void setBarter(double barter) {
		this.barter = barter;
	}

	public double getInvesting() {
		return investing;
	}

	public void setInvesting(double investing) {
		this.investing = investing;
	}

	public double getAppraisal() {
		return appraisal;
	}

	public void setAppraisal(double appraisal) {
		this.appraisal = appraisal;
	}

	public double getEND() {
		return END;
	}

	public void setEND(double eND) {
		END = eND;
	}

	public double getVIT() {
		return VIT;
	}

	public void setVIT(double vIT) {
		VIT = vIT;
	}

	public double getMagicTolerance() {
		return magicTolerance;
	}

	public void setMagicTolerance(double magicalTolerance) {
		this.magicTolerance = magicalTolerance;
	}

	public double getWeaponSmithing() {
		return weaponSmithing;
	}

	public void setWeaponSmithing(double weaponSmithing) {
		this.weaponSmithing = weaponSmithing;
	}

	public double getPugulism() {
		return pugulism;
	}

	public void setPugulism(double pugulism) {
		this.pugulism = pugulism;
	}

	public double getDEF() {
		return DEF;
	}

	public void setDEF(double dEF) {
		DEF = dEF;
	}

	public double getHeavyArmor() {
		return heavyArmor;
	}

	public void setHeavyArmor(double heavyArmor) {
		this.heavyArmor = heavyArmor;
	}

	public double getFirstAid() {
		return firstAid;
	}

	public void setFirstAid(double firstAid) {
		this.firstAid = firstAid;
	}

	public double getSurvival() {
		return survival;
	}
	
	public double getEXP(){
		return this.XP;
	}

	public void setSurvival(double survival) {
		this.survival = survival;
	}

	public double getCON() {
		return CON;
	}

	public void setCON(double cON) {
		CON = cON;
	}

	public double getArmorSmithing() {
		return armorSmithing;
	}

	public void setArmorSmithing(double armorSmithing) {
		this.armorSmithing = armorSmithing;
	}

	public double getHunting() {
		return hunting;
	}

	public void setHunting(double hunting) {
		this.hunting = hunting;
	}

	public double getMining() {
		return mining;
	}

	public void setMining(double mining) {
		this.mining = mining;
	}

	public double getMPR() {
		return MPR;
	}

	public void setMPR(double mPR) {
		MPR = mPR;
	}

	public double getMS() {
		return MS;
	}

	public void setMS(double mS) {
		MS = mS;
	}

	public double getARM() {
		return ARM;
	}

	public void setARM(double aRM) {
		ARM = aRM;
	}

	public double getMR() {
		return MR;
	}

	public void setMR(double mR) {
		MR = mR;
	}

	public double getLS() {
		return LS;
	}

	public void setLS(double lS) {
		LS = lS;
	}

	public double getHPR() {
		return HPR;
	}

	public void setHPR(double hPR) {
		HPR = hPR;
	}

	public double getDC() {
		return DC;
	}

	public void setDC(double dC) {
		DC = dC;
	}

	public double getCC() {
		return CC;
	}

	public void setCC(double cC) {
		CC = cC;
	}

	public double getSTREG() {
		return STREG;
	}

	public void setSTREG(double sTREG) {
		STREG = sTREG;
	}

	public double getSR() {
		return SR;
	}

	public void setSR(double aPR) {
		SR = aPR;
	}

	public double getSPP() {
		return SPP;
	}

	public void setSPP(double aPP) {
		SPP = aPP;
	}

	public ArrayList<Double> getCurrentStats() {
		return currentStats;
	}

	public double getATT() {
		return ATT;
	}

	public void setATT(double aTT) {
		ATT = aTT;
	}

	public double getMATT() {
		return MATT;
	}

	public void setMATT(double mATT) {
		MATT = mATT;
	}
	
	public ArrayList<move> getMoves() {
		return moves;
	}

	public void setMoves(ArrayList<move> moves) {
		this.moves = moves;
	}

	public void printHealth() {
		System.out.println(this.getCurrentStats().get(0));
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public void setName(String n) {
		// TODO Auto-generated method stub
		this.name = n;
	}

	// getters and setters
}
