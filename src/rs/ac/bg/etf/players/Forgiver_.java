/*    */ package rs.ac.bg.etf.players;
/*    */ 
/*    */ public class Forgiver_
/*    */   extends Player {
/*  5 */   private Player.Move myMove = Player.Move.PUT1COIN;
/*  6 */   private Player.Move lastOppMove = null;
/*    */ 
/*    */   
/*    */   public void resetPlayerState() {
/* 10 */     super.resetPlayerState();
/* 11 */     this.myMove = Player.Move.PUT1COIN;
/* 12 */     this.lastOppMove = null;
/*    */   }
/*    */ 
/*    */   
/*    */   public Player.Move getNextMove() {
	if(!opponentMoves.isEmpty()) System.out.print(opponentMoves.get(opponentMoves.size()-1).ordinal()+"  ");
	
/* 17 */     if (this.opponentMoves.size() > 0) {
/* 18 */       Player.Move oppMove = this.opponentMoves.get(this.opponentMoves.size() - 1);
/* 19 */       if (this.opponentMoves.size() > 1)
/* 20 */         this.lastOppMove = this.opponentMoves.get(this.opponentMoves.size() - 2); 
/* 21 */       if (oppMove != Player.Move.DONTPUTCOINS || this.lastOppMove == oppMove) {
/* 22 */         this.myMove = oppMove;
/*    */       }
/*    */     } 
		System.out.print(myMove.ordinal()+":");
/* 25 */     return this.myMove;
/*    */   }
/*    */ }


/* Location:              D:\Faks\semestar7\is\domaci1\materials\project1.jar!\rs\ac\bg\etf\players\Forgiver.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */