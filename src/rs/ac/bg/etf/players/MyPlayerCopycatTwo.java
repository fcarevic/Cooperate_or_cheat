package rs.ac.bg.etf.players;

import rs.ac.bg.etf.players.Player.Move;

public class MyPlayerCopycatTwo extends Player {

	private abstract class Strategy {
		abstract Move getNextMove();
	}

	private class InitialStrategy extends Strategy {
		int turn = 1;

		@Override
		Move getNextMove() {
			if (opponentMoves.isEmpty())
				return Move.PUT1COIN;
			else {
				if (turn == 1)
					switch (opponentMoves.get(opponentMoves.size() - 1)) {
					case DONTPUTCOINS:

						MyPlayerCopycatTwo.this.strategy = new StingerOpponent();

						break;
					case PUT2COINS:
						MyPlayerCopycatTwo.this.strategy = new GoodyAvengerOpponent();
						break;
					case PUT1COIN:
						turn++;
						return Move.PUT2COINS;

					default:
						break;
					}
				else if (turn == 2)

					switch (opponentMoves.get(opponentMoves.size() - 1)) {
					case DONTPUTCOINS:
						MyPlayerCopycatTwo.this.strategy = new ForgiverOpponent();
						break;
					case PUT2COINS:
						MyPlayerCopycatTwo.this.strategy = new MyPlayerCopycatTwoOpponent();
						break;
					case PUT1COIN:

						turn++;
						return Move.DONTPUTCOINS;

					default:
						break;
					}

				else if (turn == 3) {

					switch (opponentMoves.get(opponentMoves.size() - 1)) {
					case DONTPUTCOINS:

						MyPlayerCopycatTwo.this.strategy = new CopycatReturnZero();

						break;
					case PUT2COINS:
					case PUT1COIN:

						MyPlayerCopycatTwo.this.strategy = new ForgiverOpponent();
						return Move.PUT2COINS;
					default:
						break;
					}

				}

			}

			turn++;
			return MyPlayerCopycatTwo.this.strategy.getNextMove();

		}

	}
	// DA LI JE BOLJE DA ZA GOODY I AVENGER DAM 1 UMESTO 0 U DRUGOJ RUCI

	private class GoodyAvengerOpponent extends Strategy {
		boolean first = true;
		Move moves[] = { Move.PUT1COIN, Move.PUT1COIN };
		int ind = 0;

		@Override
		Move getNextMove() {
			if (first) {
				first = false;
				return Move.DONTPUTCOINS;
			}
			if (opponentMoves.get(opponentMoves.size() - 1) == Move.DONTPUTCOINS)
				return Move.DONTPUTCOINS;
			if (opponentMoves.get(opponentMoves.size() - 1) == Move.PUT2COINS) {

				ind = (ind + 1) % 2;
				return moves[ind];

			}
			return Move.DONTPUTCOINS;
		}
	}

	private class StingerOpponent extends Strategy {
		@Override
		Move getNextMove() {
			// TODO Auto-generated method stub
			return Move.DONTPUTCOINS;
		}
	}

	private static int ID = 0;
	private int id = ID++;

	private class MyPlayerCopycatTwoOpponent extends Strategy {
		@Override
		Move getNextMove() {
			// TODO Auto-generated method stub
			if (id == 0)
				return Move.DONTPUTCOINS;
			return Move.PUT2COINS;
		}
	}

	private class ForgiverOpponent extends Strategy {
		private Move moves[] = { Move.DONTPUTCOINS, Move.PUT2COINS };

		private int i = 0;

		@Override
		Move getNextMove() {
			// KRECE SA 2
			// TODO Auto-generated method stub
			if (opponentMoves.get(opponentMoves.size() - 1) == Move.DONTPUTCOINS)
				return Move.DONTPUTCOINS;
			i = (i + 1) % 2;
			return moves[i];
		}
	}

	private class CopycatOpponent extends Strategy {
		private boolean first = true;

		@Override
		Move getNextMove() {

			if (first) {
				first = false;
				return Move.PUT2COINS;
			}
			if (opponentMoves.get(opponentMoves.size() - 1) == Move.DONTPUTCOINS)
				return Move.DONTPUTCOINS;
			// TODO Auto-generated method stub
			return Move.PUT2COINS;
		}
	}

	private class CopycatReturnZero extends Strategy {

		@Override
		Move getNextMove() {
			// TODO Auto-generated method stub
			return Move.DONTPUTCOINS;
		}

	}

	private Strategy strategy = new InitialStrategy();

	@Override
	public Move getNextMove() {

		return strategy.getNextMove();

	}

	@Override
	public void resetPlayerState() {
		super.resetPlayerState();
		this.strategy = new InitialStrategy();

	}

}
