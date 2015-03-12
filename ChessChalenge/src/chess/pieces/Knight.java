package chess.pieces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import chess.board.Board;
import chess.board.Square;
import chess.utils.Location;

public class Knight implements Piece {
	
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
		
		moves.add(new Location(-2,1));
		moves.add(new Location(-2,-1));
		
		moves.add(new Location(2,1));
		moves.add(new Location(2,-1));
		
		moves.add(new Location(-1,2));
		moves.add(new Location(1,2));
		
		moves.add(new Location(-1,-2));
		moves.add(new Location(1,-2));
		
		return moves;
	}
	
	@Override
	public Location getPosition() {
		return position;
	}

	@Override
	public Collection<Square> getPossibleMoves(Board board) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPosition(Location position) {
		this.position = position;
	}

}
