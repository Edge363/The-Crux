package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author William
 */

public class firstActSeventhSceneController implements Initializable {
	@FXML
	private Button getUp;
	@FXML
	private BorderPane FP;
	@FXML
	private Text text;
	@FXML
	private VBox VB;
	@FXML
	private VBox VB3;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		text.setText("What now " + Main.name + "? Is anything even worth it? To show up? To live? I...I can't find a purpose, or any meaning. I guess since you're here I won't be as lonely anymore...I'm Cleave.");
		if (Main.MC.getJob() == 0) {
			getUp.setText(
					"I already know your Cleave idiot. I know you better than you know yourself...Now, The young dealer of lives is going to make quite the splash. Let's go to the center of town and decide from there.");
		} else if (Main.MC.getJob() == 1) {

			getUp.setText(
					"I already know your Cleave idiot. I know you better than you know yourself...Now, The newly created weapon is going to make quite the splash. Let's go to the center of town and decide from there.");
		} else if (Main.MC.getJob() == 2) {

			getUp.setText(
					"I already know your Cleave idiot. I know you better than you know yourself...Now, What kind of bussiness are you going to create? Doesn,t matter, it is going to make quite the splash. Let's go to the center of town and decide from there.");
		} else if (Main.MC.getJob() == 3) {

			getUp.setText(
					"I already know your Cleave idiot. I know you better than you know yourself...Now, Seems like you havea  jump start Cleave. You're going to make quite the splash. Let's go to the center of town and decide from there.");
		} else if (Main.MC.getJob() == 4) {

			getUp.setText(
					"I already know your Cleave idiot. I know you better than you know yourself...Now, The thief of life is going to make quite the splash. Let's go to the center of town and decide from there.");
		} else if (Main.MC.getJob() == 5) {

			getUp.setText(
					"I already know your Cleave idiot. I know you better than you know yourself...Now, The wanderer is going to make quite the splash. Let's go to the center of town and decide from there.");
		}
		Main.fadeIn.setNode(VB);
		Main.fadeIn.play();
	}

	@FXML
	public void getUp() throws IOException {
		Parent window1;
		window1 = FXMLLoader.load(getClass().getResource("dawngeilCenter.fxml"));
		Stage mainStage;
		mainStage = Main.parentWindow;
		Main.parentWindow.getScene().setRoot(window1);
		Main.parentWindow.getScene().getStylesheets().remove(Main.class.getResource("alley.css").toExternalForm());
	    Main.parentWindow.getScene().getStylesheets().add(Main.class.getResource("dawngeilCenter.css").toExternalForm());
	}
}
