package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import rs.ac.bg.etf.engine.Game;

public class Test {
	private static final String input= "scenariosCopycatTwo/Scenario1_F.txt"; 
	private static final String output=		"outputCopycatTwo/Scenario1_F.txt";
	private static String[] argsMain= {input, output};
	private static String getWinner() {
		String winner =null;
		File f = new File(output);
		try (Scanner s = new Scanner(f);){
			
			boolean flag=false;
			while(s.hasNextLine()) {
				String line= s.nextLine();
				if(flag) {winner=line;
				   flag=false;
				}
				else 
				if(line.contains("TOTAL POINTS")) {
					flag=true;
				}
			
				
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return winner;
		
		
	}
	public static void main(String[] args) {
		for(String s:args) {
			System.out.println(s);
		}
	int max=100;
	int cnt=0;
	for(int i=0;i<max;i++) {
	Game.main(argsMain);
	if(getWinner().contains("MyPlayer")) cnt++;
	}
		System.out.println(cnt+"/"+max);

	}

}
