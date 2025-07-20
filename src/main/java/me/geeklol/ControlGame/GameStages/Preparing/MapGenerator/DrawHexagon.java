package me.geeklol.ControlGame.GameStages.Preparing.MapGenerator;

import me.geeklol.ControlGame.ControlGame;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class DrawHexagon {
    public DrawHexagon(Player player, double centerX, double centerY, double centerZ, double radius) {
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
                drawLine(ControlGame.getInstance(), player,
                        loc1.getX(), loc1.getY(), loc1.getZ(),
                        loc2.getX(), loc2.getY(), loc2.getZ()
                );

                return;
            }

            Location loc1 = vertices.get(i);
            Location loc2 = vertices.get(i + 1);

            drawLine(ControlGame.getInstance(), player,
                    loc1.getX(), loc1.getY(), loc1.getZ(),
                    loc2.getX(), loc2.getY(), loc2.getZ()
            );
        }
    }

    public void drawLine(ControlGame plugin, Player player, double x, double y, double z, double x1, double y1, double z1) {
        BukkitTask bukkitTask = Bukkit.getScheduler().runTaskTimer(plugin, () -> {
            World world = player.getWorld();
            Location location1 = new Location(world, x, y, z);
            Location location2 = new Location(world, x1, y1, z1);

            Vector pointA = location1.toVector();
            Vector pointB = location2.toVector();

            Vector between = pointA.subtract(pointB);
            Vector modifier = between.normalize().multiply(0.1);

            double distance = location2.distance(location1);
            double particlesLineLength = 0;

            while (particlesLineLength < distance) {
                Location location = new Location(
                        world,
                        pointB.toLocation(world).getX(),
                        pointB.toLocation(world).getY(),
                        pointB.toLocation(world).getZ()
                );
                Particle.Trail trail = new Particle.Trail(location2, Color.fromRGB(255, 79, 79), 1);

                world.spawnParticle(
                        Particle.TRAIL,
                        location,
                        1,
                        trail
                );

                pointB.add(modifier);
                particlesLineLength += 0.1;
            }
        }, 0, 0);
    }
}
