package muscletp;

import java.util.ArrayList;

public class SegmentRoute extends MorceauRoute {
	
	private int longueur;
	//Un identifiant unique pour chaque segment de route
	private static int ID = 1;
	private int id;
	private ArrayList<Jonction> sesJonctions;
	private int identifiantVoitureVG;
	private int identifiantVoitureVD;
	private boolean nouvelleVoitureVG;
	private boolean nouvelleVoitureVD;
	
	//Bloc d'initialisation
	{
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

	public ArrayList<Jonction> getSesJonctions() {
		return sesJonctions;
	}

	public void setSesJonctions(ArrayList<Jonction> sesJonctions) {
		this.sesJonctions = sesJonctions;
	}
	
	/* A chaque fois qu'une voiture est ajoute on notifie le capteur*/
	


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
	
}