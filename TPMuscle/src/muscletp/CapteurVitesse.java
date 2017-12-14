package muscletp;

public class CapteurVitesse extends CapteurPresence implements ObservableCapteurVitesse{
	
	/*signale a son element de regulation l'identificateur et
	 *  la vitesse de la voiture qui passe dessus
	 *  c'est donc un observable pour les elements de regulation (observers)*/
  
	CapteurPresence capteurPresence;
	
	public CapteurVitesse(ElementRegulation sonElementRegulation, MorceauRoute sonMorceauRoute, int sonSens, int saPosition) {
		super(sonElementRegulation, sonMorceauRoute, sonSens, saPosition);
		this.register(sonElementRegulation);
		capteurPresence = new CapteurPresence(sonElementRegulation, sonMorceauRoute, sonSens, saPosition);
		type = "Vitesse";
	}
	@Override
	public boolean detecteVoiture()
	{
		if((this.sonMorceauRoute.getVoiture(this.saPosition, this.sonSens)!=null))
		{
			
			notifyObserver(this.sonMorceauRoute.getVoiture(this.saPosition, this.sonSens));
			return true;
		}
		return false;
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
	public void notifyObserver(Voiture v) 
	{
		for(ObserverCapteurVitesse o: observers){
			o.update(v);
		}
	}
}