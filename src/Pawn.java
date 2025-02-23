public class Pawn extends Piece{
    public Pawn(PieceColor color,Position position){
        super(color,position);
    }
    @Override
    public boolean isValidMove(Position newPosition,Piece[][] board){
        int forwardDirection = color==PieceColor.WHITE?-1:1;
        int rowDiff = (newPosition.getRow() - position.getRow()) * forwardDirection;
        int colDiff = (newPosition.getColumn() - position.getColumn());
        if(rowDiff == 1 && colDiff ==0 && board[newPosition.getRow()][newPosition.getColumn()]==null){
            return true;
        }
        boolean isStartingPosition = (position.getRow() == 6 && color==PieceColor.WHITE) || (position.getRow()==1 && color == PieceColor.BLACK);
        if(rowDiff == 2 && colDiff ==0 && board[newPosition.getRow()][newPosition.getColumn()]==null && isStartingPosition){
            int middlerow = (position.getRow() + newPosition.getRow())/2;
            if(board[middlerow][position.getColumn()]==null){
                return true;
            }
        }
        if(rowDiff == 1 && Math.abs(colDiff) ==1){
            PieceColor p = board[newPosition.getRow()][newPosition.getColumn()].getColor();
            if(color != p){
                return true;
            }
        }
        return false;
    }
}