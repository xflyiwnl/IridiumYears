package me.xflyiwnl.iridiumyears;

import me.xflyiwnl.iridiumyears.commands.YearCommand;
import me.xflyiwnl.iridiumyears.commands.YearTabCompleter;
import me.xflyiwnl.iridiumyears.config.Config;
import me.xflyiwnl.iridiumyears.manager.EventManager;
import me.xflyiwnl.iridiumyears.placeholder.YearPlaceholder;
import me.xflyiwnl.iridiumyears.utils.YearUtil;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main main;

    @Override
    public void onEnable() {
        main = this;

        if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new YearPlaceholder(this).register();
        }

        new Config();
        Bukkit.getPluginManager().registerEvents(new EventManager(), this);
        Bukkit.getPluginCommand("iridiumyear").setExecutor(new YearCommand());
        Bukkit.getPluginCommand("iridiumyear").setTabCompleter(new YearTabCompleter());

        YearUtil.loadYear();

    }

    public static Main getMain() {
        return main;
    }
}
