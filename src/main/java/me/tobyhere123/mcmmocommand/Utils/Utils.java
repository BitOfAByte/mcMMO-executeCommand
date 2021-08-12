package me.tobyhere123.mcmmocommand.Utils;

import net.luckperms.api.LuckPermsProvider;
import org.bukkit.ChatColor;

import java.util.UUID;

public class Utils {

    public static String chat(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public String getPrefix(UUID uuid) {
        String prefix = LuckPermsProvider.get().getGroupManager().getGroup(LuckPermsProvider.get().getUserManager().getUser(uuid).getPrimaryGroup()).getCachedData().getMetaData().getPrefix();
        return prefix;
    }

}
