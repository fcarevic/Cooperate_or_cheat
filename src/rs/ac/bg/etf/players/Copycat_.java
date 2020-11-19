/*   */ package rs.ac.bg.etf.players;
/*   */ 
/*   */ public class Copycat_
/*   */   extends Player
/*   */ {
/*   */   public Player.Move getNextMove() {
	if(!opponentMoves.isEmpty()) System.out.print(opponentMoves.get(opponentMoves.size()-1).ordinal()+"  ");
	
/* 7 */     Move m= (this.opponentMoves.size() == 0) ? Player.Move.PUT1COIN : this.opponentMoves.get(this.opponentMoves.size() - 1);
/*   */   System.out.print(m.ordinal()+":");
			return m;
			}
/*   */ }


/* Location:              D:\Faks\semestar7\is\domaci1\materials\project1.jar!\rs\ac\bg\etf\players\Copycat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */