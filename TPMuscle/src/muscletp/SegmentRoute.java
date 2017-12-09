package muscletp;

import java.awt.List;
import java.util.ArrayList;

public class SegmentRoute extends MorceauRoute {
	
	private int longueur;
	//Un identifiant unique pour chaque segment de route
	private static int ID = 1;
	private int id;
	private ArrayList<Voiture> voieGauche;
	private ArrayList<Voiture> voieDroite;
	private ArrayList<Jonction> sesJonctions;
	private int identifiantVoitureVG;
	private int identifiantVoitureVD;
	private boolean nouvelleVoitureVG;
	private boolean nouvelleVoitureVD;
	
	//Bloc d'initialisation
	{
		voieGauche = new ArrayList<Voiture>();
		voieDroite = new ArrayList<Voiture>();
		sesJonctions = new ArrayList<Jonction>();
	}
	
	//Constructeur
	public SegmentRoute()
	{
		this.id = ID;
		this.type = "Segment";
		ID++;
	}
	
	public SegmentRoute(int id)
	{
		this.id = id;
		this.type = "Segment";

	}

	public int getLongueur() {
		return longueur;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Voiture> getVoieGauche() {
		return voieGauche;
	}

	public void setVoieGauche(ArrayList<Voiture> voieGauche) {
		this.voieGauche = voieGauche;
	}

	public ArrayList<Voiture> getVoieDroite() {
		return voieDroite;
	}

	public void setVoieDroite(ArrayList<Voiture> voieDroite) {
		this.voieDroite = voieDroite;
	}

	public ArrayList<Jonction> getSesJonctions() {
		return sesJonctions;
	}

	public void setSesJonctions(ArrayList<Jonction> sesJonctions) {
		this.sesJonctions = sesJonctions;
	}
	
	/* A chaque fois qu'une voiture est ajout� on notifie le capteur*/
	
	public void ajoutVoiture(Voiture v, Voie voie){
		/*Dans tous les cas on notifie le capteur (observer)*/
		/* On traite s�parement les cas des voies droites et gauches*/
		
		if(voie.getType().equals("Gauche")){
			voie.addVoiture(v);
			identifiantVoitureVG = v.getIdentifiant();
			nouvelleVoitureVG = true;
			notifyObserver();
		}
		else if(voie.getType().equals("Droite")){
			voie.addVoiture(v);
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
	
}