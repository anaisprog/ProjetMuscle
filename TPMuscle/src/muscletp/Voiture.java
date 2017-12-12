package muscletp;

public class Voiture {
	private ReseauRoutier reseau;
	private int infinity = Integer.MAX_VALUE;
	private int identifiant;
	private double vitesseMax; 
	private MorceauRoute morceauRoute;
	private static int ID = 1;
	private int position;
	private int sens; // 1 ou -1
	private double vitesseCourante; //ETATCOURANT
	
	public Voiture()
	{
		this.identifiant = ID;
		ID++;
	}
	
	//Ajoute pour les tests: 
	public Voiture(int vitesseMax, MorceauRoute morceauRoute, int position, Voie voie ){
		this.vitesseMax = vitesseMax;
		this.morceauRoute = morceauRoute;
		this.position = position;

		
	}
	
	/* TODO : regarder le cas de la barriere ... PENSEZ A OBSERVER*/

	
	public double getVitesseCourante() {
		return vitesseCourante;
	}


	public void setVitesseCourante(double vitesseCourante) {
		this.vitesseCourante = vitesseCourante;
	}


	
	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
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
			
			if((morceauRoute.sesSemaphores.get(j).getType().equals("FeuxTricolore"))&&((morceauRoute.sesSemaphores.get(j).getSens() == this.sens))) 
			{
				
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
			
			else if((morceauRoute.sesSemaphores.get(j).getType().equals("PanneauLimitation"))&&(morceauRoute.sesSemaphores.get(j).sens == this.sens)) {
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

	/*Cette methode renvoie true s'il y a une limitation de vitesse a respecter par la voiture*/
	public boolean limitationVitesse() {
		for(int j = 0; j< this.morceauRoute.sesSemaphores.size(); j++){
			if(morceauRoute.sesSemaphores.get(j).getType().equals("PanneauLimitation")){
				return true;
			}
		}
		return false;
	}
	
	/* Methode renvoyant la valeur de la limitation de vitesse s'il y a un panneau*/
	
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

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getSens() {
		return sens;
	}

	public void setSens(int sens) {
		this.sens = sens;
	}
	
	
	
}
