package muscletp;

import java.awt.List;
import java.util.ArrayList;

public class SegmentRoute extends MorceauRoute {
	
	private int longueur;
	//Un identifiant unique pour chaque segment de route
	private static int ID = 1;
	private int id;
	
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