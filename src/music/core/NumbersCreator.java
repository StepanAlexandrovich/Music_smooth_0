package music.core;

import java.util.ArrayList;
import java.util.List;

public class NumbersCreator {
    public List<Integer> dividends(int divider){
        List<Integer> dividends = new ArrayList<>();
        for (int index = 1; index < divider; index++) {
            if(divider % index == 0){
                dividends.add(index);
            }
        }
        return dividends;
    }

    public List<Integer> line(int divider){
        List<Integer> numbers = new ArrayList<>();
        for (int index = 1; index < divider; index++) {
            numbers.add(index);
        }
        return numbers;
    }
}
