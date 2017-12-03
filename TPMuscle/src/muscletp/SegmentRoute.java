package muscletp;

import java.awt.List;
import java.util.ArrayList;

public class SegmentRoute extends MorceauRoute {
	
	private int longueur;
	//Un identifiant unique pour chaque segment de route
	private static int ID = 1;
	private int id;
	private VoieDroite voieDroite = new VoieDroite();
	private VoieGauche voieGauche = new VoieGauche();	
	private int identifiantVoitureVG;
	private int identifiantVoitureVD;
	private boolean nouvelleVoitureVG;
	private boolean nouvelleVoitureVD;
	
	//Constructeur
	public SegmentRoute()
	{
		this.id = ID;
		this.type = "Segment";
		ID++;
	}
	
	/* A chaque fois qu'une voiture est ajouté on notifie le capteur*/
	
	public void ajoutVoiture(Voiture v, Voie voie){
		/*Dans tous les cas on notifie le capteur (observer)*/
		/* On traite séparement les cas des voies droites et gauches*/
		
		if(voie.getType().equals("VoieGauche")){
			voieGauche.addVoiture(v);
			identifiantVoitureVG = v.getIdentifiant();
			nouvelleVoitureVG = true;
			notifyObserver();
		}
		else if(voie.getType().equals("VoieDroite")){
			voieDroite.addVoiture(v);
			identifiantVoitureVD = v.getIdentifiant();
			nouvelleVoitureVD = true;
			notifyObserver();
		}
	nouvelleVoitureVG = false;	
	nouvelleVoitureVD = false;
	}

	
	public boolean isNouvelleVoitureVG() {
		return nouvelleVoitureVG;
	}

	public boolean isNouvelleVoitureVD() {
		return nouvelleVoitureVD;
	}

	public int getIdentifiantVoitureVG() {
		return identifiantVoitureVG;
	}

	public int getIdentifiantVoitureVD() {
		return identifiantVoitureVD;
	}

	public VoieDroite getVoieDroite() {
		return voieDroite;
	}
	public void setVoieDroite(VoieDroite voieDroite) {
		this.voieDroite = voieDroite;
	}
	public VoieGauche getVoieGauche() {
		return voieGauche;
	}
	public void setVoieGauche(VoieGauche voieGauche) {
		this.voieGauche = voieGauche;
	}
	
	@Override
	public void register(Observer o) {
		observers.add(o);
	}

	@Override
	public void unregister(Observer o) {
		// TODO Auto-generated method stub
		observers.remove(o);
	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		for(Observer o: observers){
			o.update(this);
		}
	}

	public int getLongueur() {
		return longueur;
	}
// chaque fois que la lg change, on le notifie
	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}
	
}