package rs.ac.bg.etf.players;

public class AlternateOnesAndTwos extends Player{

	private int i=1;
	private Move moves [] = {Move.PUT1COIN, Move.PUT2COINS};
	@Override
	public Move getNextMove() {
		if(!opponentMoves.isEmpty()) System.out.print(opponentMoves.get(opponentMoves.size()-1).ordinal()+"  ");
		
		i=(i+1)%2;
		System.out.print(moves[i].ordinal()+":");
		
		return moves[i];
	}

}
