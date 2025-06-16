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

        if (thereIsAnotherPieceInTheWay(board, currentPosition, targetPosition))
            return false;

        return true;
    }

    private boolean thereIsAFriendlyPieceInTargetPosition(Position targetPosition) {
        if (targetPosition.isEmpty()) {
            return false;
        }
        Piece piece = targetPosition.getPiece();
        return piece.getColor() == this.getColor();
    }

    private boolean thereIsAnotherPieceInTheWay(Board board, Position currentPosition, Position targetPosition) {

        // get coordinates of the positions between current and target
        int rowStart = Math.min(currentPosition.getRow(), targetPosition.getRow());
        int rowEnd = Math.max(currentPosition.getRow(), targetPosition.getRow());
        int colStart = Math.min(currentPosition.getColumn(), targetPosition.getColumn());
        int colEnd = Math.max(currentPosition.getColumn(), targetPosition.getColumn());

        // check if there are any pieces in the way
        for (int row = rowStart; row <= rowEnd; row++) {
            for (int col = colStart; col <= colEnd; col++) {
                Position position = board.getPosition(row, col);
                if (!position.IsEqual(currentPosition) && !position.IsEqual(targetPosition) && !position.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

}
