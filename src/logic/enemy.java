package logic;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;

public class enemy implements Serializable {

	private static final long serialVersionUID = 1L;
	private double ID = Math.random();
	private String name = "stuff";
	private String lore;

	private double HP;// health
	private double ST;// stamina
	private double MP;// mana

	private double STR;// Improves base physical damage, and stamina
	private double AG;// improves dodge chance.
	private double SP;// regenerate action points faster
	private double PRE;// improves crit chance

	public double INT;// improves base magic damage, and mana.
	private double CHAR; // Improves allies damage and defense.
	private double WIS;// enhances mana regen
	private double ECO; // More gold

	private double END;// Improves base defense and health
	private double VIT;// more health regen
	private double DEF;// more flat defense
	private double CON; // stamina regen

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
	private double XP;// magic resistance

	public ArrayList<Double> getCurrentStats() {
		return currentStats;
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

	private ArrayList<Double> currentStats = new ArrayList<Double>();
	Boolean[] perkManager = new Boolean[20];
	private ArrayList<move> moves = new ArrayList<move>();

	// ideas : armor Penetration, magic penetration, poison.
	public enemy() {
		this.setName("Rat Goblin");
		final URL resource = getClass().getResource("strike.mp3");
		move hit = new move("Hit", "attack", "", "pugulism", 4, 0, 5, 0, resource);
		hit.setExplanation(
				" \"The most common form of hurting another person is probably just slinging your body into them however you can. This has been...common ever since multicellular creatures evolved, and quite possibly, long before that. \" \n \n ~Weiler Gox, The Body Horror. \n \n");
		this.addMove(hit);
		move strike = new move("Strike", "attack", "", "swordFighting", 12, 0, 10, 5, resource);
		strike.setExplanation(
				" \"Somehow it always seems to boil down to two men beating each other to death with something. A rock, a stick, a gun...the largest difference between now and then is how monstrous some men can become...\" \n \n ~Kelcio, Peacekeeper of the South.. \n \n");

		this.addMove(strike);

		move badIntentions = new move("Bad Intentions", "spell", "", "magicCasting", 8, 0, 3, 15, resource);
		badIntentions.setExplanation(
				" \"The most common form of hurting another person, hitting has been a common occurence ever since multicellular creatures evolved, and quite possibly, long before that.\" \n \n ~Weiler Gox, The Body Horror. \n \n");

		this.addMove(badIntentions);
		move psychicWarp = new move("Psychic Warp", "spell", "", "magicCasting", 20, 2, 10, 40, resource);
		psychicWarp.setExplanation(
				" \"The most common form of hurting anotherhe most common form of hurting another person, hitting has been a commhe most common form of hurting another person, hitting has been a commhe most common form of hurting another person, hitting has been a commhe most common form of hurting another person, hitting has been a commhe most common form of hurting another person, hitting has been a commhe most common form of hurting another person, hitting has been a commhe most common form of hurting another person, hitting has been a commhe most common form of hurting another person, hitting has been a comm person, hitting has been a common occurence ever since multicellular creatures evolved, and quite possibly, long before that.\" \n \n ~Weiler Gox, The Body Horror. \n \n");

		this.addMove(psychicWarp);
		// dynamic values
		STR = 7+(int)(Math.random()*3);
		AG = 5;
		SP = 5;
		PRE = 5;
		INT = 8;
		CHAR = 5;
		WIS = 5;
		ECO = 5;
		END = 8;
		VIT = 5;
		DEF = 5;
		CON = 5;

		// actual parametric determined by stats
		ATT = (STR + 5);// base attack
		MATT = (INT + 5);// base magic attack
		LSB = (CHAR * 2);// leadership bonus
		DC = 5 + (int) (AG / 2); // Dodge chance
		CC = 5 + (int) (PRE); // Crit chance
		STREG = 1 + (int) (CON / 2);// Stamina regeneration
		APR = 1;// Action podouble regeneration
		APP = 10 + SP;// Action podouble pool

		HPR = 1 + (int) (VIT / 2);
		MPR = 2 + (int) (WIS / 2);
		ARM = 0 + DEF;
		MR = 0;
		LS = 0;
		MS = 0;
		SS = 0;
		ACC = 50;
		M = 0;
		FS = 0;

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
		this.setLore(" Attack: "+this.ATT+"\n Magic Attack: "+this.getMATT()+"\n Defense: "+this.cDefense()+"\n Magic Defense: "+this.cMagicResistance());
		// static ones do not, they are the same for all classes
		XP = 10;
	}

	private void addMove(move hit) {
		this.moves.add(hit);

	}

	public double cHealth() {
		return this.getCurrentStats().get(0);
	}

	public double ccHealth(double x) {
		return this.getCurrentStats().set(0, x);
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
	public double cExperience() {
		return this.getEXP();
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

	public double getSP() {
		return SP;
	}

	public void setSP(double sP) {
		SP = sP;
	}

	public double getPRE() {
		return PRE;
	}

	public void setPRE(double pRE) {
		PRE = pRE;
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

	public void setCHAR(double cHAR) {
		CHAR = cHAR;
	}

	public double getWIS() {
		return WIS;
	}

	public void setWIS(double wIS) {
		WIS = wIS;
	}

	public double getECO() {
		return ECO;
	}

	public void setECO(double eCO) {
		ECO = eCO;
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

	public double getDEF() {
		return DEF;
	}

	public void setDEF(double dEF) {
		DEF = dEF;
	}

	public double getCON() {
		return CON;
	}

	public void setCON(double cON) {
		CON = cON;
	}

	public double getHPR() {
		return HPR;
	}

	public void setHPR(double hPR) {
		HPR = hPR;
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

	public double getSS() {
		return SS;
	}

	public void setSS(double sS) {
		SS = sS;
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

	public void printHealth() {
		System.out.println(this.getCurrentStats().get(0));
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
	public double getEXP() {
		return this.XP;
	}
	public void setAPP(double aPP) {
		APP = aPP;
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

	public double getXP() {
		return XP;
	}

	public void setXP(double xP) {
		XP = xP;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLore() {
		return this.lore;
		// TODO Auto-generated method stub
	}

	public void setLore(String lore) {
		this.lore = lore;
	}

	public double getID() {
		return ID;
	}

	public void setID(double iD) {
		ID = iD;
	}

	public double attack(ArrayList<character> allies, int allyNumber, int turnNumber) {

		int a = (int) Math.random() * allyNumber;
		move usedMove = this.getMoves().get(0);
		for (move move : this.getMoves()) {
			if (Math.random() < .25) {
				usedMove = move;
			}
		}
		return this.fight(allies.get(a), usedMove, turnNumber);
	}

	public double fight(character target, move move, double turnNumber) {

		this.ccStamina(this.cStamina() - move.getStaminaCost());
		this.ccHealth(this.cHealth() - move.getHealthCost());
		this.ccEssence(this.cEssence() - move.getEssenceCost());
		double random = Math.random();
		double damage = 0;
		if (random > ((this.cAccuracy() - target.cDodgeChance()) / 100)) {
			this.recover();
			return 0.0;
		} else {
			if (move.getType().equals("attack")) {
				double defense = target.cDefense();
				if (turnNumber == 0) {
					damage = (int) (this.getATT() + move.getPower()) * (this.cFirstStrike() / 100 + 1);
					if (Math.random() < (this.cCritChance() / 100)) {
						System.out.println("crit+first strike");
						if (damage * 2 > defense) {
							damage *= 2;
							damage -= defense;
							target.ccHealth(target.cHealth() - damage);
						} else {
							// 1218058850
							damage = 1;
							target.ccHealth(target.cHealth() - 1);
						}
					} else {
						System.out.println("first strike");
						if (damage > defense) {
							damage -= defense;
							target.ccHealth(target.cHealth() - damage);
						} else {
							damage = 1;
							target.ccHealth(target.cHealth() - 1);
						}
					}
				} else {

					damage = (int) ((this.getATT() + move.getPower()) * ((this.cMomentum() * turnNumber) / 100 + 1));
					if (Math.random() < (this.cCritChance() / 100)) {
						System.out.println("crit");
						if (damage * 2 > defense) {
							damage *= 2;
							damage -= defense;
							target.ccHealth(target.cHealth() - damage);
						} else {
							damage = 1;
							target.ccHealth(target.cHealth() - 1);
						}
					} else if (damage - defense > 0) {

						damage -= defense;
						target.ccHealth(target.cHealth() - damage);
					} else {
						damage = 1;
						target.ccHealth(target.cHealth() - 1);
					}
				}
			}
			if (move.getType().equals("spell")) {
				double defense = target.cMagicResistance();
				if (turnNumber == 0) {
					damage = (int) ((this.getMATT() + move.getPower()) * (this.cFirstStrike() / 100 + 1));
					if (Math.random() < (this.cCritChance() / 100)) {
						System.out.println("crit+first strike");
						if (damage * 2 > defense) {
							damage *= 2;
							damage = (damage - defense);
							target.ccHealth(target.cHealth() - damage);
						} else {
							damage = 1;
							target.ccHealth(target.cHealth() - 1);
						}
					} else {
						System.out.println("first strike");
						if (damage > defense) {
							damage -= defense;
							target.ccHealth(target.cHealth() - damage);
						} else {
							damage = 1;
							target.ccHealth(target.cHealth() - 1);
						}
					}
				} else {
					damage = (int) ((this.getMATT() + move.getPower()) * (((this.cMomentum() * turnNumber) / 100 + 1)));

					if (Math.random() < (this.cCritChance() / 100)) {
						System.out.println("crit");
						if (damage * 2 > defense) {
							damage *= 2;
							damage = (damage - defense);
							target.ccHealth(target.cHealth() - damage);
						} else {
							damage = 1;
							target.ccHealth(target.cHealth() - 1);
						}
					} else if (damage - defense > 0) {
						damage -= defense;
						target.ccHealth(target.cHealth() - damage);
					} else {
						damage = 1;
						target.ccHealth(target.cHealth() - 1);
					}
				}
			}
		}
		this.recover();
		return damage;
	}

	private void recover() {
		if ((this.cHealth() + this.cHealthRegen()) < this.getHP()) {
			this.ccHealth(this.cHealth() + this.cHealthRegen());
		}

		else {
			this.ccHealth(this.getHP());
		}

		if ((this.cStamina() + this.cStaminaRegen()) < this.getST()) {
			this.ccStamina((this.cStamina() + this.cStaminaRegen()));
		}

		else {
			this.ccStamina(this.getST());
		}

		if ((this.cEssence() + this.cEssenceRegen()) < this.getMP()) {
			this.ccEssence((this.cEssence() + this.cEssenceRegen()));
		}

		else {
			this.ccEssence(this.getMP());
		}

		if ((this.cActionPointPool() + this.cActionPointRegen()) < this.getAPP()) {
			this.ccActionPointPool((this.cActionPointPool() + this.cActionPointRegen()));
		}

		else {
			this.ccActionPointPool(this.getAPP());
		}

	}

	public ArrayList<move> getMoves() {
		return moves;
	}

	public void setMoves(ArrayList<move> moves) {
		this.moves = moves;
	}
}