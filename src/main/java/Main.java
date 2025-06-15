public class Main {
    public static void main(String[] args) {
        System.out.println("Chess App");
        Board board = new Board();
        board.print();

        System.out.println("-----------");
        System.out.println("Pieces:\n");
        Piece[] pieces = new Piece[6];
        // pieces[0] = new King();
        // pieces[1] = new Queen();
        // pieces[2] = new Bishop();
        // pieces[3] = new Knight();
        // pieces[4] = new Rook();
        pieces[5] = new Pawn(Color.WHITE);

        for (Piece piece: pieces)
            System.out.println(piece.getName());
    }
}
