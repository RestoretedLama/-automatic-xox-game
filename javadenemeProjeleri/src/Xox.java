public class Xox {
    public int boardSize = 3;
    private int moveCount;
    private String firstPlayer;
    private String secondPlayer;
    private boolean firstPlayerTurn = true;
    private boolean isFinished = false;

    private int board[][];

    public Xox(String firstPlayer, String secondPlayer){
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.moveCount = 0;
        board = new int[boardSize][boardSize];
        cleanBoard();
    }
    public void mark(int row, int column){
        boolean validMove = row>=0 && row<boardSize && column>=0 && column<boardSize && board[row][column] ==0;

        if(!isFinished){
          if(validMove){
            if (firstPlayerTurn){
                board[row][column] = 1;
            }else {
                board[row][column] = 2;
            }
            int state = gameState();
            updateGameState(state);
          }else {
              System.out.println("you can not mark this area");
          }
        }else {
            System.out.println("Game over!!!");
        }
    }
    private char maskValues(int value){
        char symbol;
        if(value == 1){
            symbol = 'X';
        }
        else if (value == 2){
            symbol = 'O';
        }else {
            symbol = ' ';
        }
             return symbol;
    }
    public void printBoard(){
        System.out.println("--------------");
        for (int r = 0; r < boardSize; r++) {
            for (int c = 0; c < boardSize; c++) {
                System.out.print(maskValues(board[r][c]) + " ");
            }
            System.out.println();
        }
        System.out.println("--------------");
    }
    private void cleanBoard()
    {
        for (int r = 0; r < boardSize; r++) {
            for (int c = 0; c < boardSize; c++) {
                board[r][c] = 0;
            }

        }

    }

    private int gameState()
    {
        int winConditions[] = new int[8];
        int state = 0;

        winConditions[0] = board[0][0]*board[0][1]*board[0][2]; //First row
        winConditions[1] = board[1][0]*board[1][1]*board[1][2]; //Second row
        winConditions[2] = board[2][0]*board[2][1]*board[2][2]; //Third row

        winConditions[3] = board[0][0]*board[1][0]*board[2][0]; //First column
        winConditions[4] = board[0][1]*board[1][1]*board[2][1]; //Second column
        winConditions[5] = board[0][2]*board[1][2]*board[2][2]; //Third column

        winConditions[6] = board[0][0]*board[1][1]*board[2][2]; //First diagonal
        winConditions[7] = board[0][2]*board[1][1]*board[2][0]; //Second diagonal
        for (int i = 0; i < winConditions.length; i++) {
           if (winConditions[i] == 1 || winConditions[i] == 8)
           {
               state = winConditions[i];
               return state;
           }
        }
        return state;
    }
    private void updateGameState(int gameState)
    {
        if(gameState == 0)
        {
            firstPlayerTurn = !firstPlayerTurn;
            moveCount++;
          if(moveCount > 8 )
          {
           System.out.println("Draw");
           isFinished = true;
          }
        }else if(gameState == 1)
        {
            System.out.println(firstPlayer + " Won!");
            isFinished = true;
        }else if (gameState == 8){
            System.out.println(secondPlayer + "Won!!");
        }
        else {
            System.out.println("Corrupt game state: " + gameState);
        }
    }



}
