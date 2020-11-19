package rs.ac.bg.etf.players;

public class AllZeros extends Player {

	@Override
	public Move getNextMove() {
		if(!opponentMoves.isEmpty()) System.out.print(opponentMoves.get(opponentMoves.size()-1).ordinal()+"  ");
		System.out.print(Move.DONTPUTCOINS.ordinal()+":");
		
		return Move.DONTPUTCOINS;
	}
	

}
