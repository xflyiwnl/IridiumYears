package me.xflyiwnl.iridiumyears.manager;

import com.palmergames.bukkit.towny.event.NewDayEvent;
import me.xflyiwnl.iridiumyears.config.Config;
import me.xflyiwnl.iridiumyears.utils.YearUtil;
import me.xflyiwnl.iridiumyears.year.Year;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class EventManager implements Listener {

    @EventHandler
    public void onNewDay(NewDayEvent event) {

        if (Config.getSettingsYaml().getBoolean("settings.mode.towny.enabled") == true) {
            Year.setYear(Year.getYear() + 1);
        }

    }

}
