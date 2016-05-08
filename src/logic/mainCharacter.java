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

public class mainCharacter extends character {
	private static final long serialVersionUID = 1L;
	
	private String location="Dawngeil";
	private double empathy=0;
	private double independence=0;
	private double agressiveness=0;
	private double job = 5;// class, 6 different ones. 0-5.
	// 0= warlord, 1 = Arcanist, 2=capitalist, 3=Brute, 4=Assassin, 5=Jack of
	// all trades
	
	Boolean[] perkManager = new Boolean[20];

	// ideas : armor Penetration, magic penetration, poison.
	public mainCharacter(String inputText) {
		
		super(inputText);
		List<String> results = game.keywordTagSearch(inputText,
		(List<String>) Arrays.asList(new String[]{ "job","empathy","independence","agressiveness" }));
		job=Integer.parseInt(results.get(0));
		empathy=Integer.parseInt(results.get(1));
		independence=Integer.parseInt(results.get(2));
		agressiveness=Integer.parseInt(results.get(3));

		// dynamic values
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
		SR = 1 + (int) running / 6;// Action podouble regeneration
		SPP = 10 + SP;// Action podouble pool
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
	public double getJob() {
		return job;
	}

	public void setJob(double job) {
		this.job = job;
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

	public Boolean[] getPerkManager() {
		return perkManager;
	}

	public void setPerkManager(Boolean[] perkManager) {
		this.perkManager = perkManager;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

}