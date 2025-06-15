public class Position {
    private int row;
    private int column;

    Position(int row, int column) {
        this.row = row;
        this.column = column;
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
}
