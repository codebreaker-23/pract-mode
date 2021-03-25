package G;


//Single game.
interface ticTacGame{
    gGame createGame(int size);
    void makeMove(int pId, int x, int y);
    int checkWinner();
}

public class ticTac implements ticTacGame{

    private gGame gGame;

    public ticTac(){
        gGame = null;
    }

   public static void swap(Integer i, Integer j)
   {
      Integer temp = new Integer(i);
      i = j;
      j = temp;
   }
   public static void main(String[] args)
   {
      Integer i = new Integer(10);
      Integer j = new Integer(20);
      swap(i, j);
      System.out.println("i = " + i + ", j = " + j);
   }
/*
    public static void main(String[] args) {
        ticTac myGameHandler = new ticTac();
        gGame myGame = myGameHandler.createGame(3);

        myGame.makeMove(1, 1,1);
    }*/

    @Override
    public gGame createGame(int size) {
        if(gGame == null)
            gGame = new gGame(size);
        return gGame;
    }

    @Override
    public void makeMove(int pId, int x, int y) {
        if(gGame!=null)
            gGame.makeMove(pId, x, y);
    }

    @Override
    public int checkWinner() {
        if(gGame!=null)
            return gGame.getWinner();
        return -1;
    }
}

class gGame {
    private final int [] [] board;
    private final int size;
    private int winner;

    public gGame(int s) {
        size = s;
        board = new int[size][size];
        winner = -1;
    }

    public int getWinner(){
        return this.winner;
    }

    public void makeMove(int pId, int i, int j){
        //logic
        if(winner==pId)
            System.out.println("This player Wins.");

    }
}

