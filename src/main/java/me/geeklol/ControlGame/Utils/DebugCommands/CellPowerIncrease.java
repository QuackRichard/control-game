package me.geeklol.ControlGame.Utils.DebugCommands;

import me.geeklol.ControlGame.ControlGame;
import me.geeklol.ControlGame.GameStages.Process.Board.Board2Players;
import me.geeklol.ControlGame.GameStages.Process.Board.Cell;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.ItemStack;

public class CellPowerIncrease implements Listener {

    @EventHandler
    public void cellPowerIncrease(PlayerInteractAtEntityEvent event) {
        Player player = event.getPlayer();
        Entity clickedEntity = event.getRightClicked();
        ItemStack itemInHand = player.getInventory().getItemInMainHand();
        if (itemInHand.getType() == Material.GOLD_NUGGET) {
            if (clickedEntity instanceof ArmorStand) {
//                Location location = clickedEntity.getLocation();
//                Board2Players board2Players = ControlGame.getActivePlaygrounds().getFirst();
//                Cell cell = board2Players.getCellByLocation(location);
//                cell.toString();
//                cell.setCellPowerNameTag(cell.getCellPower() + 1);
//                player.sendMessage("Clicked!");
            }
        }
    }
}
