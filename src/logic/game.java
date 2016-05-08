package logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class game {
	
public String name;
public locations locations; 
public storybattles storyBattles;
public mainCharacter cleave;
public map Map;

game(String inputFile) throws FileNotFoundException{
	
	Scanner scanner = new Scanner( new File(inputFile) );
	String inputText = scanner.useDelimiter("\\A").next();
	scanner.close(); // Put this call in a finally block
	inputText = inputText.replace("\n", "").replace("\r", "").replaceAll("\\s+","");
	List<String> results =keywordTagSearch
			(inputText,(List<String>)Arrays.asList(
					new String[]{"name", "locations","storybattles","maincharacter","map"}));
	name=results.get(0);
	locations= new locations(results.get(1));
	storyBattles= new storybattles(results.get(2));
	cleave=new mainCharacter(results.get(3));
	Map = new map(results.get(5));
	
}

public static List<String> keywordTagSearch(String inputText,List<String> keywords){
	
	String regex = "<%1$s>(.+?)<%1$s/>";
    List<String> strs = new ArrayList<>();
    
    for (String keyword : keywords) {
        String tempPattern = String.format(regex, keyword);
        Pattern pattern = Pattern.compile(tempPattern);
        Matcher matcher = pattern.matcher(inputText);

        while(matcher.find()){
            strs.add(matcher.group(1));
        }
    }
    
    return strs;
}

public static void main(String[] args){
	
	try {
		game theCrux = new game("C:/Users/William/Documents/workspace/TheCrux/src/logic/testGameFile.txt");
	} catch (FileNotFoundException e) {
		System.out.println("File path error.");
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
