package muscletp;

public interface ObservableCapteurVitesse {

	public void register(ObserverCapteurVitesse o);
	public void unregister(ObserverCapteurVitesse o);
	public void notifyObserver(Voiture v, int vmax);

}
