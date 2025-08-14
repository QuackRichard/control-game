package me.geeklol.ControlGame.GameStages.Process.Board;

import me.geeklol.ControlGame.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.List;

public class Cell {
    private Player owner;
    private ArmorStand cellBody;
    private List<Entity> nearbyCells;
    private Location position;
    private int cellPower;

    public Cell() { }

    public Cell(Location position) {
        position.setX(position.clone().getX() + 0.5);
        position.setY(position.clone().getY() - 0.35);
        position.setZ(position.clone().getZ() + 0.5);
        this.position = position.clone();

        ArmorStand cell = (ArmorStand) Bukkit.getServer().getWorld("HeadHunter").spawnEntity(position, EntityType.ARMOR_STAND);

        cell.setGravity(false);
        cell.setInvulnerable(true);
        this.cellBody = cell;
        this.nearbyCells = getNearbyCells(getPosition());
        this.owner = null;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public Player getOwner() {
        return owner;
    }

    public Location getPosition() {
        return position;
    }

    public List<Entity> getNearbyCells(Location position) {
        return position.getWorld()
                .getNearbyEntities(position, 4, 1, 4, (entity) -> entity.getType() == EntityType.ARMOR_STAND).stream().toList();
    }

    public int getCellPower() {
        return cellPower;
    }

    public void setCellPower(int cellPower) {
        this.cellPower = cellPower;
    }

    public List<Entity> getNearbyCells() {
        return nearbyCells;
    }

    public void setPosition(Location position) {
        this.position = position;
    }

    public ArmorStand getCellBody() {
        return cellBody;
    }

    @Override
    public String toString() {
        return "Cell[Position: " + this.position + "; Owner: " + this.owner + "]";
    }
}
