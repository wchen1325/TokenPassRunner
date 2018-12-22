public class TokenPass {
    private int[] board;
    private int currentPlayer;
    private int playerCount;

    public TokenPass(int playerCount){
        this.playerCount = playerCount;
        board= new int[playerCount];
        for(int i = 0; i < playerCount;i++){
            board[i] = (int)(Math.random()*10 + 1);
        }
        currentPlayer=(int)(Math.random()*playerCount);
    }

    public void distributeCurrentPlayerTokens(){
        int temp = board[currentPlayer];
        board[currentPlayer]=0;
        for(int i = 1; i<temp+1;i++){
            board[(currentPlayer+i)%playerCount]++;
        }
    }

    public void printBoard(){
        String str = "";

        for (int i = 0; i < board.length; i++){
            str = str +"[" +"Player(" +i+"): " + board[i] + "]";
        }
        System.out.println(str);
        System.out.println("Current Player: "+ currentPlayer);
    }

    public void nextPlayer(){
        currentPlayer = (currentPlayer + 1)% playerCount;
    }

    public int gameOver(){
        if(currentPlayer==0) {
            if (board[playerCount-1] <= 0) {
                return (playerCount-1);
            }
        }
        else{
            if(board[currentPlayer-1]<=0){
                return (currentPlayer-1);
            }

        }
        return -1;
    }
}
