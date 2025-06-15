import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PawnTest {

    @Test
    void colorTest() {
        var pawn = new Pawn(Color.WHITE);
        assertEquals(Color.WHITE, pawn.getColor());
    }

    @ParameterizedTest
    @CsvSource({
        "WHITE, 2, 2, 3, 2, true",
        "WHITE, 3, 2, 4, 2, true",
        "BLACK, 6, 2, 5, 2, true",
        "BLACK, 5, 2, 4, 2, true"
    })
    void itCanMoveOneStepFoward(String colorName, int startRow, int startCol, int targetRow, int targetCol, boolean expected) {

        Color color = Color.valueOf(colorName);
        Board board = new Board();
        Pawn pawn = new Pawn(color);

        Position currentPosition = board.getPosition(startRow, startCol);
        Position targetPosition = board.getPosition(targetRow, targetCol);

        boolean result = pawn.isValidMove(board, currentPosition, targetPosition);

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
        "WHITE, 2, 2, 5, 2, false",
        "WHITE, 2, 2, 3, 2, true",
        "WHITE, 1, 2, 3, 2, true",
        "WHITE, 3, 2, 7, 2, false",
        "WHITE, 3, 2, 5, 2, false",
        "BLACK, 6, 2, 4, 2, true",
        "BLACK, 6, 2, 3, 2, false",
        "BLACK, 5, 2, 4, 2, true",
        "BLACK, 5, 2, 1, 2, false",
    })
    void itCanNotMoveMoreThanTwoSteps(String colorName, int startRow, int startCol, int targetRow, int targetCol,
            boolean expected) {

        Color color = Color.valueOf(colorName);
        Board board = new Board();
        Pawn pawn = new Pawn(color);

        Position currentPosition = board.getPosition(startRow, startCol);
        Position targetPosition = board.getPosition(targetRow, targetCol);

        boolean result = pawn.isValidMove(board, currentPosition, targetPosition);

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
        "WHITE, 2, 2, 1, 2, false",
        "WHITE, 2, 2, 0, 2, false",
        "WHITE, 2, 2, 3, 2, true",
        "WHITE, 1, 2, 3, 2, true",
        "WHITE, 1, 2, 0, 2, false",
        "BLACK, 4, 2, 5, 2, false",
        "BLACK, 4, 2, 6, 2, false",
        "BLACK, 4, 2, 7, 2, false",
        "BLACK, 6, 2, 7, 2, false",
        "BLACK, 6, 2, 1, 2, false",
        "BLACK, 6, 2, 5, 2, true",
    })
    void shouldOnlyMoveForwardAccordingToItsColor(String colorName, int startRow, int startCol, int targetRow, int targetCol, boolean expected) {
        Color color = Color.valueOf(colorName);
        Board board = new Board();
        Pawn pawn = new Pawn(color);

        Position currentPosition = board.getPosition(startRow, startCol);
        Position targetPosition = board.getPosition(targetRow, targetCol);

        boolean result = pawn.isValidMove(board, currentPosition, targetPosition);

        assertEquals(expected, result);
    }
    

    @Test
    void canMoveTwoStepsOnlyOnFirstMove() {
    }

    @Test
    void canNotMoveHorizontaly() {
    }

    @Test
    void itCanNotMoveToSamePosition() {
    }

    // Solo mueve una posicion diagonal
    // No puede mover si hay cualquier pieza delante
    // No puede mover las 2 posiciones en el primer movimiento si hay una pieza justo delante
    // Solo puede mover hacia la diagonales delanteras apra comer una pieza enemigaç
    // Solo puede mover hacia delante en las misma columna, no puede estar en otr
    // Puede comer al paso ** necesita saber el movimiento anterior
}
