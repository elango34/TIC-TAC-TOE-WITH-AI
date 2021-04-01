package tictactoe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String[][] matrix = formEmptyMatrix(3, 3);
            System.out.print("Input command: > ");
            String players = scanner.nextLine();
            switch(players) {
                case "start easy user" : {
                    AIVsUser AIVsUser = new AIVsUser(matrix, 0, 0);
                    gameStart gameStart = new gameStart(AIVsUser, matrix);
                    gameStart.StartAIVsUser();
                    break;
                }

                case "start user easy" : {
                    AIVsUser UserVsAI = new AIVsUser(matrix, 0, 0);
                    gameStart gameStart4 = new gameStart(UserVsAI, matrix);
                    gameStart4.StartUserVsAI();
                    break;
                }

                case "start easy easy" : {
                    AIVsAI AIVsAI = new AIVsAI(matrix, 0);
                    gameStart gameStart2 = new gameStart(AIVsAI, matrix);
                    gameStart2.StartAIVsAI();
                    break;
                }

                case "start user user" : {
                    UserVsUser UserVsUser = new UserVsUser(matrix, 0);
                    gameStart gameStart3 = new gameStart(UserVsUser, matrix);
                    gameStart3.StartUserVsUser();
                    break;
                }
                case "start medium user" : {
                    AIVsUser MediumAIVsUser = new AIVsUser(matrix, 0, 0);
                    gameStart gameStart5 = new gameStart(MediumAIVsUser, matrix);
                    gameStart5.StartAIMediumVsUser();
                    break;
                }

                case"start user medium" : {
                    AIVsUser UserVsMediumAI = new AIVsUser(matrix, 0, 0);
                    gameStart gameStart6 = new gameStart(UserVsMediumAI, matrix);
                    gameStart6.StartUserVsMediumAI();
                    break;
                }
                case "start hard user" : {
                    HardAi hardAi = new HardAi(matrix, "X", "O");
                    gameStart gameStart7 = new gameStart(hardAi, matrix);
                    gameStart7.StartHardAiVsUser();
                    break;
                }

                case "start user hard" : {
                    HardAi hardAi = new HardAi(matrix, "O", "X");
                    gameStart gameStart8 = new gameStart(hardAi, matrix);
                    gameStart8.StartUserVsHardAi();
                    break;

                }

                case "start hard hard" : {
                    HardAi hardAi = new HardAi(matrix, "O", "X");
                    gameStart gameStart9 = new gameStart(hardAi, matrix);
                    gameStart9.StartHardAiVsHardAi();
                    break;
                }

                case "exit" :
                    return;
                default :
                    System.out.println("Bad parameters");
                    break;
            }
        }
    }

    public static String[][] formEmptyMatrix(int row, int column) {
        String[][] matrix = new String[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = " ";
            }
        }
        return matrix;
    }
}
