	package application;

	import java.io.IOException;
	import java.net.URL;
	import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
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
	
	    public class homeController implements Initializable {
	    @FXML
	    private Button getUp;
	    @FXML
	    private Button getUp1;
	    @FXML
	    private Text text;
	    public static boolean homeConversation;
	    private int homeSceneNumber=0;  
	    FadeTransition buttonPause = new FadeTransition();
	    SequentialTransition seqTransition = new SequentialTransition (
	            new PauseTransition(Duration.millis(1000)),buttonPause // wait a second
	           
	        );
	    FadeTransition buttonPause2 = new FadeTransition();
	    SequentialTransition seqTransition2 = new SequentialTransition (
	            new PauseTransition(Duration.millis(1000)),buttonPause2 // wait a second
	           
	        );
	    
	    @Override
	    public void initialize(URL url, ResourceBundle rb) {
	    	if(homeConversation!=true){
	    	buttonPause.setNode(getUp);
	    	buttonPause.setFromValue(0.0);
	    	buttonPause.setToValue(1.0);
	       	buttonPause2.setNode(getUp1);
	    	buttonPause2.setFromValue(0.0);
	    	buttonPause2.setToValue(1.0);
	    	getUp.setOpacity(0.0);
	    	getUp1.setOpacity(0.0);
	    	buttonPause.setDuration(Duration.millis(2500));
	    	text.setText("...Have you seen where I live "+Main.name+"? I've lived here for almost 3 years now. Ever since I was 16. Reminds me of the days in the orphanage, but at least now I have somebody who listens. Even if it isn't by choice...");
	    	getUp.setText("Stop being so down on yourself. I don't hate you. I just hate some of the things you do. Did you know I've always been here? In your mind?");
	    	
	    	Main.fadeIn.setNode(text);
	    	Main.fadeIn.setDuration(Duration.millis(2500));
	    	Main.fadeIn.play();
	    	seqTransition.play();
	    }
	    	else{
	    		text.setText("Still looks the same.");
	    		buttonPause.setNode(getUp);
		    	buttonPause.setFromValue(0.0);
		    	buttonPause.setToValue(1.0);
		      	getUp.setOpacity(0.0);
		    	getUp1.setOpacity(0.0);
		    	buttonPause.setDuration(Duration.millis(2500));
		    	getUp.setText("Yeah. Let's go.");
		    	seqTransition.play();
	    	}
	    }
	    
	    @FXML
	    	public void getUp() throws IOException{
	    	if(getUp.getOpacity()==1.0||getUp1.getOpacity()==1.0){
	    	if(homeConversation!=true){
	    		
	    	if(homeSceneNumber==0){
	    		Main.fadeIn.setNode(text);
		    	Main.fadeIn.play();
	    		text.setText("No...I thought I was always alone...So you know everything about me?");
		    	getUp.setText("Sort of. My memory is...bad...I remember that you were an orphan, you're freakishly huge, and you let everyone walk all over you.");
		    	seqTransition.play();
		    	homeSceneNumber++;
	    	}
	    	else if(homeSceneNumber==1){
	    		Main.fadeIn.setNode(text);
		    	Main.fadeIn.play();
	    		text.setText("I guess...Why are you showing up now?");
		    	getUp.setText("None of us know why we exist. Much less why it happens at a specific time. I'm honestly glad I'm here now.");
		    	seqTransition.play();
		    	homeSceneNumber++;
	    	}
	    	else if(homeSceneNumber==2){
	    		Main.fadeIn.setNode(text);
		    	Main.fadeIn.play();
	    		text.setText("Why? Life is short and then you die. You have no control, and when it ends you'll regret everything. I've seen it a thousand times.");
		    	getUp.setText("You know that's not it at all. You are completely wrong. You just need to do what I say and I promise life will be fantastic.");
		    	getUp1.setText("Cleave, stop being so pa-...Why not try owning up to the results of your life? Eh? Why the fuck not? Why not try controlling the outcome some?");
		    	seqTransition.play();
		    	seqTransition2.play();
		    	homeSceneNumber++;
	    	}
	    	else if(homeSceneNumber==3){
	    		getUp1.setOpacity(0.0);
	    		Main.MC.setIndependence(Main.MC.getIndependence()-1);
	    		Main.fadeIn.setNode(text);
		    	Main.fadeIn.play();
	    		text.setText("...Sure. I'm just happy to have somebody to talk to, plus I can't imagine you doing any worse.");
		    	getUp.setText("Yeah, I'm here to help. So just listen to me, we'll change the life you've lived so far.");
		    	seqTransition.play();
		    	homeSceneNumber++;
	    	}
	    	else if(homeSceneNumber==4){
	    		getUp1.setOpacity(0.0);
	    		Main.MC.setIndependence(Main.MC.getIndependence()-1);
	    		Main.fadeIn.setNode(text);
		    	Main.fadeIn.play();
	    		text.setText("Well...I guess we should go then. This place just brings back bad memories.");
		    	getUp.setText("Yeah, let's go.");
		    	seqTransition.play();
		    	homeSceneNumber++;
	    	}
	    	else if(homeSceneNumber==5){
	    	Parent window1;
    		window1 = FXMLLoader.load(getClass().getResource("dawngeilCenter.fxml"));
    		Stage mainStage;
    		mainStage = Main.parentWindow;
    		Main.parentWindow.getScene().setRoot(window1);
    		Main.parentWindow.getScene().getStylesheets().remove(Main.class.getResource("home.css").toExternalForm());
    	    Main.parentWindow.getScene().getStylesheets().add(Main.class.getResource("dawngeilCenter.css").toExternalForm());
	    	}
	    	}
	    	else{
	    		Parent window1;
	    		window1 = FXMLLoader.load(getClass().getResource("dawngeilCenter.fxml"));
	    		Stage mainStage;
	    		mainStage = Main.parentWindow;
	    		Main.parentWindow.getScene().setRoot(window1);
	    		Main.parentWindow.getScene().getStylesheets().remove(Main.class.getResource("home.css").toExternalForm());
	    	    Main.parentWindow.getScene().getStylesheets().add(Main.class.getResource("dawngeilCenter.css").toExternalForm());
	    	}
	    	}
	    	}
	    	public void getUp1() throws IOException{
		    	
		    	if(homeSceneNumber==3){
		    		getUp.setOpacity(0.0);
		    		Main.MC.setIndependence(Main.MC.getIndependence()+1);
		    		Main.fadeIn.setNode(text);
			    	Main.fadeIn.play();
		    		text.setText("Fine! Fuck off. I see there's no sympathy or kindness in you.");
			    	getUp1.setText("Wrong again Cleave. Sometimes you acheive kindness through cruelty. Sometimes we all need to hear what we don't want to. I really do want to help. You just need to take a hard look at yourself.");
			    	seqTransition2.play();
			    	homeSceneNumber++;
		    	}
		    	else if(homeSceneNumber==4){
		    		getUp.setOpacity(0.0);
		    		Main.fadeIn.setNode(text);
			    	Main.fadeIn.play();
		    		text.setText("Maybe...Thanks for the effort then.");
			    	getUp1.setText("No problem. Now let's get out of here.");
			    	seqTransition2.play();
			    	homeSceneNumber++;
			    	homeConversation=true;
		    	}
		    	else if(homeSceneNumber==5){
		    	Parent window1;
	    		window1 = FXMLLoader.load(getClass().getResource("dawngeilCenter.fxml"));
	    		Stage mainStage;
	    		mainStage = Main.parentWindow;
	    		Main.parentWindow.getScene().setRoot(window1);
	    		Main.parentWindow.getScene().getStylesheets().remove(Main.class.getResource("home.css").toExternalForm());
	    	    Main.parentWindow.getScene().getStylesheets().add(Main.class.getResource("dawngeilCenter.css").toExternalForm());
		    	}	
	    	}
	}


