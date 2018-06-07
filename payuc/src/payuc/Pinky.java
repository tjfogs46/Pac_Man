package payuc;

public class Pinky extends Ghost{
	
	/**
	 * basic constructor for a 
	 * @param x
	 * @param y
	 * @param direction
	 * @param speed
	 */
	public Pinky(int x, int y, short direction, double speed){
		this.x=x;
		this.y=y;
		this.direction=direction;
		this.speed=speed;
	}

	/* (non-Javadoc)
	 * @see payuc.Ghost#getTargetTile(short, int, int, int, int, boolean)
	 * pinky's target square is 4 ahead of PAC Man 
	 * (that's why there's a switch statement on direction. the direction MUST be PAC Man's)
	 */
	@Override
	protected int[] getTargetTile(short direction, int pacX, int pacY, int posX, int posY, boolean scatter) {
		int[] toReturn = {2,0};
		if(!scatter){
			switch (direction){
			case 0:
				if(toReturn[1]>3){
					toReturn[1]-=4;				
				}
				else{toReturn[1]=0;}
				break;
			case 1:
				toReturn[1]+=4;
				break;
			case 2:
				toReturn[0]-=4;
				break;
			case 3:
				toReturn[0]+=4;
				break;
			}
		}
		return toReturn;
	}

}
