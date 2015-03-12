package chess.pieces;

import java.util.ArrayList;
import java.util.List;

import chess.board.Board;
import chess.utils.Location;

public class King implements Piece {

	private Location position;
	
	@Override
	public boolean hasPiecesOnAllWays(Board board) {
		List<Location> moves = getMoves();
		for(Location move: moves){
			int toX = position.getX() + move.getX();
			int toY = position.getY() + move.getY();
			
			if(toX < board.getM() && toY < board.getN() && toX > -1 && toY > -1 && !board.getChessBoard()[toX][toY].isFree()){
				return true;
			}
		}
		return false;
	}
	
	private List<Location> getMoves(){
		List<Location> moves = new ArrayList<Location>();
		
		moves.add(new Location(-1,0));
		moves.add(new Location(1,0));
		moves.add(new Location(0,-1));
		moves.add(new Location(0,1));
		
		moves.add(new Location(1,1));
		moves.add(new Location(-1,-1));
		moves.add(new Location(-1,1));
		moves.add(new Location(1,-1));
		
		return moves;
	}

	@Override
	public Location getPosition() {
		return position;
	}

	public void setPosition(Location position) {
		this.position = position;
	}

}
