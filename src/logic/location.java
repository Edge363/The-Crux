package logic;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class location {

	character storyCharacter;
	ArrayList<character> sideCharacters;
	Shop locationShop;
	URL musicLocation;
	URL backgroundPictureLocation;
	
	location(String inputText) {
		List<String> results = game.keywordTagSearch(inputText,
				(List<String>) Arrays.asList(new String[]{ "storycharacter","shop","music","background","sidecharacters" }));
		storyCharacter=new sideCharacter(results.get(0));
		locationShop=new Shop(results.get(1));
		
		try {
			musicLocation=new URL(results.get(2));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("wrong URL");
			e.printStackTrace();
		}
		
		try {
			backgroundPictureLocation=new URL(results.get(3));
		} catch (MalformedURLException e) {
			System.out.println("wrong URL");

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<String> sidys = game.keywordTagSearch(results.get(4),
		(List<String>) Arrays.asList(new String[]{ "sidecharacter"}));
		
		for(String x :sidys){
			sideCharacters.add(new sideCharacter(x));
		}
		
	}
		
}