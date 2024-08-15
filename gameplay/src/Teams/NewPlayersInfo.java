package Teams;

public class NewPlayersInfo {
	
	private String playerName;
	private String position;
	private int PTS; 
	private int TRB; 
	private int AST; 
	private int BLK; 
	private int STL;
	
	
	
	public NewPlayersInfo(String playerName, String position, int PTS, int TRB, int AST, int BLK, int STL) {
//		super();
		this.playerName = playerName;
		this.position = position;
		this.PTS = PTS;
		this.TRB = TRB;
		this.AST = AST;
		this.BLK = BLK;
		this.STL = STL;
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
	
	@Override
    public String toString() {
        return playerName + " - " + position;
    }



}
