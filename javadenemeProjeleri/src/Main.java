//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
          Xox game = new Xox("tolga" , "buğra ");
          System.out.println("Game Started");
          game.printBoard();
          game.mark(0,0);
        game.mark(0, 0);
        game.mark(0, 1);
        game.mark(2, 0);
        game.printBoard();
        game.mark(1, 1);
        game.printBoard();
        game.mark(1, 0);
        game.printBoard();
    }
}