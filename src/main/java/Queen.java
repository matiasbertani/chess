public class Queen extends Piece {

    public Queen(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Board board, Position currentPosition, Position targetPosition) {

        if (currentPosition.IsEqual(targetPosition))
            return false;

        if (
            !currentPosition.isOnSameRow(targetPosition)
            && !currentPosition.isOnSameColum(targetPosition)
            && !currentPosition.isOnSameDiagonal(targetPosition)
        )
            return false;

        if (thereIsAFriendlyPieceInTargetPosition(targetPosition))
            return false;

        if (thereIsAnyPieceInTheWay(board, currentPosition, targetPosition))
            return false;

        return true;
    }

    private boolean thereIsAnyPieceInTheWay(Board board, Position currentPosition, Position targetPosition) {

        String kindOfMovement = currentPosition.getKindOfMovement(targetPosition);

        if (kindOfMovement.equals("diagonal")) {
            return board.thereIsAnyPieceInTheDiagonalBetween(currentPosition, targetPosition);
        } else if (kindOfMovement.equals("straight")) {
            return board.thereIsAnyPieceInTheStraightBetween(currentPosition, targetPosition);
        }

        throw new IllegalArgumentException("Invalid movement type: " + kindOfMovement);
    }

}
