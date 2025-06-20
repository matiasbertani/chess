public class Bishop extends Piece {

    public Bishop(Color color) {
        super(color);
    }

    @Override
    public String getName() {
        return "Bishop";
    }

    @Override
    public String getSymbol() {
        return getColor() == Color.WHITE ? "♗" : "♝";
    }

    @Override
    public boolean isValidMove(Board board, Position currentPosition, Position targetPosition) {

        if (currentPosition.IsEqual(targetPosition))
            return false;

        if (!currentPosition.isOnSameDiagonal(targetPosition))
        return false;

        if (thereIsAFriendlyPieceInTargetPosition(targetPosition))
            return false;

        if (board.thereIsAnyPieceInTheDiagonalBetween(currentPosition, targetPosition))
            return false;

        return true;
    }

}
