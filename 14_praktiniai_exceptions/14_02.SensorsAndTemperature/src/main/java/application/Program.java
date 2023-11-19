package application;

public class Program {

    public static void main(String[] args) {

//        StandardSensor stdSensor = new StandardSensor(5);
//        System.out.println(stdSensor.read());
//        System.out.println(stdSensor.isOn());

//        TemperatureSensor tempSensor = new TemperatureSensor();
//        tempSensor.setOn();
//        System.out.println(tempSensor.isOn());
//
//        System.out.println(tempSensor.read());

        Sensor kumpula = new TemperatureSensor();
        Sensor kaisaniemi = new TemperatureSensor();
        Sensor helsinkiVantaaAirport = new TemperatureSensor();

        AverageSensor helsinkiRegion = new AverageSensor();
        helsinkiRegion.addSensor(kumpula);
        helsinkiRegion.addSensor(kaisaniemi);
        helsinkiRegion.addSensor(helsinkiVantaaAirport);

        helsinkiRegion.setOn();
        System.out.println("temperature in Helsinki region " + helsinkiRegion.read());
        System.out.println("temperature in Helsinki region " + helsinkiRegion.read());
        System.out.println("temperature in Helsinki region " + helsinkiRegion.read());

        System.out.println(helsinkiRegion.readings());
    }

}
