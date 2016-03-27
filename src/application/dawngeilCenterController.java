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
	import javafx.stage.Stage;

	/**
	 *
	 * @author William
	 */
	
	    public class dawngeilCenterController implements Initializable {
	    @FXML
	    private Button playerStatMenuButton;
	    @FXML
	    private Button playerItemMenu;
	    @FXML
	    private Button goWork;
	    @FXML
	    private Button goHome;
	    @FXML
	    private Button goShop;
	    @FXML
	    private Button layDown;
	    @Override
	    public void initialize(URL url, ResourceBundle rb) {
	    	Main.MC.setLocation("Dawngeil");
	    	Main.fadeIn.setNode(playerStatMenuButton);
	    	Main.fadeIn.play();
	    } 
	    
	    @FXML
	    	public void openPlayerMenu() throws IOException{
	    	if(playerStatMenuButton.getOpacity()==1.0){
		    	Parent window1;
		        window1 = FXMLLoader.load(getClass().getResource("playerMenu.fxml"));
		        Stage mainStage;
		        mainStage = Main.parentWindow;
		        Main.parentWindow.getScene().setRoot(window1);
	    	}
	    	
	    }
	    @FXML
    	public void goShop(){
	    	
	    }
	    @FXML
    	public void goWork() throws IOException{
	   
		    Parent window1;
		    window1 = FXMLLoader.load(getClass().getResource("factory.fxml"));
	        Stage mainStage;
	        mainStage = Main.parentWindow;
	        Main.parentWindow.getScene().setRoot(window1); 
	        Main.parentWindow.getScene().getStylesheets().remove(Main.class.getResource("dawngeilCenter.css").toExternalForm());
		    Main.parentWindow.getScene().getStylesheets().add(Main.class.getResource("factory.css").toExternalForm());
	    }
	    @FXML
    	public void goHome() throws IOException{
	    	 Parent window1;
			    window1 = FXMLLoader.load(getClass().getResource("home.fxml"));
		        Stage mainStage;
		        mainStage = Main.parentWindow;
		        Main.parentWindow.getScene().setRoot(window1); 
		        Main.parentWindow.getScene().getStylesheets().remove(Main.class.getResource("dawngeilCenter.css").toExternalForm());
			    Main.parentWindow.getScene().getStylesheets().add(Main.class.getResource("home.css").toExternalForm());
	    }
	    @FXML
    	public void layDown(){
	    	
	    }
	}


