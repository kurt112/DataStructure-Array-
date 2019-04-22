package CarParking;
import java.util.Scanner;
public class Main {

  private static  Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {




        Parking parking = new Parking();

        parking.Parking_In();

        System.out.println(" Press 1 to Have Transaction \n" +
                " Press 2 to Update Membership \n" +
                " Press 3 to View the Cars in the parking Area \n" +
                " Press 4 to View the history of parking Area \n" +
                " Press 5 to View Available Space \n" +
                " Press 6 to View Occupied Space");

        parking.Park_Out("mark");
        boolean quit = true;

        do{

            System.out.println("Enter your Action");
            int action = scanner.nextInt();

            Action(action, parking);

            if(action == 0){
                quit = false;
            }

        }while (quit);



    }

    public static void Action (int Input, Parking park){

        switch (Input){
            case 1:
                MethodPayment();
                break;
            case 2:
                Update_Membership(park);break;
            case 3:
                ViewCars(park); break;
            case 4:
                ViewHistory(park); break;
            case 5:
                ViewAvailable(park); break;
            case 6:
                ViewOccupied(park);break;
        }

    }

    private static void Update_Membership(Parking park){

        System.out.println("Enter Owner Name");
        String owner = scanner.nextLine();

        if(park.historyParking(owner)){

            park.update_Membership(owner);

        }else{

            System.out.println("Can't Update membership for First" +
                    "Timer");

        }

    }

    private static void ViewCars(Parking park){

        System.out.println("Press 1 to view car model "
                + "\n Press 2 to view car Owner "
                + "\n Press 3 to view car Model "
                + "\n Press 4 to view car Time In "
                + "\n Press 5 to view car Plate Number "
                + "\n Press 6 to view car MemberShip "
                + "\n Press 7 to view all"
                + "\n Press anything to cancel except 1 - 7 ");

        System.out.print("Enter your action: ");
        int actions = scanner.nextInt();

        switch (actions){
            case 1:
                park.Car_Model();
                break;
            case 2:
                park.Car_Owner();
                break;
            case 3:
                park.Car_Model();
                break;
            case 4:
                park.Car_Timein();
                break;
            case 5:
                park.Car_PlateNumber();
                break;
            case 6:
                park.Car_Membership();
            case 7:
                park.Car_View_All();
                default:
                    break;
        }

    }

    private static void ViewHistory(Parking park){


        System.out.println("Press 1 to view car model "
                + "\n Press 2 to view car Owner "
                + "\n Press 3 to view car Model "
                + "\n Press 4 to view car Time In "
                + "\n Press 5 to view car Time Out "
                + "\n Press 6 to view car Plate Number "
                + "\n Press 7 to view car MemberShip "
                + "\n Press 8 to view all"
                + "\n Press anything to cancel except 1-8");

        System.out.print("Enter your action: ");
        int actions = scanner.nextInt();

        switch (actions){
            case 1:
                park.Car_Model_Hisotry();
                break;
            case 2:
                park.Car_Owner_Hisotry();
                break;
            case 3:
                park.Car_Model_Hisotry();
                break;
            case 4:
                park.Car_Timein_Hisotry();
                break;
            case 5:
                park.Car_TimeOut_Hisotry();
                break;
            case 6:
                park.Car_PlateNumber_Hisotry();
                break;
            case 7:
                park.Car_Membership_Hisotry();
            case 8:
                park.Car_View_All();
        }

    }

    private static void ViewAvailable(Parking park){

        park.View_Available_Space();

    }

    private static void ViewOccupied(Parking park){

        park.View_Occupied_Space();

    }

    private static void MethodPayment(){

        System.out.println("\n\n");

        System.out.println("Enter your Action");
        int action = scanner.nextInt();

        System.out.println(" Press 1 to Back \n" +
                " Press 2 to Parking In \n" +
                " Press 3 to Sm Points \n"+
                " Press 4 to Pay Lost Ticket \n"+
                " Press 5 to Pay Using CreditCard \n" +
                " Press 6 to Pay Using Sm Advantage ");
        switch (action){

            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;

        }


    }




}
