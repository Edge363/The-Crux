package logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class locations {

	ArrayList<location> locations = new ArrayList<location>();

	public locations(String inputText) {

		List<String> results = game.keywordTagSearch(inputText,
				(List<String>) Arrays.asList(new String[] { "location" }));
		Iterator<String> it = results.listIterator();

		while (it.hasNext()) {
			locations.add(new location(it.next()));
		}
	}
}