package muscletp;

import java.util.ArrayList;

public class ElementRegulation implements ObserverCapteurVitesse {
	//observer de capteur de vitesse
	/*elements logiciels bases sur capteurs et semaphores et regulent la circulation
	 * aux carrefours
	 */
	
	ArrayList<Capteur> sesCapteurs = new ArrayList<>();
	ArrayList<Semaphore> sesSemaphores = new ArrayList<>();
	@Override
	public void update(int identifiant, double vitesse) {
		System.out.println("--------Capteur de Vitesse--------");
		System.out.println("Identifiant Voiture : " + identifiant);
		System.out.println("Vitesse Voiture : " + vitesse);
		/*Si la vitesse est superieure a la vitesse reglementaire*/
		if(vitesse> 100){
			System.out.println("Vitesse superieure a la vitesse reglementaire");
			//Le semaphore passe au rouge.
		}
	}
	/*public static void main(String[] args){
		ElementRegulation er = new ElementRegulation();
		MorceauRoute m = new SegmentRoute();
		Voie v = new Voie("Gauche");
		Voiture voit2 = new Voiture(278, m, 2, v);
		voit2.setVitesseCourante(345);
		CapteurVitesse cv = new CapteurVitesse(er, m, v, 2);
		System.out.println("Apres ajout voiture:" + cv.capteurPresence.detectePresence());
		cv.register(er);
		cv.recupereVitesse();
		
	}*/
}
