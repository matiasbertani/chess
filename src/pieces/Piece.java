package pieces;

public class Piece {
    protected String name;
    protected String symbol;
    private int row;
    private int column;

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

    public boolean canMoveToSquare() {
        return true;
    }

    public String getName() {
        return name;
    }
}
