package Mar5_Bingo;

import java.util.ArrayList;
import java.util.Random;

public class BingoCard {
    int[][] nums;
    int id;

    public BingoCard(int id) {
        this.id = id;

        // TODO randomize the nums
        // Col 1: 1-15
        // Col 2: 16-30
        // Col 3: 31-45, Middle must be 0
        // Col 4: 46-60
        // Col 5: 61-75

        nums = new int[5][5];
        Random r = new Random();

        for (int i = 0; i < 5; i++) {
            ArrayList<Integer> bingoCol = new ArrayList<>();
            int from = (15 * i) + 1;
            int to = 15 * (i + 1);
            for (int j = 0; j < 5; j++) {
                int bingonum;

                if (i == 2 && j == 2) {
                    bingonum = 0;
                } else {
                    do {
                        bingonum =  r.nextInt(from,to);
                    } while(bingoCol.contains(bingonum));
                }

                bingoCol.add(bingonum);
                nums[j][i] = bingonum;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < 5; row++){
            for (int col = 0 ; col < 5; col++){
                sb.append(nums[row][col]).append("\t");
            }

            sb.append("\n");
        }

        return sb.toString();
    }
}
