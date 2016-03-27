package application;
	
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import logic.battle;
import logic.character;
import logic.enemy;
public class gameOverController {
@FXML
Button getUp;
@FXML
Text text;
@FXML
VBox VB;
public void initialize(URL url, ResourceBundle rb) {
	text.setText("Tired? So am I. I just wanna lay down, and give in...");
	text.setOpacity(1.0);
    getUp.setText("Hahaha! Funny stuff my friend. Let's get back to it.");
    Main.fadeIn.setNode(VB);
	Main.fadeIn.play();
} 
	public void getUp() throws IOException{
    	Parent window1;	
        window1 = FXMLLoader.load(getClass().getResource("secondMainMenu.fxml"));
        Stage mainStage;
        mainStage = Main.parentWindow;
        Main.parentWindow.getScene().setRoot(window1);
	}

}
