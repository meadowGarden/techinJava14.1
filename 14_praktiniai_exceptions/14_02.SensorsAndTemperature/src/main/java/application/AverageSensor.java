package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {

    private ArrayList<Sensor> sensors;
    private ArrayList<Integer> archive;

    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.archive = new ArrayList<>();
    }


    public void addSensor(Sensor toAdd) {
        sensors.add(toAdd);
    }

    @Override
    public boolean isOn() {
        boolean areAllOn = true;
        for (Sensor s : sensors) {
            if (!s.isOn()) {
                areAllOn = false;
            }
        }
        return areAllOn;
    }

    @Override
    public void setOn() {
        for (Sensor s : sensors) {
            s.setOn();
        }
    }

    @Override
    public void setOff() {
        for (Sensor s : sensors) {
            s.setOff();
        }
    }

    @Override
    public int read() throws IllegalStateException {

        if (this.isOn()) {

            int readingsSum = 0;
            int readingAvg;

            for (Sensor s : sensors) {
                readingsSum += s.read();
            }

            readingAvg = (int)readingsSum / sensors.size();
            archive.add(readingAvg);
            return readingAvg;

        } else {
            new IllegalStateException();
        }
        return 0;
    }

    public List<Integer> readings() {
        return archive;
    }

}
