public class Rook extends Piece{
    Rook(PieceColor color,Position position) {
        super(color, position);
    }
    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        int forwardDirection = color==PieceColor.WHITE?-1:1;
        int rowDiff = (position.getRow() - newPosition.getRow()) * forwardDirection;
        int colDiff = (position.getColumn() - newPosition.getColumn());
        if(rowDiff == 0){
            if(colDiff>0){
                int flag = 0;
                for(int i= position.getColumn()+1;i< newPosition.getColumn();i++){
                    if(board[position.getRow()][i]!=null){
                        flag = 1;
                    }
                }
                if(flag==0 && (board[newPosition.getRow()][newPosition.getColumn()]==null || board[newPosition.getRow()][newPosition.getColumn()].color!=this.color)){
                    return true;
                }
            }
            else{
                int flag = 0;
                for(int i= position.getColumn()-1;i> newPosition.getColumn();i--){
                    if(board[position.getRow()][i]!=null){
                        flag = 1;
                    }
                }
                if(flag==0 && (board[newPosition.getRow()][newPosition.getColumn()]==null || board[newPosition.getRow()][newPosition.getColumn()].color!=this.color)){
                    return true;
                }
            }
        }
        if(colDiff == 0){
            if(rowDiff>0){
                int flag = 0;
                for(int i= position.getRow()+1;i< newPosition.getRow();i++){
                    if(board[i][position.getColumn()]!=null){
                        flag = 1;
                    }
                }
                if(flag==0 && (board[newPosition.getRow()][newPosition.getColumn()]==null || board[newPosition.getRow()][newPosition.getColumn()].color!=this.color)){
                    return true;
                }
            }
            else{
                int flag = 0;
                for(int i= position.getRow()-1;i> newPosition.getRow();i--){
                    if(board[i][position.getColumn()]!=null){
                        flag = 1;
                    }
                }
                if(flag==0 && (board[newPosition.getRow()][newPosition.getColumn()]==null || board[newPosition.getRow()][newPosition.getColumn()].color!=this.color)){
                    return true;
                }
            }
        }
        return false;
    }
}