package application;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import logic.battle;
import logic.character;
import logic.enemy;

public class Main extends Application {

	public static Stage parentWindow;
	static FadeTransition fadeOut = new FadeTransition();
	static character MC = new character();
	static FadeTransition fadeIn = new FadeTransition();
	static String name;
	static battle battle = new battle();

	@Override
	public void start(Stage stage) throws Exception {

		MC.setName("Cleave");

		battle.getEnemies().add(new enemy());
		battle.getEnemies().add(new enemy());

		battle.getAllies().add(MC);
		character MD = new character();
		MD.setName("ayeo");
		battle.getAllies().add(MD);
//		character MF = new character();
//		MF.setName("eguo3b4jo34ijk");
//		battle.getAllies().add(MF);
		fadeOut.setDuration(Duration.millis(1));
		fadeOut.setFromValue(1.0);
		fadeOut.setToValue(0.0);

		fadeIn.setDuration(Duration.millis(2500));
		fadeIn.setFromValue(0.0);
		fadeIn.setToValue(1.0);

		stage.setTitle("The Crux");
		parentWindow = stage;

		Parent root = FXMLLoader.load(getClass().getResource("battleScreen.fxml"));

		Scene scene = new Scene(root);
		scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
