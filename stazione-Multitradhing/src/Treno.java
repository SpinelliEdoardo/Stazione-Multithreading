import java.util.Random;

public class Treno extends Thread { //processo A
    private Stazione stazione;
    public volatile boolean interrupt = false;

    @Override
    public void run() {
        stazione = new Stazione();
        stazione.start();
        Random random = new Random();
        while (!interrupt) {
            if (random.nextInt(10) == 0) {
                if (!stazione.isSbarra()) {
                    System.out.println("il treno sta arrivando");
                    try {
                        stazione.passaggioTreno = true;
                        Thread.sleep(3000);
                        System.out.println("sta passando il treno");
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        //ignored
                    }
                }
            }
        }
    }
}