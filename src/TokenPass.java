import java.util.Random;

public class TokenPass {
	private int[] board;
	private int currentPlayer;
	
	
	private int maxPlayers;
	Random rand = new Random();
	
	public TokenPass(int playerCount){
		board = new int[playerCount];
		for (int i = 0; i < board.length; i++) {
			int j = rand.nextInt(11);
			if(j > 0){
			board[i] = j;
			} else {
				board[i] = 1;
			}
			currentPlayer = rand.nextInt(playerCount-1);
		}
		maxPlayers = playerCount;
	} 
	 /** Distributes the tokens from the current player's position one at a time to each player in
	 * the game. Distribution begins with the next position and continues until all the tokens
	 * have been distributed. If there are still tokens to distribute when the player at the
	 * highest position is reached, the next token will be distributed to the player at position 0.
	 * Precondition: the current player has at least one token.
	 * Postcondition: the current player has not changed.
	 */
	 public void distributeCurrentPlayerTokens(){
		 int cp;
		 if (currentPlayer-1 < 0) {
		 cp = currentPlayer;
		 } else {
		cp = currentPlayer -1;
		 }
		 while (board[currentPlayer-1] > 0) {
			if (cp != currentPlayer) {
				board[cp] = board[cp] + 1;
				cp += 1;
			} else if (cp > maxPlayers){
				board[0] =board[0] + 1;
				cp = 1;
			}
			 board[currentPlayer] -= 1;
		}
		
		 if (currentPlayer >= maxPlayers-1){
			 currentPlayer = 0;
			} else {
				currentPlayer += 1;
			}
		
	 }
	public int[] getBoard() {
		return board;
	} 
	public String getState() {
		StringBuilder list = new StringBuilder();
		list.append("Current Player:" + (currentPlayer+1) + " ZzzZ ");
		for (int i = 0; i < board.length; i++) {
			list.append("|--| Player " + (i+1) + " Has " + board[i] + " Tokens");
		}
		return list.toString();
	} 
}
