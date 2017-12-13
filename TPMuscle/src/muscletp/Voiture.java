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
	public Voiture(int vitesseMax, MorceauRoute morceauRoute, int position, int sens){
		this.vitesseMax = vitesseMax;
		this.morceauRoute = morceauRoute;
		this.position = position;	
		this.sens = sens;
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
		if(feuVert()){
			this.setVitesseCourante(this.getVitesseCourante());
		}
		else if(feuOrange()){
			this.setVitesseCourante((this.getVitesseCourante())/2);
		}
		else if(feuRouge()){
			this.setVitesseCourante(0);
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
	
	public boolean feuVert() {
		for(int j = 0; j< this.morceauRoute.sesSemaphores.size(); j++){
			if((morceauRoute.sesSemaphores.get(j).getType().equals("FeuxTricolore"))&&((morceauRoute.sesSemaphores.get(j).getSens() == this.sens))) 
			{	
				if(((FeuxTricolore) morceauRoute.sesSemaphores.get(j)).getCouleurActuelle()==Couleur.VERT){
					System.out.println("La voiture " + this.getIdentifiant() + " rencontre un feu Vert ");
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean feuOrange() {
		for(int j = 0; j< this.morceauRoute.sesSemaphores.size(); j++){
			if((morceauRoute.sesSemaphores.get(j).getType().equals("FeuxTricolore"))&&((morceauRoute.sesSemaphores.get(j).getSens() == this.sens))) 
			{	
				if(((FeuxTricolore) morceauRoute.sesSemaphores.get(j)).getCouleurActuelle()==Couleur.ORANGE){
					System.out.println("La voiture " + this.getIdentifiant() + " rencontre un feu Orange ");
					return true;
				}
			}
			j++;
		}
		return false;
	}
	
	public boolean feuRouge() {
		for(int j = 0; j< this.morceauRoute.sesSemaphores.size(); j++){
			if((morceauRoute.sesSemaphores.get(j).getType().equals("FeuxTricolore"))&&((morceauRoute.sesSemaphores.get(j).getSens() == this.sens))) 
			{	
				if(((FeuxTricolore) morceauRoute.sesSemaphores.get(j)).getCouleurActuelle()==Couleur.ROUGE){
					System.out.println("La voiture " + this.getIdentifiant() + " rencontre un feu Rouge ");
					return true;
				}
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
	
	public static void main(String[] args){
		
	}
	
}
