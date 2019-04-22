package CarParking;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Car implements Comparable<Car>{

    private String Plate_Number;
    private String Owner;
    private String Time_in_complete;
    private String Time_out_complete;
    private String status_String;
    private int status;
    private int payment;
    String position;
    private String model;
    public Car(String model, String plateNumber, String owner, String position) {

        status =1;
        Plate_Number = plateNumber;
        Owner = owner;
        model = model;
        check_Statust(status);
        payment =0;
        this.position = position;
    }


    private void check_Statust(int n){

        if(n ==1){
            status_String = "Bronze Membership";
        }else if(n ==2){
            status_String = "Silver MemberShip";
        }else if(n==3){
            status_String="Gold MemberShip";
        }else if(n == 4){
            status_String = "Platinum MemberShip";
        }else if(n ==5){
            status_String ="Luxury MemberShip";
        }else{
            System.out.println("Can't Update anymore");
            n = 5;
        }

        this.status = n;


    }


    public String getModel() { return model; }

    public void setModel(String model){
        this.model = model;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPlate_Number() {
        return Plate_Number;
    }

    public void setPlate_Number(String plate_Number) {
        Plate_Number = plate_Number;
    }

    public String getOwner() {
        return Owner;
    }

    public String getStatus_String() {
        return status_String;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        check_Statust(status);
    }

    public void setOwner(String owner) {
        Owner = owner;
    }


    public String getTime_in_complete() {
        return Time_in_complete;
    }

    public void setTime_in_complete(String time_in_complete) {
        Time_in_complete = time_in_complete;
    }

    public String getTime_out_complete() {
        return Time_out_complete;
    }

    public void setTime_out_complete(String time_out_complete) {
        Time_out_complete = time_out_complete;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }


    @Override
    public String toString() {
        return "Car{" +
                "Plate_Number='" + Plate_Number + '\'' +
                ", Owner='" + Owner + '\'' +
                ", Time_in_complete='" + Time_in_complete + '\'' +
                ", Time_out_complete='" + Time_out_complete + '\'' +
                ", status_String='" + status_String + '\'' +
                ", status=" + status +
                ", position='" + position + '\'' +
                ", model='" + model + '\'' +
                '}';
    }



    @Override
    public int compareTo(Car o) {
        return this.getOwner().compareToIgnoreCase(o.getOwner());
    }
}
