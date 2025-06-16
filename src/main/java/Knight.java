public class Knight extends Piece {

    public Knight(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Board board, Position currentPosition, Position targetPosition) {

        if (currentPosition.IsEqual(targetPosition))
            return false;

        if (thereIsAFriendlyPieceInTargetPosition(targetPosition))
            return false;
        
        if (!movesInLShape(currentPosition, targetPosition)) {
            return false;
        }

        return true;
    }

    private boolean movesInLShape(Position currentPosition, Position targetPosition) {
        // Knight moves in an "L" shape: two positions in one direction and one position perpendicular
        int rowDiff = Math.abs(currentPosition.getRow() - targetPosition.getRow());
        int colDiff = Math.abs(currentPosition.getColumn() - targetPosition.getColumn());
        return (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);
    }
}
