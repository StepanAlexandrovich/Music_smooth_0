package music.core;

public class Beat {
    // static
    private int durationBeat;
    // dynamic
    private int step;

    // set
    public Beat setDurationBeat(int durationBeat) {
        this.durationBeat = durationBeat;
        reset();
        return this;
    }
    // get
    public boolean isBeat(){ return step == 0; }

    //-----------------
    public void reset(){ step = 0; }
    public void process(){
        if(++step == durationBeat){ step = 0; }
    }
    public boolean isBeatProcess(){
        process();
        return step == 0;
    }

}
