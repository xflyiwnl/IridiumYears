package me.xflyiwnl.iridiumyears.placeholder;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.xflyiwnl.iridiumyears.Main;
import me.xflyiwnl.iridiumyears.year.Year;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class YearPlaceholder extends PlaceholderExpansion {

    private final Main main;

    public YearPlaceholder(Main main) {
        this.main = main;
    }

    @Override
    public @NotNull String getIdentifier() {
        return "iridiumyears";
    }

    @Override
    public @NotNull String getAuthor() {
        return "xflyiwnl";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.0";
    }

    @Override
    public @Nullable String onRequest(OfflinePlayer player, @NotNull String params) {

        if (params.equalsIgnoreCase("year")) {
            return Year.getYear().toString();
        }

        return null;
    }
}
