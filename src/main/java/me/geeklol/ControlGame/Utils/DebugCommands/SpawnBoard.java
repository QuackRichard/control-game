package me.geeklol.ControlGame.Utils.DebugCommands;

import me.geeklol.ControlGame.ControlGame;
import me.geeklol.ControlGame.GameStages.Preparing.CellPrinter;
import me.geeklol.ControlGame.GameStages.Preparing.PatternPrinter;
import me.geeklol.ControlGame.GameStages.Preparing.Patterns;
import me.geeklol.ControlGame.GameStages.Process.Board.Board;
import me.geeklol.ControlGame.GameStages.Process.Board.Board2Players;
import me.geeklol.ControlGame.GameStages.Process.Board.Cell;
import org.apache.commons.lang3.ArrayUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class SpawnBoard implements CommandExecutor {
    private Board2Players board2Players;

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (commandSender instanceof Player player) {
            if (strings.length == 1) {
                List<Player> players = List.of(player, Bukkit.getPlayer(strings[0]));
                Integer[][] pattern = Patterns.getMatrix1vs1();

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


                ControlGame.addActivePlaygrounds(board);
                return true;
            }
        }
        return false;
    }
}
