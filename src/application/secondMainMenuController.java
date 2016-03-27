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
public class secondMainMenuController implements Initializable {
    
    @FXML
    private Button newGameButton;
    @FXML 
    private Button loadGameButton;
    @FXML 
    private Button optionsButton;
    @FXML 
    private Text theCrux;
    @FXML
    private VBox vB;
    @FXML
    private MediaView sound;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	
    	Main.fadeIn.setNode(vB);
    	Main.fadeIn.play();
    	
    	  final URL resource = getClass().getResource("mainMenu.mp3");
          Media media = new Media(resource.toString());
          MediaPlayer mediaPlayer = new MediaPlayer(media);
          mediaPlayer.setAutoPlay(true);

          MediaView mediaView = new MediaView(mediaPlayer);
          sound = mediaView;
          
//        assert newGameButton != null;
//        newGameButton.setOnAction(e -> { try {
//			startGame();
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}});
          
    } 
    
    @FXML
    	public void startGame() throws IOException{

	    	if(vB.getOpacity()==1.0){
		    	Parent window1;
		        window1 = FXMLLoader.load(getClass().getResource("firstScene.fxml"));
		        Stage mainStage;
		        mainStage = Main.parentWindow;
		        Main.parentWindow.getScene().setRoot(window1);
		        Main.parentWindow.getScene().getStylesheets().remove(Main.class.getResource("application.css").toExternalForm());
		        Main.parentWindow.getScene().getStylesheets().add(Main.class.getResource("alley.css").toExternalForm());
	    		}
	    	}
}