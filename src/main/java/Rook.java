public class Rook extends Piece {

    public Rook(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Board board, Position currentPosition, Position targetPosition) {

        if (currentPosition.IsEqual(targetPosition))
            return false;

        if (!currentPosition.isOnSameRow(targetPosition) && !currentPosition.isOnSameColum(targetPosition))
            return false;

        if (thereIsAFriendlyPieceInTargetPosition(targetPosition))
            return false;

        if (board.thereIsAnyPieceInTheStraightBetween(currentPosition, targetPosition))
            return false;

        return true;
    }
}
