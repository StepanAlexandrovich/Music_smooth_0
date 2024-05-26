package music.core;

import java.util.ArrayList;
import java.util.List;

public class PointsCreator {
    private List<Point> points = new ArrayList<>();

    // set
    public PointsCreator setLength(int length){
        points = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            Point point = new Point(3);
            point.setIndex(i);
            points.add(point);
        }
        return this;
    }

    public PointsCreator setDistancesCircle(int distance){
        for (Point point : points) {
            point.setDistanceCircle(distance);
        }
        return this;
    }

    public PointsCreator setDistances(int distance){
        for (Point point : points) {
            point.setDistanceNow(distance);
        }
        return this;
    }

    public PointsCreator setSpeeds(List<Integer> speeds){
        for (int i = 0; i < speeds.size(); i++) {
            points.get(i).setSpeed(speeds.get(i));
        }
        return this;
    }
    public PointsCreator setSpeedsExtended(List<Integer> speeds, int borderDown, double multiplication){
        for (int i = 0; i < speeds.size(); i++) {
            int speed = speeds.get(i);
            int hz = borderDown(speed,borderDown);
            int hzMultiplication = (int)((double)hz * multiplication);

            points.get(i).setSpeed(speed);
            points.get(i).setHz(hz);
            points.get(i).setHzMultiplication(hzMultiplication);
        }
        return this;
    }

    // get
    public List<Point> getPoints() {
        return points;
    }

    //--------------------
    private int borderDown(int value,int borderDown){
        while (value<borderDown && value!=0){
            value*=2;
        }
        return value;
    }
}
