package me.xflyiwnl.iridiumyears;

import me.xflyiwnl.iridiumyears.commands.YearCommand;
import me.xflyiwnl.iridiumyears.commands.YearTabCompleter;
import me.xflyiwnl.iridiumyears.config.Config;
import me.xflyiwnl.iridiumyears.manager.EventManager;
import me.xflyiwnl.iridiumyears.placeholder.YearPlaceholder;
import me.xflyiwnl.iridiumyears.utils.YearUtil;
import me.xflyiwnl.iridiumyears.year.Year;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.time.ZonedDateTime;

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

        if (Config.getSettingsYaml().getBoolean("settings.mode.time.enabled") == true) {
            timer();
        }

    }

    public void timer() {
        Bukkit.getScheduler().runTaskTimer(this, new Runnable() {

            @Override
            public void run() {

                if (ZonedDateTime.now().getHour() == Config.getSettingsYaml().getInt("settings.mode.time.hour") &&
                        ZonedDateTime.now().getMinute() == Config.getSettingsYaml().getInt("settings.mode.time.minute")) {
                    Year.setYear(Year.getYear() + 1);
                }

            }

        }, 0L, 1200L);
    }

    public static Main getMain() {
        return main;
    }
}
