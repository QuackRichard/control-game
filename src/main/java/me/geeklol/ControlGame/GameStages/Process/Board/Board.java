// Сделать, что бы сначала создавался объект Board, в себе он будет хранить игроков, клетки.
package me.geeklol.ControlGame.GameStages.Process.Board;

import org.bukkit.entity.Player;

import java.util.List;

public class Board {
    private final int amount;
    private final List<Player> players;
    private final List<Cell> cells;

    Board(Builder builder) {
        this.amount = builder.players.size();
        this.players = builder.players;
        this.cells = builder.cells;
    }

    public static class Builder {
        private List<Player> players;
        private List<Cell> cells;

        public Builder players(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder cells(List<Cell> cells) {
            this.cells = cells;
            return this;
        }

        public Board build() {
            return new Board(this);
        }
    }

    public int getAmount() {
        return amount;
    }

    public List<Player> getPlayers() {
        return players;
    }


    public List<Cell> getCells() {
        return cells;
    }

    @Override
    public String toString() {
        return "Board[Amount: " + this.amount + "Players: " + this.players + "]";
    }



//    public List<Cell> getPlaygroundCells() {
//        List<Cell> combinedCells = new ArrayList<>();
//        for (int i = 0; i < getAmount(); i++) {
//            combinedCells.addAll(this.players.get(i).getCells());
//        }
//
//        return combinedCells;
//    }
//
//    public Cell getCellByLocation(Location location) {
//        for (Cell cell : getPlaygroundCells()) {
//            cell.toString();
//            if ((cell.getPosition().getX() == location.getX()) & (cell.getPosition().getZ() == location.getZ())) {
//                return cell;
//            }
//        }
//        throw new RuntimeException("No correct cell found.");
//    }
}
