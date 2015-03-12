import org.junit.Assert;
import org.junit.Test;

import chess.board.Board;
import chess.board.Square;
import chess.pieces.Bishop;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Queen;
import chess.pieces.Rook;
import chess.utils.Location;


public class BoardTest {

	@Test
	public void printBoardTest(){
		Board chessBoard = new Board(7, 7);
		
		chessBoard.printBoard();
	}
	
	@Test
	public void bishopMoveFindPieceOnWay(){
		Board board = new Board(7, 7);
		Square square = new Square();
		Bishop bishop = new Bishop();
		bishop.setPosition(new Location(3, 3));

		square.setPiece(new Bishop());

		//upRigth
		board.getChessBoard()[6][6]=square; 
		Assert.assertTrue(bishop.hasPiecesOnAllWays(board));
		
		//downLeft
		board.getChessBoard()[6][6]=new Square(); 
		board.getChessBoard()[0][0]=square;
		Assert.assertTrue(bishop.hasPiecesOnAllWays(board));
		
		//upLeft
		board.getChessBoard()[0][0]=new Square(); 
		board.getChessBoard()[0][6]=square;
		Assert.assertTrue(bishop.hasPiecesOnAllWays(board));

		//downRigth
		board.getChessBoard()[0][6]=new Square(); 
		board.getChessBoard()[6][0]=square;
		Assert.assertTrue(bishop.hasPiecesOnAllWays(board));

	}
	
	@Test
	public void bishopMoveNotFindPieceOnWay(){
		Board board = new Board(7, 7);
		
		Bishop bishop = new Bishop();
		bishop.setPosition(new Location(3, 3));
		
		Assert.assertFalse(bishop.hasPiecesOnAllWays(board));
	}
	

	@Test
	public void kingMoveNotFindPieceOnWay(){
		Board board = new Board(7, 7);
		King king = new King();
		king.setPosition(new Location(0, 0));
		
		Assert.assertFalse(king.hasPiecesOnAllWays(board));
	}

	@Test
	public void kingMoveFindPieceOnWay(){
		Board board = new Board(7, 7);
		Square square = new Square();
		square.setPiece(new Bishop());
		
		King king = new King();
		king.setPosition(new Location(3, 3));
		
		//down
		board.getChessBoard()[3][2]=square;		
		Assert.assertTrue(king.hasPiecesOnAllWays(board));

		//up
		board.getChessBoard()[3][2]=new Square();
		board.getChessBoard()[3][4]=square;		
		Assert.assertTrue(king.hasPiecesOnAllWays(board));

		//left
		board.getChessBoard()[3][4]=new Square();
		board.getChessBoard()[2][3]=square;		
		Assert.assertTrue(king.hasPiecesOnAllWays(board));

		//rigth
		board.getChessBoard()[2][3]=new Square();
		board.getChessBoard()[4][3]=square;		
		Assert.assertTrue(king.hasPiecesOnAllWays(board));

		//downLeft
		board.getChessBoard()[4][3]=new Square();
		board.getChessBoard()[2][2]=square;
		Assert.assertTrue(king.hasPiecesOnAllWays(board));
				
		//downRigth
		board.getChessBoard()[2][2]=new Square();
		board.getChessBoard()[4][2]=square;
		Assert.assertTrue(king.hasPiecesOnAllWays(board));

		//upRigth
		board.getChessBoard()[4][2]=new Square();
		board.getChessBoard()[4][4]=square;
		Assert.assertTrue(king.hasPiecesOnAllWays(board));
		
		//upLeft
		board.getChessBoard()[4][4]=new Square();
		board.getChessBoard()[2][4]=square;
		Assert.assertTrue(king.hasPiecesOnAllWays(board));

	}

	@Test
	public void queenMoveFindPieceOnWay(){
		Board board = new Board(7, 7);
		Square square = new Square();
		square.setPiece(new Bishop());
		
		Queen queen = new Queen();
		queen.setPosition(new Location(3, 3));
		
		//down
		board.getChessBoard()[3][0]=square;		
		Assert.assertTrue(queen.hasPiecesOnAllWays(board));

		//up
		board.getChessBoard()[3][0]=new Square();
		board.getChessBoard()[3][6]=square;		
		Assert.assertTrue(queen.hasPiecesOnAllWays(board));

		//left
		board.getChessBoard()[3][6]=new Square();
		board.getChessBoard()[0][3]=square;		
		Assert.assertTrue(queen.hasPiecesOnAllWays(board));

		//rigth
		board.getChessBoard()[0][3]=new Square();
		board.getChessBoard()[6][3]=square;		
		Assert.assertTrue(queen.hasPiecesOnAllWays(board));

		//downLeft
		board.getChessBoard()[6][3]=new Square();
		board.getChessBoard()[0][0]=square;
		Assert.assertTrue(queen.hasPiecesOnAllWays(board));
				
		//downRigth
		board.getChessBoard()[0][0]=new Square();
		board.getChessBoard()[6][0]=square;
		Assert.assertTrue(queen.hasPiecesOnAllWays(board));

		//upRigth
		board.getChessBoard()[6][0]=new Square();
		board.getChessBoard()[6][6]=square;
		Assert.assertTrue(queen.hasPiecesOnAllWays(board));
		
		//upLeft
		board.getChessBoard()[6][6]=new Square();
		board.getChessBoard()[0][6]=square;
		Assert.assertTrue(queen.hasPiecesOnAllWays(board));

	}
	
	@Test
	public void queenMoveNotFindPieceOnWay(){
		Board board = new Board(7, 7);
		Queen queen = new Queen();
		queen.setPosition(new Location(3, 3));
		
		Assert.assertFalse(queen.hasPiecesOnAllWays(board));
	}

	@Test
	public void rookMoveFindPieceOnWay(){
		Board board = new Board(7, 7);
		Square square = new Square();
		square.setPiece(new Bishop());
		
		Rook rook = new Rook();
		rook.setPosition(new Location(3, 3));
		
		//down
		board.getChessBoard()[3][0]=square;		
		Assert.assertTrue(rook.hasPiecesOnAllWays(board));

		//up
		board.getChessBoard()[3][0]=new Square();
		board.getChessBoard()[3][6]=square;		
		Assert.assertTrue(rook.hasPiecesOnAllWays(board));

		//left
		board.getChessBoard()[3][6]=new Square();
		board.getChessBoard()[0][3]=square;		
		Assert.assertTrue(rook.hasPiecesOnAllWays(board));

		//rigth
		board.getChessBoard()[0][3]=new Square();
		board.getChessBoard()[6][3]=square;		
		Assert.assertTrue(rook.hasPiecesOnAllWays(board));
	}
	
	@Test
	public void rookMoveNotFindPieceOnWay(){
		Board board = new Board(7, 7);
		Rook rook = new Rook();
		rook.setPosition(new Location(3, 3));
		
		Assert.assertFalse(rook.hasPiecesOnAllWays(board));
	}
	
	
	@Test
	public void knightMoveFindPieceOnWay(){
		Board board = new Board(7, 7);
		Square square = new Square();
		square.setPiece(new Bishop());
		
		Knight knight = new Knight();
		knight.setPosition(new Location(3, 3));
				
		board.getChessBoard()[1][4]=square;		
		Assert.assertTrue(knight.hasPiecesOnAllWays(board));

		board.getChessBoard()[1][4]=new Square();
		board.getChessBoard()[1][2]=square;		
		Assert.assertTrue(knight.hasPiecesOnAllWays(board));

		board.getChessBoard()[1][2]=new Square();
		board.getChessBoard()[2][1]=square;		
		Assert.assertTrue(knight.hasPiecesOnAllWays(board));

		board.getChessBoard()[2][1]=new Square();
		board.getChessBoard()[2][5]=square;		
		Assert.assertTrue(knight.hasPiecesOnAllWays(board));

		board.getChessBoard()[2][5]=new Square();
		board.getChessBoard()[4][5]=square;
		Assert.assertTrue(knight.hasPiecesOnAllWays(board));
				
		board.getChessBoard()[4][5]=new Square();
		board.getChessBoard()[4][1]=square;
		Assert.assertTrue(knight.hasPiecesOnAllWays(board));

		board.getChessBoard()[4][1]=new Square();
		board.getChessBoard()[5][2]=square;
		Assert.assertTrue(knight.hasPiecesOnAllWays(board));
		
		board.getChessBoard()[5][2]=new Square();
		board.getChessBoard()[5][4]=square;
		Assert.assertTrue(knight.hasPiecesOnAllWays(board));
		
		knight.setPosition(new Location(1, 0));
		board.getChessBoard()[5][4]=new Square();
		board.getChessBoard()[0][2]=square;
		Assert.assertTrue(knight.hasPiecesOnAllWays(board));
	}
	
	@Test
	public void knightMoveNotFindPieceOnWay(){
		Board board = new Board(7, 7);
		Knight knight = new Knight();
		knight.setPosition(new Location(1, 0));
		
		Assert.assertFalse(knight.hasPiecesOnAllWays(board));
	}	

}
