package CandyMachine;

public class Shop {

    private Container container;
    private CashRegister cashRegister;

    public Shop(Container container, CashRegister cashRegister) {
        this.container = container;
        this.cashRegister = cashRegister;
    }

    public Container getContainer() {
        return container;
    }

    public CashRegister getCashRegister() {
        return cashRegister;
    }

    public void view_Cash(){

    }

    public void View_Candies(){

    }

    public void Buy_Candy(String Candy_Name, int pieces, int money) throws NullPointerException{

        Candy candy = container.decrement(Candy_Name);
        candy.setPieces(candy.getPrice() - pieces);
        if (money < candy.getPrice()){

            System.out.println("Your money is insufficient");

        }else {
            int change = money - candy.getPrice();
            cashRegister.setCash(cashRegister.getCash() + (money - change));
            System.out.println("Your Change " + change);
        }
    }
}
