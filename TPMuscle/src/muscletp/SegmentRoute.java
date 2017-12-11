package muscletp;

import java.util.ArrayList;

public class SegmentRoute extends MorceauRoute {
	
	private int longueur;
	//Un identifiant unique pour chaque segment de route
	private static int ID = 1;
	private int id;
	private Voie voieGauche;
	private Voie voieDroite;
	private ArrayList<Jonction> sesJonctions;
	private ArrayList<Voiture> sesVoitures;
	private int identifiantVoitureVG;
	private int identifiantVoitureVD;
	private boolean nouvelleVoitureVG;
	private boolean nouvelleVoitureVD;
	
	//Bloc d'initialisation
	{
		voieGauche = new Voie("Gauche",this);
		voieDroite = new Voie("Droite",this);
		sesJonctions = new ArrayList<Jonction>();
		sesVoitures = new ArrayList<Voiture>();
	}
	
	//Constructeur
	public SegmentRoute()
	{
		this.id = ID;
		this.type = "Segment";
		ID++;
	}
	
	public SegmentRoute(int id, int longueur)
	{
		this.id = id;
		this.longueur = longueur;
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

	public Voie getVoieGauche() {
		return voieGauche;
	}

	public void setVoieGauche(Voie voieGauche) {
		this.voieGauche = voieGauche;
	}

	public Voie getVoieDroite() {
		return voieDroite;
	}

	public void setVoieDroite(Voie voieDroite) {
		this.voieDroite = voieDroite;
	}

	public ArrayList<Jonction> getSesJonctions() {
		return sesJonctions;
	}

	public void setSesJonctions(ArrayList<Jonction> sesJonctions) {
		this.sesJonctions = sesJonctions;
	}
	
	/* A chaque fois qu'une voiture est ajoute on notifie le capteur*/
	
	public ArrayList<Voiture> getSesVoitures() {
		return sesVoitures;
	}

	public void setSesVoitures(ArrayList<Voiture> sesVoitures) {
		this.sesVoitures = sesVoitures;
	}

	public void ajoutVoiture(Voiture v, Voie voie){
		/*Dans tous les cas on notifie le capteur (observer)*/
		/* On traite s�parement les cas des voies droites et gauches*/
		
		if(voie.getType().equals("Gauche")){
			voie.addVoiture(v,0);
			identifiantVoitureVG = v.getIdentifiant();
			nouvelleVoitureVG = true;
			notifyObserver();
		}
		else if(voie.getType().equals("Droite")){
			voie.addVoiture(v,0);
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