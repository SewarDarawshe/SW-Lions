package Model;
import utils.Soldier_COLOR_AtSquare;


/*
 * @author Maisa Mansour
 */
public class Player {
	// -------------------------------Class Members------------------------------
	
	private String NickName;
	private int Points;
	private Soldier_COLOR_AtSquare Color;

	
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
	


	public Soldier_COLOR_AtSquare getColor() {
		return Color;
	}

	public void setColor(Soldier_COLOR_AtSquare color) {
		Color = color;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Color == null) ? 0 : Color.hashCode());
		result = prime * result + ((NickName == null) ? 0 : NickName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (Color != other.Color)
			return false;
		if (NickName == null) {
			if (other.NickName != null)
				return false;
		} else if (!NickName.equals(other.NickName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Player [NickName=" + NickName + ", Points=" + Points + ", Color=" + Color + "]";
	}

	
	 
	
}

