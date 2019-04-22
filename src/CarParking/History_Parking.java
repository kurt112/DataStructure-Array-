package CarParking;

public class History_Parking {

    private Car car;

    public History_Parking(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }



    @Override
    public String toString() {
        return "History_Parking{" +
                "car=" + car +
                '}';
    }
}
