package muscletp;
import java.awt.List;
import java.util.ArrayList;

/* Les morceaux routes notifie les capteurs 
 * du passage de voitures
 */
public abstract class MorceauRoute implements Observable{
	// On realise une liste d'observers qui suivent les notifications de MorceauRoute
	protected ArrayList<Observer> observers = new ArrayList<>();
	protected String type;
	//Differents types : Segments, Jonction, JSimple, Barriere, Carrefour

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
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
