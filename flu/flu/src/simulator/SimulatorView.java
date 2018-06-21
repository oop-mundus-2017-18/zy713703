package simulator;

import simulator.Field;

import java.awt.Color;

public interface SimulatorView {

    void setColor(Class animalClass, Color color);

    boolean isViable(Field field);


    void showStatus(int step, Field field);

    void reset();
}