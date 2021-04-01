package tictactoe;

public class gameStart {
    private AIVsUser AIVsUser;
    private AIVsAI AIVsAI;
    private UserVsUser UserVsUser;
    private HardAi hardAi;
    private String[][] matrix;
    private int XWin = 0;
    private int OWin = 0;

    public gameStart(AIVsUser AIVsUser, String[][] matrix) {
        this.AIVsUser = AIVsUser;
        this.matrix = matrix;
    }
    public gameStart(AIVsAI AIVsAI, String[][] matrix) {
        this.AIVsAI = AIVsAI;
        this.matrix = matrix;
    }
    public gameStart(UserVsUser UserVsUser, String[][] matrix) {
        this.UserVsUser = UserVsUser;
        this.matrix = matrix;
    }
    public gameStart(HardAi hardAi, String[][] matrix) {
        this.matrix = matrix;
        this.hardAi = hardAi;
    }

    public void StartUserVsAI() {
        AIVsUser.printMatrix(matrix);
        boolean gameOver = false;
        while (! gameOver) {
            matrix = AIVsUser.userMove("X");
            AIVsUser.printMatrix(matrix);
            XWin = AIVsUser.AnalyseMatrix(matrix,"X");
            gameOver = WhoWins(XWin, OWin, AIVsUser.getUserMove(), AIVsUser.getOpponentMove());
            if (gameOver) {
                break;
            }
            System.out.println("Making move level \"easy\" ");
            matrix = AIVsUser.RandomMove(matrix, "O");
            AIVsUser.printMatrix(matrix);
            OWin = AIVsUser.AnalyseMatrix(matrix, "O");
            gameOver = WhoWins(XWin,OWin,AIVsUser.getUserMove(),AIVsUser.getOpponentMove());
        }
        XWin = 0;
        OWin = 0;

    }
    public void StartAIVsUser() {
        AIVsUser.printMatrix(matrix);
        boolean gameOver = false;
        while (! gameOver) {
            System.out.println("Making move level \"easy\" ");
            matrix = AIVsUser.RandomMove(matrix,"X");
            AIVsUser.printMatrix(matrix);
            XWin = AIVsUser.AnalyseMatrix(matrix, "X");
            gameOver = WhoWins(XWin,OWin,AIVsUser.getUserMove(),AIVsUser.getOpponentMove());
            if (gameOver) {
                break;
            }
            matrix = AIVsUser.userMove("O");
            AIVsUser.printMatrix(matrix);
            OWin = AIVsUser.AnalyseMatrix(matrix, "O");
            gameOver = WhoWins(XWin,OWin,AIVsUser.getUserMove(),AIVsUser.getOpponentMove());
        }
        XWin = 0;
        OWin = 0;
    }

    public void StartAIMediumVsUser() {
        AIVsUser.printMatrix(matrix);
        boolean gameOver = false;
        while (! gameOver) {
            System.out.println("Making move level \"medium\" ");
            matrix = AIVsUser.RandomMoveMedium(matrix,"X");
            AIVsUser.printMatrix(matrix);
            XWin = AIVsUser.AnalyseMatrix(matrix, "X");
            gameOver = WhoWins(XWin,OWin,AIVsUser.getOpponentMove(),AIVsUser.getUserMove());
            if (gameOver) {
                break;
            }
            matrix = AIVsUser.userMove("O");
            AIVsUser.printMatrix(matrix);
            OWin = AIVsUser.AnalyseMatrix(matrix, "O");
            gameOver = WhoWins(XWin,OWin,AIVsUser.getOpponentMove(),AIVsUser.getUserMove());
        }
        XWin = 0;
        OWin = 0;
    }
    public void StartHardAiVsUser() {
        hardAi.printMatrix(matrix);
        boolean gameOver = false;
        while (! gameOver) {
            System.out.println("Making move level \"hard\" ");
            matrix = hardAi.findOptimalMove(matrix,"X", "O");
            hardAi.printMatrix(matrix);
            XWin = hardAi.AnalyseMatrix(matrix, "X");
            gameOver = WhoWins(XWin,OWin,hardAi.getOpponentMove(),hardAi.getUserMove());
            if (gameOver) {
                break;
            }
            matrix = hardAi.userMove("O");
            hardAi.printMatrix(matrix);
            OWin = hardAi.AnalyseMatrix(matrix, "O");
            gameOver = WhoWins(XWin,OWin,hardAi.getOpponentMove(),hardAi.getUserMove());
        }
        XWin = 0;
        OWin = 0;
    }
    public void StartUserVsMediumAI() {
        AIVsUser.printMatrix(matrix);
        boolean gameOver = false;
        while (! gameOver) {
            matrix = AIVsUser.userMove("X");
            AIVsUser.printMatrix(matrix);
            XWin = AIVsUser.AnalyseMatrix(matrix,"X");
            gameOver = WhoWins(XWin, OWin, AIVsUser.getUserMove(), AIVsUser.getOpponentMove());
            if (gameOver) {
                break;
            }
            System.out.println("Making move level \"medium\" ");
            matrix = AIVsUser.RandomMoveMedium(matrix, "O");
            AIVsUser.printMatrix(matrix);
            OWin = AIVsUser.AnalyseMatrix(matrix, "O");
            gameOver = WhoWins(XWin,OWin,AIVsUser.getUserMove(),AIVsUser.getOpponentMove());
        }
        XWin = 0;
        OWin = 0;
    }
    public void StartUserVsHardAi() {
        hardAi.printMatrix(matrix);
        boolean gameOver = false;
        while (! gameOver) {
            matrix = hardAi.userMove("X");
            hardAi.printMatrix(matrix);
            XWin = hardAi.AnalyseMatrix(matrix,"X");
            gameOver = WhoWins(XWin, OWin, hardAi.getUserMove(), hardAi.getOpponentMove());
            if (gameOver) {
                break;
            }
            System.out.println("Making move level \"hard\" ");
            matrix = hardAi.findOptimalMove(matrix, "O","X");
            hardAi.printMatrix(matrix);
            OWin = hardAi.AnalyseMatrix(matrix, "O");
            gameOver = WhoWins(XWin,OWin,hardAi.getUserMove(),hardAi.getOpponentMove());
        }
        XWin = 0;
        OWin = 0;
    }


    public void StartAIVsAI() {
        AIVsAI.printMatrix(matrix);
        boolean gameOver = false;
        while (! gameOver) {
            System.out.println("Making move level \"easy\" ");
            matrix = AIVsAI.RandomMove(matrix, "X");
            AIVsAI.printMatrix(matrix);
            XWin = AIVsAI.AnalyseMatrix(matrix, "X");
            gameOver = WhoWins(XWin,OWin,AIVsAI.getOpponentMove(),AIVsAI.getOpponentMove2());
            if (gameOver) {
                break;
            }
            System.out.println("Making move level \"easy\" ");
            matrix = AIVsAI.RandomMove2(matrix, "O");
            AIVsAI.printMatrix(matrix);
            OWin = AIVsAI.AnalyseMatrix(matrix, "O");
            gameOver = WhoWins(XWin,OWin,AIVsAI.getOpponentMove(),AIVsAI.getOpponentMove2());
        }
        XWin = 0;
        OWin = 0;


    }
    public void StartHardAiVsHardAi() {
        int XMove = 0;
        int OMove = 0;
        hardAi.printMatrix(matrix);
        boolean gameOver = false;
        while (! gameOver) {
            System.out.println("Making move level \"hard\" ");
            matrix = hardAi.findOptimalMove(matrix, "X", "O");
            hardAi.printMatrix(matrix);
            XMove++;
            XWin = hardAi.AnalyseMatrix(matrix, "X");
            gameOver = WhoWins(XWin,OWin,XMove,OMove);

            if (gameOver) {
                break;
            }
            System.out.println("Making move level \"hard\" ");
            matrix = hardAi.findOptimalMove(matrix, "O", "X");
            hardAi.printMatrix(matrix);
            OMove++;
            OWin = hardAi.AnalyseMatrix(matrix, "O");
            gameOver = WhoWins(XWin,OWin,XMove,OMove);
        }
        XWin = 0;
        OWin = 0;


    }
    public void StartUserVsUser() {
        UserVsUser.printMatrix(matrix);
        boolean gameOver = false;
        while (! gameOver) {
            matrix = UserVsUser.userMove("X");
            UserVsUser.printMatrix(matrix);
            XWin = UserVsUser.AnalyseMatrix(matrix,"X");
            gameOver = WhoWins(XWin, OWin, UserVsUser.getUserMove(), UserVsUser.getUserMove2());
            if (gameOver) {
                break;
            }
            matrix = UserVsUser.userMove2("O");
            UserVsUser.printMatrix(matrix);
            OWin = UserVsUser.AnalyseMatrix(matrix, "O");
            gameOver = WhoWins(XWin,OWin,UserVsUser.getUserMove(),UserVsUser.getUserMove2());
        }
        XWin = 0;
        OWin = 0;
    }


    public boolean WhoWins(int XWin, int OWin, int XMove, int OMove) {
        if (XWin > OWin) {
            System.out.println("X wins");
            return true;
        }  if (OWin > XWin) {
            System.out.println("O wins");
            return true;
        }

        if (XMove == 5 && OMove == 4) {
            System.out.println("Draw");
            return true;
        }
        return false;
    }
}

