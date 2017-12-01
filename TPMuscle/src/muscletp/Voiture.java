package muscletp;

import java.util.ArrayList;
import java.util.Collection;

public class Voiture {
	private ReseauRoutier reseau;
	private int identifiant;
	private double vitesseMax; 
	private MorceauRoute morceauRoute;
	private EtatCourant etatCourant;
	
	/* TODO : regarder le cas de la barriere ... PENSEZ A OBSERVER*/
	
	public double getVitesseActuelle(){
			return this.etatCourant.getVitesseCourante();
	}
	
	public void setVitesseActuelle(double vitesse){
			this.etatCourant.setVitesseCourante(vitesse);
	}
	
	public void initialiseVitesse(double vitesseInitiale){
		this.etatCourant.setVitesseCourante(vitesseInitiale);
	}

	public double calculeVitesseActuelle() {
		/* Si le sémaphore est un feu tricolore on divise par deux la vitesse de la voiture 
		 * dans le cas où le feu est orange
		 * Si le feu est rouge la voiture a une vitesse nulle 
		 * Si le feu est vert elle prend sa vitesse max, s'il y a un panneau de limitation de vitesse ..
		 */
			for(int j = 0; j< this.morceauRoute.sesSemaphores.size(); j++){
			
			if(morceauRoute.sesSemaphores.get(j).getType().equals("FeuxTricolore")) {
				
				if(((FeuxTricolore) morceauRoute.sesSemaphores.get(j)).getCouleurActuelle()==Couleur.ORANGE){
					this.setVitesseActuelle((this.getVitesseActuelle())/2);
					j++;
				}

				else if(((FeuxTricolore) morceauRoute.sesSemaphores.get(j)).getCouleurActuelle()==Couleur.ROUGE){
					this.setVitesseActuelle(0);
					System.out.println("VITESSE APRES FEU ROUGE" + this.getVitesseActuelle());
					j++;
				}
				
				else if(((FeuxTricolore) morceauRoute.sesSemaphores.get(j)).getCouleurActuelle()==Couleur.VERT){
					/* Boolean panneau de limitation : si true la vitesse prend la valeur du panneau*/
					
					this.setVitesseActuelle(this.vitesseMax);
					System.out.println("VITESSE APRES FEU VERT" + this.getVitesseActuelle());
					j++;
				}	
				}
				/* Les voitures doivent respecter les limitations imposées par un panneau 
				 * de limitation de vitesse
				 * On etudie le cas ou il n'y a pas de feux
				 */
			
			else if(morceauRoute.sesSemaphores.get(j).getType().equals("PanneauLimitation")) {
				System.out.println(" REDUIT TA VITESSE");
				if(this.getVitesseActuelle()>(((PanneauLimitation) morceauRoute.sesSemaphores.get(j)).getLimitation())){
					this.setVitesseActuelle((((PanneauLimitation) morceauRoute.sesSemaphores.get(j)).getLimitation()));
					System.out.println("La nouvelle valeur de vitesse est " + this.getVitesseActuelle());
					j++;
				}	
			}
			else{
				this.setVitesseActuelle(this.vitesseMax);
			}
		}
			return this.getVitesseActuelle();
	}
	
	public void setVitesseMax(double vitesseMax) {
		this.vitesseMax = vitesseMax;
	}

	public EtatCourant getEtatCourant() {
		return etatCourant;
	}

	public void setEtatCourant(EtatCourant etatCourant) {
		this.etatCourant = etatCourant;
	}

	public double getVitesseMax() {
		return vitesseMax;
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
