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
	    public class characterCreationController implements Initializable {
	    @FXML
	    private Button warlord;
	    @FXML
	    private Button arcanist;
	    @FXML
	    private Button capitalist;
	    @FXML
	    private Button brute;
	    @FXML
	    private Button jack;
	    @FXML
	    private Button assassin;
	    
	    @Override
	    public void initialize(URL url, ResourceBundle rb) {
	    	
	    } 
	    
	    @FXML
	    	public void makeWarlord() throws IOException{
	    		Main.MC.setJob(0);
		    	Parent window1;
		        window1 = FXMLLoader.load(getClass().getResource("confirmation.fxml"));
		        Stage mainStage;
		        mainStage = Main.parentWindow;
		        Main.parentWindow.getScene().setRoot(window1);
	    	
	    	}
	    @FXML
	    public void makeArcanist() throws IOException{
    		Main.MC.setJob(1);
	    	Parent window1;
	        window1 = FXMLLoader.load(getClass().getResource("confirmation.fxml"));
	        Stage mainStage;
	        mainStage = Main.parentWindow;
	        Main.parentWindow.getScene().setRoot(window1);
    	
    	}
	    @FXML
	    public void makeCapitalist() throws IOException{
    		Main.MC.setJob(2);
	    	Parent window1;
	        window1 = FXMLLoader.load(getClass().getResource("confirmation.fxml"));
	        Stage mainStage;
	        mainStage = Main.parentWindow;
	        Main.parentWindow.getScene().setRoot(window1);
    	
    	}
	    @FXML
	    public void makeBrute() throws IOException{
    		Main.MC.setJob(3);
	    	Parent window1;
	        window1 = FXMLLoader.load(getClass().getResource("confirmation.fxml"));
	        Stage mainStage;
	        mainStage = Main.parentWindow;
	        Main.parentWindow.getScene().setRoot(window1);
    	
    	}
	    @FXML
	    public void makeAssassin() throws IOException{
    		Main.MC.setJob(4);
	    	Parent window1;
	        window1 = FXMLLoader.load(getClass().getResource("confirmation.fxml"));
	        Stage mainStage;
	        mainStage = Main.parentWindow;
	        Main.parentWindow.getScene().setRoot(window1);
    	
    	}
	    @FXML
	    public void makeJack() throws IOException{
    		Main.MC.setJob(5);
	    	Parent window1;
	        window1 = FXMLLoader.load(getClass().getResource("confirmation.fxml"));
	        Stage mainStage;
	        mainStage = Main.parentWindow;
	        Main.parentWindow.getScene().setRoot(window1);
    	
    	}
	}


