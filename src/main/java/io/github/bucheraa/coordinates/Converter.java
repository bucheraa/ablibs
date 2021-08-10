package io.github.bucheraa.coordinates;

import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;

public class Converter {

    /**
     * converts decimal coordinates (latitude, longitude) into Degrees° Minutes' Seconds"
     * @param latitude
     * @param longitude
     * @return
     */
    public static String decimal2DMS(final double latitude, final double longitude) {
        return getStringDMS(latitude) + " " + getStringDMS(longitude);
    }

    /**
     * converts decimal latitude OR longitude into Degrees° Minutes' Seconds"
     * @param latLon
     * @return
     */
    private static String getStringDMS(final double latLon) {
        return getDegree(latLon) + "° " + getMinute(latLon) + "' " + new DecimalFormat("##.##").format(getSecond(latLon)) + "\"";
    }

    /**
     * returns number before decimal point
     * @param latLon
     * @return
     */
    private static int getDegree(final double latLon) {
        return (int) latLon;
    }

    /**
     * returns minutes from given dec coordinate
     * @param latLon
     * @return
     */
    private static int getMinute(final double latLon) {
        double numberAfterPoint = latLon - Math.floor(latLon);
        double minuteTemp = numberAfterPoint * 60;
        return (int) minuteTemp;
    }

    /**
     * returns seconds from given dec coordinate
     * @param latLon
     * @return
     */
    private static double getSecond(final double latLon) {
        double numberAfterPoint = latLon - Math.floor(latLon);
        double minuteTemp = numberAfterPoint * 60;

        return (minuteTemp - Math.floor(minuteTemp)) * 60;
    }

}
