package me.geeklol.ControlGame.Utils.DebugCommands;

import me.geeklol.ControlGame.ControlGame;
import me.geeklol.ControlGame.GameStages.Process.Board.Cell;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ShowActivePlaygrounds implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (commandSender instanceof Player player) {
            player.sendMessage(Arrays.stream(ControlGame.getActivePlaygrounds().toArray()).toList().toString());
            return true;
        } else if (commandSender instanceof ConsoleCommandSender) {
            if (ControlGame.getActivePlaygrounds().isEmpty()) {
                throw new NoSuchElementException("No active playgrounds, create at least one.");
            }
            for (Cell cell : ControlGame.getActivePlaygrounds().getFirst().getCells()) {
                Bukkit.getConsoleSender().sendMessage(cell.toString());
            }
            return true;
        }
        return false;
    }
}
