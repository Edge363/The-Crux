/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;

public class character implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private double level;

	private double HP;// health
	private double ST;// stamina
	private double MP;// mana
	private double XP;// experience
	private String Location = "Dawngeil";// Used to identify where the player
											// is, and which scene they should
											// be brought back to.

	private double independence = 0;
	private double agressiveness = 0;
	private double empathy = 0;

	private double STR;// Improves base physical damage, and stamina
	private double AG;// improves dodge chance.
	private double smallArms = (int) (Math.random() * 5);
	private double throwing = (int) (Math.random() * 5);
	private double lightArmor = (int) (Math.random() * 5);
	private double SP;// determines if you or the enemy goes first
	private double running = (int) (Math.random() * 5);// increases the passive
														// recovery of all flat
														// regens.
	private double archery = (int) (Math.random() * 5);
	private double swordfighting = (int) (Math.random() * 5);
	private double PRE;// improves crit chance
	private double largeArms = (int) (Math.random() * 5);
	private double aim = (int) (Math.random() * 5);// Higher percentage to hit
	private double dodging = (int) (Math.random() * 5);// flat dodge chance
														// increase

	public double INT;// improves base magic damage, and mana.
	private double CHAR; // Improves allies damage and defense.
	private double taming = (int) (Math.random() * 5); // can tame better
														// creatures
	private double speechcraft = (int) (Math.random() * 5);// better dialogue
															// options
	private double leadership = (int) (Math.random() * 5);// can have more
															// allies.
	private double WIS;// enhances mana regen
	private double alchemy = (int) (Math.random() * 5);
	private double magicCasting = (int) (Math.random() * 5);
	private double summoning = (int) (Math.random() * 5);// More available
															// summons
	private double ECO; // More gold
	private double barter = (int) (Math.random() * 5); // lower prices, higher
														// sell values.
	private double investing = (int) (Math.random() * 5); // better shop
															// investment
															// returns.
	private double appraisal = (int) (Math.random() * 5); // Allows you to
															// identify
															// artifacts.

	private double END;// Improves base defense and health
	private double VIT;// more health regen
	private double magicTolerance = (int) (Math.random() * 5);// can cast more
																// spells
	private double weaponSmithing = (int) (Math.random() * 5);
	private double pugulism = (int) (Math.random() * 5);// hand to hand
	private double DEF;// more flat defense
	private double heavyArmor = (int) (Math.random() * 5);
	private double firstAid = (int) (Math.random() * 5);// better healing on you
														// in general
	private double survival = (int) (Math.random() * 5);// recipes n stuff
	private double CON; // stamina regen
	private double armorSmithing = (int) (Math.random() * 5);
	private double hunting = (int) (Math.random() * 5); // deal more damage on
														// first hit
	private double mining = (int) (Math.random() * 5); // slowly rev up to deal
														// more damage over long
														// fights

	private double HPR;// health regen
	private double MPR;// mana regen
	private double MS;// manasteal
	private double ARM;// armor
	private double MR;// magic resistance
	private double LS;// lifesteal
	private double SS;// staminasteal
	private double DC; // Dodge chance
	private double CC; // Crit chance
	private double STREG;// Stamina regeneration
	private double APR;// Action podouble regeneration
	private double APP;// Action podouble pool
	private double LSB;// Leader ship bonus
	private double M;// Momentum, which is how much extra % damage you deal each
						// turn the battle continues.
	private double FS;// first strike, a percentage of how much you will deal
						// extra the first turn.
	private double ACC;// accuracy
	private double ATT;// Attack
	private double MATT;// MagicAttack

	private ArrayList<move> moves = new ArrayList<move>();

	private double job = 5;// class, 6 different ones. 0-5.
	// 0= warlord, 1 = Arcanist, 2=capitalist, 3=Brute, 4=Assassin, 5=Jack of
	// all trades

	private ArrayList<Double> currentStats = new ArrayList<Double>();
	Boolean[] perkManager = new Boolean[20];

	// ideas : armor Penetration, magic penetration, poison.
	public character() {

		// dynamic values
		STR = 10 + (int) (Math.random() * 3);
		AG = 5 + (int) (Math.random() * 5);
		SP = 5 + (int) (Math.random() * 5);
		PRE = 5 + (int) (Math.random() * 5);
		INT = 10 + (int) (Math.random() * 3);
		CHAR = 5 + (int) (Math.random() * 5);
		WIS = 5 + (int) (Math.random() * 5);
		ECO = 5 + (int) (Math.random() * 5);
		END = 10 + (int) (Math.random() * 3);
		VIT = 5 + (int) (Math.random() * 5);
		DEF = 5 + (int) (Math.random() * 5);
		CON = 5 + (int) (Math.random() * 5);

		// actual parametric determined by stats
		setATT(STR + 3);// base attack
		setMATT(INT + 3);// base magic attack
		LSB = (CHAR * 3 + leadership);// leadership bonus
		DC = 5 + (int) (AG / 2); // Dodge chance
		CC = 5 + (int) (PRE); // Crit chance
		STREG = 1 + (int) (CON / 2.5);// Stamina regeneration
		APR = 1 + (int) running / 6;// Action podouble regeneration
		APP = 10 + SP;// Action podouble pool

		HPR = 1 + (int) (VIT / 2);
		MPR = 2 + (int) (WIS);
		ARM = 0 + DEF;
		MR = 0 + magicTolerance;
		LS = 0;
		MS = 0;
		SS = 0;
		ACC =80 + aim;
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
		currentStats.add(APR);
		currentStats.add(APP);
		currentStats.add(M);
		currentStats.add(FS);
		currentStats.add(ACC);
		currentStats.add(LSB);
		currentStats.add(0.0);

		// static ones do not, they are the same for all classes
		XP = 100;
		level = 1;
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
		currentStats.set(25, APR);
		currentStats.set(26, APP);
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
		System.out.println(turnNumber);
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
						System.out.println("crit+first strike");
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
						System.out.println("first strike");
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
						System.out.println("crit");
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
						System.out.println("crit+first strike");
						if (damage * 2 > defense) {
							damage*=2;
							damage=(damage-defense);
							enemy.ccHealth(enemy.cHealth() - damage);
						} else {
							damage=1;
							enemy.ccHealth(enemy.cHealth() - 1);
						}
					} else {
						System.out.println("first strike");
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
						System.out.println("crit");
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

		if ((this.cActionPointPool() + this.cActionPointRegen()) * (this.getRunning() / 50 + 1) < this.getAPP()) {
			this.ccActionPointPool((this.cActionPointPool() + this.cActionPointRegen()) * (this.getRunning() / 50 + 1));
		}

		else {
			this.ccActionPointPool(this.getAPP());
		}

	}

	public void levelUp(String cruxStat, String[] satteliteStats, String[] skills) {

		// this will raise all of the new stats based on a series of strings
		// indicating what to level up. This will all be done graphically of
		// course. Of course.
		this.level++;
		this.XP = (int) (Math.pow(this.level, 1.5) * (100 + this.level));

		if (cruxStat.equals("STR")) {
			this.STR++;
		} else if (cruxStat.equals("INT")) {
			this.INT++;
		} else if (cruxStat.equals("END")) {
			this.END++;
		}
		for (String stat : satteliteStats) {
			if (stat.equals("AG")) {
				this.AG++;
			} else if (stat.equals("SP")) {
				this.SP++;
			} else if (stat.equals("PRE")) {
				this.PRE++;
			} else if (stat.equals("CHAR")) {
				this.CHAR++;
			} else if (stat.equals("WIS")) {
				this.SP++;
			} else if (stat.equals("ECO")) {
				this.PRE++;
			} else if (stat.equals("VIT")) {
				this.AG++;
			} else if (stat.equals("DEF")) {
				this.SP++;
			} else if (stat.equals("CON")) {
				this.PRE++;
			}
		}

		for (String skill : skills) {

			this.skillIncrease(skill);

		}

		randomSkillIncrease(5);
		// leveling up for warlord
		if (this.job == 0) {
			for (double a = 0; a < 4; a++) {
				double skillDecider = (int) (Math.random() * 4);
				if (skillDecider == 0) {
					this.skillIncrease("lightArmor");
				} else if (skillDecider == 1) {
					this.skillIncrease("leaderShip");
				} else if (skillDecider == 2) {
					this.skillIncrease("aim");
				} else if (skillDecider == 3) {
					this.skillIncrease("weaponSmithing");
				}
			}
		}
		// arcanist
		if (this.job == 1) {
			for (double a = 0; a < 4; a++) {
				double skillDecider = (int) (Math.random() * 4);
				if (skillDecider == 0) {
					this.skillIncrease("magicCasting");
				} else if (skillDecider == 1) {
					this.skillIncrease("summoning");
				} else if (skillDecider == 2) {
					this.skillIncrease("aim");
				} else if (skillDecider == 3) {
					this.skillIncrease("magicTolerance");
				}
			}
		}
		// capitalist
		if (this.job == 2) {
			for (double a = 0; a < 4; a++) {
				double skillDecider = (int) (Math.random() * 4);
				if (skillDecider == 0) {
					this.skillIncrease("investing");
				} else if (skillDecider == 1) {
					this.skillIncrease("leaderShip");
				} else if (skillDecider == 2) {
					this.skillIncrease("speechcraft");
				} else if (skillDecider == 3) {
					this.skillIncrease("running");
				}
			}
		}
		// brute
		if (this.job == 3) {
			for (double a = 0; a < 4; a++) {
				double skillDecider = (int) (Math.random() * 4);
				if (skillDecider == 0) {
					this.skillIncrease("heavyArmor");
				} else if (skillDecider == 1) {
					this.skillIncrease("armorSmithing");
				} else if (skillDecider == 2) {
					this.skillIncrease("mining");
				} else if (skillDecider == 3) {
					this.skillIncrease("pugulism");
				}
			}
		}
		// Assassin
		if (this.job == 4) {
			for (double a = 0; a < 4; a++) {
				double skillDecider = (int) (Math.random() * 4);
				if (skillDecider == 0) {
					this.skillIncrease("swordfighting");
				} else if (skillDecider == 1) {
					this.skillIncrease("magicCasting");
				} else if (skillDecider == 2) {
					this.skillIncrease("hunting");
				} else if (skillDecider == 3) {
					this.skillIncrease("alchemy");
				}
			}
		}

		// jack
		if (this.job == 5) {
			this.randomSkillIncrease(7);
		} else {

		}
		// sets the new combat stat values based on new values given by the
		// level up.
		setATT(STR + 5);// base attack
		setMATT(INT + 5);// base magic attack
		LSB = (CHAR * 3 + leadership);// leadership bonus
		DC = 5 + (int) (AG / 2); // Dodge chance
		CC = 5 + (int) (PRE); // Crit chance
		STREG = 1 + (int) (CON / 2.5);// Stamina regeneration
		APR = 1 + (int) running / 6;// Action podouble regeneration
		APP = 10 + SP;// Action podouble pool

		HPR = 1 + (int) (VIT / 2);
		MPR = 2 + (int) (WIS / 2);
		ARM = 0 + DEF;
		MR = 0 + magicTolerance;
		LS = 0;
		MS = 0;
		SS = 0;
		ACC = 50 + aim;
		M = (int) (mining / 5) + 1;
		FS = (int) (hunting * 2);

		HP = END * 10;
		MP = INT * 10;
		ST = STR * 10;

		// Updates all of the moves based on new skill values.
		ArrayList<move> copy = this.getMoves();
		this.getMoves().clear();
		for (move move : copy) {
			this.addMove(move);
		}
	}

	public void skillIncrease(String skill) {
		if (skill.equals("smallArms")) {
			this.smallArms++;
		} else if (skill.equals("throwing")) {
			this.throwing++;
		} else if (skill.equals("lightArmor")) {
			this.lightArmor++;
		}
		if (skill.equals("running")) {
			this.running++;
		} else if (skill.equals("archery")) {
			this.archery++;
		} else if (skill.equals("swordfighting")) {
			this.swordfighting++;
		}
		if (skill.equals("largeArms")) {
			this.largeArms++;
		} else if (skill.equals("aim")) {
			this.aim++;
		} else if (skill.equals("dodging")) {
			this.dodging++;
		} else if (skill.equals("taming")) {
			this.taming++;
		} else if (skill.equals("speechcraft")) {
			this.speechcraft++;
		} else if (skill.equals("leadership")) {
			this.leadership++;
		} else if (skill.equals("alchemy")) {
			this.alchemy++;
		} else if (skill.equals("magicCasting")) {
			this.magicCasting++;
		} else if (skill.equals("summoning")) {
			this.summoning++;
		} else if (skill.equals("barter")) {
			this.barter++;
		} else if (skill.equals("investing")) {
			this.investing++;
		} else if (skill.equals("appraisal")) {
			this.appraisal++;
		} else if (skill.equals("magicTolerance")) {
			this.magicTolerance++;
		} else if (skill.equals("weaponSmithing")) {
			this.weaponSmithing++;
		} else if (skill.equals("pugulism")) {
			this.pugulism++;
		} else if (skill.equals("heavyArmor")) {
			this.heavyArmor++;
		} else if (skill.equals("firstAid")) {
			this.firstAid++;
		} else if (skill.equals("survival")) {
			this.survival++;
		} else if (skill.equals("armorSmithing")) {
			this.armorSmithing++;
		} else if (skill.equals("hunting")) {
			this.hunting++;
		} else if (skill.equals("mining")) {
			this.mining++;
		}
	}

	public void randomSkillIncrease(double a) {
		for (double x = 0; x < a; x++) {
			double skillDecider = (int) (Math.random() * 27);
			if (skillDecider == 0) {
				this.skillIncrease("smallArms");
			} else if (skillDecider == 1) {
				this.skillIncrease("throwing");
			} else if (skillDecider == 2) {
				this.skillIncrease("lightArmor");
			} else if (skillDecider == 3) {
				this.skillIncrease("running");
			} else if (skillDecider == 4) {
				this.skillIncrease("archery");
			} else if (skillDecider == 5) {
				this.skillIncrease("swordfighting");
			} else if (skillDecider == 6) {
				this.skillIncrease("largeArms");
			} else if (skillDecider == 7) {
				this.skillIncrease("aim");
			} else if (skillDecider == 8) {
				this.skillIncrease("dodging");
			} else if (skillDecider == 9) {
				this.skillIncrease("taming");
			} else if (skillDecider == 10) {
				this.skillIncrease("speechcraft");
			} else if (skillDecider == 11) {
				this.skillIncrease("leaderShip");
			} else if (skillDecider == 12) {
				this.skillIncrease("alchemy");
			} else if (skillDecider == 13) {
				this.skillIncrease("magicCasting");
			} else if (skillDecider == 14) {
				this.skillIncrease("summoning");
			} else if (skillDecider == 15) {
				this.skillIncrease("barter");
			} else if (skillDecider == 16) {
				this.skillIncrease("investing");
			} else if (skillDecider == 17) {
				this.skillIncrease("appraisal");
			} else if (skillDecider == 18) {
				this.skillIncrease("magicTolerance");
			} else if (skillDecider == 19) {
				this.skillIncrease("weaponSmithing");
			} else if (skillDecider == 20) {
				this.skillIncrease("pugulism");
			} else if (skillDecider == 21) {
				this.skillIncrease("heavyArmor");
			} else if (skillDecider == 22) {
				this.skillIncrease("firstAid");
			} else if (skillDecider == 23) {
				this.skillIncrease("survival");
			} else if (skillDecider == 24) {
				this.skillIncrease("armorSmithing");
			} else if (skillDecider == 25) {
				this.skillIncrease("hunting");
			} else if (skillDecider == 26) {
				this.skillIncrease("mining");
			}
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

	public Boolean[] getPerkManager() {
		return perkManager;
	}

	public void setPerkManager(Boolean[] perkManager) {
		this.perkManager = perkManager;
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

	public double getAPR() {
		return APR;
	}

	public void setAPR(double aPR) {
		APR = aPR;
	}

	public double getAPP() {
		return APP;
	}

	public void setAPP(double aPP) {
		APP = aPP;
	}

	public double getJob() {
		return job;
	}

	public void setJob(double job) {
		this.job = job;
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

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public double getIndependence() {
		return independence;
	}

	public void setIndependence(double independence) {
		this.independence = independence;
	}

	public double getAgressiveness() {
		return agressiveness;
	}

	public void setAgressiveness(double agressiveness) {
		this.agressiveness = agressiveness;
	}

	public double getEmpathy() {
		return empathy;
	}

	public void setEmpathy(double empathy) {
		this.empathy = empathy;
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
