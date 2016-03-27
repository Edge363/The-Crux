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
import javafx.stage.Stage;

	/**
	 *
	 * @author William
	 */
	
	    public class firstActFirstSceneController implements Initializable {
	    @FXML
	    private Button getUp;
	    @FXML
	    private FlowPane FP;
	    
	    @Override
	    public void initialize(URL url, ResourceBundle rb) {
	    	Main.fadeIn.setNode(FP);
	    	Main.fadeIn.play();
	    } 
	    
	    @FXML
	    	public void getUp() throws IOException{
	    	if(FP.getOpacity()==1.0){
		    	Parent window1;
		        window1 = FXMLLoader.load(getClass().getResource("secondScene.fxml"));
		        Stage mainStage;
		        mainStage = Main.parentWindow;
		        Main.parentWindow.getScene().setRoot(window1);
	    	}
	    	}
	}


