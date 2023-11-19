package application;

public class StandardSensor implements Sensor {

    private boolean isOn;
    private int number;

    public StandardSensor(int number) {
        this.number = number;
        isOn = true;
    }


    @Override
    public boolean isOn() {
        return isOn;
    }

    @Override
    public void setOn() {}

    @Override
    public void setOff() {}

    @Override
    public int read() throws IllegalStateException {
        if (isOn) {
           return number;
        }
        throw new IllegalStateException();
    }

}
