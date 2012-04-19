package org.beldyk.spiral;

public class Spiral {
	protected final Integer topValue;
	protected Integer[][] buffer;
	protected Boolean haveAlreadyPopulated;


	//  Directions to remember our logic of working around the spiral
	public enum ClockwiseDirection{
		Right, Down, Left, Up;
	}


	public Spiral(Integer num){
		topValue = num;
		this.haveAlreadyPopulated = false;
		this.checkSanity();
		
		buffer = allocateBuffer(topValue);
		this.populateBuffer();
		this.haveAlreadyPopulated = true;
	}

	/**
	 * This code makes sure that the input to this class is sane before attempting to do work
	 * 
	 */
	protected void checkSanity(){
		if (topValue < 0){
			throw new RuntimeException("Negative input value results undefined");
		}
	}

	@Override public String toString(){
		return this.bufferToString();
	}

	/**
	 * This function will fill the pre-allocated buffer with a spiral of numbers
	 */
	protected void populateBuffer(){

		if( this.haveAlreadyPopulated){
			throw new RuntimeException("Cannot reuse object to repopulate a new buffer");
		}

		//  Find the center of the buffer
		Integer centerX = buffer.length/2;
		Integer centerY = buffer.length/2;

		// Start our counting at zero as in the example
		buffer[centerX][centerY] = 0;

		// Yes, row major/minor order looks mixed up here (Just imagine you are laying on your right 
		// side looking at the buffer )
		ClockwiseDirection dir = ClockwiseDirection.Up;
		Integer x = centerX;
		Integer y = centerY;
		Integer counter = 1;
		while(counter <= topValue){
			if (dir == ClockwiseDirection.Right){
				x += 1;
				if (buffer[x][y-1] == null){
					dir = ClockwiseDirection.Down;
				}
			} else if (dir == ClockwiseDirection.Down){
				y -= 1;
				if (buffer[x-1][y] == null){
					dir = ClockwiseDirection.Left;
				}
			} else if (dir == ClockwiseDirection.Left){
				x -= 1;
				if (buffer[x][y+1] == null){
					dir = ClockwiseDirection.Up;
				}
			} else if (dir == ClockwiseDirection.Up){
				y += 1;
				if (buffer[x+1][y] == null){
					dir = ClockwiseDirection.Right;
				}
			}else{
				throw new RuntimeException("I've lost all hope of having directions, perhaps there is a third dimension");
			}

			buffer[x][y] = counter;
			counter += 1;
			//System.out.println( bufferToString());
		}

	}

	/**
	 * translates the buffer into a pretty printed String ified
	 * spiral.  This adds the minimal amount of white space padding it
	 * can get away with
	 * 
	 * @return
	 */
	protected String bufferToString(){
		StringBuilder sb = new StringBuilder();
		for( int x = 0; x < buffer.length; x++){
			for( int y = 0; y <buffer.length; y++){

				sb.append(padInt(buffer[x][y]));

				// no extra spaces at the end of the line
				if(y < buffer.length - 1){
					sb.append(" ");
				}
			}
			// no extra new line at the end of the output
			if (x < buffer.length - 1){
				sb.append("\n");
			}
		}
		return sb.toString();
	}

	/**
	 * allocates a buffer that will eventually be filled with a spiral of numbers
	 * 
	 * @param maxVal
	 * @return
	 */
	protected Integer [][] allocateBuffer(Integer maxVal){

		if( this.haveAlreadyPopulated){
			throw new RuntimeException("Cannot reuse object to repopulate a new buffer");
		}

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

	/**
	 * Returns a string that is left space padded based on the biggest value
	 * this particular spiral will see
	 * 
	 * @param num
	 * @return
	 */
	protected String padInt(Integer num){
		Integer paddingWidth = this.topValue.toString().length();
		if ( num == null){
			return String.format("%"+paddingWidth+"s", ""); 
		} else {
			return String.format("%"+paddingWidth+"s", num);
		}
	}



}
