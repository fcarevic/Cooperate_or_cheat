package test;

import java.util.Random;

import rs.ac.bg.etf.engine.Match;
import rs.ac.bg.etf.players.AllOnes;
import rs.ac.bg.etf.players.AllTwos;
import rs.ac.bg.etf.players.AllZeros;
import rs.ac.bg.etf.players.AlternateOnesAndTwos;
import rs.ac.bg.etf.players.Avenger;
import rs.ac.bg.etf.players.Avenger_;
import rs.ac.bg.etf.players.Copycat;
import rs.ac.bg.etf.players.Copycat_;
import rs.ac.bg.etf.players.Detective;
import rs.ac.bg.etf.players.Forgiver;
import rs.ac.bg.etf.players.Forgiver_;
import rs.ac.bg.etf.players.Goody;
import rs.ac.bg.etf.players.MyPlayerCopycatTwo;
import rs.ac.bg.etf.players.Player;
import rs.ac.bg.etf.players.Stinger;
import rs.ac.bg.etf.players.TwoOneZero;

public class RandMatch {

	public static void main(String[] args) {
		Player [] opp = {new Avenger(), new Copycat(), new Goody(), new Detective(), new Stinger()};
		Random rand= new Random();
		int ind = rand.nextInt(5);
		
		
		new Match(10, new Forgiver(), new MyPlayerCopycatTwo(), 0).playMatch();
		
		
		
		Player p= opp[ind];
		Player [] my = {new AllOnes(), new AllTwos(), new AllZeros(), new AlternateOnesAndTwos(), new TwoOneZero(), new Avenger_(), new Forgiver_(), new Copycat_()};
		
		for(Player p2:my) {
			System.out.println("\nNew Match vs "+ p2.getName());
			Match m = new Match(10, p2, p, 0);
			int[] scores= m.playMatch();
			System.out.println("\t\tSCORE  " + scores[0]+ " : " + scores[1]);
			
		}
		

	}

}
