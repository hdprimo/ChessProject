package chess.board;

import chess.pieces.Piece;

public class Square {
	private Piece piece;
	
	public boolean isFree() {
		return piece == null;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}
}
