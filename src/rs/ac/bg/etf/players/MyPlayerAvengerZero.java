package rs.ac.bg.etf.players;



public class MyPlayerAvengerZero extends Player {

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
					
					MyPlayerAvengerZero.this.strategy=new StingerOpponent();
					
					break;
				case PUT2COINS:
					 MyPlayerAvengerZero.this.strategy= new GoodyAvengerOpponent();
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
					
					MyPlayerAvengerZero.this.strategy=new MyPlayerAvengerZeroOpponent();
					
					
					break;
				case PUT2COINS:
					 MyPlayerAvengerZero.this.strategy= new GoodyAvengerOpponent();
					break;
				case PUT1COIN:
					
					MyPlayerAvengerZero.this.strategy=new ForgiverCopycatOpponent();
					 
				default:
					break;
				}
				
				
			}
				
			
			turn++;
			return MyPlayerAvengerZero.this.strategy.getNextMove();
			
	}
		
		
		
	}
	//DA LI JE BOLJE DA ZA GOODY I AVENGER DAM 1 UMESTO 0 U DRUGOJ RUCI
	
	private class GoodyAvengerOpponent extends Strategy{
		
		@Override
		Move getNextMove() {
	
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
	
	
	private class MyPlayerAvengerZeroOpponent extends Strategy{
		@Override
		Move getNextMove() {
			// TODO Auto-generated method stub
			return Move.PUT2COINS;
		}
	}
	
	private class ForgiverCopycatOpponent extends Strategy{
		private Move moves[] = {Move.DONTPUTCOINS, Move.PUT2COINS};
		
		private int i=0;
		
		@Override
		Move getNextMove() {
			
			if(opponentMoves.get(opponentMoves.size()-1)==Move.DONTPUTCOINS) return Move.DONTPUTCOINS;
			// TODO Auto-generated method stub
			i=(i+1)%2;
			return moves[i];
		}
	}
	
	

	
	
	
	
	
	private Strategy strategy= new InitialStrategy();
	
	@Override
	public Move getNextMove() {
	
		return strategy.getNextMove();
		
	}

	
	@Override
	public void resetPlayerState() {
		super.resetPlayerState();
		this.strategy=new InitialStrategy();
		
	}
	
}
