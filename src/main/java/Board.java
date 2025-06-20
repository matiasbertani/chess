public class Board {
    final int ROWS = 8;
    final int COLS = 8;
    private Position[][] positions;

    Board() {
        positions = new Position[ROWS][COLS];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                positions[i][j] = new Position(i, j);
            }
        }
    }

    public void print() {
        String strBoard = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                strBoard += " " + positions[i][j].getContent();
            }
            strBoard += "\n";
        }
        System.out.println(strBoard);
    }

    public Position getPosition(int row, int column){
        return this.positions[row][column];
    }

    public boolean thereIsAnyPieceInTheStraightBetween(Position startPosition, Position endPosition) {
        // get coordinates of the positions between start and end positions
        int rowStart = Math.min(startPosition.getRow(), endPosition.getRow());
        int rowEnd = Math.max(startPosition.getRow(), endPosition.getRow());
        int colStart = Math.min(startPosition.getColumn(), endPosition.getColumn());
        int colEnd = Math.max(startPosition.getColumn(), endPosition.getColumn());

        // check if there are any pieces in the way
        for (int row = rowStart; row <= rowEnd; row++) {
            for (int col = colStart; col <= colEnd; col++) {
                Position position = this.getPosition(row, col);
                if (!position.IsEqual(startPosition) && !position.IsEqual(endPosition) && !position.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean thereIsAnyPieceInTheDiagonalBetween(Position startPosition, Position endPosition) {
        // get coordinates of the positions between start and end positions
        int rowStart = Math.min(startPosition.getRow(), endPosition.getRow());
        int rowEnd = Math.max(startPosition.getRow(), endPosition.getRow());
        int colStart = Math.min(startPosition.getColumn(), endPosition.getColumn());

        // check if there are any pieces in the way
        for (int row = rowStart; row <= rowEnd; row++) {
            int col = colStart + (row - rowStart);
            Position position = this.getPosition(row, col);
            if (!position.IsEqual(startPosition) && !position.IsEqual(endPosition) && !position.isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
