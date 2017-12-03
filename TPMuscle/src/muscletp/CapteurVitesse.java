package muscletp;

public class CapteurVitesse extends Capteur implements Observable{
	/*signale a son element de regulation l'identificateur et
	 *  la vitesse de la voiture qui passe dessus
	 *  c'est donc un observable pour les elements de regulation (observers)*/

	@Override
	public void register(Observer o) {
		observers.add(o);
	}

	@Override
	public void unregister(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyObserver() {
		for(Observer o: observers){
			o.update(this);
		}
	}
}
