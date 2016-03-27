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
	
	    public class firstActSixthSceneController implements Initializable {
	    @FXML
	    private Button getUp;
	    @FXML
	    private TextField name;
	    @FXML
	    private BorderPane FP;
	    @FXML
	    private Text text;
	    @FXML
	    private VBox VB2;
	    @FXML
	    private VBox VB3;
	    @Override
	    public void initialize(URL url, ResourceBundle rb) {
	    	Main.fadeIn.setNode(VB2);
	    	Main.fadeIn.play();
	    	
	    } 
	    
	    @FXML
	    	public void getUp() throws IOException{
	    	Parent window1;
			window1 = FXMLLoader.load(getClass().getResource("dawngeilCenter.fxml"));
			Stage mainStage;
			mainStage = Main.parentWindow;
			Main.parentWindow.getScene().setRoot(window1);
			Main.parentWindow.getScene().getStylesheets().remove(Main.class.getResource("alley.css").toExternalForm());
		    Main.parentWindow.getScene().getStylesheets().add(Main.class.getResource("dawngeilCenter.css").toExternalForm());
	    	}
	    
	    @FXML
    	public void revealButton() throws IOException{
	    	Main.fadeOut.setNode(VB2);
	    	Main.fadeOut.play();
	    	
	    	Main.name=name.getText();
	    	getUp.setText("I'm your new best friend "+Main.name+". I've always been here. Now we need you to go to the center of town. Then we can decide.");
	    	Main.fadeIn.setNode(VB3);
	    	Main.fadeIn.play();
	    }
	}


