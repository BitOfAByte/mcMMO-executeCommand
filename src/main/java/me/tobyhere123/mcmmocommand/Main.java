package me.tobyhere123.mcmmocommand;

import me.tobyhere123.mcmmocommand.Events.ChatEvent;
import me.tobyhere123.mcmmocommand.Events.JoinEvent;
import me.tobyhere123.mcmmocommand.Events.LevelUp;
import me.tobyhere123.mcmmocommand.Events.QuitEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    private static Main plugin;

    @Override
    public void onEnable() {
        plugin = this;
        saveDefaultConfig();
        if(!Bukkit.getPluginManager().isPluginEnabled("LuckPerms") || !Bukkit.getPluginManager().isPluginEnabled("mcMMO")) {
            Bukkit.getPluginManager().disablePlugin(plugin);
            Bukkit.getConsoleSender().sendMessage((getConfig().getString("messages.DisabledPlugin")));
        } else {
            loadEvents();
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Main getPlugin() {
        return plugin;
    }


    private void loadEvents() {
        getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        getServer().getPluginManager().registerEvents(new QuitEvent(), this);
        getServer().getPluginManager().registerEvents(new ChatEvent(), this);
        getServer().getPluginManager().registerEvents(new LevelUp(), this);
    }
}
