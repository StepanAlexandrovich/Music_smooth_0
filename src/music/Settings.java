package music;

import music.audibility.Sound;
import music.core.Beat;
import music.core.NumbersCreator;
import music.core.PointsCreator;
import music.visibility.CanvasFrame;
import music.core.Numbers;

import java.util.List;

public class Settings {
    private NumbersCreator numbersCreator = new NumbersCreator();
    private PointsCreator pointsCreator = new PointsCreator();

    private Numbers numbers;
    private Sound sound;
    private CanvasFrame canvas;

    private Beat beat;
    private Delay delay;

    public Settings(Numbers numbers,Sound sound,CanvasFrame canvasFrame,Beat beat,Delay delay) {
        this.numbers = numbers;
        this.sound = sound;
        this.canvas = canvasFrame;
        this.beat = beat;
        this.delay = delay;
    }

    int numberOfSong = -1;
    public void updateSong(){
        if(++numberOfSong == 2){
            numberOfSong = 0;
        }

        switch (numberOfSong){
            case 0: song0(); break;
            case 1: song1(); break;
        }
    }

    public void song0(){
        int divider = 96;
        int smoothness = 1;
        int distanceCircle = divider*smoothness;
        List<Integer> numbers = this.numbersCreator.line(divider);

        pointsCreator
                .setLength(numbers.size())
                .setDistancesCircle(distanceCircle)
                .setDistances(0)
                .setSpeedsExtended(numbers,0,10.0);
        this.numbers
                .setMode("DOWN")
                .setPoints(pointsCreator.getPoints());
        beat
                .setDurationBeat(smoothness);
        sound
                .setVolume(5)
                .setDuration(500);
        canvas
                .setAutoMultiplicationX(distanceCircle)
                .setAutoMultiplicationY(divider/2);
        delay
                .setDelay(5);
    }

    public void song1(){
        int divider = 1260;
        int smoothness = 1;
        int distanceCircle = divider*smoothness;
        List<Integer> dividends = this.numbersCreator.dividends(divider);

        pointsCreator
                .setLength(dividends.size())
                .setDistancesCircle(distanceCircle)
                .setDistances(0)
                .setSpeedsExtended(dividends,200,0.5);
        numbers
                .setMode("DOWN")
                .setPoints(pointsCreator.getPoints());
        beat
                .setDurationBeat(smoothness);
        sound
                .setVolume(5)
                .setDuration(500);
        canvas
                .setAutoMultiplicationX(distanceCircle)
                .setAutoMultiplicationY(divider/2);
        delay
                .setDelay(5);
    }

}
