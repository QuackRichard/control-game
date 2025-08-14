package me.geeklol.ControlGame.GameStages.Process.Board;

import me.geeklol.ControlGame.GameStages.Preparing.CellPrinter;
import me.geeklol.ControlGame.GameStages.Preparing.PatternPrinter;
import org.apache.commons.lang3.ArrayUtils;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Board2Players {
    public Board2Players(Integer[][] pattern, List<Player> players) {
        if (players.size() == 2) {
            Integer[][] secondHalf = pattern.clone();
            ArrayUtils.reverse(secondHalf);

            Player firstPlayer = players.getFirst().getPlayer();
            Player secondPlayer = players.getLast().getPlayer();

            PatternPrinter firstPlayerHalf = new PatternPrinter(pattern, firstPlayer, 0, 50, 0);
            PatternPrinter secondPlayerHalf = new PatternPrinter(secondHalf, secondPlayer, 1, 50, 20);

            List<Location> firstPlayerCellsLocation = firstPlayerHalf.getSpawnBlocks();
            List<Location> secondPlayerCellsLocation = secondPlayerHalf.getSpawnBlocks();

            CellPrinter cellPrinterFirstHalf = new CellPrinter(firstPlayerCellsLocation);
            CellPrinter cellPrinterSecondHalf = new CellPrinter(secondPlayerCellsLocation);

            List<Cell> combinedCells = new ArrayList<>(cellPrinterFirstHalf.getCells());
            combinedCells.addAll(cellPrinterSecondHalf.getCells());

            Board board = new Board.Builder()
                    .players(List.of(firstPlayer, secondPlayer))
                    .cells(combinedCells)
                    .build();

        } else {
            throw new RuntimeException("Players list have to be count of 2.");
        }
    }
}
