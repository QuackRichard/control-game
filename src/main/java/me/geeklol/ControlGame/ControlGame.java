package me.geeklol.ControlGame;

import me.geeklol.ControlGame.GameStages.Preparing.MapGenerator.Commands.DrawPattern;
import org.bukkit.plugin.java.JavaPlugin;

public final class ControlGame extends JavaPlugin {

    private static ControlGame instance;

    @Override
    public void onEnable() {
        instance = this;
        // Plugin startup logic
        this.getCommand("drawpattern").setExecutor(new DrawPattern());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static ControlGame getInstance() { return instance; }
}
