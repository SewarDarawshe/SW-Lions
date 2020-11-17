package Model;

public class Player {
	// -------------------------------Class Members------------------------------
	
	private String NickName;
	private int Points;
	
	// -------------------------------Constructors-------------------------------

	public Player(String nickName, int points) {
		super();
		this.NickName = nickName;
		this.Points = points;
	}
	
	// -------------------------------Getters And Setters-------------------------

	public String getNickName() {
		return NickName;
	}

	public void setNickName(String nickName) {
		this.NickName = nickName;
	}

	public int getPoints() {
		return Points;
	}

	public void setPoints(int points) {
		this.Points = points;
	}

	@Override
	public String toString() {
		return "Player [NickName=" + NickName + ", Points=" + Points + "]";
	}
	 
	
}

