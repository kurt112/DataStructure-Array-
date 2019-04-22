package CandyMachine;

public class Candy {

    private int price;
    private int pieces;
    private String name;

    public Candy(String name,int price, int pieces) {
        this.price = price;
        this.pieces = pieces;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        if(this.pieces - pieces < 0){
            System.out.println(" Can't order that many, " + " Only available " + getPieces() );
        }else{
            this.pieces = pieces;
        }
    }

    public boolean CheckStack(){

        if(pieces !=0){
            return true;
        }else {
            return false;
        }

    }
}
