package org.beldyk.spiral.test;

import org.beldyk.spiral.Spiral;

public class SpiralInternalsTester extends Spiral {

	public SpiralInternalsTester(Integer num) {
		super(num);
	}
	
	@Override
	public Integer[][] allocateBuffer(Integer maxVal){
		return super.allocateBuffer(maxVal);
	}
	
	@Override
	public void populateBuffer(){
		super.populateBuffer();
	}
	

}
