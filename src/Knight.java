public class Knight extends Piece{
    Knight(PieceColor color,Position position){
        super(color,position);
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        if (newPosition.equals(this.position)) {
            return false;
        }
        int rowDiff = position.getRow() - newPosition.getRow();
        int colDiff = position.getColumn() - newPosition.getColumn();
        if(Math.abs(rowDiff)==2 && Math.abs(colDiff)==1 && (board[newPosition.getRow()][newPosition.getColumn()]==null || board[newPosition.getRow()][newPosition.getColumn()].color!=this.color)){
            return true;
        }
        else if(Math.abs(rowDiff)==1 && Math.abs(colDiff)==2 && (board[newPosition.getRow()][newPosition.getColumn()]==null || board[newPosition.getRow()][newPosition.getColumn()].color!=this.color)){
            return true;
        }
        return false;
    }
}