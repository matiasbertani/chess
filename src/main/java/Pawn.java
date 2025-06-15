public class Pawn extends Piece {

    final int STEP = 1;

    public Pawn(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Board board, Position currentPosition, Position targetPosition) {

        int verticalDistance = currentPosition.verticalDistanceFrom(targetPosition);

        if (verticalDistance > 2)
            return false;
        
        if (!isMovingFoward(currentPosition, targetPosition))
            return false;

        if (currentPosition.horizontalDistanceFrom(targetPosition) > 1)
            return false;

        if (verticalDistance == 2 && !isFirstMove(currentPosition))
            return false;

        if (currentPosition.getRow() == targetPosition.getRow())
            return false;

        // if initial position is possible to take a step of 2
        // int direction = (getColor() == Color.WHITE) ? 1 : -1;
        // int step = (isFirstMove(currentPosition)) ? 2 : 1;

        // Position oneStepForward = position.offset(0, direction);

        // if (board.isValidPosition(oneStepForward) && board.isEmpty(oneStepForward)) {
        //     validMoves.add(oneStepForward);
        // }

        // Additional logic for capturing diagonally or initial two-step move can be added here.
        return true;
    }

    private boolean isMovingFoward(Position currentPosition, Position targetPosition) {

        boolean movingFoward = targetPosition.getRow() - currentPosition.getRow() > 0;
        if (this.color == Color.BLACK)
            movingFoward = !movingFoward;
        return movingFoward;
    }

    private boolean isFirstMove(Position currentPosition) {
        return currentPosition.getRow() == 1 && this.color == Color.WHITE
                || currentPosition.getRow() == 6 && this.color == Color.BLACK;
    }

    public Color getColor() {
        return this.color;
    }

}
