package chess.board;


public class Board {
	private Square[][] chessBoard;
	private int m;
	private int n;
	
	public Board(int m, int n){
		this.setChessBoard(new Square[m][n]);
		this.m = m;
		this.n = n;
		
		initializeBoard();
	}
	
	private void initializeBoard(){
		for(int i=0; i < this.m; i++){
			for(int j=0; j < this.n; j++){
				this.chessBoard[i][j] = new Square();
			}
		}
	}

	public Square[][] getChessBoard() {
		return chessBoard;
	}

	public void setChessBoard(Square[][] chessBoard) {
		this.chessBoard = chessBoard;
	}
		
	public void printBoard(){
		for(int i=0;i < this.m;i++){
			System.out.print(i+1);
			System.out.print("|");
			for(int j=0;j < this.n;j++){
				System.out.print("_");				
				System.out.print("|");
			}
			System.out.println();
			if(i+1 >= this.m){
				for(int j=0;j < this.n; j++){
					if(j==0){
						System.out.print("  ");
					}else{
						System.out.print(" ");
					}
					System.out.print(j+1);					 
				}
			}
		}
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
}
