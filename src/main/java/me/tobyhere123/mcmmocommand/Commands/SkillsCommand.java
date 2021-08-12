package me.tobyhere123.mcmmocommand.Commands;

import com.gmail.nossr50.api.SkillAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.tobyhere123.mcmmocommand.Main.getPlugin;

public class SkillsCommand implements CommandExecutor {

    public SkillsCommand() {
        getPlugin().getCommand("skills").setExecutor(this);
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if(!(sender instanceof Player)) return  true;

        Player player = (Player) sender;

        player.sendMessage(String.valueOf(SkillAPI.getSkills().get(14)));
        return true;
    }
}
