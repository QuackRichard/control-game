package me.geeklol.ControlGame.Utils.DebugCommands;

import me.geeklol.ControlGame.ControlGame;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class JoinTeam implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (commandSender instanceof Player player) {
            if (strings.length >= 1) {
                if (strings[0].equalsIgnoreCase("red") | strings[0].equalsIgnoreCase("blue")) {
                    ControlGame.getScoreboard().getTeam(strings[0]).addPlayer(player);
                    return true;
                }
            }
        }

        return false;
    }
}
