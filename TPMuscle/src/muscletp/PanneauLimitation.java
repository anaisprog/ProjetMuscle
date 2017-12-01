package muscletp;

public class PanneauLimitation extends Semaphore{
	
	private int limitation;
	public PanneauLimitation(){
		this.type = "PanneauLimitation";
		
	}
	
	public int getLimitation() {
		return limitation;
	}

	public void setLimitation(int limitation) {
		this.limitation = limitation;
	}
}
 