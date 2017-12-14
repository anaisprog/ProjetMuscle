package muscletp;

import java.util.ArrayList;


public class Carrefour extends Jonction {
	// Cette m�thode permettra de choisir al�atoirement le segment sur lequel la voiture continuera
	
	/**
	 * Ce constructeur va nous permettre de construire des carrefour à 3, 4... segments
	 */
	public Carrefour (SegmentRoute...segments)
	{
		super(segments);
		this.type = "Carrefour";
		this.ajouterSemaphore();
	
	}
	public Carrefour(int id)
	{
		super(id);
		this.type = "Carrefour";
		this.ajouterSemaphore();
	}
	
	public Carrefour()
	{
		super();
		this.type = "Carrefour";
		this.ajouterSemaphore();
		
	}
	
	// Cette methode permettra de choisir aleatoirement le segment sur lequel la voiture continuera
	// de rouler
	/*public SegmentRoute choixRoute(Voiture v){
		// Le choix de route se fait de maniere aleatoire
		int min = 0;
		int max = segments.size()-1;
		int random = (int)(Math.random() * (max-min)) + min;
		return segments.get(random);
	}*/
	
}