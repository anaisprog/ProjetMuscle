package muscletp;
import java.util.ArrayList;

<<<<<<< HEAD
public abstract class MorceauRoute {
	
	//Differents types : Segments, Jonction, JSimple, Barriere, Carrefour
	protected String type;

	
	ArrayList<? extends Semaphore> sesSemaphores = new ArrayList<>();
	
	public ArrayList<? extends Semaphore> getSesSemaphores() {
		return sesSemaphores;
	}
	public void setSesSemaphores(ArrayList<? extends Semaphore> sesSemaphores) {
		this.sesSemaphores = sesSemaphores;
	}
	public void setSesCapteurs(ArrayList<? extends Capteur> sesCapteurs) {
		this.sesCapteurs = sesCapteurs;
	}
	public ArrayList<? extends Capteur> getSesCapteurs() {
		return sesCapteurs;
	}
	ArrayList<? extends Capteur> sesCapteurs = new ArrayList<>(); 
	
}
