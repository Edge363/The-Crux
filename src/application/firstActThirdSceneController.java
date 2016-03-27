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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

	/**
	 *
	 * @author William
	 */
	
	    public class firstActThirdSceneController implements Initializable {
	    @FXML
	    private Button getUp;
	    @FXML
	    private Button getUpTwo;
	    @FXML
	    private VBox VB;
	    @Override
	    public void initialize(URL url, ResourceBundle rb) {
	    	Main.fadeIn.setNode(VB);
	    	Main.fadeIn.play();
	    } 
	    
	    @FXML
	    	public void getUp() throws IOException{
		    	Parent window1;
		        window1 = FXMLLoader.load(getClass().getResource("fourthScene.fxml"));
		        Stage mainStage;
		        mainStage = Main.parentWindow;
		        Main.parentWindow.getScene().setRoot(window1);
		      	Main.MC.setIndependence(Main.MC.getIndependence()-1);
	    	}
	    @FXML
    	public void getUpTwo() throws IOException{
	    	Main.MC.setIndependence(Main.MC.getIndependence()+1);
	    	Parent window1;
	        window1 = FXMLLoader.load(getClass().getResource("fourthScene.fxml"));
	        Stage mainStage;
	        mainStage = Main.parentWindow;
	        Main.parentWindow.getScene().setRoot(window1);
    	}
	}


