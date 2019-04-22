package CarParking;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ParkingInner {
    private String Location = "C:\\Users\\orioque35\\Desktop\\History.txt";
    private List<Car> Car_List = new ArrayList<>();
    private List<Section> sections = new ArrayList<>();
    private List<History_Parking> history = new ArrayList<>();
    private char end_section;
    private int quantity_section;
    private String name;

    public ParkingInner(String name, char end_section, int quantity_section) {

        this.end_section = end_section;
        this.quantity_section = quantity_section;
        this.name = name;

        for(char start ='A'; start<=end_section; start++){

            for(int quantity_start=1; quantity_start <= quantity_section+1; quantity_start++){

                sections.add(new Section( new Car("","","",""),
                        start + String.format("%02d", quantity_start)));

            }

        }

    }

    public void View_car(){


        for(Car car: Car_List){

            if(car.getPlate_Number().equals("")){

            }else{
                System.out.println("Car Model: " + car.getPlate_Number() + "| Owner: " + car.getOwner() + "| Position: " +car.getPosition());
            }

        }
    }

    public boolean Park(String model, String position, String owner, String Car_PlateNumber){

        Section section = null;

        for(Section section1: sections){
            if(section1.getName().equals(position)){

                section = section1;
                break;

            }
        }

        if(section == null){

            System.out.println("We don't have that section");
            return false;

        }else {
            section.getCar().setModel(model);
            section.getCar().setPlate_Number(Car_PlateNumber);
            section.getCar().setOwner(owner);
            section.getCar().setPosition(position);


        }
        return section.Time_in();

    }

    public String New_Park(){

        return Postion_Level(1);

    }

    public int Rate(int status){

        int rate = 0;

        if(status ==1){
            return rate =50;
        }else if(status ==2){
            return rate = 60;
        }else if(status ==3){
            return rate = 70;
        }else if(status ==4){
            return rate = 90;
        }else if(status ==5){
            return rate = 100;
        }

        return rate;

    }

    public boolean Park_Out(String position){

        Section section = null;

        for(Section section1: sections){

            if(section1.getName().equals(position)){

                section = section1;
                break;

            }

        }

        if(section == null){

            System.out.println("Can't Time out");

        }

        return section.Time_Out();

    }

    private final Comparator<Car> Car_Sort_Pos = (o1, o2) -> o1.getPosition().compareToIgnoreCase(o2.getPosition());

    private final Comparator<Car> Car_Sort_Model = (o1, o2) -> o1.getPlate_Number().compareToIgnoreCase(o2.getPlate_Number());

    public void SortCar(int a){

        if(a ==1){
            Collections.sort(Car_List);
        }else if(a ==2 ){
            Collections.sort(Car_List,Car_Sort_Pos);
        }else if(a == 3 ){
            Collections.sort(Car_List,Car_Sort_Model);
        }else {
            System.out.println("NO Sort");
        }


    }

    public void View_Sections_Available(){

        System.out.println("--------------------------------------------------------------");
        System.out.println("| \t\t\t\t\t\t  Available  \t\t\t\t\t\t |");
        System.out.println("--------------------------------------------------------------");


        for(int i=0; i<sections.size()-1;i++){

            if(!sections.get(i).isOccupy()){

                if(sections.get(i).getName().charAt(0) != sections.get(i+1).getName().charAt(0) ){
                    System.out.println(" |");
                }else {
                    System.out.print(" | "+sections.get(i).getName());
                }
            }else{

                System.out.print(" |\t");

            }
        }

        System.out.print(" |");
        System.out.println("\n\n");
    }

    public void View_Sections_Occupied(){

        System.out.println("--------------------------------------------------------------");
        System.out.println("| \t\t\t\t\t\t Not Available  \t\t\t\t\t\t |");
        System.out.println("--------------------------------------------------------------");
        int limit = 10;
        for(Section section: sections){

            if(section.occupy){

                System.out.print(" | "+ section.getName());
                limit--;
                if (limit ==0){

                    System.out.println();
                    limit =10;
                }
            }

        }

        System.out.print(" | ");

        System.out.println("\n\n");

    }

    public void View_History(){
        for(History_Parking history_parking: history){

            System.out.println(history_parking.getCar().getPosition());

        }
    }

    public String Postion_Level(int stats){

        String parking = null;

            for(Section section: sections){

                if(!section.isOccupy()){

                    switch (stats){
                        case 1:
                            if(section.getName().charAt(0) == 'A' || section.getName().charAt(0) =='B'
                                    || section.getName().charAt(0) =='C' ) return parking=section.getName();
                            break;
                        case 2:
                            if(section.getName().charAt(0) == 'D') return parking=section.getName();
                            break;
                        case 3:
                            if(section.getName().charAt(0) == 'E')return parking=section.getName();
                            break;
                        case 4:
                            if(section.getName().charAt(0) == 'F') return parking=section.getName();
                            break;
                        case  5:
                            if(section.getName().charAt(0) == 'G') return parking=section.getName();
                            break;
                    }


                    }
                }

        return "ParkingInner is full";

    }

    public List<Car> getCar_List() {
        return Car_List;
    }

    public List<History_Parking> getHistory() {
        return history;
    }

    public List<Section> getSections() {
        return sections;
    }
    public class Section implements Comparable<Section>{

        private String name;
        private boolean occupy;
        private Car car;

        @Override
        public int compareTo(Section o) {
            return 0;
        }

        public Section(Car car,String name) {
            this.name = name;
            occupy = false;
            this.car = car;
            Car_List.add(car);

        }

        public Car getCar() {
            return car;
        }

        public boolean isOccupy() {
            return occupy;
        }

        public void setOccupy(boolean occupy) {
            this.occupy = occupy;
        }

        public String getName() {
            return name;
        }

        public boolean Time_in() {

            DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM dd, u @ H:mm:s a");
            String MyTime = df.format(LocalDateTime.now());

            if (!occupy) {
                setOccupy(true);
                car.setTime_in_complete(MyTime);
                System.out.println("Time in: " + MyTime  );
                return true;
        }else{
                System.out.println("Time in Not Successful");
                return false;
            }

        }


        public boolean Time_Out(){

            DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM dd, u @ H:mm:s a");
            String MyTime =df.format(LocalDateTime.now());

            if(occupy){
                setOccupy(false);
                car.setTime_out_complete(MyTime);
                history.add(0,new History_Parking(car));


                try {
                    File file = new File(Location);
                    FileWriter fileWriter = new FileWriter(file,true);
                    fileWriter.write(car.getOwner() + "\t" + car.getModel()+
                            "\t" + car.getPlate_Number() + "\t" + car.getTime_in_complete() +
                            "\t" + car.getTime_out_complete() +
                            "\t" +car.getStatus_String() + "\t" + car.getPosition() + System.lineSeparator());
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                for(int i=0; i<Car_List.size();i++){

                    if(Car_List.get(i).getPosition()== this.car.getPosition()){
                        Car_List.remove(i);
                    }

                }

                return  true;
            }else{
                System.out.println("Time out not Successful");
                return  false;
            }
        }

    }

}
