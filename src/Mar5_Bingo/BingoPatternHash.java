package Mar5_Bingo;

import java.util.ArrayList;

public class BingoPatternHash extends BingoPattern{
    public BingoPatternHash(BingoCard toCheck) {
        super(toCheck);
        bingoCheckers = new ArrayList<>();
        bingoCheckers.add(new BingoRowChecker(toCheck, 2));
        bingoCheckers.add(new BingoRowChecker(toCheck, 4));

        bingoCheckers.add(new BingoColumnChecker(toCheck, 2));
        bingoCheckers.add(new BingoColumnChecker(toCheck, 4));
    }
}
