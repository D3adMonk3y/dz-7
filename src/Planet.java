public enum Planet {
    MERCURY(1, 0,  2439.7, null),
    VENUS(2, 108.2,  6051.8, MERCURY),

    EARTH(3, 149.6,  6371, VENUS),
    MARS(4, 227.9,  3389.5, EARTH),
    JUPITER(5, 778.5,  69911, MARS),
    SATURN(6, 1433.5,  58232, JUPITER),
    URANUS(7, 2872.5,  25362, SATURN),
    NEPTUNE(8, 4495.1,  24622, URANUS);

    private int positionFromSun;
    private double distanceFromPrevious;
    private double distanceFromSun;
    private double radius;
    private Planet previousPlanet;
    private Planet nextPlanet = null;

    private Planet(int positionFromSun, double distanceFromPrevious,  double radius,
                   Planet previousPlanet) {
        this.positionFromSun = positionFromSun;
        this.distanceFromPrevious = distanceFromPrevious;
        this.distanceFromSun = previousPlanet != null ? previousPlanet.distanceFromSun + distanceFromPrevious : 0;
        this.radius = radius;
        this.previousPlanet = previousPlanet;
        if(previousPlanet != null)
            previousPlanet.nextPlanet = this;

    }

    public int getPositionFromSun() {
        return positionFromSun;
    }

    public double getDistanceFromPrevious() {
        return distanceFromPrevious;
    }

    public double getDistanceFromSun() {
        return distanceFromSun;
    }

    public double getRadius() {
        return radius;
    }

    public Planet getPreviousPlanet() {
        return previousPlanet;
    }

    public Planet getNextPlanet() {
        return nextPlanet;
    }
}
