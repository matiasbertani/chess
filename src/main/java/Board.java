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
}
