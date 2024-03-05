package Mar5_Bingo;

import java.util.ArrayList;
import java.util.List;

public abstract class BingoPattern implements Runnable{
    List<BingoChecker> bingoCheckers;
    BingoCard toCheck;

    public BingoPattern(BingoCard toCheck) {
        this.toCheck = toCheck;
    }

    @Override
    public void run() {
        List <Thread> bcThreads = new ArrayList<>();

        for (BingoChecker checker: bingoCheckers){
            bcThreads.add(new Thread(checker));
        }

        for (Thread bc: bcThreads){
            bc.start();
        }

        for (Thread bc: bcThreads){
            try {
                bc.join();
            } catch (InterruptedException e) {
                System.out.println("Card [" + toCheck.id + "] loses");
                return;
            }
        }

        BingoGame.isBingo = true;
        System.out.println("Card [" + toCheck.id + "] completes pattern");
        System.out.println(toCheck);
    }
}
