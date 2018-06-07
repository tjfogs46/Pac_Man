package payuc;

public class Tile {
	//denotes wall type for graphics
	private char kind;
	/**
	 * for pellet
	 * 0 = no pellet
	 * 1 = normal pellet
	 * 2 = power pellet
	 * 3=fruit
	 */
	private short pellet;
	private boolean passable;
	
	
	public Tile(char kind, short pellet, boolean passable){
		this.kind=kind;
		this.pellet=pellet;
		this.passable=passable;
	}
	
	/**
	 * the no-graphics constructor (sets kind of wall to null so that we can test
	 * @param pellet 0=empty; 1=normal pellet; 2 = super pellet; 3=fruit
	 * @param passable whether or not PAC-MAN can pass through the tile
	 */
	public Tile(short pellet, boolean passable){
		this.kind='\0';
		this.pellet=pellet;
		this.passable=passable;
	}


	public int getKind() {
		return kind;
	}


	/**
	 * @return short representing pellet type
	 * 0=empty
	 * 1=normal pellet
	 * 2=power pellet
	 * 3=fruit 
	 */
	public short getPellet() {
		return pellet;
	}


	public boolean isPassable() {
		return passable;
	}


	/**
	 * @param pellet
	 * 0=empty
	 * 1=normal pellet
	 * 2=power pellet
	 * 3=fruit
	 */
	public void setPellet(short pellet) {
		if(passable){
			this.pellet = pellet;
		}
	}
	
	
}
