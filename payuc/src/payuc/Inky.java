package payuc;

/**
 * @author tjfogarty
 * THE RED GHOST, INKY
 */
public class Inky extends Ghost{

	/**
	 * basic constructor for a 
	 * @param x
	 * @param y
	 * @param direction
	 * @param speed
	 */
	public Inky(int x, int y, short direction, double speed){
		this.x=x;
		this.y=y;
		this.direction=direction;
		this.speed=speed;
	}
	
	
	/* (non-Javadoc)
	 * @see payuc.Ghost#getTargetTile(short, int, int, int, int, boolean)
	 * his target is just pacX, pacY
	 */
	@Override
	protected int[] getTargetTile(short direction, int pacX, int pacY, int posX, int posY, boolean scatter) {
		int[] toReturn = new int[2];
		if(scatter){
			toReturn[0]=25;
			toReturn[1]=0;
		}
		else{
			toReturn[0]=pacX;
			toReturn[1]=pacY;
		}
		return toReturn;
	}

}
