package muscletp;

import java.util.ArrayList;
import java.util.Collection;

public class Voiture {
	private ReseauRoutier reseau;
	private int identifiant;
	private double longueur; 
	private double vitesseMax; 
	private MorceauRoute morceauRoute;
	
	//Les voitures peuvent avoir une visibilit� sur des semaphores
	private ArrayList<Semaphore> semaphoresVisibles = new ArrayList<Semaphore>(); 
	
	// A definir : facon de concevoir l'�tat courant de la voiture
	private EtatCourant etatCourant;
	
	public void vitesseActuelle(){
		
	}
	
}
