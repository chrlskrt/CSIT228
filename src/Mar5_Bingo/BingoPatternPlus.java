package Mar5_Bingo;

import java.util.ArrayList;

public class BingoPatternPlus extends BingoPattern{

    public BingoPatternPlus(BingoCard toCheck) {
        super(toCheck);
        bingoCheckers = new ArrayList<>();
        bingoCheckers.add(new BingoRowChecker(toCheck, 3));
        bingoCheckers.add(new BingoColumnChecker(toCheck, 3));
    }

//    @Override
//    public void run() {
//        for (Thread bc: bingoCheckers){
//            bc.start();
//            try {
//                bc.join();
//            } catch (InterruptedException e) {
//                System.out.println("Card [" + toCheck.id + "] loses");
//                return;
//            }
//        }
//
//        BingoGame.isBingo = true;
//        System.out.println("Card [" + toCheck.id + "] completes Plus pattern");
//        System.out.println(toCheck);
//    }
}
