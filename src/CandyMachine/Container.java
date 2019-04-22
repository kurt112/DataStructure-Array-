package CandyMachine;

import javax.swing.text.View;
import java.util.List;

public class Container {

    private List<Candy> candy;


    public Container() {


    }

    public void addCandy(Candy candy1){

        candy.add(candy1);
    }

    public Candy decrement(String candy_Name){

        Candy candy1 = null;

        for(Candy candy: this.candy){

            if(candy.getName().equals(candy_Name)){

                candy1 = candy;
                return candy1;
            }

        }

        System.out.println("There are no " + candy_Name);
        System.out.println("Only Available");
        ViewCandy();
        return null;

    }

    public void ViewCandy() {

        for (Candy candy : this.candy) {

            System.out.println("Candy Name : " + candy.getName() + " Pieces : " + candy.getPieces() + " Price : " + candy.getPrice());

        }

    }

    public List<Candy> getCandy() {
        return candy;
    }
}

