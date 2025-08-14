package me.geeklol.ControlGame.GameStages.Preparing;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PatternPrinter {
    private final List<Location> spawnBlocks;

    public PatternPrinter(Integer[][] matrix, Player player, double x, double y, double z) {
        Location spawnCursor = new Location(player.getWorld(), x, y, z);
        this.spawnBlocks = new ArrayList<>();

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
                if (material.equals(Material.LAPIS_BLOCK) || material.equals(Material.REDSTONE_BLOCK)) {
                    this.spawnBlocks.add(new Location(player.getWorld(), originX + j, y, originZ + i));
                }
            }
        }
    }

    public List<Location> getSpawnBlocks() {
        return spawnBlocks;
    }
}
