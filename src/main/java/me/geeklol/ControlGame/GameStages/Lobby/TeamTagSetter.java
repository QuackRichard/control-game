package me.geeklol.ControlGame.GameStages.Lobby;

import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class TeamTagSetter {
    public static void setNameTag(Scoreboard scoreboard, String teamName ,String prefix) {
        Team team = scoreboard.registerNewTeam(teamName);
        team.setPrefix(prefix);
    }
}
