package me.geeklol.ControlGame.GameStages.Preparing.MapGenerator.Commands;

import me.geeklol.ControlGame.GameStages.Preparing.MapGenerator.TwoPlayersPatterns;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;


public class DrawPattern implements CommandExecutor {
    // Two players game mode

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (commandSender instanceof Player player) {
            if (strings.length == 0) {
                return false;
            } else if (strings.length == 3) {
                if (((!strings[0].isEmpty()) && (!strings[1].isEmpty())) && (!strings[2].isEmpty())) {
                    drawPattern(new TwoPlayersPatterns().getMatrix(), player, Double.parseDouble(strings[0]), Double.parseDouble(strings[1]), Double.parseDouble(strings[2]));
                    return true;
                } return false;
            } else if (strings.length == 4) {
                if (strings[3].equalsIgnoreCase("corner")) {
                    drawPattern(new TwoPlayersPatterns().getCorner(), player, Double.parseDouble(strings[0]), Double.parseDouble(strings[1]), Double.parseDouble(strings[2]));
                    return true;
                }
            }
        }
        return false;
    }

    public void drawPattern(Integer[][] matrix, Player player, double x, double y, double z) {
        Location spawnCursor = new Location(player.getWorld(), x, y, z);

        Integer[][] pattern = matrix.clone();

        int columns = pattern[0].length;
        int rows = pattern.length;

        double originX = spawnCursor.getX();
        double originZ = spawnCursor.getZ();

        Material material = Material.AIR;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (pattern[i][j] == 0) {
                    material = Material.SNOW_BLOCK;
                } else if (pattern[i][j] == 1) {
                    material = Material.LAPIS_BLOCK;
                } else if (pattern[i][j] == 2) {
                    material = Material.STONE;
                } else if (pattern[i][j] == 3) {
                    material = Material.REDSTONE_BLOCK;
                }

                spawnCursor.setX(originX + j);
                spawnCursor.setZ(originZ + i);
                spawnCursor.getBlock().setType(material);
            }
        }
    }

}