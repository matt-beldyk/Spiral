package org.beldyk.spiral;

public class Spiral {
	protected Integer topValue;
	
	public Spiral(Integer num){
		topValue = num;
	}
	
	protected Integer [][] allocateBuffer(Integer maxVal){
		//1, 9, 25, 49... odd numbers squared
		Integer counter = 1;
		//TODO make this faster (ie ceil(sqrt(maxVal+1)) then be odd
		while(counter*counter < maxVal+1){
			// We are gonna work through odd numbers until we can allocate a buffer big enough
			
			counter += 2;  
		}
		Integer [][] buffer = new Integer[counter][counter];
		return buffer;
	}
	
	
	public String toString(){
		return null;
	}

}
