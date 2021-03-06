package me.xflyiwnl.iridiumyears.commands;

import me.xflyiwnl.iridiumyears.config.Config;
import me.xflyiwnl.iridiumyears.year.Year;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class YearCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String PREFIX = Config.getLanguageYaml().getString("language.chat-prefix");
        int year = Year.getYear();

        if (!(sender instanceof Player)) {
            sender.sendMessage(format(ChatColor.translateAlternateColorCodes('&',
                    Config.getLanguageYaml().getString("language.errors.is-not-player").replace("{prefix}", PREFIX))));
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("iridiumyears.admin")) {
            sender.sendMessage(format(ChatColor.translateAlternateColorCodes('&',
                    Config.getLanguageYaml().getString("language.errors.not-have-permission").replace("{prefix}", PREFIX))));
            return true;
        }

        if (args.length == 0) {

            for (String arg : Config.getLanguageYaml().getStringList("language.args")) {
                player.sendMessage(format(ChatColor.translateAlternateColorCodes('&', arg.replace("{prefix}", PREFIX))));
            }
            return true;
        }

        if (args[0].equalsIgnoreCase("get")) {

            player.sendMessage(format(ChatColor.translateAlternateColorCodes('&',
                    Config.getLanguageYaml().getString("language.command.get.year").replace("{prefix}", PREFIX).replace("{year}", String.valueOf(year)))));

            return true;

        } else if (args[0].equalsIgnoreCase("set")) {

            if (args.length < 2) {
                return true;
            }

            Year.setYear(Integer.valueOf(args[1]));

            player.sendMessage(format(ChatColor.translateAlternateColorCodes('&',
                    Config.getLanguageYaml().getString("language.command.set.successful").replace("{prefix}", PREFIX))));

            return true;
        } else if (args[0].equalsIgnoreCase("reload")) {

            Config.reload();

            player.sendMessage(format(ChatColor.translateAlternateColorCodes('&',
                    Config.getLanguageYaml().getString("language.command.reload.reloaded").replace("{prefix}", PREFIX))));

            return true;
        } else {
            player.sendMessage(format(ChatColor.translateAlternateColorCodes('&',
                    Config.getLanguageYaml().getString("language.errors.unknown-cmd").replace("{prefix}", PREFIX))));

            return true;
        }
    }

    private static String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg.
                replaceAll("#([a-fA-F0-9])([a-fA-F0-9])([a-fA-F0-9])([a-fA-F0-9])([a-fA-F0-9])([a-fA-F0-9])", "&x&$1&$2&$3&$4&$5&$6"));
    }

}
