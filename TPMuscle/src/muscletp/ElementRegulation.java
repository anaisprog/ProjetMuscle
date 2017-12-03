package muscletp;

import java.util.ArrayList;

public class ElementRegulation implements Observer {
	/*elements logiciels bases sur capteurs et semaphores et regulent la circulation
	 * aux carrefours
	 */
	
	ArrayList<Capteur> sesCapteurs = new ArrayList<>();
	ArrayList<Semaphore> sesSemaphores = new ArrayList<>();
	@Override
	public void update(Observable o) {
		System.out.println("Il y a du nouveau chez les capteurs de vitesse!");
	}
	
}
