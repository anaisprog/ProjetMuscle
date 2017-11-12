package muscletp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

public class Carrefour extends Jonction {
	Collection<SegmentRoute> segments = new ArrayList<SegmentRoute>();
	
	
	// Cette méthode permettra de choisir aléatoirement le segment sur lequel la voiture continuera
	// de rouler
	public int choixRoute(Voiture v){
		// Le choix de route se fait de maniere aleatoire
		int min = 0;
		int max = segments.size()-1;
		int random = (int)(Math.random() * (max-min)) + min;
		return random;
	}
	
	public static void main(String[] args){
		Voiture v = new Voiture();
		Carrefour c = new Carrefour();
		SegmentRoute s = new SegmentRoute();
		SegmentRoute s2 = new SegmentRoute();
		SegmentRoute s3 = new SegmentRoute();
		c.segments.add(s);
		c.segments.add(s2);
		c.segments.add(s3);
		c.choixRoute(v);
		
		PositionVoiture pV = new PositionVoiture();
		pV.setPosition(34.0);
		pV.setSegmentRoute(s2);
		pV.getPosition();
		}
	}
