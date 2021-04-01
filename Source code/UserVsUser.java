package tictactoe;

import java.util.InputMismatchException;

public class UserVsUser extends AIVsUser{
    private int UserMove2;
    private String[][] matrix;
    public UserVsUser(String[][] matrix, int move) {
        super(matrix,0,0);
        this.matrix = matrix;
        this.UserMove2 = move;
    }

    public int getUserMove2() {
        return UserMove2;
    }

    public String[][] userMove2(String a) {
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
                    UserMove2++;
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



}

