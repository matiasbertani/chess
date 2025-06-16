public abstract class Piece {
    protected String name;
    protected Color color;
    protected String symbol;
    private int row;
    private int column;

    public Piece(Color color) {
        this.color = color;
    }

    public int[] getPosition() {
        return new int[] { row, column };
    }

    public void setPosition(int row, int column){
        this.row = row;
        this.column = column;
    }

    public String getSymbol(){
        return symbol;
    }

    public boolean canMoveToPosition() {
        return true;
    }

    public abstract boolean isValidMove(Board board, Position currentPosition, Position targetPosition);

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }
}
