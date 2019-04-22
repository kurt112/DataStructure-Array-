import java.io.IOException;

public class Clock {

    public static void main(String[] args) throws InterruptedException, IOException {

        Time time = new Time(0,0,0);


        while (true){

            time.run();
            time.seeClock();
            Thread.sleep(1000);
            System.out.print("\033[H\033[2J");
            System.out.flush();


        }
    }


    public static class Time {

        private int hour;
        private int minutes;
        private int seconds;

        public Time(int hour, int minutes, int seconds) {
            this.hour = hour;
            this.minutes = minutes;
            this.seconds = seconds;
        }

        public void run(){

            this.seconds++;
            check_hour();
            check_minutes();
            check_Second();


        }

        public void seeClock() throws IOException {
            System.out.println(hour + " : " + minutes + " : " + seconds);

        }

        public void check_Second(){

            if(this.seconds > 59){setMinutes(minutes); minutes++; this.seconds =0;}


        }

        public void check_hour(){

            if(this.hour > 24) {
                setMinutes(0);
                setHour(0);
                setSeconds(0);
                this.hour = 0;
            }

        }

        public void check_minutes(){

            if(minutes >59) {
                this.minutes = 0;
                hour++;
                setMinutes(this.hour);
            }
        }

        public int getHour() {
            return hour;
        }

        public void setHour(int hour) {
            this.hour = hour;
        }

        public int getMinutes() {
            return minutes;
        }

        public void setMinutes(int minutes) {
            this.minutes = minutes;
        }

        public int getSeconds() {
            return seconds;
        }

        public void setSeconds(int seconds) {
            this.seconds = seconds;
        }
    }

}
