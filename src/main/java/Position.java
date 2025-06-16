public class Position {
    private int row;
    private int column;
    private Piece piece;

    Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean isEmpty() {
        return this.piece == null;
    }

    public int[] getPosition() {
        return new int[] {row, column};
    }

    public String getContent() {
        return "0";  // until implement the piece within the position
    }

    public int getColumn() {
        return this.column;
    }

    public int getRow() {
        return this.row;
    }

    public int verticalDistanceFrom(Position otherPosition) {
        return Math.abs(this.row - otherPosition.row);
    }

    public int horizontalDistanceFrom(Position otherPosition) {
        return Math.abs(this.column - otherPosition.column);
    }

    public boolean IsEqual(Position otherPosition) {
        return this.row == otherPosition.row && this.column == otherPosition.column;
    }

    public boolean isOnSameRow(Position otherPosition) {
        return this.row == otherPosition.row;
    }

    public boolean isOnSameColum(Position otherPosition) {
        return this.column == otherPosition.column;
    }
}
