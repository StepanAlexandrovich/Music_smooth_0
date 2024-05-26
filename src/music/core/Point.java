package music.core;

public class Point extends NextValue {
    // static
    private Ring ring;
    private int index;
    private int speed,hz;
    private int hzMultiplication;
    // dynamic
    private int[] distance;

    public Point(int tableLength) {
        super(tableLength);

        distance = new int[tableLength];
        ring = new Ring();
    }

    // SET
    public void setIndex(int index) {
        this.index = index;
    }
    public void setDistanceNow(int distance) {
        this.distance[now] = distance;
    }
    public void setSpeed(int speed) { this.speed = speed; }
    public void setHz(int hz) { this.hz = hz; }
    public void setHzMultiplication(int hzMultiplication) { this.hzMultiplication = hzMultiplication; }

    public void setDistanceCircle(int distanceCircle) { ring.setStart(0).setEnd(distanceCircle - 1); }

    // GET
    public int getIndex() { return index; }

    public int getDistanceBack() { return distance[back]; }
    public int getDistanceNow() { return distance[now]; }
    public int getSpeed() { return speed; }
    public int getHz() { return hz; }
    public int getHzMultiplication() { return hzMultiplication; }

    @Override
    public void nextValue() {
        distance[next] = ring.right(distance[now],speed);
    }
}
