package softing.UBaH4ukDev.Lesson13;

import java.util.ArrayList;
import java.util.Arrays;

/****
 Project HomeWork
 Package softing.UBaH4ukDev.Lesson13.ClassWork

 Created by Ivan Sheynmaer

 2021.02.17
 v1.0
 */
public class Race {
    private ArrayList<Stage> stages;
    public ArrayList<Stage> getStages() { return stages; }
    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }
}
