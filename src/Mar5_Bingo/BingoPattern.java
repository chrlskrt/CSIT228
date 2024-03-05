package Mar5_Bingo;

import java.util.List;

public abstract class BingoPattern implements Runnable{
    List<Thread> bingoCheckers;
    BingoCard toCheck;

    public BingoPattern(BingoCard toCheck) {
        this.toCheck = toCheck;
    }

//    @Override
//    public void run() {
//        for(int i = 0; i < 5; i++){
//            bingoCheckers.add(new Thread(new BingoRowChecker(toCheck, i)));
//            bingoCheckers.add(new Thread(new BingoColumnChecker(toCheck, i)));
//        }
//
//        for (Thread bc: bingoCheckers){
//            bc.start();
//            try {
//                bc.join();
//            } catch (InterruptedException e) {
//                System.out.println("Card [" + toCheck.id + "] loses");
//            }
//        }
//
//        BingoGame.isBingo = true;
//        System.out.println("Card [" + toCheck.id + "] completes pattern");
//        System.out.println(toCheck);
//    }
}
