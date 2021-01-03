package utils;
/**
 * Enum E_Difficulty - represents the question Difficulty in the game
 * @author Sewar Drawshe
 * 
 */
public enum E_Difficulty {
	// --------------------------------Values--------------------------------------
	EASY(1), MEDIUM(2), HARD(3);

	// --------------------------------Class Members-------------------------------
	private final int number;

	// --------------------------------Constructor----------------------------------
	E_Difficulty(int number) {
		this.number = number;
	}

	// --------------------------------Methods---------------------------------------
	public int getNumber() {
		return number;
	}
	public static int Addedpoints(E_Difficulty s) {
		switch (s) {
		case EASY:
			return 100;
		case MEDIUM:
			return 200;
		case HARD:
			return 500;
		}
		return 0;
	}
	public static int Removedpoints(E_Difficulty s) {
		switch (s) {
		case EASY:
			return 250;
		case MEDIUM:
			return 100;
		case HARD:
			return 50;
		}
		return 0;
	}
	public static E_Difficulty returnEnum(String s) {
		switch (s) {
		case "1":
			return E_Difficulty.EASY;
		case "2":
			return E_Difficulty.MEDIUM;
		case "3":
			return E_Difficulty.HARD;
		}
		return null;
	}

	public static E_Difficulty longToEnum(Long l) {
		int l2 = Math.toIntExact(l);
		switch (l2) {
		case 1:
			return E_Difficulty.EASY;
		case 2:
			return E_Difficulty.MEDIUM;
		case 3:
			return E_Difficulty.HARD;
		}
		return null;
	}

}
