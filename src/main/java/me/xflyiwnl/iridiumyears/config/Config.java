package me.xflyiwnl.iridiumyears.config;

import me.xflyiwnl.iridiumyears.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Config {

    private static File settingsFile;
    private static FileConfiguration settingsYaml;

    private static File languageFile;
    private static FileConfiguration languageYaml;

    public Config() {

        settingsFile = new File(Main.getMain().getDataFolder(), "settings.yml");
        if (!settingsFile.exists()) {
            Main.getMain().saveResource("settings.yml", true);
        }
        settingsYaml = YamlConfiguration.loadConfiguration(settingsFile);

        languageFile = new File(Main.getMain().getDataFolder(), "language.yml");
        if (!languageFile.exists()) {
            Main.getMain().saveResource("language.yml", true);
        }
        languageYaml = YamlConfiguration.loadConfiguration(languageFile);

    }

    public static void reload() {
        languageYaml = YamlConfiguration.loadConfiguration(languageFile);
        settingsYaml = YamlConfiguration.loadConfiguration(settingsFile);
    }

    public static File getSettingsFile() {
        return settingsFile;
    }

    public static FileConfiguration getSettingsYaml() {
        return settingsYaml;
    }

    public static File getLanguageFile() {
        return languageFile;
    }

    public static FileConfiguration getLanguageYaml() {
        return languageYaml;
    }
}
