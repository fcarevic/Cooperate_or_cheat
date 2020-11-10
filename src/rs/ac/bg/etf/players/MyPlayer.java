package rs.ac.bg.etf.players;

public class MyPlayer extends Player {

	private abstract class Strategy{
		abstract Move  getNextMove();
	}
	
	private class InitialStrategy extends Strategy {
			int turn=1;
		@Override
		Move getNextMove() {
			if(opponentMoves.isEmpty()) return Move.PUT1COIN;
			else {
			if(turn==1)	
				switch (opponentMoves.get(opponentMoves.size()-1)) {
				case DONTPUTCOINS:
					
					MyPlayer.this.strategy=new StingerOpponent();
					
					break;
				case PUT2COINS:
					 MyPlayer.this.strategy= new GoodyOpponent();
					break;
				case PUT1COIN:
							turn++;
						 return Move.DONTPUTCOINS;
					
					 
				default:
					break;
				}
			else if(turn==2) 
				
				switch (opponentMoves.get(opponentMoves.size()-1)) {
				case DONTPUTCOINS:
					
					MyPlayer.this.strategy=new CopycatOpponent();
					
					
					break;
				case PUT2COINS:
					 MyPlayer.this.strategy= new GoodyOpponent();
					break;
				case PUT1COIN:
					
					MyPlayer.this.strategy=new ForgiverOpponent();
					 
				default:
					break;
				}
				
				
			}
				
			
			turn++;
			return MyPlayer.this.strategy.getNextMove();
			
	}
		
		
		
	}
	//DA LI JE BOLJE DA ZA GOODY I AVENGER DAM 1 UMESTO 0 U DRUGOJ RUCI
	
	private class GoodyOpponent extends Strategy{
		int turn=1;
		@Override
		Move getNextMove() {
			// TODO Auto-generated method stub
			//ovo ispod mozda ne treba
			if(turn==1) { turn++; return Move.PUT1COIN; } //da se vidi da li je avenger
			if(opponentMoves.get(opponentMoves.size()-1).equals(Move.PUT1COIN)) 
				{
					MyPlayer.this.strategy= new AvengerOpponent();
					return MyPlayer.this.strategy.getNextMove();
				}
			return Move.DONTPUTCOINS;
		}
	}
	
	private class StingerOpponent extends Strategy{
		@Override
		Move getNextMove() {
			// TODO Auto-generated method stub
			return Move.DONTPUTCOINS;
		}
	}
	
	
	private class CopycatOpponent extends Strategy{
		@Override
		Move getNextMove() {
			// TODO Auto-generated method stub
			return Move.PUT2COINS;
		}
	}
	
	private class ForgiverOpponent extends Strategy{
		private Move moves[] = {Move.DONTPUTCOINS, Move.PUT2COINS};
		private int i=0;
		
		@Override
		Move getNextMove() {
			// TODO Auto-generated method stub
			i=(i+1)%2;
			return moves[i];
		}
	}
	

	
	
	private class AvengerOpponent extends Strategy{
		@Override
		Move getNextMove() {
			// TODO Auto-generated method stub
			return Move.PUT1COIN;
		}
	}
	
	
	private Strategy strategy= new InitialStrategy();
	//private Strategy strategy= new ForgiverOpponent();
	
	//int flag=0;
	@Override
	public Move getNextMove() {
		/*if(flag>=2 ) return strategy.getNextMove();
		flag++;
		if(flag==2) return Move.DONTPUTCOINS;
		return Move.PUT1COIN;*/
		return strategy.getNextMove();
		
	}

	
	@Override
	public void resetPlayerState() {
		super.resetPlayerState();
		this.strategy=new InitialStrategy();
		
	}
	
}
