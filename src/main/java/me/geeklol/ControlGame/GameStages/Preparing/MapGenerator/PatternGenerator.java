package me.geeklol.ControlGame.GameStages.Preparing.MapGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PatternGenerator {
    public PatternGenerator() {

    }

    public List<Integer> offsetGenerator() {
        List<Integer> offset = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < 15; i++) {
            offset.add(random.nextInt(4) + 1);
        }

        return offset;
    }
}
