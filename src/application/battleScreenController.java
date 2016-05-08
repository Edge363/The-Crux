package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.SliderBuilder;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logic.character;
import logic.enemy;
import logic.move;

/**
 *
 * @author William
 */
public class battleScreenController implements Initializable {

	@FXML
	TabPane tabPane;
	@FXML
	private Button attacks, attacks1, attacks2, attacks3, attacks4;
	@FXML
	private Button moveName, moveName1, moveName2, moveName3, moveName4;
	@FXML
	private Button skip, skip1, skip2, skip3, skip4;
	@FXML
	private Button spells, spells1, spells2, spells3, spells4;
	@FXML
	private Button items, items1, items2, items3, items4;
	@FXML
	private ListView<String> list, list1, list2, list3, list4;
	@FXML
	private ListView<String> enemyList, enemyList1, enemyList2, enemyList3, enemyList4;
	@FXML
	private Slider healthBar, allyHealthBar1, allyHealthBar2, allyHealthBar3, allyHealthBar4, enemyHealthBar1,
			enemyHealthBar2, enemyHealthBar3, enemyHealthBar4, enemyHealthBar5;
	@FXML
	private Slider essenceBar, allyEssenceBar1, allyEssenceBar2, allyEssenceBar3, allyEssenceBar4, enemyEssenceBar1,
			enemyEssenceBar2, enemyEssenceBar3, enemyEssenceBar4, enemyEssenceBar5;
	@FXML
	private Slider staminaBar, allyStaminaBar1, allyStaminaBar2, allyStaminaBar3, allyStaminaBar4, enemyStaminaBar1,
			enemyStaminaBar2, enemyStaminaBar3, enemyStaminaBar4, enemyStaminaBar5;
	@FXML
	private Text explanation, explanation1, explanation2, explanation3, explanation4;
	@FXML
	private Label explanationTitle, explanationTitle1, explanationTitle2, explanationTitle3, explanationTitle4;
	@FXML
	private Label enemyName, enemyName1, enemyName2, enemyName3, enemyName4;
	@FXML
	private Text enemyLore, enemyLore1, enemyLore2, enemyLore3, enemyLore4;
	@FXML
	private Tab enemyOne, enemyTwo, enemyThree, enemyFour, enemyFive;
	@FXML
	private Tab allyOne, allyTwo, allyThree;
	@FXML
	private MediaView sound;
	@FXML
	private ImageView cleavePicture;
	@FXML
	private ImageView enemyImage;
	@FXML
	private Text battleLog;
	@FXML
	private ScrollPane battleLogScroll;
	@FXML
	private MediaView sound2;
	private double turnNumber = 0;
	private int enemyNumber = 0;
	private int allyNumber = 0;
	final URL resource = getClass().getResource("reload.wav");
	final URL buttonPress = getClass().getResource("button.wav");
	final URL tabSwap = getClass().getResource("tabSwap.wav");
	final URL listSwap = getClass().getResource("listSwap.wav");
	Media media = new Media(resource.toString());
	MediaPlayer mediaPlayer = new MediaPlayer(media);
	MediaView mediaView = new MediaView(mediaPlayer);

	private ArrayList<Tab> tabs = new ArrayList<Tab>();

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		System.out.println(Main.MC.cExperience());
		System.out.println(Main.MC.getEXP());		
		Rectangle clip = new Rectangle(200, 200);
		clip.setArcWidth(20);
		clip.setArcHeight(20);
		cleavePicture.setClip(clip);

		// snapshot the rounded image.
		SnapshotParameters parameters = new SnapshotParameters();
		parameters.setFill(Color.TRANSPARENT);
		WritableImage image = cleavePicture.snapshot(parameters, null);

		// remove the rounding clip so that our effect can show through.
		cleavePicture.setClip(null);

		// store the rounded image in the cleavePicture.
		cleavePicture.setImage(image);

		enemyImage.setClip(clip);

		// snapshot the rounded image.

		parameters.setFill(Color.TRANSPARENT);
		image = enemyImage.snapshot(parameters, null);

		// remove the rounding clip so that our effect can show through.
		enemyImage.setClip(null);

		// store the rounded image in the enemyImage.
		enemyImage.setImage(image);
		try {
			setUp();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initializeAllies();
		tabs.add(allyOne);
		tabs.add(allyTwo);
		tabs.add(allyThree);
		
		
		
		for (enemy enemy : Main.battle.getEnemies()) {
			enemyNumber++;
		}
		for (character stuff : Main.battle.getAllies()) {
			allyNumber++;
		}
	}

	public void setUp() throws IOException {
		System.out.println(Main.MC.cExperience());
		System.out.println(Main.MC.getEXP());
		if (Main.MC.cHealth() < 0) {
			Parent window1;
			window1 = FXMLLoader.load(getClass().getResource("gameOver.fxml"));
			Stage mainStage;
			mainStage = Main.parentWindow;
			Main.parentWindow.getScene().setRoot(window1);
			Main.parentWindow.getScene().getStylesheets()
					.add(Main.class.getResource("application.css").toExternalForm());
		}
		healthBar.setMax(Main.MC.getHP());
		healthBar.setValue(Main.MC.cHealth());
		essenceBar.setMax(Main.MC.getMP());
		essenceBar.setValue(Main.MC.cEssence());
		staminaBar.setMax(Main.MC.getST());
		staminaBar.setValue(Main.MC.cStamina());
		int disabledNumber = 0;
		for (Tab tab : tabs) {
			if (tab.isDisabled()) {
				disabledNumber++;
			}
		}
		if (disabledNumber == 3) {
			turnNumber++;
			for (enemy enemy : Main.battle.getEnemies()) {
				double hit =enemy.attack(Main.battle.getAllies(), allyNumber, (int) turnNumber);
				if(hit>0.0){
				battleLog.setText(battleLog.getText()+"\n \n"+enemy.getName()+" dealt "+hit+" damage to "+Main.battle.getAllies().get(allyNumber-1).getName());
				}
				else{
					battleLog.setText(battleLog.getText()+"\n \n"+enemy.getName()+" missed while trying to hit "+Main.battle.getAllies().get(allyNumber-1).getName());
				}
			}

			for (Tab tab : tabs) {
				if (tab.getText().equals("empty") == false) {
					tab.setDisable(false);
				}
			}

			Media media = new Media(resource.toString());
			MediaPlayer mediaPlayer = new MediaPlayer(media);
			mediaPlayer.setAutoPlay(true);
			MediaView mediaView = new MediaView(mediaPlayer);
			sound = mediaView;

		}
		setUpAllies();
		setUpEnemies();
		if (Main.battle.getEnemies().isEmpty()) {
			
			Parent window1;
			window1 = FXMLLoader.load(getClass().getResource("wonBattle.fxml"));
			Stage mainStage;
			mainStage = Main.parentWindow;
			Main.parentWindow.getScene().setRoot(window1);
		}
		ObservableList<String> items = FXCollections.observableArrayList();

		for (enemy enemy : Main.battle.getEnemies()) {
			items.add(enemy.getName());
		}
		enemyList.setItems(items);
		battleLogScroll.setVvalue(1.0);
	}

	public void setUpAllies() {

		int y = 0;
		for (character ally : Main.battle.getAllies()) {
			if (y == 1) {

				allyTwo.setText(ally.getName());
				allyHealthBar1.setMax(ally.getHP());
				allyHealthBar1.setValue(ally.cHealth());
				allyEssenceBar1.setMax(ally.getMP());
				allyEssenceBar1.setValue(ally.cEssence());
				allyStaminaBar1.setMax(ally.getST());
				allyStaminaBar1.setValue(ally.cStamina());
				ObservableList<String> items = FXCollections.observableArrayList();
				if (Main.battle.getAllies().get(1).cHealth() < 0) {
					allyTwo.setText("Incapacitated");
					allyTwo.setDisable(true);
				}
				for (enemy enemy : Main.battle.getEnemies()) {
					items.add(enemy.getName());
				}
				enemyList1.setItems(items);

			} else if (y == 2) {
				allyThree.setText(ally.getName());
				allyHealthBar2.setMax(ally.getHP());
				allyHealthBar2.setValue(ally.cHealth());
				allyEssenceBar2.setMax(ally.getMP());
				allyEssenceBar2.setValue(ally.cEssence());
				allyStaminaBar2.setMax(ally.getST());
				allyStaminaBar2.setValue(ally.cStamina());
				ObservableList<String> items = FXCollections.observableArrayList();
				if (Main.battle.getAllies().get(2).cHealth() < 0) {
					allyThree.setText("Incapacitated");
					allyThree.setDisable(true);
				}
				for (enemy enemy : Main.battle.getEnemies()) {
					items.add(enemy.getName());
				}
				enemyList2.setItems(items);
			} 
			y++;
		}
	}

	public void initializeAllies() {
		int y = 0;
		for (character ally : Main.battle.getAllies()) {
			if (y == 1) {
				allyTwo.setDisable(false);
			} else if (y == 2) {
				allyThree.setDisable(false);
			} 
			y++;
		}
	}
	public void setUpEnemies() {
		int y = 0;
		for (enemy enemy : Main.battle.getEnemies()) {
			if (y == 0) {

				enemyOne.setText(enemy.getName());
				enemyHealthBar1.setMax(enemy.getHP());
				enemyHealthBar1.setValue(enemy.cHealth());
				enemyEssenceBar1.setMax(enemy.getMP());
				enemyEssenceBar1.setValue(enemy.cEssence());
				enemyStaminaBar1.setMax(enemy.getST());
				enemyStaminaBar1.setValue(enemy.cStamina());
				enemyName.setText(enemy.getName());
				enemyLore.setText(enemy.getLore());
				enemyOne.setDisable(false);
			} else if (y == 1) {

				enemyTwo.setText(enemy.getName());
				enemyHealthBar2.setMax(enemy.getHP());
				enemyHealthBar2.setValue(enemy.cHealth());
				enemyEssenceBar2.setMax(enemy.getMP());
				enemyEssenceBar2.setValue(enemy.cEssence());
				enemyStaminaBar2.setMax(enemy.getST());
				enemyStaminaBar2.setValue(enemy.cStamina());
				enemyName1.setText(enemy.getName());
				enemyLore1.setText(enemy.getLore());
				enemyTwo.setDisable(false);
			} else if (y == 2) {

				enemyThree.setText(enemy.getName());
				enemyHealthBar3.setMax(enemy.getHP());
				enemyHealthBar3.setValue(enemy.cHealth());
				enemyEssenceBar3.setMax(enemy.getMP());
				enemyEssenceBar3.setValue(enemy.cEssence());
				enemyStaminaBar3.setMax(enemy.getST());
				enemyStaminaBar3.setValue(enemy.cStamina());
				enemyName2.setText(enemy.getName());
				enemyLore2.setText(enemy.getLore());
				enemyThree.setDisable(false);
			} else if (y == 3) {
				enemyFour.setText(enemy.getName());
				enemyHealthBar4.setMax(enemy.getHP());
				enemyHealthBar4.setValue(enemy.cHealth());
				enemyEssenceBar4.setMax(enemy.getMP());
				enemyEssenceBar4.setValue(enemy.cEssence());
				enemyStaminaBar4.setMax(enemy.getST());
				enemyStaminaBar4.setValue(enemy.cStamina());
				enemyName3.setText(enemy.getName());
				enemyLore3.setText(enemy.getLore());
				enemyFour.setDisable(false);
			} else if (y == 4) {
				enemyFive.setText(enemy.getName());
				enemyHealthBar5.setMax(enemy.getHP());
				enemyHealthBar5.setValue(enemy.cHealth());
				enemyEssenceBar5.setMax(enemy.getMP());
				enemyEssenceBar5.setValue(enemy.cEssence());
				enemyStaminaBar5.setMax(enemy.getST());
				enemyStaminaBar5.setValue(enemy.cStamina());
				enemyName4.setText(enemy.getName());
				enemyLore4.setText(enemy.getLore());
				enemyFive.setDisable(false);
			}
			y++;
		}
	}

	@FXML
	public void attack() throws IOException {

		if (enemyList.getSelectionModel().getSelectedItem() != null
				&& list.getSelectionModel().getSelectedItem() != null) {

			move usedMove = Main.MC.getMoves().get(0);
			for (move move : Main.MC.getMoves()) {
				if (move.getName().equals(list.getSelectionModel().getSelectedItem())) {
					usedMove = move;
				}
			}

			if (usedMove.getEssenceCost() < Main.MC.cEssence() && usedMove.getStaminaCost() < Main.MC.cStamina()
					&& usedMove.getHealthCost() <= Main.MC.cHealth()) {

				int x = 0;
				for (enemy enemy : Main.battle.getEnemies()) {
					if (enemy.getName().equals(enemyList.getSelectionModel().getSelectedItem())) {
						double hit = Main.MC.fight(Main.battle.getEnemies().get(x), usedMove, turnNumber);
						if (hit>0.0) {
							Media media = new Media(usedMove.getSoundEffect());
							MediaPlayer mediaPlayer = new MediaPlayer(media);
							mediaPlayer.setAutoPlay(true);
							MediaView mediaView = new MediaView(mediaPlayer);
							sound = mediaView;
							battleLog.setText(battleLog.getText()+"\n \n"+"Cleave hit for "+hit+"");
						} else {
							Media media = new Media(getClass().getResource("miss.wav").toString());
							MediaPlayer mediaPlayer = new MediaPlayer(media);
							mediaPlayer.setAutoPlay(true);
							MediaView mediaView = new MediaView(mediaPlayer);
							sound = mediaView;
							battleLog.setText(battleLog.getText()+"\n \n"+"Cleave missed his attack!");
						}
						if (Main.battle.getEnemies().get(x).cHealth() <= 0) {
							Main.MC.ccExperience(Main.MC.cExperience()-Main.battle.getEnemies().get(x).cExperience());
							for (character stuff : Main.battle.getAllies()) {
								stuff.ccExperience(stuff.cExperience()-(Main.battle.getEnemies().get(x).cExperience()));
							}
							
							Main.battle.getEnemies().remove(x);

							switch (enemyNumber) {

							case 1:
								
								enemyOne.setDisable(true);
								enemyOne.setText("empty");
								break;
							case 2:

								enemyTwo.setDisable(true);
								enemyTwo.setText("empty");
								break;
							case 3:

								enemyThree.setDisable(true);
								enemyThree.setText("empty");
								break;
							case 4:

								enemyFour.setDisable(true);
								enemyFour.setText("empty");
								break;
							case 5:

								enemyFive.setDisable(true);
								enemyFive.setText("empty");
								break;
							}
							enemyNumber--;
						}
						break;
					}
					x++;
				}
				allyOne.setDisable(true);
			} else {
				explanation.setText("You don't have enough resources to use that move! \n \n Try another one. \n \n ");
			}
		}
		setUp();

	}

	@FXML
	public void attack1() throws IOException {

		if (enemyList1.getSelectionModel().getSelectedItem() != null
				&& list1.getSelectionModel().getSelectedItem() != null) {

			move usedMove = Main.battle.getAllies().get(1).getMoves().get(0);
			for (move move : Main.battle.getAllies().get(1).getMoves()) {
				if (move.getName().equals(list1.getSelectionModel().getSelectedItem())) {
					usedMove = move;
				}
			}
			if (usedMove.getEssenceCost() < Main.battle.getAllies().get(1).cEssence()
					&& usedMove.getStaminaCost() < Main.battle.getAllies().get(1).cStamina()
					&& usedMove.getHealthCost() <= Main.battle.getAllies().get(1).cHealth()) {
				int x = 0;
				for (enemy enemy : Main.battle.getEnemies()) {
					if (enemy.getName().equals(enemyList1.getSelectionModel().getSelectedItem())) {
						double hit = Main.battle.getAllies().get(1).fight(Main.battle.getEnemies().get(x), usedMove,
								turnNumber);
						if (hit>0.0) {
							Media media = new Media(usedMove.getSoundEffect());
							MediaPlayer mediaPlayer = new MediaPlayer(media);
							mediaPlayer.setAutoPlay(true);
							MediaView mediaView = new MediaView(mediaPlayer);
							sound = mediaView;
							battleLog.setText(battleLog.getText()+"\n \n"+Main.battle.getAllies().get(1).getName()+" hit for "+hit+"");
						} else {
							Media media = new Media(getClass().getResource("miss.wav").toString());
							MediaPlayer mediaPlayer = new MediaPlayer(media);
							mediaPlayer.setAutoPlay(true);
							MediaView mediaView = new MediaView(mediaPlayer);
							sound = mediaView;
							battleLog.setText(battleLog.getText()+"\n \n"+Main.battle.getAllies().get(1).getName()+" missed his attack!");

						}
						if (Main.battle.getEnemies().get(x).cHealth() <= 0) {
							Main.battle.getEnemies().remove(x);
							switch (enemyNumber) {

							case 1:
								enemyOne.setDisable(true);
								enemyOne.setText("empty");

								break;
							case 2:

								enemyTwo.setDisable(true);
								enemyTwo.setText("empty");
								break;
							case 3:

								enemyThree.setDisable(true);
								enemyThree.setText("empty");
								break;
							case 4:

								enemyFour.setDisable(true);
								enemyFour.setText("empty");
								break;
							case 5:

								enemyFive.setDisable(true);
								enemyFive.setText("empty");
								break;
							}
							enemyNumber--;
						}
						break;
					}
					x++;
				}
				allyTwo.setDisable(true);
			}
		}
		setUp();

	}

	@FXML
	public void attack2() {

	}

	@FXML
	public void loadAttacks() {
		ObservableList<String> items = FXCollections.observableArrayList();
		for (move move : Main.MC.getMoves()) {
			if (move.getType().equals("attack")) {
				items.add(move.getName());
			}
		}
		list.setItems(items);

		Media media = new Media(buttonPress.toString());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);
		MediaView mediaView = new MediaView(mediaPlayer);
		sound = mediaView;
	}

	@FXML
	public void loadAttacks1() {
		ObservableList<String> items = FXCollections.observableArrayList();
		for (move move : Main.battle.getAllies().get(1).getMoves()) {
			if (move.getType().equals("attack")) {
				items.add(move.getName());
			}
		}
		list1.setItems(items);
		Media media = new Media(buttonPress.toString());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);
		MediaView mediaView = new MediaView(mediaPlayer);
		sound = mediaView;
	}

	@FXML
	public void loadAttacks2() {
		ObservableList<String> items = FXCollections.observableArrayList();
		for (move move : Main.battle.getAllies().get(2).getMoves()) {
			if (move.getType().equals("attack")) {
				items.add(move.getName());
			}
		}
		list2.setItems(items);
		Media media = new Media(buttonPress.toString());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);
		MediaView mediaView = new MediaView(mediaPlayer);
		sound = mediaView;
	}

	@FXML
	public void getUp() throws IOException {
		if (Main.MC.getLocation().equals("Dawngeil")) {
			Parent window1;
			window1 = FXMLLoader.load(getClass().getResource("dawngeilCenter.fxml"));
			Stage mainStage;
			mainStage = Main.parentWindow;
			Main.parentWindow.getScene().setRoot(window1);
		}
		Media media = new Media(buttonPress.toString());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);
		MediaView mediaView = new MediaView(mediaPlayer);
		sound = mediaView;
	}

	@FXML
	public void loadListView() {
		String x = list.getSelectionModel().getSelectedItem();
		for (move move : Main.MC.getMoves()) {
			if (x.equals(move.getName())&&move.getType().equals("attack")) {
				System.out.println(move.getType());
				explanationTitle.setText(move.getName());
				explanation.setText("Attack:"+Main.MC.getATT()+"\nMove Damage: " + move.getPower() + "\n" + "Health Cost: " + move.getHealthCost() + "\n"
						+ "Stamina Cost: " + move.getStaminaCost() + "\n" + "Essence Cost: " + move.getEssenceCost()
						+ "\n" + "Current Accuracy: " + Main.MC.cAccuracy() + "\n \n" );
			return;
			}
			else if (x.equals(move.getName())&&move.getType().equals("spell")){
				System.out.println(move.getType());
				explanationTitle.setText(move.getName());
				explanation.setText("Magic Attack:"+Main.MC.getMATT()+"\nSpell Damage: " + move.getPower() + "\n" + "Health Cost: " + move.getHealthCost() + "\n"
						+ "Stamina Cost: " + move.getStaminaCost() + "\n" + "Essence Cost: " + move.getEssenceCost()
						+ "\n" + "Current Accuracy: " + Main.MC.cAccuracy() + "\n \n" );
			return;
			}
		}

		Media media = new Media(listSwap.toString());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);
		MediaView mediaView = new MediaView(mediaPlayer);
		sound = mediaView;

	}

	public void loadListView1() {

		String x = list1.getSelectionModel().getSelectedItem();
		for (move move : Main.battle.getAllies().get(1).getMoves()) {
			if (x.equals(move.getName())&&move.getType().equals("attack")) {
				explanationTitle1.setText(move.getName());
				explanation1.setText("Attack:"+Main.battle.getAllies().get(1).getATT()+"\nMove Damage: " + move.getPower() + "\n" + "Health Cost: " + move.getHealthCost() + "\n"
						+ "Stamina Cost: " + move.getStaminaCost() + "\n" + "Essence Cost: " + move.getEssenceCost()
						+ "\n" + "Current Accuracy: " + Main.battle.getAllies().get(1).cAccuracy() + "\n \n" );
			return;
			}
			else if (x.equals(move.getName())&&move.getType().equals("spell")){
				explanationTitle1.setText(move.getName());
				explanation1.setText("Magic Attack:"+Main.battle.getAllies().get(1).getMATT()+"\nSpell Damage: " + move.getPower() + "\n" + "Health Cost: " + move.getHealthCost() + "\n"
						+ "Stamina Cost: " + move.getStaminaCost() + "\n" + "Essence Cost: " + move.getEssenceCost()
						+ "\n" + "Current Accuracy: " + Main.battle.getAllies().get(1).cAccuracy() + "\n \n" );
			return;
			}
		}
		Media media = new Media(listSwap.toString());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);
		MediaView mediaView = new MediaView(mediaPlayer);
		sound = mediaView;
	}

	public void loadListView2() {

		String x = list2.getSelectionModel().getSelectedItem();

		for (move move : Main.battle.getAllies().get(2).getMoves()) {
			if (x.equals(move.getName())&&move.getType().equals("attack")) {
				explanationTitle2.setText(move.getName());
				explanation2.setText("Attack:"+Main.battle.getAllies().get(2).getATT()+"\nMove Damage: " + move.getPower() + "\n" + "Health Cost: " + move.getHealthCost() + "\n"
						+ "Stamina Cost: " + move.getStaminaCost() + "\n" + "Essence Cost: " + move.getEssenceCost()
						+ "\n" + "Current Accuracy: " + Main.battle.getAllies().get(2).cAccuracy() + "\n \n" );
			return;
			}
			else if (x.equals(move.getName())&&move.getType().equals("spell")){
				explanationTitle2.setText(move.getName());
				explanation2.setText("Magic Attack:"+Main.battle.getAllies().get(2).getMATT()+"\nSpell Damage: " + move.getPower() + "\n" + "Health Cost: " + move.getHealthCost() + "\n"
						+ "Stamina Cost: " + move.getStaminaCost() + "\n" + "Essence Cost: " + move.getEssenceCost()
						+ "\n" + "Current Accuracy: " + Main.battle.getAllies().get(2).cAccuracy() + "\n \n" );
			return;
			}
		}
		Media media = new Media(listSwap.toString());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);
		MediaView mediaView = new MediaView(mediaPlayer);
		sound = mediaView;
	}

	@FXML
	public void loadSpells() {

		ObservableList<String> items = FXCollections.observableArrayList();
		for (move move : Main.MC.getMoves()) {
			if (move.getType().equals("spell")) {
				items.add(move.getName());
			}
		}
		list.setItems(items);
		Media media = new Media(buttonPress.toString());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);
		MediaView mediaView = new MediaView(mediaPlayer);
		sound = mediaView;
	}

	@FXML
	public void loadSpells1() {

		ObservableList<String> items = FXCollections.observableArrayList();
		for (move move : Main.battle.getAllies().get(1).getMoves()) {
			if (move.getType().equals("spell")) {
				items.add(move.getName());
			}

		}
		list1.setItems(items);
		Media media = new Media(buttonPress.toString());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);
		MediaView mediaView = new MediaView(mediaPlayer);
		sound = mediaView;
	}
	
	@FXML
	public void loadSpells2() {

		ObservableList<String> items = FXCollections.observableArrayList();
		for (move move : Main.battle.getAllies().get(2).getMoves()) {
			if (move.getType().equals("spell")) {
				items.add(move.getName());
			}

		}
		list2.setItems(items);
		Media media = new Media(buttonPress.toString());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);
		MediaView mediaView = new MediaView(mediaPlayer);
		sound = mediaView;
	}

	@FXML
	public void loadItems() {

	}

	@FXML
	public void loadItems1() {

	}

	@FXML
	public void loadItems2() {

	}

	
	@FXML
	void onKeyPressed(KeyEvent keyEvent) {
		if (!keyEvent.isControlDown() && keyEvent.getCode() == KeyCode.SPACE) {
			keyEvent.consume();
			swapAllyTabs();
		}
	}

	public void swapAllyTabs() {
		tabPane.getSelectionModel().selectNext();
		if (tabPane.getSelectionModel().getSelectedItem().isDisabled()) {
			tabPane.getSelectionModel().selectFirst();
		}
		if (tabPane.getSelectionModel().getSelectedItem().isDisabled()) {
			tabPane.getSelectionModel().selectNext();
		}
		if (tabPane.getSelectionModel().getSelectedItem().getId().equals("allyThree")&&tabPane.getSelectionModel().getSelectedItem().isDisabled()) {
			tabPane.getSelectionModel().selectFirst();
		}
		Media media = new Media(tabSwap.toString());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);
		MediaView mediaView = new MediaView(mediaPlayer);
		sound = mediaView;
	}

	@FXML
	public void playSound() {
		Media media = new Media(listSwap.toString());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);
		MediaView mediaView = new MediaView(mediaPlayer);
		sound = mediaView;
	}
}
