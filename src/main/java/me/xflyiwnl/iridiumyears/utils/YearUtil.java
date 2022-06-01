package me.xflyiwnl.iridiumyears.utils;

import me.xflyiwnl.iridiumyears.config.Config;
import me.xflyiwnl.iridiumyears.year.Year;

public class YearUtil {

    public static void saveYear(int year) {

        Config.getSettingsYaml().set("settings.year", year);

    }

    public static void loadYear() {

        int year = Config.getSettingsYaml().getInt("settings.year");

        Year.setYear(year);

    }

}
