

package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.SliderBuilder;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author William
 */

public class playerMenuController implements Initializable {

@FXML
private Button core;
@FXML
private Button sattelite;
@FXML
private Button skills;
@FXML
private ListView<String> list;
@FXML
private Slider healthBar;
@FXML
private Slider essenceBar;
@FXML
private Slider staminaBar;
@FXML
private Slider experienceBar;
@FXML
private Label healthRegeneration;
@FXML
private Label essenceRegeneration;
@FXML
private Label staminaRegeneration;
@FXML
private Label level;
@FXML
private Label lifesteal;
@FXML
private Label essencesteal;
@FXML
private Label staminasteal;
@FXML
private Label dodgeChance;
@FXML
private Label criticalChance;
@FXML
private Label momentum;
@FXML
private Label firstStrike;
@FXML
private Label damageResistance;
@FXML
private Label leadingBonus;
@FXML
private Label attack;
@FXML
private Label baseEssence;
@FXML
private Label Accuracy;
@FXML
private Label armor;
@FXML
private Label magicResistance;
@FXML
private Text explanation;
@FXML
private Text explanationTitle;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		healthBar.setMax(Main.MC.getHP());
		healthBar.setValue(Main.MC.getCurrentStats().get(0));
		essenceBar.setMax(Main.MC.getMP());
		essenceBar.setValue(Main.MC.getCurrentStats().get(1));
		staminaBar.setMax(Main.MC.getST());
		staminaBar.setValue(Main.MC.getCurrentStats().get(2));
		
		
	}
	
@FXML
public void loadCoreStats() {
	ObservableList<String> items =FXCollections.observableArrayList ("Strength "+Main.MC.getSTR(),"Intelligence "+Main.MC.getINT(),"Endurance "+Main.MC.getEND());
		list.setItems(items);
		InnerShadow satteliteShadow= new InnerShadow();
		satteliteShadow.setColor(Color.rgb(0,0,100));
		satteliteShadow.setWidth(50);
		satteliteShadow.setHeight(50);
		list.setEffect(satteliteShadow);
}

@FXML
public void loadSatteliteStats() {
	ObservableList<String> items =FXCollections.observableArrayList ("Agility "+Main.MC.getAG(),
			"Speed "+Main.MC.getSP(),
			"Precision "+Main.MC.getPRE(),
			"Charisma "+Main.MC.getCHAR(),
			"Wisdom "+Main.MC.getWIS(),
			"Economics "+Main.MC.getECO(),
			"Vitality "+Main.MC.getVIT(),
			"Defense "+Main.MC.getDEF(),
			"Constitution "+Main.MC.getCON());
		list.setItems(items);
		InnerShadow satteliteShadow= new InnerShadow();
		satteliteShadow.setColor(Color.rgb(0,100,0));
		satteliteShadow.setWidth(50);
		satteliteShadow.setHeight(50);
		list.setEffect(satteliteShadow);
}

@FXML
public void loadSkillsStats() {
	ObservableList<String> items =FXCollections.observableArrayList ("Small Arms "+Main.MC.getSmallArms(),
			"Throwing "+Main.MC.getThrowing(),
			"Light Armor "+Main.MC.getLightArmor(),
			"Running "+Main.MC.getRunning(),
			"Archery "+Main.MC.getArchery(),
			"Sword Fighting "+Main.MC.getSwordfighting(),
			"Large Arms "+Main.MC.getLargeArms(),
			"Aim "+Main.MC.getAim(),
			"Dodging "+Main.MC.getDodging(),
			"Taming "+Main.MC.getTaming(),
			"Speechcraft "+Main.MC.getSpeechcraft(),
			"Leadership "+Main.MC.getLeadership(),
			"Alchemy "+Main.MC.getAlchemy(),
			"Magic Casting "+Main.MC.getMagicCasting(),
			"summoning "+Main.MC.getSummoning(),
			"Barter "+Main.MC.getBarter(),
			"Investing "+Main.MC.getInvesting(),
			"Appraisal "+Main.MC.getAppraisal(),
			"Magic Tolerance "+Main.MC.getMagicTolerance(),
			"Weapon Smithing "+Main.MC.getWeaponSmithing(),
			"Pugulism "+Main.MC.getPugulism(),
			"Heavy Armor "+Main.MC.getHeavyArmor(),
			"First Aid "+Main.MC.getFirstAid(),
			"Survival "+Main.MC.getSurvival(),
			"Armor Smithing "+Main.MC.getArmorSmithing(),
			"Hunting "+Main.MC.getHunting(),
			"Mining "+Main.MC.getMining());
		list.setItems(items);
		InnerShadow satteliteShadow= new InnerShadow();
		satteliteShadow.setColor(Color.rgb(150,150,0));
		satteliteShadow.setWidth(50);
		satteliteShadow.setHeight(50);
		list.setEffect(satteliteShadow);
}
@FXML
public void getUp() throws IOException{
	if(Main.MC.getLocation().equals("Dawngeil")){
		Parent window1;
        window1 = FXMLLoader.load(getClass().getResource("dawngeilCenter.fxml"));
        Stage mainStage;
        mainStage = Main.parentWindow;
        Main.parentWindow.getScene().setRoot(window1);
	}
}

@FXML
public void loadListView(){
	String x =list.getSelectionModel().getSelectedItem();

	if(x.equals(("Small Arms "+Main.MC.getSmallArms()))){
		explanationTitle.setText("Small Arms");
		explanation.setText("Small arms will effect the base damage value of pistols, submachine guns, whips, and assault rifles. "
				+ "Throughout history these arms have become the predominant killing tools on the planet. Whether by fire or lead, the pistols and "
				+ "rifles of the world have killed droves of people. \n \n \"Luke the Fire herald only armed his men with pistols. I guess it makes sense, large enough to kill anyone, but tame in comparison to some of the horrors the badland's technicians can cook up.\" \n ~John Watson, Mayor #13F5 of Dawngeil. "
				);
	}
	else if(x.equals(("Throwing "+Main.MC.getThrowing()))){
		explanationTitle.setText("Throwing");
		explanation.setText("Throwing will effect the base damage of grenades, javelins, and most importantly, potions. Time and time again people have creatively invented better ways to hurt each other. The advent of ranged combat was an inevitability."
				+ "\n \n"
				+ " \"The ability for humans to throw is built into their very biology. Over time it has been used as all other forms of human biology have been used. To kill everything in sight, but mainly, each other.. \" \n ~Kolkon Darkreach, Religious Leader of the Great Spiders of Shallen.");
	}
	else if(x.equals(("Light Armor "+Main.MC.getLightArmor()))){
		explanationTitle.setText("Throwing");
		explanation.setText("Light armor directly impacts the base armor value of a variety of lightweight sets of armor. Many different varieties of light armor exist, but the best must be bought or forged.  \n \n"
				+ ""
				+ " \"Luckily, humanity has a long history of creating devices to prevent the further slaughter of themselves throughout the ages. Unluckily, most of them don't work all the time. I just wish they did! Nothing is better than more of them squirming through the city!\" \n ~Kill, the current mayor of Dawngeil.");
	}
	else if(x.equals(("Running "+Main.MC.getRunning()))){
		explanationTitle.setText("Running");
		explanation.setText("Running will improve the recovery of action points throughout long fights. It only adds an extra point of regeneration every six points. So upgrade it in chunks. \n \n \"They say we people can run farther than any land mammal. Too fucking bad their are so many giant lizards. \" \n ~Arnold Atlanta, famed wildlands survivalist.");
	}
	else if(x.equals(("Archery "+Main.MC.getArchery()))){
		explanationTitle.setText("Archery");
		explanation.setText("Archery directly impacts the base value of bows you use. They are long range, but can be an effective weapon even at closer ranges. Their greatest benefit is they use poisons many times better than other weapons, and receive a large boost to first strike bonuses. \n \n \"I always pictured 'Nile the Great' as a lot taller. This little goblin can't even stare a boy in the eyes, much less shoot a man between them. \n ~A man's last words.");
	}
	else if(x.equals(("Sword Fighting "+Main.MC.getSwordfighting()))){
		explanationTitle.setText("Sword Fighting");
		explanation.setText("The ability to use any bladed weapon. Even weapons that launch them. This skill is useful when combined with poisons, or spellcasting. \n \n \"They always said swords would fall out of fashion, but then they found out you can put more essence into more metal. Then they found out essence is more potent when used on something's...Insides. Bloody mess cleaning up afterwards though. \n ~Leo Saltack, Master of Smithing and Essence Weaving for Gauncreek University.");
	}
	else if(x.equals(("Large Arms "+Main.MC.getLargeArms()))){
		explanationTitle.setText("Large Arms");
		explanation.setText("Large Arms directly increases the damage done by bazookas, nuclear launchers, and many other varieties of munitions. Large arms can be an effective route for any person who can afford their cost and maintanence. \n \n \"Oh the joy one can feel from one button, one trigger, or one lever. You can feel a thousand souls being drained from their bodies, a thousand futures being brought to the importance of a single press of your finger.\" \n ~Shal'goanth, Dread Lord of the Southern lands.");
	}
	else if(x.equals(("Aim "+Main.MC.getAim()))){
		explanationTitle.setText("Aim");
		explanation.setText("Aim will dramatically impact a weapons ability to hit a target. This ability can cause your accuracy to flow well over 100%, causing a 'sureshot' effect, halving stamina and AP costs of ranged weapons. \n \n \"A thousand men, and they can't get past the one girl of Dunwich forest. A shot rings through the air, and another one falls. The ghost will not leave, it seems she will not forget the sins of our people for another millenia to come.\" \n  ~Tul Sin, General of the Arkmal army.");
	}
	else if(x.equals(("Dodging "+Main.MC.getDodging()))){
		explanationTitle.setText("Dodging");
		explanation.setText("Dodging will improve your dodge chance. This allows you to overcome peoples accuracy, or lack there of. \n \n \"The people of Arsicka knew how to dance with the wind. Bullets, fire...god's wrath could not touch them. Too bad nobody saw the Eldritch Invasion coming. Maybe they could have left with the wind, but dodging a wall of flesh is...well... \" \n ~Shil, The greatest historian.");
	}
	else if(x.equals(("Taming "+Main.MC.getTaming()))){
		explanationTitle.setText("Taming");
		explanation.setText("Taming allows you to more effectively use bought beasts. It also allows you to tame more wild ones. \n \n\"What a glorious day. Some say Keoth's young are the greatest scurge of humanity, I say if you pet and kiss them juuuust right... They'll hurt in the other direction...\" \n ~Arnold Atlanta, famed wildlands survivalist.");
	}
	else if(x.equals(("Speechcraft "+Main.MC.getSpeechcraft()))){
		explanationTitle.setText("Speechcraft");
		explanation.setText("Speechcraft will improve the quality of people you can adopt as teammates. This will almost certainly be critical for economic classes. \n \n \"They always tell me I won't be able to control them, twist them. I tell them time will turn all things to dust, and the air will always heave, and the sea will always row, and you...You will do exactly what I demand, because...I am.\" \n ~Sarthack, the Ghoul of Arlock's Cave.");
	}
	else if(x.equals(("Leadership "+Main.MC.getLeadership()))){
		explanationTitle.setText("Leadership");
		explanation.setText("Leadership improves your allies. Each point in leading bonus will improve their damage and hp by 1%. \n \n \"If not for all of our sacrifices our people would fall into despair! If not for all of our hardship our towns would burn, swallowed by evil so unknowable we cannot resist it's will, but we will. We must. We reject that fate, we will conquer death's door, and create a future even god denies us. \n ~Antiquus before the hoards of Eldritch, before ascending. ");
	}
	else if(x.equals(("Alchemy "+Main.MC.getAlchemy()))){
		explanationTitle.setText("Alchemy");
		explanation.setText("Alchemy will improve all potions and poisons you make dramatically. It's a great perk for most teams, but it can only affect one person at a time. \n \n \"Oh they all say that honey. They just haven't seen Atticus the strange do his work yet. He can make the dead rise, and the living boil in neon light. It makes me think about what you would look like in a particular shade of pale pink....\" \n ~Deloriah, the strange's assistant.");
	}
	else if(x.equals(("Magic Casting "+Main.MC.getMagicCasting()))){
		explanationTitle.setText("Magic Casting");
		explanation.setText("Magic casting improves all offensive based magic. It is the most important skill for new arcanists, and will improve the burst damage of any class. \n \n \"They tell me I can destroy the world, and even make a new one. The problem is they think that is all I can do. Small minds have small ideas I guess...\" \n ~La'fawm Do Gawnruth, the Black One. ");
	}
	else if(x.equals(("summoning "+Main.MC.getSummoning()))){
		explanationTitle.setText("Summoning");
		explanation.setText("Summoning will improve any summoned creatures health and damage by 1%. It can really beef up stronger summons in the long run. \n \n \"Oh Molly. Sweet Molly. Can you embrace me for another second before I let you go back? Damn, I guess even my dreams have a limit, but not...my horrors. \" \n ~Kin Faux, grand Necromancer of Dawngeil.");
	}
	else if(x.equals(("Barter "+Main.MC.getBarter()))){
		explanationTitle.setText("Barter");
		explanation.setText("Barter lowers the price of items you buy, and also increases the cost of things you sell. Each by 1% for each point in barter. \n \n \"Maybe life isn't hard, maybe you just gotta know how to chew the right way. Maybe...Haha, you want fancy words for how well I can fuck over someone else? Just trust me doll, I'm the best, and I'll handle it.\" \n ~Donald Bast, NewProne Industries Creator.");
	}
	else if(x.equals(("Investing "+Main.MC.getInvesting()))){
		explanationTitle.setText("Investing");
		explanation.setText("Investing will allow you to invest into certain bussinesses. Afterwards they will give you much better rates. This skill can be used for all kinds of services. \n \n \"Wise cracking mother fucker named Donald walked in yesterday looking for a partner for a bussiness proposition. Not a penny to his name, and I Woulda said no...but the man had a pretty grand plan. I'm not sure if even he understands how much this is going to change...everything. \" \n ~Walter Mintock, Co-Founder of NewProne Industries.");
	}
	else if(x.equals(("Appraisal "+Main.MC.getAppraisal()))){
		explanationTitle.setText("Appraisal");
		explanation.setText("Appraisal will allow you to identify artifacts. While the skill may sound bad at first, artifacts can make stretches of the game much easier. \n \n \"Fancy ey? Can't even tell what it does, but as long as you can feel the essence through it, you can use it. 'At right there is what seperates chumwater from the sharks in the appraising bussiness, boy.\" \n ~Jack Donovan, Scourge of the floating seas.");
	}
	else if(x.equals(("Magic Tolerance "+Main.MC.getMagicTolerance()))){
		explanationTitle.setText("Magic Tolerance");
		explanation.setText("Magic tolerance improves your magic resistance. This will allow you to cast more spells, and withstand more punishment. It more easily scales than armor from defense. \n \n \"Haha, as fancy as those sparks look. Daniel the Defiler's soldiers won't care. You gotta cut them, or poison them. Their glowing armada is immune to the usual 'Armageddon' tactics of arcanists...\" \n ~Shin Gon, lead librarian for Gauncreek University. ");
	}
	else if(x.equals(("Weapon Smithing "+Main.MC.getWeaponSmithing()))){
		explanationTitle.setText("Weapon Smithing");
		explanation.setText("Weapon smithing will dramatically improve the quality of any weapon you create. This effect can double down with gauntlets since they are both armor and a weapon. \n \n \"Think about how empty everybody would be without my guns. Instead, they are all packed tight with lead. The work here is my lifeblood, but nothing is quite as refreshing as pulling the trigger on a battlefield...\" \n ~David Tin, Daniel the Defiler's Armory keeper.");
	}
	else if(x.equals(("Pugulism "+Main.MC.getPugulism()))){
		explanationTitle.setText("Pugulism");
		explanation.setText("Pugulism will increase the base damage with your fists and your gauntlets. It is lower damage than many other disciplines, but it costs less resources to strike. You can also strike more times per turn with it. \n \n \"I hate it Jill. Each day another man dies diretly by my hands. Is it worth it? Is being the best something I should have rejected? \" \n ~Timothy, the collosal.");
	}
	else if(x.equals(("Heavy Armor "+Main.MC.getHeavyArmor()))){
		explanationTitle.setText("Heavy Armor");
		explanation.setText("Heavy armor directly impacts the base defensive value of a variety of armors. This skill will allow certain classes to shine later on in the game. \n \n \"Oh yes. My armies are invincible, but only because I lead them. A star that shines brighter than any crystal, or gem, I lead with voracity unmatched. The grand evils of this world will stand to be crushed beneath my heel, so I can stand above the gods even on earth. I will continue to do so for more millenia to come... \" \n ~Daniel the Defiler.");
	}
	else if(x.equals(("First Aid "+Main.MC.getFirstAid()))){
		explanationTitle.setText("First Aid");
		explanation.setText("All forms of healing are increased by first aid. It also more seriously impacts the healing rate of spells dedicated to allies. \n \n \"They can try, but we won't let them die. We fight for the life of a precious child, or a wounded ally.\" \n ~Creed of Galon Meadow, the healing village. ");
	}
	else if(x.equals(("Survival "+Main.MC.getSurvival()))){
		explanationTitle.setText("Survival");
		explanation.setText("Survival will give you a flat damage reduction. Each point is half a percent. \n \n \"The only thing certain in life is death, at least that's what I thought till I met Jack Donovan! The little scamp could take a beating like I didn't think was possible. \" \n ~Kill, the current mayor of Dawngeil.");
	}
	else if(x.equals(("Armor Smithing "+Main.MC.getArmorSmithing()))){
		explanationTitle.setText("Armor Smithing");
		explanation.setText("Armor smithing will greatly improve the quality of your produced armors. This skill can be a life savor for classes that need to be tanky mid and early game. \n \n \"I just wish it was possible. I've tried just about everything to pry it off of him, but it has no cracks! No seams. It's invincible otherwise, so how do I get it off? More importantly, how did he get it on...? \" \n ~Chronicles of Dawngeil, quoted by a scavenger after war #45f6a");
	}
	else if(x.equals(("Hunting "+Main.MC.getHunting()))){
		explanationTitle.setText("Hunting");
		explanation.setText("Hunting increases first strike. It improves the damage of the first strike of your match. Each point will add 1.5% more damage to your first hit. \n \n \"They say a war is won with time and patience, but not wars between men. It all comes down to one moment, one instance of time where the other man dies... or I do. That...That's what war is. \" \n ~Countersniper in Daniel the Defilers Elite regime.");
	}
	else if(x.equals(("Mining "+Main.MC.getMining()))){
		explanationTitle.setText("Mining");
		explanation.setText("Mining will increase momentum. It slowly stacks to a flat increase in damage over longer fights. Stacking limitlessly. It increases by a percent every 5 points. So upgrade it in chunks. \n \n \"There was nothing that could stop him now...With one strike he can fall an armada, with one wave of his hand...Atlas will fall another man... \" \n ~Shil, the greatest historian.");
	}
	else if(x.equals(("Strength "+Main.MC.getSTR()))){
		explanationTitle.setText("Strength");
		explanation.setText("Strength increases maximum stamina, and base damage. You only get one point for core points each level. Make them count...or else. \n \n \"I guess I agree sir, being the strongest is all that really matters. Sad a fact as it is, all the right in the world isn't going to do a damn. \" \n~Sir Thomas Reynolds, head knight of Daniel the Defiler. ");
	}
	else if(x.equals(("Intelligence "+Main.MC.getINT()))){
		explanationTitle.setText("Intelligence");
		explanation.setText("Intelligence is the ability to reason. It will increase your maximum essence, and your base magic damage multiplier. You only get one core point each level. Make it count..,or else. \n \n \"They call me insane! They call me weird, or bizare, but I know better. I know...Everything. \" \n ~Atticus the Strange");
	}
	else if(x.equals(("Endurance "+Main.MC.getEND()))){
		explanationTitle.setText("Endurance");
		explanation.setText("Endurance is your ability to take punishment. It will increase your total hp. There are many defense multipliers, so more hp can really come in handy during a pinch. You only get one core point each level. Make it count..,or else. \n \n \"Did you know that Dawngeil used to be the one of the worst places to live in the world? You know why so many people lived there anyway? It's the oldest city in the word, and notice how I said 'live' instead of 'die' earlier...\" \n~Shil, the greatest historian.");
	}
	else if(x.equals(("Agility "+Main.MC.getAG()))){
		explanationTitle.setText("Agility");
		explanation.setText("Agility is the ability for one to maneuver themselves. Agility will increase your dodge chance. \n \n \"Time will tell if the eldritch can be stopped. Your will, and more importantly, your legs will tell if you can avoid it. \" \n~Alda, leader of Arsicka.  ");
	}
	else if(x.equals(("Speed "+Main.MC.getSP()))){
		explanationTitle.setText("Speed");
		explanation.setText("Speed is how quickly one can move. Speed will improve the initial value of your action point pool. \n \n \"Sonic booms can be heard through the air, and only the bravest of men reveal their heads to the punishment to get a shot. Titans of immeasurable speed collide with air to create shockwaves as they fight. I thank the holy ghost and our god antiquus for delivering us. For saving the human race. \" \n ~A soldier's diary from the Eldritch invasion.");
	}
	else if(x.equals(("Precision "+Main.MC.getPRE()))){
		explanationTitle.setText("Precision");
		explanation.setText("Precision is the exactness of someone's motions. It will increase the critical chance of Cleave. \n \n \"Hahaha! I love it. I'd say one out of one thousand. That...That is how many can survive the other side of my scope, of my will. My only wish is they live enough for the other nine hundred and ninety nine, for the lost souls put against my vigor...my bloodlust. \" \n ~Fortenbras, Mankind's greatest weapon. ");
	}
	else if(x.equals(("Charisma "+Main.MC.getCHAR()))){
		explanationTitle.setText("Charisma");
		explanation.setText("Charisma is the ability to make people listen and follow you. It will greatly increase Cleave's allies strength. This stat can snowball given other stats help. \n \n \"For our people! For our nation...For everything we hold of value. Can you not feel it brothers? The love we all share.The life we all need. The love we all have flooding our very bodies when we fight the black hate. I love you all men, and we will all fight together, not for ourselves, but for all! For the people! For humanity! \" \n ~Gaddius Marlow, before the great fall of Tiblan.");
	}
	else if(x.equals(("Wisdom "+Main.MC.getWIS()))){
		explanationTitle.setText("Wisdom");
		explanation.setText("Wisdom is the ability to see a situation for how it is. Wisdom will increase your essence regeneration. \n \n \"Sight? You have no idea. The man can see through your soul, through the very essence of the world. I pity his enemies, and I worship his virtues. \" \n ~Truath, headmaster of Guancreek commenting on La'fawm Do Gawnruth");
	}
	else if(x.equals(("Economics "+Main.MC.getECO()))){
		explanationTitle.setText("Economics");
		explanation.setText("Economics has a large impact on an individual's ability to gather capital. Without it money will never reach the player in large patches. \n \n \"A sorry sight is the commmon man. He can't grow his own worth, but he can break his back. He can't make something, but he can lose it. I wish to be something else, something only the gods can write about in the deep blood of this small world. \" \n ~Donal Bast, creator of NewProne Industries.");
	}
	else if(x.equals(("Vitality "+Main.MC.getVIT()))){
		explanationTitle.setText("Vitality");
		explanation.setText("Vitality is the ability to recover after punishment. It will increase your health regen. This stat will be critical towards winning some fights later on for certain classes. \n \n \"No...How is he getting up? Is there no hope? Can he even be killed...Hurry, burn it to ashes before he...reforms from that husk.\" \n ~Til'Teath,Leader of the Great Spiders of Shallen, commenting on Arnold Atlantis.");
	}
	else if(x.equals(("Defense "+Main.MC.getDEF()))){
		explanationTitle.setText("Defense");
		explanation.setText("Defense is when something is resistant to damage. It will flatly lower physical damage towards your player. This stat is critical for a strong early game for certain builds. \n \n \"A wise man once told me small minds have small ideas. I can't understand that, but I can say without doubt that small bodies have thin bones. \" \n~Atlas the giant.");
	}
	else if(x.equals(("Constitution "+Main.MC.getCON()))){
		explanationTitle.setText("Constitution");
		explanation.setText("Constitution is the ability to remain at top condition despite punishment. It will increase the stamina regeneration of a character. \n \n \"I want...to be able to fight forever. Why stop? In this world the next great battle is just waiting for a captain to steer, a general to order...The only problem is how peaceful things have been lately... \" \n ~Quoted from 'The Fall of Humanity's Spear; Fortenbras.'");
	}
}
}
