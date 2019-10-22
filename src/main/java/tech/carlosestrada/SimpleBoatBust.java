package tech.carlosestrada;

import java.util.ArrayList;

public class SimpleBoatBust {
	GameHelper helper = new GameHelper();
	ArrayList<SimpleBoat> simpleBoatList = new ArrayList<SimpleBoat>();
	int numOfGuesses = 0;

	void setUpGame() {
		SimpleBoat one = new SimpleBoat();
		one.setName("Sea Plus Plus");

		SimpleBoat two = new SimpleBoat();
		two.setName("Sea Taxi");

		SimpleBoat three = new SimpleBoat();
		three.setName("DiAbLo");

		simpleBoatList.add(one);
		simpleBoatList.add(two);
		simpleBoatList.add(three);

		System.out.println(
				"Your goal is to sink three boats.\n" +
				"Sea Plus Plus, Sea Taxi, Diablo\n" +
				"Try to sink them all in the fewest number of guesses");

		for (SimpleBoat boat : simpleBoatList) {
			ArrayList<String> newLocation = helper.placeBoat(3);
			boat.setLocationCell(newLocation);
		}
	}

	private void startPlaying() {
		while(!simpleBoatList.isEmpty()) {
			String userGuess = helper.getUserInput("Enter a guess");
			checkUserGuess(userGuess);
		}
		finishGame();
	}

	private void checkUserGuess(String userGuess) {
		String result = "";
		numOfGuesses++;

		for (SimpleBoat boat : simpleBoatList) {
			result = boat.checkYourself(userGuess);

			if (result.equals(SimpleBoat.ON_HIT))
				break;

			if (result.equals(SimpleBoat.ON_KILL)){
				simpleBoatList.remove(boat);
				break;
			}
		}

		System.out.println(result);
	}

	private void finishGame() {
		System.out.println("All boats are dead! Your stock is now worthless.");

		if (numOfGuesses <= 18) {
			System.out.println("It only took you " + numOfGuesses + " guesses.");
			System.out.println(" You got out before your options sank.");
		} else {
			System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
			System.out.println("Fish are dancing with your options.");
		}
	}

	public static void main(String[] args) {
		SimpleBoatBust game = new SimpleBoatBust();

		game.setUpGame();
		game.startPlaying();
	}
}
