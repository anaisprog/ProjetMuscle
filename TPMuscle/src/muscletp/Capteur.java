package muscletp;

import java.util.ArrayList;


public abstract class Capteur {
	/* Un capteur est plac� sur un troncon de route et associ� a un element de regulation */
	
	protected ArrayList<ObserverCapteurVitesse> observers = new ArrayList<>();
	
	protected ElementRegulation elemRegulationAssocie;
	protected MorceauRoute sonMorceauRoute;
	int sonSens;
	protected int saPosition;
	protected String type;
	
	
	
	public ElementRegulation getElemRegulationAssocie() {
		return elemRegulationAssocie;
	}



	public void setElemRegulationAssocie(ElementRegulation elemRegulationAssocie) {
		this.elemRegulationAssocie = elemRegulationAssocie;
	}



	public MorceauRoute getSonMorceauRoute() {
		return sonMorceauRoute;
	}



	public void setSonMorceauRoute(MorceauRoute sonMorceauRoute) {
		this.sonMorceauRoute = sonMorceauRoute;
	}



	public int getSonSens() {
		return sonSens;
	}



	public void setSonSens(int sonSens) {
		this.sonSens = sonSens;
	}



	public int getSaPosition() {
		return saPosition;
	}



	public void setSaPosition(int saPosition) {
		this.saPosition = saPosition;
	}



	public Capteur(ElementRegulation sonElementRegulation, MorceauRoute sonMorceauRoute, int sonSens, int saPosition){
		this.elemRegulationAssocie = sonElementRegulation;
		this.sonMorceauRoute = sonMorceauRoute;
		this.sonSens = sonSens;
		this.saPosition = saPosition;
	}
	
	
	/*public static void main(String[] args){
		SegmentRoute sujet = new SegmentRoute();
		Capteur obs1 = new CapteurVitesse();
		sujet.register(obs1);
		Voiture v = new Voiture();
		v.setIdentifiant(34);
		Voie vG = new Voie("Gauche",sujet);
		Voie vD = new Voie("Droite",sujet);
		//vG.addVoiture(v);
		//vG.addVoiture(v);
		//sujet.ajoutVoitureVG(v);
		sujet.ajoutVoiture(v, vG);
		sujet.ajoutVoiture(v, vD);
	}*/
}
