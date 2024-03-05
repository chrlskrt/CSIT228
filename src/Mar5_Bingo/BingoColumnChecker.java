package Mar5_Bingo;

public class BingoColumnChecker extends BingoChecker{
    int colToCheck;

    public BingoColumnChecker(BingoCard card, int colToCheck) {
        super(card);
        this.colToCheck = colToCheck;
    }

    @Override
    public void run() {
        for (int row = 0; row < 5; row++){
            int number = card.nums[row][colToCheck];
            while(!BingoGame.result[number]){
                try {
                    synchronized (BingoGame.result) {
                        BingoGame.result.wait();
                    }
                } catch (InterruptedException e) {
                    System.out.println("Waiting for "+ number);
                }
            }
        }
    }
}
