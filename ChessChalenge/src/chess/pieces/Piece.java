package chess.pieces;

import java.util.Collection;

import chess.board.Board;
import chess.board.Square;
import chess.utils.Location;

public interface Piece {
	static final String VERTICAL_HORIZONTAL_MOVES ="VERTICALHORIZONTALMOVES";
	static final String DIAGONAL_MOVES = "DIAGONALMOVES";
	
	boolean hasPiecesOnAllWays(Board board);
	Location getPosition();
	Collection<Square> getPossibleMoves(Board board);
}
