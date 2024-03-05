package Feb27;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter password: ");
        String pass = sc.nextLine();

        Thread[] crackers = new Thread[26];

        for (int i = 0; i < 26; i++){
            crackers[i] = new Thread(new CrackerRunnable((char) ('a' + i), pass));
        }

        for (Thread c : crackers){
            c.start();
        }
    }
}
