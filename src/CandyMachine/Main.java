package CandyMachine;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Candy cookies = new Candy("Cookies",100,100);
        Candy donut  = new Candy("donut",100,50);
        Candy lollipop = new Candy("Lollipop",100, 23);


        Container container = new Container();
        container.getCandy().add(cookies);
//        container.addCandy(cookies);
//        container.addCandy(donut);
//        container.addCandy(lollipop);

        CashRegister cashRegister = new CashRegister(500);

        Shop shop = new Shop(container, cashRegister);

        shop.Buy_Candy("donut",10,12);
        shop.getContainer().ViewCandy();



    }



}
