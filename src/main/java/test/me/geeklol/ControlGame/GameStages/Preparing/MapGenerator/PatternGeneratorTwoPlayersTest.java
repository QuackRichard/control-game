package test.me.geeklol.ControlGame.GameStages.Preparing.MapGenerator;

import me.geeklol.ControlGame.GameStages.Preparing.MapGenerator.TwoPlayersPatterns;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class PatternGeneratorTwoPlayersTest {

    @Test
    void getPattern() {

        TwoPlayersPatterns patternGeneratorTwoPlayers = new TwoPlayersPatterns();

        Integer[][] matrix = patternGeneratorTwoPlayers.getMatrix();

        int expected = 0;
        int actual = 0;

        int columns = matrix.length;
        int rows = matrix[0].length;
        int totalCells = rows * columns;

        for (int i = 0; i < totalCells; i++) {

        }

        assertEquals(expected, actual);
    }
}