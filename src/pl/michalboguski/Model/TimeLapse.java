package pl.michalboguski.Model;


import java.time.LocalTime;

public class TimeLapse extends Thread {
    public static int seconds = 0;

    public TimeLapse() {
    }

    public void run() {

        while (true){
            try {
                TimeLapse.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            seconds ++;
            System.out.println(DificulyLevel.level);
            if ((seconds % 5) == 0)
                DificulyLevel.level++;
            System.out.println("sekunda "+ seconds);
            System.out.println("LEVEL" + DificulyLevel.level );

        }

}

    public int getSeconds() {
        return seconds;
    }
}

