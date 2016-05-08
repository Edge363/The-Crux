package logic;

import java.util.Arrays;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class map {
	Image mapBackground;
	map(String inputText){
		List<String> results =game.keywordTagSearch
				(inputText,(List<String>)Arrays.asList(
						new String[]{"image"}));
		mapBackground=new Image(results.get(0));
	}
	
}