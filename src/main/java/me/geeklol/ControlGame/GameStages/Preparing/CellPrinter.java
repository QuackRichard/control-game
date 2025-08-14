package me.geeklol.ControlGame.GameStages.Preparing;

import me.geeklol.ControlGame.GameStages.Process.Board.Cell;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

public class CellPrinter {
    private final List<Cell> cells;

    public CellPrinter(List<Location> spawnBlocks) {
        this.cells = new ArrayList<>();

        for (Location location : spawnBlocks) {
            this.cells.add(new Cell(location));
        }
    }

    public List<Cell> getCells() {
        return cells;
    }
}
