import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Treno treno = new Treno();
        System.out.println("INSERISCI 0 PER USCIRE");

        treno.start();

        while(!treno.interrupt) {
            if (scanner.nextInt() == 0) {
                treno.interrupt = true;
                System.exit(0);
            }
        }
    }
}