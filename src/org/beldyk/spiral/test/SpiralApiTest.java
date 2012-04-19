package org.beldyk.spiral.test;

import static org.junit.Assert.*;
import org.beldyk.spiral.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SpiralApiTest {

	Spiral spiral; 

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test public void exampleFromAssignemnt() {
		Spiral spiral = new Spiral(24);
		String targetResult = 
						"20 21 22 23 24\n" +
						"19  6  7  8  9\n"+
						"18  5  0  1 10\n"+
						"17  4  3  2 11\n"+
						"16 15 14 13 12";
		String resultFromCode = spiral.toString();
		assertEquals(targetResult, resultFromCode);

	}

	@Test public void spiral23() {
		Spiral spiral = new Spiral(23);
		String targetResult = 
						"20 21 22 23   \n" +
						"19  6  7  8  9\n"+
						"18  5  0  1 10\n"+
						"17  4  3  2 11\n"+
						"16 15 14 13 12";
		String resultFromCode = spiral.toString();
		assertEquals(targetResult, resultFromCode);

	}
	@Test public void negativeSpiral() {
		try {
			Spiral spiral = new Spiral(-57);
			fail("Should throw an runtime exception on negative values");
			System.out.println(spiral); //Should never run except before this error case is handled

		}catch(RuntimeException e){
			assertEquals("Negative input value results undefined", e.getMessage());
		}
	}
	@Test public void PopulatedCheck() {
		SpiralInternalsTester spiral = new SpiralInternalsTester(42);
		assertEquals(true, spiral.getAlreadyHavePopulated());

	}

	@Test public void PopulatedCheckBadEnd() {
		SpiralInternalsTester spiral = new SpiralInternalsTester(42);
		assertEquals(true, spiral.getAlreadyHavePopulated());
		try {
			spiral.populateBuffer();
			fail("Should have caught a runtime exception");
		}catch(RuntimeException e){
			assertEquals("Cannot reuse object to repopulate a new buffer",e.getMessage());
		}


	}
	@Test public void zeroCase() {
		Spiral spiral = new Spiral(0);
		String targetResult = "0";
		String resultFromCode = spiral.toString();
		assertEquals(targetResult, resultFromCode);

	}

	@Test public void allocateBuffer0() {
		SpiralInternalsTester spiral = new SpiralInternalsTester(0);
		spiral.setAlreadyHavePopulated(false); //supressing runtime exceptions
		Integer [][] buffer = spiral.allocateBuffer(0);
		assertEquals(1, buffer.length);
		assertEquals(1, buffer[0].length);
	}
	@Test public void allocateBuffer1() {
		SpiralInternalsTester spiral = new SpiralInternalsTester(1);
		spiral.setAlreadyHavePopulated(false); //supressing runtime exceptions

		Integer [][] buffer = spiral.allocateBuffer(1);
		assertEquals(3, buffer.length);
		assertEquals(3, buffer[0].length);
	}
	@Test public void allocateBuffer24() {
		SpiralInternalsTester spiral = new SpiralInternalsTester(24);
		spiral.setAlreadyHavePopulated(false); //supressing runtime exceptions

		Integer [][] buffer = spiral.allocateBuffer(24);
		assertEquals(5, buffer.length);
		assertEquals(5, buffer[0].length);
	}

}
