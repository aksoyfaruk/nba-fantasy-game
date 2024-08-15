package Players;

import java.util.Random;

public class PointGuard extends Player {

	public PointGuard(String playerName, String position, int PTS, int TRB, int AST, int BLK, int STL,
			double totalScore) {
		super(playerName, "PG", PTS, TRB, AST, BLK, STL, 0);
		// TODO Auto-generated constructor stub
	}
	

	
	@Override
	public double calculateScore() {
	
		int n_PTS = 7;
		int n_AST = 5;
		int n_TRB = 3;
		int n_BLK = 1;
		int n_STL = 1;
		
		int lastPTS = Math.max(1, randomRange(PTS - n_PTS, PTS + n_PTS));
		int lastAST = Math.max(1, randomRange(AST - n_AST, AST + n_AST));
		int lastTRB = Math.max(1, randomRange(TRB - n_TRB, TRB + n_TRB));
		int lastBLK = Math.max(0, randomRange(BLK - n_BLK, BLK + n_BLK));
		int lastSTL = Math.max(0, randomRange(STL - n_STL, STL + n_STL));
		
		totalScore = (lastPTS*0.85) + (lastAST*0.1) + (lastTRB*0.03) + (lastBLK*0.01) + (lastSTL*0.01);
		return totalScore;
	}

	
	
}
