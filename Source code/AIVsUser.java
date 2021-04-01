package tictactoe;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class AIVsUser {
    private String[][] matrix;
    public static Scanner scanner = new Scanner(System.in);
    private int UserMove;
    private int OpponentMove;
    private boolean played = false;
    private boolean defend = false;
    private String userMove;



    public AIVsUser(String[][] matrix, int UserMove, int OpponentMove) {
        this.matrix = matrix;
        this.UserMove = UserMove;
        this.OpponentMove = OpponentMove;
    }

    public int getUserMove() {
        return UserMove;
    }

    public int getOpponentMove() {
        return OpponentMove;
    }

    public String[][] userMove(String a) {
        this.userMove = a;
        while (true) {
            System.out.print("Enter the coordinates: > ");
            int i, j;
            try {
                i = scanner.nextInt() - 1;
                j = scanner.nextInt() - 1;
            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
                scanner.nextLine();
                continue;
            }

            try {
                if (matrix[i][j].equals(" ")) {
                    matrix[i][j] = a;
                    UserMove++;
                    break;
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Coordinates should be from 1 to 3!");

            }
        }
        return matrix;
    }

    public void printMatrix(String[][] matrix) {
        System.out.println("---------");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == null) {
                    matrix[i][j] = " ";
                }
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public int AnalyseMatrix(String[][] matrix, String temp) {
        int count = 0;
        int win = 0;
        if ((matrix[0][0].equals(temp) && matrix[1][1].equals(temp) && matrix[2][2].equals(temp)) || (matrix[0][2].equals(temp) && matrix[1][1].equals(temp) && matrix[2][0].equals(temp))) {
            win++;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals(temp)) {
                    count++;
                }
                if (count == 3) {
                    win++;
                }
            }
            count = 0;
        }
        count = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i].equals(temp)) {
                    count++;
                }
                if (count == 3) {
                    win++;
                }
            }
            count = 0;
        }
        return win;
    }

    public String[][] RandomMove(String[][] matrix, String a) {
        Random random = new Random();
        int i;
        int j;
        while (true) {
            i = random.nextInt(matrix.length);
            j = random.nextInt(matrix[0].length);
            if (matrix[i][j].equals(" ")) {
                matrix[i][j] = a;
                OpponentMove++;
                break;
            }
        }
        return matrix;
    }

    public String[][] RandomMoveMedium(String[][] matrix, String a) {
        String[][] matrix1;
        matrix1 = winOrDefend(matrix, a, a);
        if (! played) {
            matrix1 = winOrDefend(matrix, userMove, a);
            if (played) {
                defend = true;
            }
        } if (! defend && ! played) {
            matrix1 = RandomMove(matrix, a);
        }
        return matrix1;
    }





    //add diagonal check
    public String[][] winOrDefend(String[][] matrix, String a, String AIMove) {
        int rowCounter = 0;
        int columnCounter = 0;
        int overallRowCounter = 0;
        int overallColumnCounter = 0;
        int diagonalCounter1 = 0;
        int diagonalCounter2 = 0;
        int noDiagonalElement_i = 0;
        int noDiagonalElement_j = 0;
        int noDiagonalElement2_i = 0;
        int noDiagonalElement2_j = 0;
        int overallDiagonalCounter1 = 0;
        int overallDiagonalCounter2 = 0;
        int tempi = 0;
        int tempj = 2;
        int c;
        int d;
        Random random = new Random();

        for (int i = 0; i < matrix.length; i++) {
            if (! matrix[i][i].equals(" ")) {
                overallDiagonalCounter1++;
                if (matrix[i][i].equals(a)) {
                    diagonalCounter1++;
                }
            }
            if (matrix[i][i].equals(" ")) {
                noDiagonalElement_i = i;
                noDiagonalElement_j = i;
            }
            if (! matrix[tempi][tempj].equals(" ")) {
                overallDiagonalCounter2++;
                if (matrix[tempi][tempj].equals(a)) {
                    diagonalCounter2++;

                }
            }
            if (matrix[tempi][tempj].equals(" ")) {
                noDiagonalElement2_i = tempi;
                noDiagonalElement2_j = tempj;
            }
            tempi++;
            tempj--;

            for (int j = 0; j < matrix[i].length; j++) {
                if (! matrix[i][j].equals(" ")) {
                    overallRowCounter++;
                } if (! matrix[j][i].equals(" ")) {
                    overallColumnCounter++;
                }
                if (matrix[i][j].equals(a)) {
                    rowCounter++;
                }
                if (matrix[j][i].equals(a)) {
                    columnCounter++;
                }
            }

            if (rowCounter == 2 && (overallRowCounter < 3)) {
                while (true) {
                    c = random.nextInt(matrix[0].length);
                    if (matrix[i][c].equals(" ")) {
                        matrix[i][c] = AIMove;
                        OpponentMove++;
                        played = true;
                        return matrix;
                    }
                }
            }


            if (columnCounter == 2 && (overallColumnCounter < 3)) {
                while (true) {
                    d = random.nextInt(matrix.length);
                    if (matrix[d][i].equals(" ")) {
                        matrix[d][i] = AIMove;
                        OpponentMove++;
                        played = true;
                        return matrix;
                    }
                }
            }

            rowCounter = 0;
            columnCounter = 0;
            overallColumnCounter = 0;
            overallRowCounter = 0;
        }
        if (diagonalCounter1 == 2 && (overallDiagonalCounter1 < 3)) {
            matrix[noDiagonalElement_i][noDiagonalElement_j] = AIMove;
            OpponentMove++;
            played = true;
            return matrix;
        }
        if (diagonalCounter2 == 2 && (overallDiagonalCounter2 < 3)) {
            matrix[noDiagonalElement2_i][noDiagonalElement2_j] = AIMove;
            OpponentMove++;
            played = true;
            return matrix;
        }
        played = false;
        defend = false;
        return matrix;
    }

    public String[][] getMatrix() {
        return matrix;
    }
}

