package org.beldyk.spiral.test;

import org.beldyk.spiral.Spiral;


/**
 * this class just extends Spiral to get access to the internal 
 * for purposes of testing without exposing the internal info
 * into the regular API.
 * @author beldyk
 *
 */
public class SpiralInternalsTester extends Spiral {

	public SpiralInternalsTester(Integer num) {
		super(num);
	}
	
	public Boolean getAlreadyHavePopulated(){
		return super.haveAlreadyPopulated;
	}
	
	public void setAlreadyHavePopulated(Boolean havePop){
		super.haveAlreadyPopulated = havePop;
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
