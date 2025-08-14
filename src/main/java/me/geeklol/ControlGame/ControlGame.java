package me.geeklol.ControlGame;

import me.geeklol.ControlGame.GameStages.Lobby.TeamTagSetter;
import me.geeklol.ControlGame.GameStages.Process.Board.Board;
import me.geeklol.ControlGame.Utils.DebugCommands.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;

import java.util.ArrayList;
import java.util.List;

public final class ControlGame extends JavaPlugin {

    private static ControlGame instance;
    private static Scoreboard scoreboard;
    private static List<Board> activePlaygrounds;

    @Override
    public void onEnable() {
        instance = this;
        // Plugin startup logic
        this.getCommand("spawnboard").setExecutor(new SpawnBoard());
        this.getCommand("jointeam").setExecutor(new JoinTeam());
        this.getCommand("ap").setExecutor(new ShowActivePlaygrounds());
        this.getCommand("vap").setExecutor(new VisualActivePlaygrounds());
        this.getCommand("deleteapg").setExecutor(new DeleteAllPlaygrounds());

        this.getServer().getPluginManager().registerEvents(new CellPowerIncrease(), this);

        activePlaygrounds = new ArrayList<>();

        scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        TeamTagSetter.setNameTag(scoreboard, "red", "[RED] ");
        TeamTagSetter.setNameTag(scoreboard, "blue", "[BLUE] ");
    }

    @Override
    public void onDisable() {
        removeAllActivePlaygrounds();
    }

    public static Scoreboard getScoreboard() { return scoreboard; }

    public static ControlGame getInstance() { return instance; }

    public static List<Board> getActivePlaygrounds() {
        return activePlaygrounds;
    }

    public static void addActivePlaygrounds(Board activePlayground) {
        ControlGame.activePlaygrounds.add(activePlayground);
    }

    public static void removeAllActivePlaygrounds() {
        ControlGame.activePlaygrounds.clear();
    }
}
