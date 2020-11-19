/*    */ package rs.ac.bg.etf.players;
/*    */ 
/*    */ public class Avenger_
/*    */   extends Player {
/*  5 */   private Player.Move myMove = Player.Move.PUT2COINS;
/*    */ 
/*    */   
/*    */   public void resetPlayerState() {
/*  9 */     super.resetPlayerState();
/* 10 */     this.myMove = Player.Move.PUT2COINS;
/*    */   }
/*    */ 
/*    */   
/*    */   public Player.Move getNextMove() {
	if(!opponentMoves.isEmpty()) System.out.print(opponentMoves.get(opponentMoves.size()-1).ordinal()+"  ");
	
/* 15 */     if (this.opponentMoves.size() > 0 && ((Player.Move)this.opponentMoves.get(this.opponentMoves.size() - 1)).ordinal() < this.myMove.ordinal()) {
/* 16 */       this.myMove = this.opponentMoves.get(this.opponentMoves.size() - 1);
/*    */     }
System.out.print(myMove.ordinal()+":");
/* 18 */     return this.myMove;
/*    */   }
/*    */ }


/* Location:              D:\Faks\semestar7\is\domaci1\materials\project1.jar!\rs\ac\bg\etf\players\Avenger.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */