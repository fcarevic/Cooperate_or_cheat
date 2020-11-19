package rs.ac.bg.etf.players;

public class TwoOneZero extends Player{

	int i=0;
	Move moves [] = {Move.PUT2COINS, Move.PUT1COIN, Move.DONTPUTCOINS};
	@Override
	public Move getNextMove() {
		if(!opponentMoves.isEmpty()) System.out.print(opponentMoves.get(opponentMoves.size()-1).ordinal()+"  ");
		
		Move m= moves[i];
		i=(i+1)%3;
		System.out.print(m.ordinal()+":");
		return m; 
	}
	@Override
	public void resetPlayerState() {
		
		// TODO Auto-generated method stub
		super.resetPlayerState();
		i=0;
	}

}
