package me.geeklol.ControlGame.GameStages.Preparing;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrawHexagonTest {

    @Test
    public void drawHexagonTest() {
        World world = Bukkit.getWorld("HeadHunter");

        int expected = 15;
        int actual = 15;

        assertEquals(expected, actual);
    }

}