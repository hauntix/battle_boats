package tech.carlosestrada;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		int numOfGuesses = 0;

		SimpleBoat myBoat = new SimpleBoat();

		int random = (int) (Math.random() * 5);
		ArrayList<String> coords = new ArrayList<String>();
		coords.add(Integer.toString(random));
		coords.add(Integer.toString(random+1));
		coords.add(Integer.toString(random+2));

		myBoat.setLocationCell(coords);

		GameHelper gameHelper = new GameHelper();

		while(myBoat.isLiving()){
			String guess = gameHelper.getUserInput("enter a number ");
			String result = myBoat.checkYourself(guess);
			System.out.println(result);
			numOfGuesses++;
		}

		System.out.println("you took " + numOfGuesses + " guesses");
	}
}
