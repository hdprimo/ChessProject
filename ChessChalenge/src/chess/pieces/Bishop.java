package chess.pieces;

import java.util.ArrayList;
import java.util.List;

import chess.board.Board;
import chess.utils.Location;

public class Bishop implements Piece {

	private Location position;
	
	@Override
	public boolean hasPiecesOnAllWays(Board board) {
		List<Location> moves = getMoves();
		
		for(Location move: moves){
			if(hasPiecesOnWay(new Location(position.getX() + move.getX(), position.getY() + move.getY()), board, move)){
				return true;
			}
		}
		
		return false;
	}

	private List<Location> getMoves(){
		List<Location> moves = new ArrayList<Location>();
		moves.add(new Location(1, 1));
		moves.add(new Location(1, -1));
		moves.add(new Location(-1,1));
		moves.add(new Location (-1,-1));
		
		return moves;
	}

	private boolean hasPiecesOnWay(Location to, Board board, Location move) {
		if((to.getX() < board.getM() && to.getY() < board.getN()) && (to.getX() > -1 && to.getY() > -1)){
			
			if((Math.abs(position.getX() - to.getX()) == Math.abs(position.getY() - to.getY())) && !board.getChessBoard()[to.getX()][to.getY()].isFree()){
				System.out.println("To X:" + (to.getX()+1) + "; To Y:" + (to.getY()+1));
				System.out.println("Not free");
				return true;
			}else{
				System.out.println("To X:" + (to.getX()+1) + "; To Y:" + (to.getY()+1));
				System.out.println("free");
				to.setX(to.getX() + move.getX());
				to.setY(to.getY() + move.getY());				
				return hasPiecesOnWay(to,board,move);
			}
		}
		
		return false;
	}

	@Override
	public Location getPosition() {
		return position;
	}

	public void setPosition(Location position) {
		this.position = position;
	}

}
