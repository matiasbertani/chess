package main.java;
public class Square {
    private int row;
    private int column;

    Square(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int[] getPosition() {
        return new int[] {row, column};
    }

    public String getContent() {
        return "0";  // until implement the piece within the square
    }
}
