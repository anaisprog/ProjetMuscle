package muscletp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

public class Carrefour extends Jonction {
	ArrayList<SegmentRoute> segments = new ArrayList<SegmentRoute>();
	// Cette m�thode permettra de choisir al�atoirement le segment sur lequel la voiture continuera
	
	public Carrefour(int id)
	{
		super(id);
	}
	
	public Carrefour()
	{
		super();
	}
	
	// Cette methode permettra de choisir aleatoirement le segment sur lequel la voiture continuera
	// de rouler
	public SegmentRoute choixRoute(Voiture v){
		// Le choix de route se fait de maniere aleatoire
		int min = 0;
		int max = segments.size()-1;
		int random = (int)(Math.random() * (max-min)) + min;
		return segments.get(random);
	}
	
}