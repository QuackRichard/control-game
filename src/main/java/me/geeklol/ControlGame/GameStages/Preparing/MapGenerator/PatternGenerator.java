package me.geeklol.ControlGame.GameStages.Preparing.MapGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PatternGenerator {

    public PatternGenerator(List<Integer> offset) {

    }

    private List<Integer> offsetGenerator(int playerCount) {
        List<Integer> offset = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < 15; i++) {
            offset.set(i, random.nextInt(4) + 1);
        }

        return offset;
    }
}
