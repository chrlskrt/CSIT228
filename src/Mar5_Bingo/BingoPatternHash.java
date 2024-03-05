package Mar5_Bingo;

public class BingoPatternHash extends BingoPattern{
    public BingoPatternHash(BingoCard toCheck) {
        super(toCheck);
        bingoCheckers.add(new Thread(new BingoRowChecker(toCheck, 2)));
        bingoCheckers.add(new Thread(new BingoRowChecker(toCheck, 4)));

        bingoCheckers.add(new Thread(new BingoColumnChecker(toCheck, 2)));
        bingoCheckers.add(new Thread(new BingoColumnChecker(toCheck, 4)));
    }

    @Override
    public void run() {


        for (Thread bc: bingoCheckers){
            bc.start();
            try {
                bc.join();
            } catch (InterruptedException e) {
                System.out.println("Card [" + toCheck.id + "] loses");
            }
        }

        BingoGame.isBingo = true;
        System.out.println("Card [" + toCheck.id + "] completes Hash pattern");
        System.out.println(toCheck);
    }
}
