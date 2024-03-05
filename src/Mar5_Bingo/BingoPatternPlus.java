package Mar5_Bingo;

public class BingoPatternPlus extends BingoPattern{

    public BingoPatternPlus(BingoCard toCheck) {
        super(toCheck);
    }

    @Override
    public void run() {
        bingoCheckers.add(new Thread(new BingoRowChecker(toCheck, 3)));
        bingoCheckers.add(new Thread(new BingoColumnChecker(toCheck, 3)));

        for (Thread bc: bingoCheckers){
            bc.start();
        }

        BingoGame.isBingo = true;
        System.out.println("Card [" + toCheck.id + "] completes pattern");
        System.out.println(toCheck);
    }
}
