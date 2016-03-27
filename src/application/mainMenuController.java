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
import javafx.scene.control.ListView;
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

public class mainMenuController implements Initializable {
	
	@FXML
	private Button startButton;
	@FXML
	private VBox VB2;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
	}

	@FXML
	public void showMainMenu() throws IOException {
	 	Parent window1;
        window1 = FXMLLoader.load(getClass().getResource("secondMainMenu.fxml"));
        Stage mainStage;
        mainStage = Main.parentWindow;
        Main.parentWindow.getScene().setRoot(window1);
	}
}
