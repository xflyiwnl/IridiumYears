package me.xflyiwnl.iridiumyears.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class YearTabCompleter implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        List<String> argument = new ArrayList<>();

        if (argument.isEmpty()) {
            argument.add("set");
            argument.add("get");
            argument.add("reload");
        }

        if (args.length == 1) {
            return argument;
        }

        return null;
    }

}
