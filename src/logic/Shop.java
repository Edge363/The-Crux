package logic;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Shop {

	ArrayList<weapon> weapons;
	ArrayList<armor> armors;
	ArrayList<move> moves;
	URL background;

	Shop(String inputText) {

		List<String> results = game.keywordTagSearch(inputText,
				(List<String>) Arrays.asList(new String[] { "weapons", "armors", "moves", "background" }));
		
		List<String> weap = game.keywordTagSearch(results.get(0),
				(List<String>) Arrays.asList(new String[] { "weapon" }));
		
		for (String weapon : weap) {
			weapons.add(new weapon(weapon));
		}
		
		List<String> arm = game.keywordTagSearch(results.get(1),
				(List<String>) Arrays.asList(new String[] { "armor" }));
		for (String armor : arm) {
			armors.add(new armor(armor));
		}
		List<String> mov = game.keywordTagSearch(results.get(2), (List<String>) Arrays.asList(new String[] { "move" }));
		for (String move : mov) {
			moves.add(new move(move));
		}
		List<String> back = game.keywordTagSearch(results.get(3),
				(List<String>) Arrays.asList(new String[] { "background" }));
		
		try {
			background = new URL(back.get(0));
		} catch (MalformedURLException e) {
			System.out.println("incorrect URL for the shop background.");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}