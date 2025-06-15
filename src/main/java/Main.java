public class Main {
    public static void main(String[] args) {
        System.out.println("Chess App");
        Board board = new Board();
        board.print();

        System.out.println("-----------");
        System.out.println("Pieces:\n");
        Piece[] pieces = new Piece[6];

        pieces[5] = new Pawn(Color.WHITE);

        for (Piece piece: pieces)
            System.out.println(piece.getName());
    }
}
