package me.tobyhere123.mcmmocommand.Events;

import com.gmail.nossr50.api.ExperienceAPI;
import com.gmail.nossr50.api.SkillAPI;
import com.gmail.nossr50.datatypes.skills.PrimarySkillType;
import com.gmail.nossr50.events.experience.McMMOPlayerLevelUpEvent;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static me.tobyhere123.mcmmocommand.Main.getPlugin;

public class LevelUp implements Listener {

    @EventHandler
    public void LevelUpEvent(McMMOPlayerLevelUpEvent event) {
        Player player = event.getPlayer();
        int woodCutting = ExperienceAPI.getLevel(player, PrimarySkillType.WOODCUTTING);
        if (woodCutting == (int) getPlugin().getConfig().get("values.requiredWoodCuttingLevel")) {
            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
            Bukkit.dispatchCommand(console, "ultimatetimber give " + player.getName());
        }
    }


    public int getTotLevel(Player p) {
        int sum = 0;
        for (String skill : SkillAPI.getSkills()) {
            sum += ExperienceAPI.getLevel(p, skill);
        }
        return sum;
    }
}