package me.geeklol.ControlGame.Utils;

import me.geeklol.ControlGame.ControlGame;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

public class Utils {
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
