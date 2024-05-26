package music.core;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    // static
    private List<Point> points;
    private List<Point> currentPoints = new ArrayList<>();
    // dynamic
    private String mode;

    // get
    public List<Point> getPoints() { return points; }
    public int getSpeed(){ return getCurrentPoint().getSpeed(); }
    public int getHz(){
        if(getCurrentPoint()!=null){ return getCurrentPoint().getHz(); }
        else{ return 0; }
    }
    public int getHzMultiplication(){
        if(getCurrentPoint()!=null){ return getCurrentPoint().getHzMultiplication(); }
        else{ return 0; }
    }
    public boolean isEnd() { return points.get(0).getDistanceNow() == 0; }
    // set
    public Numbers setPoints(List<Point> points) {
        this.points = points;
        this.currentPoints = pointsBeat(points);
        return this;
    }
    public Numbers setMode(String mode) {
        this.mode = mode;
        return this;
    }

    //------------------
    public Point getCurrentPoint(){
        Point point = null;

        switch (mode){
            case "UP": point = getPointUp(); break;
            case "DOWN": point = getPointDown(); break;
        }
        return point;
    }
    private Point getPointDown(){
        if(currentPoints.size()>0){ return currentPoints.get(0); }
        return null;
    }
    private Point getPointUp(){
        if(currentPoints.size()>0){ return currentPoints.get(currentPoints.size() - 1); }
        return null;
    }
    private List<Point> pointsBeat(List<Point> points){
        List<Point> pointsBeat = new ArrayList<>();
        for (Point point : points) {
            if(point.getDistanceNow() == 0){
                pointsBeat.add(point);
            }
        }
        return pointsBeat;
    }
    //---------------------------

    public void process(){
        for (Point point : points) {
            point.process();
        }

        currentPoints = pointsBeat(points);
    }

}
