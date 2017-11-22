package muscletp;

import java.util.ArrayList;
import java.util.Collection;

public class Voiture {
	private ReseauRoutier reseau;
	private int identifiant;
	private double vitesseMax; 
	private MorceauRoute morceauRoute;
	private EtatCourant etatCourant;
	
	
	public double getVitesseActuelle(){
			return this.etatCourant.getVitesseCourante();
	}
	
	public double calculeVitesseActuelle(){
		/*Prend en compte tous les cas de l'énoncé*/
		/*Pour tous les morceaux route on doit regarder s'il y a un semaphore */
		
		/*Si semaphore est feuTrico et orange vitesseAct /2*/
		return this.vitesseMax; 
	}
	
	
	
	public static void main(String[] args){
		Voiture v = new Voiture();
		FeuxTricolore f = new FeuxTricolore();
		f.attribueCouleurRouge();
		
	}
	
}
