package tictactoe;

public class HardAi extends AIVsUser{
    int row;
    int column;
    String[][] matrix;
    String player;
    String opponent;
    int opponentMove = 0;

    public HardAi(String[][] matrix, String player, String opponent) {
        super(matrix, 0, 0);
        this.matrix = matrix;
        this.player = player;
        this.opponent = opponent;

    }
    public int getOpponentMove() {
        return opponentMove;
    }
    public String[][] findOptimalMove(String[][] matrix, String player, String opponent) {

        int bestValue = -1000;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j].equals(" ")) {
                    matrix[i][j] = player;
                    int moveVal = minimax(matrix, 0, false,  player, opponent);
                    matrix[i][j] = " ";
                    if (moveVal > bestValue) {
                        bestValue = moveVal;
                        row = i;
                        column = j;
                    }
                }
            }
        }
        matrix[row][column] = player;
        opponentMove++;
        return matrix;

    }
    public int minimax(String[][] matrix, int depth, boolean isMax, String player, String opponent) {

        int score = evaluate(matrix, player, opponent);


        if (score == 10) {
            return score;
        } else if (score == -10) {
            return score;
        }
        if (! isMatrixEmpty(matrix)) {

            return 0;
        }

        if (isMax) {
            int best = -1000;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j].equals(" ")) {
                        matrix[i][j] = player;
                        best =  Math.max(best, minimax(matrix, depth + 1, false, player, opponent));
                        matrix[i][j] = " ";
                    }
                }
            }
            return best;
        }
        else {
            int best = 1000;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j].equals(" ")) {
                        matrix[i][j] = opponent;
                        best =  Math.min(best, minimax(matrix, depth + 1, true, player, opponent));
                        matrix[i][j] = " ";
                    }
                }
            }
            return best;

        }

    }

    public  boolean isMatrixEmpty(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j].equals(" ")) {
                    return true;
                }
            }
        }
        return false;
    }

    public  int evaluate(String[][] matrix, String player, String opponent) {


        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0].equals(matrix[i][1]) && matrix[i][0].equals(matrix[i][2])) {
                if (matrix[i][0].equals(player)) {
                    return +10;
                } else if (matrix[i][0].equals(opponent)){
                    return -10;
                }
            }
        }
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] .equals( matrix[1][j]) && matrix[0][j].equals( matrix[2][j])) {
                if (matrix[0][j] .equals( player) ){
                    return +10;
                } else if (matrix[0][j] .equals( opponent)) {
                    return -10;
                }
            }
        }
        if (matrix[0][0] .equals( matrix[1][1]) && matrix[0][0] .equals( matrix[2][2])) {
            if (matrix[0][0] .equals( player)) {
                return +10;
            } else if (matrix[0][0] .equals( opponent)){
                return -10;
            }
        }
        if (matrix[0][2] .equals( matrix[1][1]) && matrix[0][2] .equals( matrix[2][0])) {
            if (matrix[0][2] .equals( player)) {
                return +10;
            } else if (matrix[0][2] .equals( opponent)){
                return -10;
            }
        }
        return 0;


    }


}
