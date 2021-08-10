package io.github.bucheraa.coordinates;

public class Util {

    /**
     * @param lat1
     * @param lon1
     * @param lat2
     * @param lon2
     * @return distance between coordinates (wgs84) in miles
     */
    public static double distanceWgs84Miles(final double lat1, final double lon1, final double lat2, final double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;

        return dist;
    }

    /**
     * @param lat1
     * @param lon1
     * @param lat2
     * @param lon2
     * @return distance between coordinates (wgs84) in meters
     */
    public static double distanceWgs84Meter(final double lat1, final double lon1, final double lat2, final double lon2) {
        return 1.609344 * 1000 * distanceWgs84Miles(lat1, lon1, lat2, lon2);
    }

    /**
     * @param lat1
     * @param lon1
     * @param lat2
     * @param lon2
     * @return distance between coordinates (wgs84) in nautical miles
     */
    public static double distanceWgs84NauticalMiles(final double lat1, final double lon1, final double lat2, final double lon2) {
        return distanceWgs84Miles(lat1, lon1, lat2, lon2) * 0.8684;
    }

    /**
     * @param deg
     * @return degrees to radians
     */
    private static double deg2rad(final double deg) {
        return (deg * Math.PI / 180.0);
    }

    /**
     * @param rad
     * @return radians to degrees
     */
    private static double rad2deg(final double rad) {
        return (rad * 180.0 / Math.PI);
    }
}
