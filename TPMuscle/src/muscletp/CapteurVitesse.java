package muscletp;

public class CapteurVitesse extends CapteurPresence implements ObservableCapteurVitesse{
	
	/*signale a son element de regulation l'identificateur et
	 *  la vitesse de la voiture qui passe dessus
	 *  c'est donc un observable pour les elements de regulation (observers)*/
	int vmax;
	
	public CapteurVitesse(ElementRegulation sonElementRegulation, MorceauRoute sonMorceauRoute, int sonSens, int saPosition, int vmax) 
	{
		super(sonElementRegulation, sonMorceauRoute, sonSens, saPosition);
		this.register(sonElementRegulation);
		type = "Vitesse";
		this.vmax = vmax;
		sonMorceauRoute.getSesCapteurs().add(this);
	}

	@Override
	public boolean detecteVoiture()
	{
		if((this.sonMorceauRoute.getVoiture(this.saPosition, this.sonSens)!=null)&&((this.sonMorceauRoute.getVoiture(this.saPosition, this.sonSens).getVitesseCourante()>vmax)))
		{
			notifyObserver(this.sonMorceauRoute.getVoiture(this.saPosition, this.sonSens), vmax);
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
	public void notifyObserver(Voiture v, int vmax) 
	{
		for(ObserverCapteurVitesse o: observers){
			o.update(v, vmax);
		}
	}
}