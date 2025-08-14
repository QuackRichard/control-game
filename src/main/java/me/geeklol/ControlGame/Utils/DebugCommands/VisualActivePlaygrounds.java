package me.geeklol.ControlGame.Utils.DebugCommands;

import me.geeklol.ControlGame.ControlGame;
import me.geeklol.ControlGame.GameStages.Process.Board.Cell;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class VisualActivePlaygrounds implements CommandExecutor {
    private Inventory menu;

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (commandSender instanceof Player player) {
            if (ControlGame.getActivePlaygrounds().isEmpty()) {
                player.sendMessage("No active playgrounds.");
                return true;
            }
            menu = Bukkit.createInventory(null, 27, "Active playgrounds: " + ControlGame.getActivePlaygrounds().size());
            for (int i = 0; i < ControlGame.getActivePlaygrounds().size(); i++) {
                menu.addItem(createPlaygroundIcon(i, ControlGame.getActivePlaygrounds().get(i).getCells()));
            }

            player.openInventory(menu);
            return true;
        }
        return false;
    }

    private ItemStack createPlaygroundIcon(int playgroundNumber, List<Cell> cells) {
        ItemStack icon = new ItemStack(Material.GOLD_BLOCK, 1);
        ItemMeta meta = icon.getItemMeta();

        // Set the name of the item
        meta.setDisplayName("Playground N. " + playgroundNumber);

        // Set the lore of the item
        List<String> lore = new ArrayList<>();
        for (Cell cell : cells) {
            lore.add(cell.toString());
        }
        meta.setLore(lore);

        icon.setItemMeta(meta);

        return icon;
    }
}
