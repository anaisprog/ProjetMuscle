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
	
	public double calculeVitesseActuelle() throws ClassNotFoundException{
		Class c = Class.forName("FeuxTricolore");
		/*Prend en compte tous les cas de l'énoncé*/
		/*Pour tous les morceaux route on doit regarder s'il y a un semaphore */
		for (int i=0; i< reseau.getSesRoutes().size(); i++){
			if(morceauRoute.sesSemaphores.get(i).getType().equals("FeuxTricolore")) {
				
				System.out.println(morceauRoute.sesSemaphores.get(i).getClass().equals(c));
				//if(((morceauRoute.sesSemaphores.get(i).getClass())==c)){
					//System.out.println();
					
				System.out.println("COUCOU TU ES SUR UNE TRES TRES BONNE VOIE!!!!");
				//}
				System.out.println("Je sors");
			}
		}
		
		/*Si semaphore est feuTrico et orange vitesseAct /2*/
		return this.vitesseMax; 
	}
	
	
	
	public static void main(String[] args){
		Voiture v = new Voiture();
		FeuxTricolore f = new FeuxTricolore();
		f.attribueCouleurRouge();
		ReseauRoutier r; 
		
		 
	}

	public ReseauRoutier getReseau() {
		return reseau;
	}

	public void setReseau(ReseauRoutier reseau) {
		this.reseau = reseau;
	}

	public MorceauRoute getMorceauRoute() {
		return morceauRoute;
	}

	public void setMorceauRoute(MorceauRoute morceauRoute) {
		this.morceauRoute = morceauRoute;
	}
	
}
