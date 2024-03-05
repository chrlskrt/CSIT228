package Mar5_Bingo;

public class BingoPatternPlus extends BingoPattern{

    public BingoPatternPlus(BingoCard toCheck) {
        super(toCheck);
        bingoCheckers.add(new Thread(new BingoRowChecker(toCheck, 3)));
        bingoCheckers.add(new Thread(new BingoColumnChecker(toCheck, 3)));
    }

    @Override
    public void run() {
        for (Thread bc: bingoCheckers){
            bc.start();
            try {
                bc.join();
            } catch (InterruptedException e) {
                System.out.println("Card [" + toCheck.id + "] loses");
                return;
            }
        }

        BingoGame.isBingo = true;
        System.out.println("Card [" + toCheck.id + "] completes Plus pattern");
        System.out.println(toCheck);
    }
}
