package tech.carlosestrada;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Arrays;

public class SimpleBoat {
	public static final String ON_HIT = "noice, you hit";
	public static final String ON_KILL = "oh fuck you kill't it";
	public static final String ON_MISS = "bruh you missed 💁‍";

	private ArrayList<String> locationCells;
	private boolean living;
	private int numOfHits;
	private String name = "shit";

	public SimpleBoat() {
		this.living = true;
	}

	public SimpleBoat(ArrayList<String> locationCells) {
		this.living = true;
		this.locationCells = locationCells;
	}

	public String checkYourself(String userGuess) {
		String result = "";

		for (String location :	locationCells) {
			if (location.equals(userGuess)) {
				numOfHits++;


				result = SimpleBoat.ON_HIT;
				locationCells.remove(userGuess);
				if(locationCells.isEmpty()){
					this.living = false;
					result = SimpleBoat.ON_KILL;
				}

				break;
			} else
				result = SimpleBoat.ON_MISS;
		}

		return result;
	}

	void setLocationCell(ArrayList<String> locationCells){
		this.locationCells = locationCells;
	}

	void setName(String name) {
		this.name = name;
	}

	boolean isLiving(){
		return this.living;
	}
}
