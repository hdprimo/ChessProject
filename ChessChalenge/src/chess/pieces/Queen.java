package chess.pieces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import chess.board.Board;
import chess.board.Square;
import chess.utils.Location;

public class Queen implements Piece {
	
	private Location position;

	@Override
	public boolean hasPiecesOnAllWays(Board board) {
		Map<String, List<Location>> allMoves = getMoves();
		
		for(String key :allMoves.keySet()){
			List<Location> moves = allMoves.get(key);
			
			if(VERTICAL_HORIZONTAL_MOVES.equals(key)){
				for(Location move:moves){
					if(hasVerticalHorizontalPiecesOnWay(new Location(position.getX() + move.getX(), position.getY() + move.getY()), board, move)){
						return true;
					}
				}
			}else if(DIAGONAL_MOVES.equals(key)){			
				for(Location move: moves){
					if(hasDiagonalMovePiecesOnWay(new Location(position.getX() + move.getX(), position.getY() + move.getY()), board, move)){
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public Location getPosition() {
		return position;
	}
	
	public void setPosition(Location position){
		this.position = position;
	}

	@Override
	public Collection<Square> getPossibleMoves(Board board) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Map<String, List<Location>> getMoves(){
		Map<String, List<Location>> result = new HashMap<String, List<Location>>();
		List<Location> moves = new ArrayList<Location>();

		moves.add(new Location(-1,0));
		moves.add(new Location(1,0));
		moves.add(new Location(0,-1));
		moves.add(new Location(0,1));		
		
		result.put(VERTICAL_HORIZONTAL_MOVES, moves);
		
		moves = new ArrayList<Location>();
		moves.add(new Location(1,1));
		moves.add(new Location(-1,-1));
		moves.add(new Location(-1,1));
		moves.add(new Location(1,-1));
		
		result.put(DIAGONAL_MOVES, moves);
		
		return result;
	}
	
	private boolean hasDiagonalMovePiecesOnWay(Location to, Board board, Location move) {
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
				return hasDiagonalMovePiecesOnWay(to,board,move);
			}
		}
		
		return false;
	}

	private boolean hasVerticalHorizontalPiecesOnWay(Location to, Board board, Location move) {
		if((to.getX() < board.getM() && to.getY() < board.getN()) && (to.getX() > -1 && to.getY() > -1)){
			
			//Vertical
			if(position.getX() == to.getX() && position.getY() != to.getY()){
				if(!board.getChessBoard()[to.getX()][to.getY()].isFree()){
					System.out.println("Vertical To X:" + (to.getX()+1) + "; To Y:" + (to.getY()+1));
					System.out.println("Not free");
					return true;
				}else{
					System.out.println("Vertical To X:" + (to.getX()+1) + "; To Y:" + (to.getY()+1));
					System.out.println("free");
					
					to.setY(to.getY() + move.getY());
					return hasVerticalHorizontalPiecesOnWay(to,board,move);
				}
			//Horizontal
			}else if(position.getX() != to.getX() && position.getY() == to.getY()){
				if(!board.getChessBoard()[to.getX()][to.getY()].isFree()){
					System.out.println("Horizontal To X:" + (to.getX()+1) + "; To Y:" + (to.getY()+1));
					System.out.println("Not free");
					
					return true;
				}else{
					System.out.println("Horizontal To X:" + (to.getX()+1) + "; To Y:" + (to.getY()+1));
					System.out.println("free");
					
					to.setX(to.getX() + move.getX());				
					return hasVerticalHorizontalPiecesOnWay(to,board,move);
				}
			}
		}
		
		return false;
	}

}
