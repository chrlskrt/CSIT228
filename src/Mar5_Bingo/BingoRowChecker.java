package Mar5_Bingo;

public class BingoRowChecker extends BingoChecker{
    int rowToCheck;

    public BingoRowChecker(BingoCard card, int rowToCheck) {
        super(card);
        this.rowToCheck = rowToCheck-1;
    }

    @Override
    public void run() {
        for (int col = 0; col < 5; col++){
            int number = card.nums[rowToCheck][col];
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
