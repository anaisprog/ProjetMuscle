package muscletp;

import java.util.ArrayList;

import javax.swing.text.Segment;

public class Capteur {
	/* Un capteur est plac� sur un troncon de route et associ� a un element de regulation */
	
	protected ArrayList<ObserverCapteurVitesse> observers = new ArrayList<>();
	
	ElementRegulation sonElementRegulation;
	MorceauRoute sonMorceauRoute;
	Voie saVoie;
	protected int saPosition;
	
	public Capteur(ElementRegulation sonElementRegulation, MorceauRoute sonMorceauRoute, Voie saVoie, int saPosition){
		this.sonElementRegulation = sonElementRegulation;
		this.sonMorceauRoute = sonMorceauRoute;
		this.saVoie = saVoie;
		this.saPosition = saPosition;
	}
	
	public static void main(String[] args){
		SegmentRoute sujet = new SegmentRoute();
		ElementRegulation sonElementRegulation = new ElementRegulation();
		MorceauRoute sonMorceauRoute = new SegmentRoute();
		Voie saVoie=new Voie("Gauche");
		Capteur obs1 = new CapteurVitesse(sonElementRegulation, sonMorceauRoute, saVoie, 1);
		
	}
}
