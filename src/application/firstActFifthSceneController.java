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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author William
 */

public class firstActFifthSceneController implements Initializable {
	@FXML
	private Button getUp;
	@FXML
	private BorderPane FP;
	@FXML
	private Text text;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		if (Main.MC.getJob() == 0) {
			text.setText(
					"Why would I let you decide that? It's my life, and I'll do anything I want. Being a warlord sounds terrible.");
			getUp.setText(
					"Because you've done such a great job up until now. Cleave listen, you will be a Warlord because I demand it.");
		} else if (Main.MC.getJob() == 1) {
			text.setText("Magic? I've never cast a spell before, or summoned anything...");
			getUp.setText("Of course not, but you will learn my friend! We're friends now right? Pals? Chums?");
		} else if (Main.MC.getJob() == 2) {
			text.setText("I guess...but I've never even held an entire gold peice in my hand. Why do that now?");
			getUp.setText(
					"Because now you are going to change, you're being baptised my friend. We're friends now right? Pals? Chums?");
		} else if (Main.MC.getJob() == 3) {
			text.setText("What? I'm tough but...Why a brute? Why now?");
			getUp.setText("You're being baptised now my friend. We're friends now right? Pals? Chums?");
		} else if (Main.MC.getJob() == 4) {
			text.setText("No. I won't do that. I'm not a murdering psycho.");
			getUp.setText(
					"Yes you will. You will because I demand it. You'll be baptised now my friend. We're friends now right? Pals? Chums?");
		} else if (Main.MC.getJob() == 5) {
			text.setText("I can't tell if you want me to be good at everything, or terrible at everything...");
			getUp.setText(
					"Whatever I want you to do. You're being baptised now my friend. We're friends now right? Pals? Chums?");
		}

		Main.fadeIn.setNode(FP);
		Main.fadeIn.play();
	}

	@FXML
	public void getUp() throws IOException {
		if (FP.getOpacity() == 1.0) {
			Parent window1;
			window1 = FXMLLoader.load(getClass().getResource("sixthScene.fxml"));
			Stage mainStage;
			mainStage = Main.parentWindow;
			Main.parentWindow.getScene().setRoot(window1);
		}
	}
}
