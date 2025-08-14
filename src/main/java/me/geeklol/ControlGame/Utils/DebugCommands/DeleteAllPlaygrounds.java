package me.geeklol.ControlGame.Utils.DebugCommands;

import me.geeklol.ControlGame.ControlGame;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class DeleteAllPlaygrounds implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (ControlGame.getActivePlaygrounds().isEmpty()) {
            if (commandSender instanceof Player player) {
                player.sendMessage("Nothing to delete.");
            } else if (commandSender instanceof ConsoleCommandSender) {
                Bukkit.getConsoleSender().sendMessage("Nothing to delete.");
            }
            return false;
        }
        ControlGame.removeAllActivePlaygrounds();
        if (commandSender instanceof Player player) {
            player.sendMessage("All playgrounds deleted.");
        } else if (commandSender instanceof ConsoleCommandSender) {
            Bukkit.getConsoleSender().sendMessage("All playgrounds deleted.");
        }
        return true;
    }
}
