package payuc;

public class Game {
	
	static Tile[][] gameBoard;
	
	public static void main(String[] args){
		
		gameBoard=createBoard();
		loop();
	}
	
	static void loop(){
		
	}
	
	/**
	 * @return the game board represented as a 2x2 grid of tiles
	 * google "pac man ghost logic" and click on the first link
	 * for the grid (you'll need to scroll down
	 * each tile is an 8x8 grid
	 */
	static Tile[][] createBoard(){
		//TODO
		Tile[][] toReturn= new Tile[28][36];
		
		//top 4 rows not passable
		for(int i=0;i<28;i++){
			for(int j=0;j<4;j++){
				toReturn[i][j]=new Tile((short)0,false);
			}
		}
		
		//bottom 3 rows not passable
		for(int i=0;i<28;i++){
			for(int j=33;j<36;j++){
				toReturn[i][j]=new Tile((short)0, false);
			}
		}
		
		return toReturn;
	}
}
