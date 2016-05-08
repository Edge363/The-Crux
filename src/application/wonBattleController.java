package application;

import java.io.File;
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
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author William
 */

public class wonBattleController implements Initializable {

	@FXML
	private Button getUp;
	@FXML
	private Slider experienceBar;
	@FXML
	private BorderPane FP;
	@FXML
	private Text text;
	@FXML
	Label explanationTitle;

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		Main.fadeIn.play();
		experienceBar.setMax(Main.MC.getEXP());
		experienceBar.setValue(Main.MC.cExperience());
	}

	@FXML
	public void getUp() throws IOException {
		
			Parent window1;
			window1 = FXMLLoader.load(getClass().getResource("sixthScene.fxml"));
			Stage mainStage;
			mainStage = Main.parentWindow;
			Main.parentWindow.getScene().setRoot(window1);
		
		
	}
}
