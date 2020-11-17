package Model;

public class Soldier {
	
	// -------------------------------Class Members------------------------------

	private boolean IsAlive;
	private boolean IsQueen;
	private Square Location;
	
	// -------------------------------Constructors-------------------------------

	public Soldier(boolean isAlive, boolean isQueen, Square location) {
		super();
		this.IsAlive = isAlive;
		this.IsQueen = isQueen;
		this.Location = location;
	}
	
	// -------------------------------Getters And Setters-------------------------

	public boolean isIsAlive() {
		return IsAlive;
	}

	public void setIsAlive(boolean isAlive) {
		this.IsAlive = isAlive;
	}

	public boolean isIsQueen() {
		return IsQueen;
	}

	public void setIsQueen(boolean isQueen) {
		this.IsQueen = isQueen;
	}

	public Square getLocation() {
		return Location;
	}

	public void setLocation(Square location) {
		this.Location = location;
	}

	@Override
	public String toString() {
		return "Soldier [IsAlive=" + IsAlive + ", IsQueen=" + IsQueen + ", Location=" + Location + "]";
	}
	
	// -------------------------------Methods------------------------------------

	//To Do
	public void UPright() {
		return;
	}
	
	//To Do
	public void Upleft() {
		return;
	}
	

}
