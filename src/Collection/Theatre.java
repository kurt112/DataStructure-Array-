package Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Theatre {

    private final String theatreName;
    private Collection<Seat> seats = new  ArrayList<>();

    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;
        int lastRow = 'A' + (numRows -1);

        for(char row='A'; row<= lastRow; row++){
            for(int seatNum =1; seatNum <=seatsPerRow; seatNum++){
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
            }
        }

    }

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat(String seatNumber){
        Seat requestSeat = null;

        for(Seat seat: seats){
            if(seat.getSeatNumber().equals(seatNumber)){
                requestSeat = seat;
                break;
            }
        }

        if(requestSeat == null){
            System.out.println("There is no  seat " +  seatNumber);
            return false;
        }

        return requestSeat.Reserves();
    }

    public void getSeats(){

        for(Seat seat: seats){
            System.out.println(seat.getSeatNumber());
        }

    }

    private class Seat implements Comparable<Seat>{
        private final String seatNumber;
        private boolean reserves = false;

        public Seat(String seatNumber){
            this.seatNumber = seatNumber;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public boolean Reserves() {
            if(!this.reserves){
                this.reserves=true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            }else{
                return false;
            }

        }

        public boolean cancel(){
            if(this.reserves){
                this.reserves = false;
                System.out.println("Reservation of seat " +  seatNumber + "Cancelled");
                return true;
            }else{
                return false;
            }
        }
    }
}
