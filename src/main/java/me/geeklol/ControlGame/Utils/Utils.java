package me.geeklol.ControlGame.Utils;

import me.geeklol.ControlGame.ControlGame;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Utils {
    public void drawLine(ControlGame plugin, String worldName, double x, double y, double z, double x1, double y1, double z1) {
        BukkitTask bukkitTask = Bukkit.getScheduler().runTaskTimer(plugin, () -> {
            World world = Bukkit.getServer().getWorld(worldName);
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

    public void scanArea5by5(Player player, Location center) {
        World world = player.getWorld();
        double bufferX = center.getX() - 2;
        double bufferY = center.getY();
        double bufferZ = center.getZ() - 2;
        HashMap<Block, List<Block>> area = new HashMap<>();
        List<Block> areaBlocks = new ArrayList<>();
        Location cursor = new Location(world, bufferX, bufferY, bufferZ);

        for (int i = 0; i < 5; i++) {
            bufferX += 1.0;
            for (int j = 0; j < 5; j++) {
                bufferZ = center.getZ() - 2;
                for (int k = 0; k < 5; k++) {
                    bufferZ += 1.0;
                    areaBlocks.add(world.getBlockAt((int) bufferX, (int) bufferY, (int) bufferZ));
                }
            }
        }

        area.put(center.getBlock(), areaBlocks);
    }

    public void writeFile(String fileName, String fileContext) {
        try {
            FileWriter writer = new FileWriter(fileName); // Creates or overwrites
            writer.write(fileContext);
            writer.close(); // Important to close the writer
            System.out.println(fileContext);
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void drawHexagon(String worldName, double centerX, double centerY, double centerZ, double radius) {
        Utils utils = new Utils();
        List<Location> vertices = new ArrayList<>();
        World world = Bukkit.getServer().getWorld(worldName);

        for (int i = 0; i < 6; i++) {
            double angle = Math.toRadians(60 * i);
            double x = centerX + radius * Math.cos(angle);
            double z = centerZ + radius * Math.sin(angle);

            vertices.add(new Location(world, x, centerY + 0.1, z));
        }

        for (int i = 0; i < vertices.size(); i++) {
            if (i == 5) {
                Location loc1 = vertices.get(i);
                Location loc2 = vertices.getFirst();
                utils.drawLine(ControlGame.getInstance(), world.toString(),
                        loc1.getX(), loc1.getY(), loc1.getZ(),
                        loc2.getX(), loc2.getY(), loc2.getZ()
                );

                return;
            }

            Location loc1 = vertices.get(i);
            Location loc2 = vertices.get(i + 1);

            utils.drawLine(ControlGame.getInstance(), world.toString(),
                    loc1.getX(), loc1.getY(), loc1.getZ(),
                    loc2.getX(), loc2.getY(), loc2.getZ()
            );
        }
    }
}
