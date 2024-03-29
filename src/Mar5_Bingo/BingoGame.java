package Mar5_Bingo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BingoGame implements Runnable {
    List<BingoCard> cards;
    List<Thread> bingoPatterns;
    static boolean isBingo = false;
    static final boolean[] result = new boolean[76];
    @Override
    public void run() {
        Scanner s = new Scanner(System.in);
        System.out.print("Choose patter (1. +  2. #  3. Black-out) : ");
        int pattern = s.nextInt();

        System.out.print("How many players? ");
        int cnt = s.nextInt();

        cards = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            cards.add(new BingoCard(i+1));
        }

        bingoPatterns = new ArrayList<>();
        for (BingoCard card : cards) {
            System.out.println("Card " + card.id);
            System.out.println(card);

            switch (pattern){
                case 1:
                    bingoPatterns.add(new Thread(new BingoPatternPlus(card)));
                    break;
                case 2:
                    bingoPatterns.add(new Thread(new BingoPatternHash(card)));
                    break;
            }
        }

//        // TODO create your checker threads per card
//        Thread[] checkerThrds = new Thread[cnt];
//        for (int i = 0; i < cnt; i++) {
//            checkerThrds[i] = new Thread(new BingoRowChecker(cards.get(i), 2));
//            checkerThrds[i].start();
//        }

//        bingoPatterns = new ArrayList<>();
//
//        for (int i = 0; i < cnt; i++){
//            bingoPatterns.add(new Thread(new BingoPatternHash(cards.get(i))));
//            bingoPatterns.add(new Thread(new BingoPatternPlus(cards.get(i))));
//        }

        for (Thread bp: bingoPatterns){
            bp.start();
        }


        // TODO RANDOM RESULTS
        // TODO randomly get number from 1-75 while not bingo
        result[0] = true;
        Random r = new Random();
        int num;
        while (!isBingo){
            do {
                num = r.nextInt(1, 75);
            } while (result[num]);

            result[num] = true;

            synchronized (result) {
                result.notifyAll();
            }

            System.out.println(num);

            printBingoRes();

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println("UNSAN MAN UY");
            }
        }

        System.out.println("WE GOT A BINGO!!!");
        printBingoRes();

        for (Thread t: bingoPatterns){
            t.interrupt();
        }

        s.close();
    }

    private void printBingoRes() {
        System.out.println("\nB I N G O");
        for (int i = 0; i < 76; i++){
            if (result[i]){
                System.out.print(i + " ");
            }
        }
        System.out.println("\n");
    }
}
