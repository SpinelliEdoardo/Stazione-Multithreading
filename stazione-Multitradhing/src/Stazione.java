public class Stazione extends Thread {
    public volatile boolean interrupt = false;
    public boolean passaggioTreno = false;
    private volatile boolean sbarra = false; //false=alzata , true=abbassata
    private volatile boolean semaforo = false; //false=verde , true=rosso

    public boolean isSbarra() {
        return sbarra;
    }

    public void abbassaSbarra() {
        sbarra = true;
        semaforo = true;
        System.out.println("la sbarra si e' abbassata e il semaforo e' diventato rosso");
    }

    public void alzaSbarra() {
        sbarra = false;
        semaforo = false;
        System.out.println("la sbarra si e' alzata e il semaforo e' diventato verde e quindi si puo attraversare fino a quando non arriva un altro treno");
    }

    @Override
    public void run() {
        while (!interrupt) {
            if (passaggioTreno) {
                try {
                    System.out.println("si sta abbassando la sbarra");
                    Thread.sleep(1000);
                    abbassaSbarra();


                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    //ignored
                }
                alzaSbarra();
                passaggioTreno = false;
            }
        }
    }
}