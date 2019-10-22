package tech.carlosestrada;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;


public class SimpleBoatTest {

	@Test
	public void simpleBoatTest() {
		SimpleBoat boat = new SimpleBoat();

		ArrayList<String> coords = new ArrayList<String>();
		coords.add(Integer.toString(3));
		coords.add(Integer.toString(4));
		coords.add(Integer.toString(5));
		boat.setLocationCell(coords);

		String userGuess = "3";
		String actual = boat.checkYourself(userGuess);

		String expected = SimpleBoat.ON_HIT;

		Assert.assertEquals(expected, actual);

		userGuess = "1";
		actual = boat.checkYourself(userGuess);

		expected = SimpleBoat.ON_MISS;

		Assert.assertEquals(expected, actual);
	}

}
