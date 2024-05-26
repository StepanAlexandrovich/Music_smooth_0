package music.core;

public class NumbersWrapper {
    private Numbers numbers;
    private int durationBeat;
    private int step = 0;

    public NumbersWrapper(Numbers numbers) {
        this.numbers = numbers;
    }
    // set
    public void setDurationBeat(int durationBeat) { this.durationBeat = durationBeat; }
    // get
    public int getHz(){ return numbers.getHz(); }
    public void process(Numbers numbers){
        if(++step == durationBeat){ step = 0; }

        numbers.process();
    }



}
