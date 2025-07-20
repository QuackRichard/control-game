package me.geeklol.ControlGame.GameStages.Preparing.MapGenerator;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class SpawnArmorStands {
    private final List<Entity> armorStands = new ArrayList<>();

    public SpawnArmorStands(Player player, double x, double y, double z) {
        World world = player.getWorld();
        Location location = new Location(world, x, y, z);
        ArmorStand armorStand = (ArmorStand) world.spawnEntity(location, EntityType.ARMOR_STAND);
        armorStands.add(armorStand);
    }

    public List<Entity> getArmorStandLocation() {
        return armorStands;
    }

    public void checkNearbyArmorStand(List<Entity> armorStands) {
        for (Entity armorStand : armorStands) {
            for (int i = 0; i < 6; i++) {
                double angle = Math.toRadians(60 * i);
//                armorStand.getLocation().setYaw();
            }
        }
    }
}
