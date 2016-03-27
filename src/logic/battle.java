package logic;

import java.util.ArrayList;

public class battle {
private ArrayList<character> allies=new ArrayList<character>();
public ArrayList<character> getAllies() {
	return allies;
}

public void setAllies(ArrayList<character> allies) {
	this.allies = allies;
}

public ArrayList<enemy> getEnemies() {
	return enemies;
}

public void setEnemies(ArrayList<enemy> enemies) {
	this.enemies = enemies;
}

private ArrayList<enemy> enemies=new ArrayList<enemy>();

public battle(){
}


}
