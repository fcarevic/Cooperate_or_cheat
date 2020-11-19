package rs.ac.bg.etf.players;

public class AllOnes extends Player {

	@Override
	public Move getNextMove() {
		// TODO Auto-generated method stub
		if(!opponentMoves.isEmpty()) System.out.print(opponentMoves.get(opponentMoves.size()-1).ordinal()+"  ");
		
		System.out.print(Move.PUT1COIN.ordinal()+":");
		return Move.PUT1COIN;
		
	}

}
