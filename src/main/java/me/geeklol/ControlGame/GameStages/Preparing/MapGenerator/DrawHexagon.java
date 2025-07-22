package me.geeklol.ControlGame.GameStages.Preparing.MapGenerator;

import me.geeklol.ControlGame.ControlGame;
import me.geeklol.ControlGame.Utils.Utils;
import org.bukkit.*;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class DrawHexagon {
    public DrawHexagon(Player player, double centerX, double centerY, double centerZ, double radius) {
        Utils utils = new Utils();
        List<Location> vertices = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            double angle = Math.toRadians(60 * i);
            double x = centerX + radius * Math.cos(angle);
            double z = centerZ + radius * Math.sin(angle);

            vertices.add(new Location(player.getWorld(), x, centerY + 0.1, z));
        }

        for (int i = 0; i < vertices.size(); i++) {
            if (i == 5) {
                Location loc1 = vertices.get(i);
                Location loc2 = vertices.getFirst();
                utils.drawLine(ControlGame.getInstance(), player,
                        loc1.getX(), loc1.getY(), loc1.getZ(),
                        loc2.getX(), loc2.getY(), loc2.getZ()
                );

                return;
            }

            Location loc1 = vertices.get(i);
            Location loc2 = vertices.get(i + 1);

            utils.drawLine(ControlGame.getInstance(), player,
                    loc1.getX(), loc1.getY(), loc1.getZ(),
                    loc2.getX(), loc2.getY(), loc2.getZ()
            );
        }
    }


}
