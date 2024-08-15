package Players;

import java.util.Random;

public abstract class Player implements Scorable {
	
	protected String playerName;
	protected String position;
	protected int PTS; 
	protected int TRB; 
	protected int AST; 
	protected int BLK; 
	protected int STL; 
	protected double totalScore;
	
	
	
	
	public Player(String playerName, String position, int PTS, int TRB, int AST, int BLK, int STL, double totalScore) {
//		super();
		this.playerName = playerName;
		this.position = position;
		this.PTS = PTS;
		this.TRB = TRB;
		this.AST = AST;
		this.BLK = BLK;
		this.STL = STL;
		this.totalScore = totalScore;
	}
	
	


	public String getPlayerName() {
		return playerName;
	}

	public String getPosition() {
		return position;
	}

	public int getPTS() {
		return PTS;
	}

	public int getTRB() {
		return TRB;
	}

	public int getAST() {
		return AST;
	}

	public int getBLK() {
		return BLK;
	}


	public int getSTL() {
		return STL;
	}


	public double getTotalScore() {
		return totalScore;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}



	public void setPosition(String position) {
		this.position = position;
	}

	public void setPTS(int PTS) {
		this.PTS = PTS;
	}


	public void setTRB(int TRB) {
		this.TRB = TRB;
	}

	public void setAST(int AST) {
		this.AST = AST;
	}


	public void setBLK(int BLK) {
		this.BLK = BLK;
	}


	public void setSTL(int STL) {
		this.STL = STL;
	}

	public void setTotalScore(double totalScore) {
		this.totalScore = totalScore;
	}

	
//	 I have learned this way of getting random from internet and apply as method for further process but didn't use much, i don't remember the website
	public static int randomRange(int min, int max) {
	    Random random = new Random();
	    return random.ints(min, max)
	      .findFirst()
	      .getAsInt();
	}
	
	
	

	

	
	
}
