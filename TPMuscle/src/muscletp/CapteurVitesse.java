package muscletp;

public class CapteurVitesse extends Capteur implements ObservableCapteurVitesse{
	
	/*signale a son element de regulation l'identificateur et
	 *  la vitesse de la voiture qui passe dessus
	 *  c'est donc un observable pour les elements de regulation (observers)*/
	
	double vitesse; // attribut pertinent de signaler a l'observer
	int identifiant;  
	CapteurPresence capteurPresence;
	
	public CapteurVitesse(ElementRegulation sonElementRegulation, MorceauRoute sonMorceauRoute, Voie saVoie, int saPosition) {
		super(sonElementRegulation, sonMorceauRoute, saVoie, saPosition);
		capteurPresence = new CapteurPresence(sonElementRegulation, sonMorceauRoute, saVoie, saPosition);
	}
	
	public double getVitesse() {
		return vitesse;
	}
	
	//METHODE 1 : Methode qui recupere la vitesse Courante de la voiture presente sur le morceauRoute
	// et notifie les ElementRegulation de l'identifiant et de la vitesse de la voiture
	
	public void recupereVitesse(){
		if(capteurPresence.detectePresence()){
			vitesse = this.sonMorceauRoute.getVoiture(saPosition, saVoie).getVitesseCourante();
			notifyObserver(this.capteurPresence.idVoiture(), vitesse);
		}
	}
	
	@Override
	public void register(ObserverCapteurVitesse o) {
		observers.add(o);	
	}

	@Override
	public void unregister(ObserverCapteurVitesse o) {
		observers.remove(o);
	}

	@Override
	public void notifyObserver(int identifiant, double vitesse) {
		for(ObserverCapteurVitesse o: observers){
			o.update(identifiant, vitesse);
		}
	}
}
