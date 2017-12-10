package muscletp;

import java.util.ArrayList;
import java.util.Collection;

public class Voiture {
	
	//petit soucis : morceauRoute dans voiture et segmentRoute dans etatCourant
	private int infinity = Integer.MAX_VALUE;
	private static int nbVoitures = 0;
	private ReseauRoutier reseau;
	private int identifiant;
	private double vitesseMax; 
	private MorceauRoute morceauRoute;
	private Voie voie;
	private double vitesseCourante; //ETATCOURANT
	//pourtest: 
	private int position;
	
	/* TODO : regarder le cas de la barriere ... PENSEZ A OBSERVER*/
	
	public int getPosition() {
		return position;
	}

	//Ajoute pour les tests: 
	public Voiture(int vitesseMax, MorceauRoute morceauRoute, int position, Voie voie ){
		this.vitesseMax = vitesseMax;
		this.morceauRoute = morceauRoute;
		this.voie = voie;
		this.position = position;
		this.morceauRoute.ajoutVoiture(this, voie);
		this.identifiant = nbVoitures++;
		
	}
	
	public double getVitesseCourante() {
		return vitesseCourante;
	}


	public void setVitesseCourante(double vitesseCourante) {
		this.vitesseCourante = vitesseCourante;
	}
	
	public void ralentir(){
		this.setVitesseCourante(this.getVitesseCourante()/2);
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
					this.setVitesseCourante((this.getVitesseCourante())/2);
					j++;
				}

				else if(((FeuxTricolore) morceauRoute.sesSemaphores.get(j)).getCouleurActuelle()==Couleur.ROUGE){
					this.setVitesseCourante(0);
					System.out.println("VITESSE APRES FEU ROUGE" + this.getVitesseCourante());
					j++;
				}
				
				else if(((FeuxTricolore) morceauRoute.sesSemaphores.get(j)).getCouleurActuelle()==Couleur.VERT){
					if(limitationVitesse()){
						this.setVitesseCourante(this.valeurLimitationVitesse());
					}
					else{
						this.setVitesseCourante(this.vitesseMax);
					}
					System.out.println("VITESSE APRES FEU VERT" + this.getVitesseCourante());
					j++;
				}	
			}
				/* Les voitures doivent respecter les limitations imposées par un panneau 
				 * de limitation de vitesse
				 * On etudie le cas ou il n'y a pas de feux
				 */
			
			else if(morceauRoute.sesSemaphores.get(j).getType().equals("PanneauLimitation")) {
				if(this.getVitesseCourante()>(((PanneauLimitation) morceauRoute.sesSemaphores.get(j)).getLimitation())){
					this.setVitesseCourante((((PanneauLimitation) morceauRoute.sesSemaphores.get(j)).getLimitation()));
					System.out.println("La nouvelle valeur de vitesse est " + this.getVitesseCourante());
					j++;
				}	
			}
			else{
				this.setVitesseCourante(this.vitesseMax);
			}
		}
			return this.getVitesseCourante();
	}
	
	public int getIdentifiant() {
		return identifiant;
	}

	/*Cette methode renvoie true s'il y a une limitation de vitesse a respecter par la voiture*/
	public boolean limitationVitesse() {
		for(int j = 0; j< this.morceauRoute.sesSemaphores.size(); j++){
			if(morceauRoute.sesSemaphores.get(j).getType().equals("PanneauLimitation")){
				return true;
			}
		}
		return false;
	}
	
	/* Méthode renvoyant la valeur de la limitation de vitesse s'il y a un panneau*/
	
	public int valeurLimitationVitesse() {
		for(int j = 0; j< this.morceauRoute.sesSemaphores.size(); j++){
			if(morceauRoute.sesSemaphores.get(j).getType().equals("PanneauLimitation")){
				return ((PanneauLimitation)morceauRoute.sesSemaphores.get(j)).getLimitation();
			}
		}
		return infinity;
	}
	

	public void setVitesseMax(double vitesseMax) {
		this.vitesseMax = vitesseMax;
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
