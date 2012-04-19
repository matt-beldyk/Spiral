package org.beldyk.spiral;

public class Spiral {
	protected Integer topValue;
	protected Integer[][] buffer;

	public enum ClockwiseDirection{
		Right, Down, Left, Up;
	}


	public Spiral(Integer num){
		topValue = num;
		buffer = allocateBuffer(topValue);
	}

	protected void populateBuffer(){
		Integer centerX = buffer.length/2;
		Integer centerY = buffer.length/2;

		System.out.println( "centerX: "+centerX+", centerY: "+centerY);
		buffer[centerX][centerY] = 0;
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
			System.out.println( unpaddedBufferToString());
		}

	}
	protected String unpaddedBufferToString(){
		StringBuilder sb = new StringBuilder();
		for( int x = 0; x < buffer.length; x++){
			for( int y = 0; y <buffer.length; y++){

				sb.append(buffer[x][y] + "\t");
			}
			sb.append("\n");
		}
		return sb.toString();
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
