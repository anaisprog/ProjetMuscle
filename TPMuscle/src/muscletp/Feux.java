package muscletp;

public abstract class Feux extends Semaphore{
		// on d�finit une enum�ration pour Couleur qui sera diff�rente selon 
		//feux bicolores ou tricolore
	
	public abstract void attribueCouleurRouge();
	public abstract void attribueCouleurOrange();
	public abstract Couleur getCouleurActuelle();
}
