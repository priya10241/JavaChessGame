public class King extends Piece{
    King(PieceColor color,Position position){
        super(color,position);
    }
    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        int rowDiff = Math.abs(position.getRow() - newPosition.getRow());
        int colDiff = Math.abs(position.getColumn() - newPosition.getColumn());
        if((rowDiff > 1 || colDiff>1) || (rowDiff==0 && colDiff==0)){
            return false;
        }
        if(board[newPosition.getRow()][newPosition.getColumn()]==null){
            return true;
        }
        if(board[newPosition.getRow()][newPosition.getColumn()].color != this.color){
            return true;
        }
        return false;
    }
}