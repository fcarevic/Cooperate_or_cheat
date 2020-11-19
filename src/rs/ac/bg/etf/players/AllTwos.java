package rs.ac.bg.etf.players;

import rs.ac.bg.etf.players.Player.Move;

public class AllTwos extends Player {

	@Override
	public Move getNextMove() {
		// TODO Auto-generated method stub
		if(!opponentMoves.isEmpty()) System.out.print(opponentMoves.get(opponentMoves.size()-1).ordinal()+"  ");
		System.out.print(Move.PUT2COINS.ordinal()+":");
		
		return Move.PUT2COINS;
	}

}
