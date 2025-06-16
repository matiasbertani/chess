import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RookTest {

    @ParameterizedTest
    @CsvSource({
        "WHITE, 3, 3, 3, 4, true",
        "BLACK, 3, 3, 3, 5, true",
        "WHITE, 3, 3, 3, 6, true",
        "BLACK, 3, 3, 3, 7, true",
        "WHITE, 3, 3, 3, 2, true",
        "BLACK, 3, 3, 3, 1, true",
        "WHITE, 3, 3, 3, 0, true",
        "WHITE, 3, 3, 4, 3, true",
        "BLACK, 3, 3, 5, 3, true",
        "WHITE, 3, 3, 6, 3, true",
        "WHITE, 3, 3, 7, 3, true",
        "BLACK, 3, 3, 2, 3, true",
        "WHITE, 3, 3, 1, 3, true",
        "WHITE, 3, 3, 0, 3, true",
        "WHITE, 3, 3, 3, 3, false",
        "WHITE, 3, 3, 2, 2, false",
        "BLACK, 3, 3, 5, 7, false",
    })
    void testRookMovement(
        String colorName,
        int currentRow,
        int currentCol,
        int targetRow,
        int targetCol,
        boolean expected
    ){
        Board board = new Board();

        Color color = Color.valueOf(colorName);
        Rook rook = new Rook(color);

        Position currentPosition = board.getPosition(currentRow, currentCol);
        Position targetPosition = board.getPosition(targetRow, targetCol);

        boolean result = rook.isValidMove(board, currentPosition, targetPosition);

        assertEquals(expected, result);
    }


    @ParameterizedTest
    @CsvSource({
        "WHITE, 2, 2, 2, 3, WHITE, 2, 5, true",
        "WHITE, 2, 2, 2, 4, BLACK, 2, 5, true",
        "WHITE, 2, 2, 2, 6, BLACK, 2, 5, false",
        "WHITE, 2, 2, 2, 7, BLACK, 2, 5, false",
        "WHITE, 2, 2, 2, 6, WHITE, 2, 5, false",
        "WHITE, 2, 2, 2, 7, WHITE, 2, 5, false",
    })
    void itCanNotMoveWhenThereIsAnotherPieceInTheWay(
        String colorName,
        int currentRow,
        int currentCol,
        int targetRow,
        int targetCol,
        String anotherPieceColorName,
        int anotherPieceRow,
        int anotherPieceCol,
        boolean expected
    ) {

        Board board = new Board();

        Color color = Color.valueOf(colorName);
        Rook rook = new Rook(color);

        Position currentPosition = board.getPosition(currentRow, currentCol);
        Position targetPosition = board.getPosition(targetRow, targetCol);

        Color anotherPieceColor = Color.valueOf(anotherPieceColorName);
        Piece anotherPiece = new Rook(anotherPieceColor); // Using Rook for simplicity, can be any piece.
        Position anotherPiecePosition = board.getPosition(anotherPieceRow, anotherPieceCol);
        anotherPiecePosition.setPiece(anotherPiece);

        boolean result = rook.isValidMove(board, currentPosition, targetPosition);

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
        "WHITE, 2, 2, 2, 5, WHITE, 2, 5, false",
        "BLACK, 2, 2, 2, 5, BLACK, 2, 5, false",
    })
    void itCanNotMoveToTargetPositionWithFriendlyPiece(
        String colorName,
        int currentRow,
        int currentCol,
        int targetRow,
        int targetCol,
        String anotherPieceColorName,
        int anotherPieceRow,
        int anotherPieceCol,
        boolean expected
    ) {

        Board board = new Board();

        Color color = Color.valueOf(colorName);
        Rook rook = new Rook(color);

        Position currentPosition = board.getPosition(currentRow, currentCol);
        Position targetPosition = board.getPosition(targetRow, targetCol);

        Color anotherPieceColor = Color.valueOf(anotherPieceColorName);
        Piece anotherPiece = new Rook(anotherPieceColor); // Using Rook for simplicity, can be any piece.
        Position anotherPiecePosition = board.getPosition(anotherPieceRow, anotherPieceCol);
        anotherPiecePosition.setPiece(anotherPiece);

        boolean result = rook.isValidMove(board, currentPosition, targetPosition);

        assertEquals(expected, result);
    }
}
