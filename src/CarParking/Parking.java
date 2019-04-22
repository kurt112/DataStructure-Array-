package CarParking;

import java.util.Scanner;

public class Parking {

    private ParkingInner parkingInner;

    public Parking() {

        Scanner scanner = new Scanner(System.in);
        String name;
        char section;
        int quantity;


//        System.out.println("Name of Parking ");
//        name = scanner.nextLine();
//
//        System.out.println("Enter End section");
//        section = scanner.next().charAt(0);
//
//        System.out.println("Enter number Per Section");
//        quantity = scanner.nextInt();

        CreateParking("Sm",'G',10);

    }

    private void CreateParking(String name, char End_Section, int quantity_Section){

        ParkingInner parkingInner = new ParkingInner(name, End_Section, quantity_Section);
        this.parkingInner = parkingInner;
        hashCode();
    }




    public void Print_List(){

        System.out.println("\n\n");
        
        System.out.println(" Press 1 to Have Transaction \n" +
                " Press 2 to Update Membership \n" +
                " Press 3 to View the Cars in the parkingInner area \n" +
                " Press 4 to View the history of parkingInner \n" +
                " Press 5 to View Available Space \n" +
                " Press 6 to View Occupied Space");

    }

    public void Have_Transaction(int n){

        System.out.println("\n\n");

        System.out.println(" Press 1 to Back \n" +
                " Press 2 to Parking In \n" +
                " Press 3 to Sm Points \n"+
                " Press 4 to Pay Lost Ticket \n"+
                " Press 5 to Pay Using CreditCard \n" +
                " Press 6 to Pay Using Sm Advantage ");
//        Runtime.getRuntime().exec("cls");
    }



    public boolean Parking_In(){

        Scanner scanner = new Scanner(System.in);
        String Plate_Number,Owner_Name;

        System.out.println("Enter Plate Number");
        Plate_Number = scanner.nextLine();

        History_Parking history_parking = Check(Plate_Number);


        if(history_parking == null){

            System.out.println("Please Enter Name");
            Owner_Name = scanner.nextLine();

            System.out.println("Enter Car Model");
            String model = scanner.nextLine();

            parkingInner.Park(model, parkingInner.New_Park(),Owner_Name,(Plate_Number));
            return true;

        } else if(history_parking.getCar().getPlate_Number().equals(Plate_Number)){

            String pos = parkingInner.Postion_Level(history_parking.getCar().getStatus());
            parkingInner.Park(history_parking.getCar().getModel(),pos,history_parking.getCar().getOwner(),(Plate_Number));
            return true;

        }

        return false;

    }

    private History_Parking Check(String s){

        History_Parking history_parking1 = null;

        for(History_Parking history_parking: parkingInner.getHistory()){

            if(history_parking.getCar().getPlate_Number().equals(s)){

                return history_parking1 = history_parking;

            }

        }

        return null;

    }

    /**
     *
     * The method Below will output the Car List in the current parking area
     * (Car Model, Car plate number, Car Owner, Car Time In, Car Time Out,
     * Car MemberShip)
     */

    public void Car_Model(){

        for(Car car: parkingInner.getCar_List()){

            if(car.getPosition().equals("")){

            }else{
                System.out.println(car.getModel());
            }

        }

    }

    public void Car_Owner(){

        for(Car car: parkingInner.getCar_List()){

            if(car.getPosition().equals("")){

            }else{
                System.out.println(car.getOwner());
            }
        }

    }

    public void Car_PlateNumber (){

        for(Car car: parkingInner.getCar_List()){

            if(car.getPosition().equals("")){

            }else{
                System.out.println(car.getPlate_Number());
            }

        }

    }

    public void Car_Timein(){

        for(Car car: parkingInner.getCar_List()){

            if(car.getPosition().equals("")){

            }else {
                System.out.println(car.getTime_in_complete());
            }

        }

    }

    public void Car_TimeOut(){

        for(Car car: parkingInner.getCar_List()){

            if(car.getPosition().equals("")){

            }else {
                System.out.println(car.getTime_out_complete());
            }

        }

    }

    public void Car_Membership(){

        for (Car car: parkingInner.getCar_List()){

            if(car.getPosition().equals("")){

            }else {
                System.out.println(car.getStatus_String());
            }

        }

    }

    public void Car_View_All(){

        for (Car car: parkingInner.getCar_List()){

            if(car.getPosition().equals("")){

            }else {
                System.out.println(car.toString());
            }

        }
    }

    /**
     *
     * The method Below will output the Car List in Parking history
     * (Car Model, Car plate number, Car Owner, Car Time In, Car Time Out,
     * Car MemberShip)
     */

    public void Car_Model_Hisotry(){

        for(History_Parking history_parking: parkingInner.getHistory()){

            if(history_parking.getCar().getPosition().equals("")){

            }else{
                System.out.println(history_parking.getCar().getModel());
            }

        }

    }

    public void Car_Owner_Hisotry(){

        for(History_Parking history_parking: parkingInner.getHistory()){

            if(history_parking.getCar().getPosition().equals("")){

            }else{
                System.out.println(history_parking.getCar().getOwner());
            }

        }

    }

    public void Car_PlateNumber_Hisotry(){

        for(History_Parking history_parking: parkingInner.getHistory()){

            if(history_parking.getCar().getPosition().equals("")){

            }else{
                System.out.println(history_parking.getCar().getPlate_Number());
            }

        }

    }

    public void Car_Timein_Hisotry(){

        for(History_Parking history_parking: parkingInner.getHistory()){

            if(history_parking.getCar().getPosition().equals("")){

            }else{
                System.out.println(history_parking.getCar().getTime_in_complete());
            }

        }

    }

    public void Car_TimeOut_Hisotry(){

        for(History_Parking history_parking: parkingInner.getHistory()){

            if(history_parking.getCar().getPosition().equals("")){

            }else{
                System.out.println(history_parking.getCar().getTime_out_complete());
            }

        }

    }

    public void Car_Membership_Hisotry(){

        for(History_Parking history_parking: parkingInner.getHistory()){

            if(history_parking.getCar().getPosition().equals("")){

            }else{
                System.out.println(history_parking.getCar().getStatus_String());
            }

        }
    }

    public void Car_View_All_History(){

        for(History_Parking history_parking: parkingInner.getHistory()){

            if(history_parking.getCar().getPosition().equals("")){

            }else {
                System.out.println(history_parking.getCar().toString());
            }

        }

    }

    /**
     *
     * @param Owner - It will check if the owner is true if the owner is
     *              present in the List it will return true and then if the
     *              owner is not present in List it will return false
     *
     */

    public boolean update_Membership(String Owner){

        History_Parking history_parking = null;

        for(History_Parking history_parking1: parkingInner.getHistory()){

            if(history_parking1.getCar().getOwner().equals(Owner)){

                history_parking = history_parking1;

            }

        }

        if(history_parking == null){

            System.out.println("Can't Update");
            return false;

        }else {
            int stats = history_parking.getCar().getStatus();
            System.out.println(" Before ->" + history_parking.getCar().getStatus_String());
            stats++;
            history_parking.getCar().setStatus(stats);
            System.out.println("After -> " + history_parking.getCar().getStatus_String());
            return true;

        }


    }

    /**
     *
     * @param owner - It will check if the owner is on the History if the owner
     *              is on the history of the car it will return true else
     *              it will return false
     *
     */

    public boolean historyParking(String owner){

        History_Parking history_parking =null;

        for(History_Parking history_parking1: parkingInner.getHistory()){

            if(history_parking1.getCar().getOwner().equals(owner)){

                history_parking = history_parking1;

            }

        }

        if(history_parking == null){

            return false;

        }else{

            return true;

        }


    }


    /**
     *
     * @param owner - It will check if the owner is in  the parking are if the
     *              owner is not in the parking are it will return false then
     *              iw will return true
     *
     */

    public boolean Park_Out(String owner){

        Car car1 = null;

        for (Car car: parkingInner.getCar_List()){

            if(car.getOwner().equals(owner)){

                car1 = car;

            }

        }

        if (car1 == null){
            System.out.println("Can't Park out");
            return false;
        }else {
            parkingInner.Park_Out(car1.getPosition());
            System.out.println("success");
            return true;
        }

    }

    public void View_Available_Space(){

        parkingInner.View_Sections_Available();

    }

    public void View_Occupied_Space(){

        parkingInner.View_Sections_Occupied();

    }


}
