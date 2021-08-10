package io.github.bucheraa.coordinates;

import java.text.DecimalFormat;

public class Converter {

    @org.jetbrains.annotations.NotNull
    public static String decimal2DMS(final double latitude, final double longitude) {
        return getStringDMS(latitude) + " " + getStringDMS(longitude);
    }

    @org.jetbrains.annotations.NotNull
    private static String getStringDMS(final double latLon) {
        return getDegree(latLon) + "° " + getMinute(latLon) + "' " + new DecimalFormat("##.##").format(getSecond(latLon)) + "\"";
    }

    private static int getDegree(final double latLon) {
        return (int) latLon;
    }

    private static int getMinute(final double latLon) {
        double numberAfterPoint = latLon - Math.floor(latLon);
        double minuteTemp = numberAfterPoint * 60;
        return (int) minuteTemp;
    }

    private static double getSecond(final double latLon) {
        double numberAfterPoint = latLon - Math.floor(latLon);
        double minuteTemp = numberAfterPoint * 60;

        return (minuteTemp - Math.floor(minuteTemp)) * 60;
    }

}
