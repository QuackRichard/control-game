package me.geeklol.ControlGame.GameStages.Preparing.MapGenerator;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class DrawLineBetweenHexagons {
    // Сделать проход по 5х5 блокам вокруг ляпис блока
    public DrawLineBetweenHexagons(Player player, double x, double y, double z) {
        double bufferX = x - 2;
        double bufferZ = z - 2;

        List<Block> blocks = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            bufferX += 1;
            for (int k = 0; k < 5; k++) {
                bufferZ += 1;

                if (new Location(player.getWorld(), bufferX, y, bufferZ).getBlock().getType() == Material.LAPIS_BLOCK) {
                    Location location = new Location(player.getWorld(), bufferX, y, bufferZ);
                    System.out.println(x + ":" + z + " " + location.getBlock().getType() + " | " + location.getX() + " : " + location.getY() + " : " + location.getZ());
                    blocks.add(new Location(player.getWorld(), bufferX, y, bufferZ).toBlockLocation().getBlock());
                }
            }
        }

        System.out.println(blocks);
    }
}
