public class Board {
    final int ROWS = 8;
    final int COLS = 8;
    private Square[][] squares;

    Board() {
        squares = new Square[ROWS][COLS];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                squares[i][j] = new Square(i, j);
            }
        }
    }

    public void print() {
        String strBoard = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                strBoard += " " + squares[i][j].getContent();
            }
            strBoard += "\n";
        }
        System.out.println(strBoard);
    }
}
