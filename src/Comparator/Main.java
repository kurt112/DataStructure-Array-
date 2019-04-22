package Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Laptop> laps = new ArrayList<>();
        laps.add(new Laptop("Dell",601,20));
        laps.add(new Laptop("Lenovo",20,2050));
        laps.add(new Laptop("Mac",599,2220));
        laps.add(new Laptop("Cherry Mobile",100,2123));
        laps.add(new Laptop("Huawai",200,1234));
        laps.add(new Laptop("Graham",241,1111));
        laps.add(new Laptop("Acer",619,2120));


        Collections.sort(laps);


        for(Laptop l: laps){
            System.out.println(l);
        }


    }


}
