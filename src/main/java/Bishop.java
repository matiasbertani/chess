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

        if (thereIsAnotherPieceInTheWay(board, currentPosition, targetPosition))
            return false;

        return true;
    }

    private boolean thereIsAnotherPieceInTheWay(Board board, Position currentPosition, Position targetPosition) {

        // get coordinates of the positions between current and target
        int rowStart = Math.min(currentPosition.getRow(), targetPosition.getRow());
        int rowEnd = Math.max(currentPosition.getRow(), targetPosition.getRow());
        int colStart = Math.min(currentPosition.getColumn(), targetPosition.getColumn());

        // check if there are any pieces in the way
        for (int row = rowStart; row <= rowEnd; row++) {
            int col = colStart + (row - rowStart);
            Position position = board.getPosition(row, col);
            if (!position.IsEqual(currentPosition) && !position.IsEqual(targetPosition) && !position.isEmpty()) {
                return true;
            }
        }
        return false;
    }

}
