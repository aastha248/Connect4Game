import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Aastha
 */
public class maxconnect4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
    if( args.length != 4 ) 
    {
      System.out.println("Four command-line arguments are needed:\n"
                         + "Usage: java [program name] interactive [input_file] [computer-next / human-next] [depth]\n"
                         + " or:  java [program name] one-move [input_file] [output_file] [depth]\n");

      exit_function( 0 );
     }
    String game_mode = args[0].toString();				// the game mode
    String input = args[1].toString();
    String output = args[2].toString();// the input game file
    int depthLevel = Integer.parseInt( args[3] );  		// the depth level of the ai search
    GameBoard currentGame = new GameBoard( input );
    AiPlayer calculon = new AiPlayer();
		
    //  variables to keep up with the game
    int playColumn = 99;				//  the players choice of column to play
    boolean playMade = false;			//  set to true once a play has been made

    if( game_mode.equalsIgnoreCase( "interactive" ) ) 
    {
	if(output.equalsIgnoreCase("computer-next"))
        {
            if(currentGame.getCurrentTurn() != 1)
            {
                System.out.println("Invalid player");
                exit_function(0);
            }
        }
        else if(output.equalsIgnoreCase("human-next"))
        {
            if(currentGame.getCurrentTurn() != 2)
            {
                System.out.println("Invalid player");
                exit_function(0);
            }
        }
        System.out.print("\nMaxConnect-4 game\n");
        System.out.print("game state before move:\n");
        currentGame.printGameBoard();
        System.out.println( "Score: Player 1 = " + currentGame.getScore( 1 ) +
			", Player2 = " + currentGame.getScore( 2 ) + "\n " );
        while( currentGame.getPieceCount() < 42 ) 
        {
            int current_player = currentGame.getCurrentTurn();
            if(current_player == 1)
                playColumn = calculon.findBestPlay( currentGame, current_player, depthLevel );
            else
            {
                boolean isvalid;
                do
                {
                    System.out.println();
                    System.out.print("Make A Move : ");
                    Scanner in = new Scanner(System.in);
                    playColumn = Integer.parseInt(in.nextLine());
                    isvalid= currentGame.isValidPlay(playColumn);
                }while(!isvalid);
            }
            currentGame.playPiece( playColumn );
            System.out.println("move " + currentGame.getPieceCount() 
                           + ": Player " + current_player
                           + ", column " + playColumn);
            System.out.print("game state after move:\n");
            currentGame.printGameBoard();
            System.out.println( "Score: Player 1 = " + currentGame.getScore( 1 ) +
                            ", Player2 = " + currentGame.getScore( 2 ) + "\n " );
            if(current_player == 1)
                currentGame.printGameBoardToFile( "computer.txt" );
            else
               currentGame.printGameBoardToFile( "human.txt" ); 
        } 
        System.out.println("\nI can't play.\nThe Board is Full\n\nGame Over");
        playMade = true;
	return;
    } 
			
    else if( !game_mode.equalsIgnoreCase( "one-move" ) ) 
    {
      System.out.println( "\n" + game_mode + " is an unrecognized game mode \n try again. \n" );
      return;
    }

    /////////////   one-move mode ///////////
    // the output game file
    
    System.out.print("\nMaxConnect-4 game\n");
    System.out.print("game state before move:\n");
    
    //print the current game board
    currentGame.printGameBoard();
    // print the current scores
    System.out.println( "Score: Player 1 = " + currentGame.getScore( 1 ) +
			", Player2 = " + currentGame.getScore( 2 ) + "\n " );
    
    // ****************** this chunk of code makes the computer play
    if( currentGame.getPieceCount() < 42 ) 
    {
        int current_player = currentGame.getCurrentTurn();
	playColumn = calculon.findBestPlay( currentGame, current_player, depthLevel );
	currentGame.playPiece( playColumn );
        	
        // display the current game board
        System.out.println("move " + currentGame.getPieceCount() 
                           + ": Player " + current_player
                           + ", column " + playColumn);
        System.out.print("game state after move:\n");
        currentGame.printGameBoard();
    
        // print the current scores
        System.out.println( "Score: Player 1 = " + currentGame.getScore( 1 ) +
                            ", Player2 = " + currentGame.getScore( 2 ) + "\n " );
        
        currentGame.printGameBoardToFile( output );
    } 
    else 
    {
	System.out.println("\nI can't play.\nThe Board is Full\n\nGame Over");
    }
	
    //************************** end computer play
			
    
    return;
    
}
    
  private static void exit_function( int value )
  {
      System.out.println("exiting from MaxConnectFour.java!\n\n");
      System.exit( value );
  }
}
    