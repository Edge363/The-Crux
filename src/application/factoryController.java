	package application;

	import java.io.IOException;
	import java.net.URL;
	import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
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
import javafx.util.Duration;

	/**
	 *
	 * @author William
	 */
	    public class factoryController implements Initializable {
	    public static boolean factoryConversation;
	    private int factorySceneNumber=0;
	    @FXML
	    private Button getUp;
	    @FXML
	    private Button getUpTwo;
	    @FXML
	    private BorderPane FP;
	    @FXML
	    private Text cleaveTalk;
	    @FXML
	    private Text bossTalk;
	    FadeTransition stuff = new FadeTransition();
	    SequentialTransition stuff2 = new SequentialTransition (
	            new PauseTransition(Duration.millis(3000)),stuff // wait a second
	        );
	    @Override
	    public void initialize(URL url, ResourceBundle rb) {
	    	stuff.setDuration(Duration.millis(2500));
	 	    stuff.setFromValue(0.0);
	 	    stuff.setToValue(1.0);
	 	    stuff.setNode(getUp);

	    	Main.fadeIn.setDuration(Duration.millis(5000));
	    	if(factoryConversation!=true){
	    		Main.fadeIn.setNode(cleaveTalk);
	    		Main.fadeOut.setNode(cleaveTalk);
	    		Main.fadeIn.play();
	    		stuff2.play();
	    	}
	    	else{
	    	
	    		bossTalk.setText("Leave. Y-You've been fired.");
	    		getUp.setText("Leave.");
	    	}

	    } 
	    
	    @FXML
	    	public void getUp() throws IOException{
	    	if(factoryConversation!=true){
	    		if(getUp.getOpacity()==1.0){
	    	if(factorySceneNumber==0){
	    		FadeTransition sterf = new FadeTransition();
	    	  	sterf.setDuration(Duration.millis(5000));
		 	    sterf.setFromValue(0.0);
		 	    sterf.setToValue(1.0);
		 	    sterf.setNode(cleaveTalk);
		 	    sterf.play();
	    		factorySceneNumber++;
	    		bossTalk.setText("Are you paid to think you stupid oaf? No. You're paid to show up, and carry the bodies. Now get to work.");
	    		cleaveTalk.setText("Of course sir! I'll get on it right now.");
	    		Main.fadeIn.play();
	    		stuff2.play();
	    		getUp.setText("Cleave, he is obviously stepping on you. Stand up for yourself! He's a whole head shorter.");
	    	
	    	}
	    	else if(factorySceneNumber==1){
	    		factorySceneNumber++;
	    		bossTalk.setText("....");
	    		cleaveTalk.setText("This is my only job "+Main.name+". I gotta do what he says...");
	    		getUp.setText("So what? Get a new job! You don't need it anymore anyways. You can be so much more. This is holding you back!");
	    		Main.fadeIn.play();
	    		FadeTransition sterf = new FadeTransition();
	    	  	sterf.setDuration(Duration.millis(5000));
		 	    sterf.setFromValue(0.0);
		 	    sterf.setToValue(1.0);
		 	    sterf.setNode(cleaveTalk);
		 	    sterf.play();
	    		stuff2.play();
	    	}
	    	else if(factorySceneNumber==2){
	    	 	Main.fadeIn.setNode(getUpTwo);
		    	Main.fadeIn.play();
	    		factorySceneNumber++;
	    		bossTalk.setText("Are you talking to yourself Cleave? Did you finally lose it? Well too bad, your going to work for free today. Now go before I stop feeling generous.");
	    		cleaveTalk.setText("...Sure. Sir.");
	    		getUp.setText("You know this is wrong Cleave. You can talk this out. Just get him to understand your pos-");
	    		getUpTwo.setText("Cleave. Look at yourself. You're massive. Just break his face, or at least talk bac-");
	    		FadeTransition sterf = new FadeTransition();
	    	  	sterf.setDuration(Duration.millis(5000));
		 	    sterf.setFromValue(0.0);
		 	    sterf.setToValue(1.0);
		 	    sterf.setNode(cleaveTalk);
		 	    sterf.play();
	    		stuff2.play();
	    	}
	    	else if(factorySceneNumber==3){
	    		if(Main.MC.getAgressiveness()==0){
	    			 Main.MC.setAgressiveness(Main.MC.getAgressiveness()-1);
	    		}
	    		factorySceneNumber++;
	    		getUpTwo.setOpacity(0.0);
	    		bossTalk.setText("....");
	    		cleaveTalk.setText("Everybody...just... \n SHUT THE FUCK UP.");
	    		getUp.setText("....");
	    		getUpTwo.setOpacity(0.0);
	    		stuff2.play();
	    		getUpTwo.setOpacity(0.0);
	    	}
	    	else if(factorySceneNumber==4){
	    		factorySceneNumber++;
	    		getUpTwo.setOpacity(0.0);
	    		factoryConversation=true;
	    		factorySceneNumber++;
	    		bossTalk.setText("...L-L-Leave! You freak. Get out! I-I-ll call security.");
	    		cleaveTalk.setText("...");
	    		getUp.setText("Let's go. This is a good thing anyway.");
	    		
	    	}
	    	else if(factorySceneNumber==5){
	    		getUpTwo.setOpacity(0.0);
	    		Parent window1;
	    		window1 = FXMLLoader.load(getClass().getResource("dawngeilCenter.fxml"));
	    		Stage mainStage;
	    		mainStage = Main.parentWindow;
	    		Main.parentWindow.getScene().setRoot(window1);
	    		Main.parentWindow.getScene().getStylesheets().remove(Main.class.getResource("factory.css").toExternalForm());
	    	    Main.parentWindow.getScene().getStylesheets().add(Main.class.getResource("dawngeilCenter.css").toExternalForm());
	    	}
	    		
	    	else{
	    		Parent window1;
	    		window1 = FXMLLoader.load(getClass().getResource("dawngeilCenter.fxml"));
	    		Stage mainStage;
	    		mainStage = Main.parentWindow;
	    		Main.parentWindow.getScene().setRoot(window1);
	    		Main.parentWindow.getScene().getStylesheets().remove(Main.class.getResource("factory.css").toExternalForm());
	    	    Main.parentWindow.getScene().getStylesheets().add(Main.class.getResource("dawngeilCenter.css").toExternalForm());
	    	}
	    		}
	    	}
	    	else{
	    	Parent window1;
    		window1 = FXMLLoader.load(getClass().getResource("dawngeilCenter.fxml"));
    		Stage mainStage;
    		mainStage = Main.parentWindow;
    		Main.parentWindow.getScene().setRoot(window1);
    		Main.parentWindow.getScene().getStylesheets().remove(Main.class.getResource("factory.css").toExternalForm());
    	    Main.parentWindow.getScene().getStylesheets().add(Main.class.getResource("dawngeilCenter.css").toExternalForm());
	    	}
	    	}
	    	
	    @FXML
	    public void getUpTwo() throws IOException{
	    Main.MC.setAgressiveness(Main.MC.getAgressiveness()+1);
	    getUp();
	    }
    	public void fadeInCleaveTalk() throws IOException{
    
    	
    	}
	}


