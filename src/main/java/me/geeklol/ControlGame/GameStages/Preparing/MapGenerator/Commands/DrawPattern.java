package me.geeklol.ControlGame.GameStages.Preparing.MapGenerator.Commands;

import me.geeklol.ControlGame.GameStages.Preparing.MapGenerator.TwoPlayersPatterns;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.BoundingBox;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class DrawPattern implements CommandExecutor {
    // Two players game mode

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (commandSender instanceof Player player) {
            if (strings.length == 0) {
                return false;
            } else if (strings.length == 3) {
                double x = Double.parseDouble(strings[0]);
                double y = Double.parseDouble(strings[1]);
                double z = Double.parseDouble(strings[2]);
                if (((!strings[0].isEmpty()) && (!strings[1].isEmpty())) && (!strings[2].isEmpty())) {
                    drawPattern(new TwoPlayersPatterns().getMatrix(), player, x, y, z);
                    return true;
                } return false;
            } else if (strings.length == 4) {
                double x = Double.parseDouble(strings[0]);
                double y = Double.parseDouble(strings[1]);
                double z = Double.parseDouble(strings[2]);
                if (strings[3].equalsIgnoreCase("corner")) {
                    drawPattern(new TwoPlayersPatterns().getCorner(), player, x, y, z);
                    reduceRedstoneBlocksAmount(player.getWorld(), x, y, z);
                    return true;
                }
            }
        }
        return false;
    }

    public void drawPattern(Integer[][] matrix, Player player, double x, double y, double z) {
        Location spawnCursor = new Location(player.getWorld(), x, y, z);

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
            }
        }
    }

    public void reduceRedstoneBlocksAmount(World world, double x, double y, double z) {
        BoundingBox boundingBox = new BoundingBox(x, y, z + 18.0, x + 18.0, y, z + 18.0);
        Block endBlock = boundingBox.getMax().toLocation(world).getBlock();
        int difference = (int) (endBlock.getZ() - z);

        List<Block> line = new ArrayList<>();
        for (int i = 0; i < difference; i++) {
            Block block = new Location(world, x + i, y, z + difference).toBlockLocation().getBlock();
            line.add(world.getBlockAt(block.getLocation()));
        }

        System.out.println(line);

//        Random random = new Random();
//        for (int i = 0; i < line.size(); i++) {
//            int randomNum = random.nextInt(4 - 1 + 1) + 1;
//            Block block = line.get(i);
//            Material material = line.get(i).getType();
//            if (material != Material.REDSTONE_BLOCK) {
//                line.remove(block);
//            } else {
//                if (randomNum == 2) {
//                    line.remove(block);
//                    System.out.println(randomNum);
//                }
//            }
//        }
//        System.out.println(line);
    }
}