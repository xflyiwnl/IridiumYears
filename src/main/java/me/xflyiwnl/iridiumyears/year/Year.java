package me.xflyiwnl.iridiumyears.year;

import me.xflyiwnl.iridiumyears.utils.YearUtil;

public class Year {

    private static Integer year;

    public static Integer getYear() {
        return year;
    }

    public static void setYear(Integer year) {
        Year.year = year;
        YearUtil.saveYear(year);
    }

}
