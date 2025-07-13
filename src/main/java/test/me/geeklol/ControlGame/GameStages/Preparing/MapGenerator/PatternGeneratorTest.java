package test.me.geeklol.ControlGame.GameStages.Preparing.MapGenerator;

import me.geeklol.ControlGame.GameStages.Preparing.MapGenerator.PatternGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PatternGeneratorTest {

    @Test
    void offsetGenerator() {
        PatternGenerator patternGenerator = new PatternGenerator();

        List<Integer> offset = patternGenerator.offsetGenerator();

        int expected = 15;
        int actual = patternGenerator.offsetGenerator().size();

        System.out.println(offset);

        assertEquals(expected, actual);
    }
}