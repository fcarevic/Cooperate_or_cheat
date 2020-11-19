package rs.ac.bg.etf.players;

import rs.ac.bg.etf.players.Player.Move;

public class Detective extends Player {

	private int i=1;
	private boolean cheated=false;
	@Override
	public Move getNextMove() {
		if(i==1) {
			i++;
			return Move.PUT2COINS;
		}
		else if(i==2) {
			
			i++;
			return Move.DONTPUTCOINS;
		}
		else if (i==3 || i==4) {
			cheated= opponentMoves.contains(Move.DONTPUTCOINS);
			i++;
			return Move.PUT2COINS;
		} else {
			if(cheated) return opponentMoves.get(opponentMoves.size()-1);
			else return Move.DONTPUTCOINS;
			
		}
		
	}
	@Override
	public void resetPlayerState() {
		// TODO Auto-generated method stub
		super.resetPlayerState();
	 i=1;
	}

}
