package testing;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import main.SbJsonOperations;

public class SbJsonOperationsTest {
	
	private 	SbJsonOperations jsonOperations = new SbJsonOperations();

	@Test
	public void testCreatePool() {		
		Assert.assertTrue(jsonOperations.getMap().isEmpty());
		Assert.assertTrue(jsonOperations.getMapForCalculation().isEmpty());	
		}

	@Test
	public void testLoadMapFromJson() {		
		Assert.assertTrue(jsonOperations.loadMapFromJson());
	}

	@Test
	public void testGetRandomQuestionList() {		
		Assert.assertTrue(jsonOperations.getOutputList().isEmpty());	
	}

	@Test
	public void testSetAnswer1() {
		jsonOperations.setAnswer1("cat");
		Assert.assertEquals("cat",jsonOperations.getAnswer1());
	}

	@Test
	public void testSetAnswer2() {
		jsonOperations.setAnswer2("cat");
		Assert.assertEquals("cat",jsonOperations.getAnswer2());
	}

	@Test
	public void testSetAnswer3() {
		jsonOperations.setAnswer3("cat");
		Assert.assertEquals("cat",jsonOperations.getAnswer3());
	}

	@Test
	public void testSetAnswer4() {
		jsonOperations.setAnswer4("cat");
		Assert.assertEquals("cat",jsonOperations.getAnswer4());
	}

	@Test
	public void testSetAnswer5() {
		jsonOperations.setAnswer5("cat");
		Assert.assertEquals("cat",jsonOperations.getAnswer5());
	}

	@Test
	public void testSetName() {
		jsonOperations.setName("cat");
		Assert.assertEquals("cat",jsonOperations.getName());
	}

	@Test
	public void testSetSurrname() {
		jsonOperations.setSurrname("cat");
		Assert.assertEquals("cat",jsonOperations.getSurrname());
	}

}
