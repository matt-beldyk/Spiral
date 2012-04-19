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
	
	@Test public void zeroCase() {
		Spiral spiral = new Spiral(0);
		String targetResult = "0";
		String resultFromCode = spiral.toString();
		assertEquals(targetResult, resultFromCode);
		
	}
	
	@Test public void allocateBuffer0() {
		SpiralInternalsTester spiral = new SpiralInternalsTester(0);
		Integer [][] buffer = spiral.allocateBuffer(0);
		assertEquals(1, buffer.length);
		assertEquals(1, buffer[0].length);
	}
	@Test public void allocateBuffer1() {
		SpiralInternalsTester spiral = new SpiralInternalsTester(1);
		Integer [][] buffer = spiral.allocateBuffer(1);
		assertEquals(3, buffer.length);
		assertEquals(3, buffer[0].length);
	}
	@Test public void allocateBuffer24() {
		SpiralInternalsTester spiral = new SpiralInternalsTester(24);
		Integer [][] buffer = spiral.allocateBuffer(24);
		assertEquals(5, buffer.length);
		assertEquals(5, buffer[0].length);
	}
	
}
