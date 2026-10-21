import Model.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeSimulation {

    public Deque<Player> players;
    public Board gameBoard;
    Player winner;

    public void initializeGame(){
        players=new LinkedList<>();
        PlayingPieceX crossPiece=new PlayingPieceX();
        Player player1=new Player("Player1",crossPiece);

        PlayingPieceO noughtsPiece=new PlayingPieceO();
        Player player2=new Player("Player2",noughtsPiece);

        players.add(player1);
        players.add(player2);

        gameBoard=new Board(3);
    }

    public GameStatus startGame(){
        boolean noWinner=true;

        while(noWinner){

            //Remove the player whose turn is and also put the player in the list back;
            Player currentPlayer=players.removeFirst();

            //Get the free space from the board
            gameBoard.printBoard();

            List<Pair> freeSpaces=gameBoard.getFreeCells();
            if(freeSpaces.isEmpty()){
                noWinner=false;
                continue;
            }
            System.out.print("Player: "+currentPlayer.name+" - Please enter [row, column]: ");
            Scanner sc=new Scanner(System.in);
            String s=sc.next();
            String[] values=s.split(",");
            int row=Integer.valueOf(values[0]);
            int column=Integer.valueOf(values[1]);

            //place the piece in the board
            boolean validMove=gameBoard.addPiece(row,column, currentPlayer.getPiece());

            if(!validMove){
                //Invalid Move->Player canot insert the piece into this cell,player has to choose another cell
                System.out.println("Incorrect position chosen, try again!");
                players.addFirst(currentPlayer); //Add the player back to the queue
                continue;
            }
            players.addLast(currentPlayer);

            //Check if the valid move is a winning move or not

            boolean isWinner=checkForWinner(row,column,currentPlayer.getPiece().type);
            if(isWinner){
                gameBoard.printBoard();
                winner=currentPlayer;
                return GameStatus.WIN;
            }





        }
        return GameStatus.DRAW;


    }

    public boolean checkForWinner(int row, int col,PieceType pieceType){
        boolean rowMatch=true;
        boolean columnMatch=true;
        boolean diagonalMatch=true;
        boolean antiDiagonalMatch= true;

        //Check Row
        for(int i=0;i< gameBoard.size;i++){
            if(gameBoard.board[row][i]==null || gameBoard.board[row][i].type != pieceType){
                rowMatch=false;
                break;
            }
        }

        //check column
        for(int i = 0; i < gameBoard.size; i++){
            if(gameBoard.board[i][col] == null ||
                    gameBoard.board[i][col].type != pieceType){
                columnMatch = false;
                break;
            }
        }

        //check Diagonally
        for(int i=0,j=0;i< gameBoard.size;i++,j++){
            if(gameBoard.board[i][j] == null || gameBoard.board[i][j].type != pieceType){
                diagonalMatch=false;
                break;
            }
        }

        //check anti-diagonally
        for(int i=0,j= gameBoard.size-1; i<gameBoard.size;i++,j--){
            if(gameBoard.board[i][j]== null || gameBoard.board[i][j].type !=pieceType){
                antiDiagonalMatch=false;
                break;
            }
        }

     return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;

    }


}
