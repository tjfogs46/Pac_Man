package payuc;

public abstract class Ghost {
	int x;
	int y;
	short direction;
	double speed;
	
	/**
	 * method for calculating the target tile of a ghost
	 * @param direction the direction that pac man is facing
	 * @param pacX the x tile of pac man (not pixels, the grid tile)
	 * @param pacY the y tile of pac man
	 * @param posX the x tile of the ghost (or in certain circumstances, another ghost)
	 * @param posY the y tile of the ghost
	 * @param scatter whether scatter mode is activated
	 * @return an int array with the x and y positions of the tile. [x,y]
	 */
	protected abstract int[] getTargetTile(short direction, int pacX, int pacY, int posX, int posY, boolean scatter);
	
	/**
	 * calculates distance between two tiles
	 * @param tileX
	 * @param tileY
	 * @param targetX
	 * @param targetY
	 * @return
	 */
	public double getDistance(int tileX,int tileY, int targetX, int targetY){
		int xDist=targetX-tileX;
		int yDist=targetY-tileY;
		double toReturn= Math.sqrt(xDist*xDist+yDist*yDist);
		return toReturn;
	}
	
	public short getTurnDirection(Tile[][] board, int pacX, int pacY, short pacDirection, boolean scatter){
		int xTile=x/8;
		int yTile=y/8;
		
		double upDistance=99;
		double dwnDistance=99;
		double leftDistance=99;
		double rtDistance=99;
		
		int[] targetTile=getTargetTile(pacDirection,pacX, pacY,xTile,yTile, scatter);
		int targetX=targetTile[0];
		int targetY=targetTile[1];
		switch(direction){
		case 0: //code stub for up
			if(board[x][y+1].isPassable()){
				dwnDistance=getDistance(xTile,yTile+1,targetX,targetY);
			}
			if(board[x-1][y].isPassable()){
				leftDistance=getDistance(xTile-1,yTile,targetX,targetY);
			}
			if(board[x+1][y].isPassable()){
				rtDistance=getDistance(xTile+1,yTile,targetX,targetY);
			}
		break;
		case 1: // code stub for down
			if(board[x][y-1].isPassable()){
				upDistance=getDistance(xTile,yTile-1,targetX,targetY);
			}
			if(board[x-1][y].isPassable()){
				leftDistance=getDistance(xTile-1,yTile,targetX,targetY);
			}
			if(board[x+1][y].isPassable()){
				rtDistance=getDistance(xTile+1,yTile,targetX,targetY);
			}
		break;
		case 2: //code stub for left
			if(board[x][y+1].isPassable()){
				dwnDistance=getDistance(xTile,yTile+1,targetX,targetY);
			}
			if(board[x][y-1].isPassable()){
				upDistance=getDistance(xTile,yTile-1,targetX,targetY);
			}
			if(board[x+1][y].isPassable()){
				rtDistance=getDistance(xTile+1,yTile,targetX,targetY);
			}
		break;
		case 3: //stub for right
			if(board[x][y+1].isPassable()){
				dwnDistance=getDistance(xTile,yTile+1,targetX,targetY);
			}
			if(board[x-1][y].isPassable()){
				leftDistance=getDistance(xTile-1,yTile,targetX,targetY);
			}
			if(board[x][y-1].isPassable()){
				upDistance=getDistance(xTile,yTile-1,targetX,targetY);
			}
		break;
		default: throw new IllegalArgumentException();
		}
		if(upDistance<dwnDistance && upDistance<leftDistance && upDistance<rtDistance){
			return 0;
		}
		else if(dwnDistance<leftDistance && dwnDistance<rtDistance){
			return 1;
		}
		else if(leftDistance<rtDistance){
			return 2;
		}
		else{
			return 3;
		}
	}

	/**
	 * a getter for the x position (in pixels)
	 * @return the x position (in pixels)
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x position to be set, in pixels
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y position, in pixels
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y position, in pixels
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the ghost's direction
	 * 0=up
	 * 1=down
	 * 2=left
	 * 3=right
	 */
	public short getDirection() {
		return direction;
	}

	/**
	 * @param direction the direction the ghost is traveling
	 * 0=up
	 * 1=down
	 * 2=left
	 * 3=right
	 */
	public void setDirection(short direction) {
		this.direction = direction;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
}
