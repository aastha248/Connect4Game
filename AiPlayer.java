import java.util.LinkedList;


/**
 *
 * @author Aastha
 */
public class AiPlayer {
    public AiPlayer() 
    {
    }

    /**
     * This method plays a piece randomly on the board
     * @param currentGame The GameBoard object that is currently being used to
     * play the game.
     * @param current_player
     * @return an integer indicating which column the AiPlayer would like
     * to play in.
     */
    public int getutility(GameBoard currentGame, int player, int number)
    {
        int count = 0;
        int[][] matrix = currentGame.getGameBoard();
        for( int i = 0; i < 6; i++ ) {
	    for( int j = 0; j < 4; j++ ) 
            {
		if((( matrix[ i ][j] == 0 ) &&
		    ( matrix[ i ][ j+1 ] == player ) &&
		    ( matrix[ i ][ j+2 ] == player ) &&
		    ( matrix[ i ][ j+3 ] == player ) ) ||
                    (( matrix[ i ][j] == player ) &&
		    ( matrix[ i ][ j+1 ] == player ) &&
		    ( matrix[ i ][ j+2 ] == player ) &&
		    ( matrix[ i ][ j+3 ] == 0 ) )) 
                        {
                            if(number == 3 )
                                count ++;
                        }
                else if((( matrix[ i ][j] == 0 ) &&
		    ( matrix[ i ][ j+1 ] == 0 ) &&
		    ( matrix[ i ][ j+2 ] == player ) &&
		    ( matrix[ i ][ j+3 ] == player ) ) ||
                    (( matrix[ i ][j] == player ) &&
		    ( matrix[ i ][ j+1 ] == player ) &&
		    ( matrix[ i ][ j+2 ] == 0 ) &&
		    ( matrix[ i ][ j+3 ] == 0 ) )) 
                        {
                            if(number == 2 )
                                count ++;
                        }
                else if((( matrix[ i ][j] == 0 ) &&
		    ( matrix[ i ][ j+1 ] == 0 ) &&
		    ( matrix[ i ][ j+2 ] == 0 ) &&
		    ( matrix[ i ][ j+3 ] == player ) ) ||
                    (( matrix[ i ][j] == player ) &&
		    ( matrix[ i ][ j+1 ] == 0 ) &&
		    ( matrix[ i ][ j+2 ] == 0 ) &&
		    ( matrix[ i ][ j+3 ] == 0 ) )) 
                        {
                            if(number == 1 )
                                count ++;
                        }
	    }
	}
        // end horizontal

	//check vertically
	for( int i = 0; i < 3; i++ ) {
	    for( int j = 0; j < 7; j++ ) {
		if( ( matrix[ i ][ j ] == 0 ) &&
		    ( matrix[ i+1 ][ j ] == player ) &&
		    ( matrix[ i+2 ][ j ] == player ) &&
		    ( matrix[ i+3 ][ j ] == player ) ) 
                        {
                            if(number == 3 )
                                count ++;
                        }
                else if( ( matrix[ i ][ j ] == 0 ) &&
		    ( matrix[ i+1 ][ j ] == 0 ) &&
		    ( matrix[ i+2 ][ j ] == player ) &&
		    ( matrix[ i+3 ][ j ] == player ) ) 
                        {
                            if(number == 2 )
                                count ++;
                        }
                else if( ( matrix[ i ][ j ] == 0 ) &&
		    ( matrix[ i+1 ][ j ] == 0 ) &&
		    ( matrix[ i+2 ][ j ] == 0 ) &&
		    ( matrix[ i+3 ][ j ] == player ) ) 
                        {
                            if(number == 1 )
                                count ++;
                        }
	    }
	}// end verticle
	
	//check diagonally - backs lash ->	\
	for( int i = 0; i < 3; i++ ){
            for( int j = 0; j < 4; j++ ) {
		if( (( matrix[ i ][ j ] == player ) &&
                    ( matrix[ i+1 ][ j+1 ] == player ) &&
                    ( matrix[ i+2 ][ j+2 ] == player ) &&
                    ( matrix[ i+3 ][ j+3 ] == 0 )) ||
                    (( matrix[ i ][ j ] == 0 ) &&
                    ( matrix[ i+1 ][ j+1 ] == player ) &&
                    ( matrix[ i+2 ][ j+2 ] == player ) &&
                    ( matrix[ i+3 ][ j+3 ] == player )) ) 
                        {
                            if(number == 3 )
                                count ++;
                        }
                else if( (( matrix[ i ][ j ] == player ) &&
                    ( matrix[ i+1 ][ j+1 ] == player ) &&
                    ( matrix[ i+2 ][ j+2 ] == 0 ) &&
                    ( matrix[ i+3 ][ j+3 ] == 0 )) ||
                    (( matrix[ i ][ j ] == 0 ) &&
                    ( matrix[ i+1 ][ j+1 ] == 0 ) &&
                    ( matrix[ i+2 ][ j+2 ] == player ) &&
                    ( matrix[ i+3 ][ j+3 ] == player )) ) 
                        {
                            if(number == 2 )
                                count ++;
                        }
                else if( (( matrix[ i ][ j ] == player ) &&
                    ( matrix[ i+1 ][ j+1 ] == 0 ) &&
                    ( matrix[ i+2 ][ j+2 ] == 0 ) &&
                    ( matrix[ i+3 ][ j+3 ] == 0 )) ||
                    (( matrix[ i ][ j ] == 0 ) &&
                    ( matrix[ i+1 ][ j+1 ] == 0 ) &&
                    ( matrix[ i+2 ][ j+2 ] == 0 ) &&
                    ( matrix[ i+3 ][ j+3 ] == player )) ) 
                        {
                            if(number == 1 )
                                count ++;
                        }
            }
        }
	//check diagonally - forward slash -> /
	for( int i = 0; i < 3; i++ ){
            for( int j = 0; j < 4; j++ ) {
		if( (( matrix[ i+3 ][ j ] == player ) &&
                    ( matrix[ i+2 ][ j+1 ] == player ) &&
                    ( matrix[ i+1 ][ j+2 ] == player ) &&
                    ( matrix[ i ][ j+3 ] == 0 )) ||
                    (( matrix[ i+3 ][ j ] == 0 ) &&
                    ( matrix[ i+2 ][ j+1 ] == player ) &&
                    ( matrix[ i+1 ][ j+2 ] == player ) &&
                    ( matrix[ i ][ j+3 ] == player )) ) 
                        {
                            if(number == 3 )
                                count ++;
                        }
                else if( (( matrix[ i+3 ][ j ] == player ) &&
                    ( matrix[ i+2 ][ j+1 ] == player ) &&
                    ( matrix[ i+1 ][ j+2 ] == 0 ) &&
                    ( matrix[ i ][ j+3 ] == 0 )) ||
                    (( matrix[ i+3 ][ j ] == 0 ) &&
                    ( matrix[ i+2 ][ j+1 ] == 0 ) &&
                    ( matrix[ i+1 ][ j+2 ] == player ) &&
                    ( matrix[ i ][ j+3 ] == player )) ) 
                        {
                            if(number == 2 )
                                count ++;
                        }
                else if( (( matrix[ i+3 ][ j ] == player ) &&
                    ( matrix[ i+2 ][ j+1 ] == 0 ) &&
                    ( matrix[ i+1 ][ j+2 ] == 0 ) &&
                    ( matrix[ i ][ j+3 ] == 0 )) ||
                    (( matrix[ i+3 ][ j ] == 0 ) &&
                    ( matrix[ i+2 ][ j+1 ] == 0 ) &&
                    ( matrix[ i+1 ][ j+2 ] == 0 ) &&
                    ( matrix[ i ][ j+3 ] == player )) )
                        {
                            if(number == 1 )
                                count ++;
                        }
            }
        }
	return count;
    }
    
    public int evalfunction(GameBoard currentGame)
    {
        int utility = 0;
        int newcurrentplayerscore = currentGame.getScore(currentplayer);
        int newoppositeplayerscore = currentGame.getScore(oppositeplayer);
        int newplayerblocks = currentGame.getblocks(currentplayer);
        return newcurrentplayerscore + newplayerblocks + getutility(currentGame, currentplayer, 3) + getutility(currentGame, currentplayer,2) + getutility(currentGame, currentplayer,1) - newoppositeplayerscore;
    }
    
    int currentplayer, oppositeplayer, depth, prevcurrentplayerscore, prevoppositeplayerscore, playerblocks, playerchoice = 100;
    public int findBestPlay( GameBoard currentGame, int current_player, int depthlevel ) 
    {
        depth = depthlevel;
        currentplayer = current_player;
        if(currentplayer == 1)
            oppositeplayer = 2;
        else 
            oppositeplayer = 1;
        playerblocks = currentGame.getblocks(currentplayer);
        prevcurrentplayerscore = currentGame.getScore(currentplayer);
        prevoppositeplayerscore = currentGame.getScore(oppositeplayer);
        int temp_utility = max_value(currentGame, -100000, 100000, 0);
        return playerchoice;
    }
    public int max_value(GameBoard currentGame, int alpha, int beta, int depthlevel)
    {
        depthlevel++;
        if(depth == depthlevel || currentGame.getPieceCount() >= 42)
            return evalfunction(currentGame);
        int utility = -100000;
        LinkedList<node> successors = new LinkedList<node>();
        for(int i = 0; i < 7; i++)
        {
            for(int j=5;j>=0;j--)
            {
                if(currentGame.getGameBoard()[j][i] == 0)
                {
                    node successor = new node();
                    successor.currenti = i;
                    successor.currentj = j;
                    successors.add(successor);
                    break;
                }
            }
        }
        int [][] temp = currentGame.getGameBoard();
        int [][] store_temp = new int[6][7];
        for(int k = 0; k < 6; k++)
        {
            for(int l=0;l<7;l++)
            {
                store_temp[k][l] = temp[k][l];
            }
        }
        for(node current_successor : successors)
        {
            GameBoard tempstate = new GameBoard(store_temp);
            int [][] tempref = tempstate.getGameBoard();
            tempref[current_successor.currentj][current_successor.currenti] = currentplayer;
            GameBoard tempgame = new GameBoard(tempref);
            int temp_utility = min_value(tempgame,alpha,beta,depthlevel);
            if(temp_utility > utility)
            {
                utility = temp_utility;
                playerchoice = current_successor.currenti;
            }
            if(utility >= beta)
                return utility;
            if(utility > alpha)
                alpha = utility;
        }
        return utility;
    }
    public int min_value(GameBoard currentGame, int alpha, int beta, int depthlevel)
    {
        depthlevel++;
        if(depth == depthlevel || currentGame.getPieceCount() >= 42)
            return evalfunction(currentGame);
        int utility = 100000;
        LinkedList<node> successors = new LinkedList<node>();
        for(int i = 0; i < 7; i++)
        {
            for(int j=5;j>=0;j--)
            {
                if(currentGame.getGameBoard()[j][i] == 0)
                {
                    node successor = new node();
                    successor.currenti = i;
                    successor.currentj = j;
                    successors.add(successor);
                    break;
                }
            }
        }
        int[][] temp = currentGame.getGameBoard();
        int [][] store_temp = new int[6][7];
        for(int k = 0; k < 6; k++)
        {
            for(int l=0;l<7;l++)
            {
                store_temp[k][l] = temp[k][l];
            }
        }
        for(node current_successor : successors)
        {
            GameBoard tempstate = new GameBoard(store_temp);
            int [][] tempref = tempstate.getGameBoard();
            tempref[current_successor.currentj][current_successor.currenti] = oppositeplayer;
            GameBoard tempgame = new GameBoard(tempref);
            int temp_utility = max_value(tempgame,alpha,beta,depthlevel);
            if(temp_utility < utility)
                utility = temp_utility;
            if(utility <= alpha)
                return utility;
            if(utility < beta)
                beta = utility;
        }
        return utility;
    }  
}
