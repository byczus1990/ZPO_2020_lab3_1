package testing;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import main.SbGetLevenshteinDistance;

public class SbGetLevenshteinDistanceTest {

	@Test
	public void testGetLevDist() {
		Assert.assertEquals(2, SbGetLevenshteinDistance.getLevDist("cat", "cor"));
		Assert.assertNotEquals(2, SbGetLevenshteinDistance.getLevDist("cat", "car"));
	}

}
