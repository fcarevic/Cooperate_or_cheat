package rs.ac.bg.etf.players;

public class OppositePlayer extends Player {

/*	@Override
	public Move getNextMove() {
		if(opponentMoves.size()>0) {
			if(opponentMoves.get(opponentMoves.size()-1)==Move.DONTPUTCOINS) {
				if(Math.random()<0.5) {
					return Move.PUT2COINS;
				} else return Move.PUT1COIN;
				
			} else return Move.DONTPUTCOINS;
			
		}
		return Move.PUT1COIN;
	}*/
	
	@Override
	public Move getNextMove() {
		if(opponentMoves.size()>0) {
			if(opponentMoves.get(opponentMoves.size()-1)==Move.DONTPUTCOINS) {
				if(Math.random()<0.5) {
					return Move.PUT2COINS;
				} else return Move.PUT1COIN;
				
			} else if (opponentMoves.get(opponentMoves.size()-1)==Move.PUT2COINS)return Move.PUT1COIN;
			else return Move.DONTPUTCOINS;
			
		}
		return Move.PUT1COIN;
	}

}
