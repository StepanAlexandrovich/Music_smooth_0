package music;

import music.audibility.Sound;
import music.core.*;
import music.visibility.CanvasFrame;
import music.listeners.MouseListenerImpl;

import java.util.List;

public class Main {
    private Numbers numbers = new Numbers();
    //----------------
    private CanvasFrame canvasFrame = new CanvasFrame();
    private Sound sound = new Sound();
    //----------------------
    private Beat beat = new Beat();
    private Delay delay = new Delay();
    //-----------------------------
    private Settings settings = new Settings(numbers,sound,canvasFrame,beat,delay);
    //-----------------------
    //----------------------
    Test test = new Test();
    enum Mode{PROCESS,PAUSE,EXIT,NEXT}
    Mode mode = Mode.PAUSE;

    public static void main(String[] args) {
        new Main().start();
    }

    private int step = -1;
    private void start(){
        canvasFrame.setMouseListener(new MouseListenerImpl(this));

        //settings.updateSong();
        settings.song1();

        sound.open();

        while (true){
            delay.delay();

            switch (mode){
                case PROCESS :
                    step++;

                    // logic
                    if(step>0){
                        numbers.process();
                        beat.process();
                    }
                    // wrapper
                    if(step>=0){
                        if(true)          { canvasFrame.update(numbers);                  }
                        if(beat.isBeat()) { sound.process(numbers.getHzMultiplication()); }
                    }
                    //-------------
//                    if(step>0){
//                        if(numbers.isEnd()){ mode = Mode.PAUSE; }
//                    }

                    break;
                case NEXT:
                    settings.updateSong();
                    mode = Mode.PROCESS;
                    break;
                case EXIT:
                    sound.close();
                    canvasFrame.dispose();
                    return;
            }

        }
    }

    public void startStop(){
        if(mode == Mode.PROCESS){
            mode = Mode.PAUSE;
        }else
        if(mode == Mode.PAUSE){
            mode = Mode.PROCESS;
        }
    }
    public void exit(){
        mode = Mode.EXIT;
    }

    public void nextSong(){
        mode = Mode.NEXT;
    }

}


