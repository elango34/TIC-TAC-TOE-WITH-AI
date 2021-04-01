package tictactoe;

import java.util.Random;

public class AIVsAI extends AIVsUser {
    private int OpponentMove2;
    private String[][] matrix;
    public AIVsAI(String[][] matrix, int a) {
        super(matrix, 0, 0);
        this.matrix = matrix;
        this.OpponentMove2 = a;
    }

    public String[][] RandomMove2(String[][] matrix, String a) {
        this.matrix = matrix;
        Random random = new Random();
        int i;
        int j;
        while (true) {
            i = random.nextInt(matrix.length);
            j = random.nextInt(matrix[0].length);
            if (matrix[i][j].equals(" ")) {
                matrix[i][j] = a;
                OpponentMove2++;
                break;
            }
        }
        return matrix;
    }

    public int getOpponentMove2() {
        return OpponentMove2;
    }
}
