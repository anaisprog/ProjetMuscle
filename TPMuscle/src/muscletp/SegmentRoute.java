package muscletp;


import java.util.ArrayList;

public class SegmentRoute extends MorceauRoute {

	private int longueur;
	//Un identifiant unique pour chaque segment de route
	private static int ID = 1;
	private int id;
	private ArrayList<Voiture> voieGauche;
	private ArrayList<Voiture> voieDroite;
	
	//Bloc d'initialisation
	{
		voieGauche = new ArrayList<Voiture>();
		voieDroite = new ArrayList<Voiture>();
	}
	
	//Constructeur
	public SegmentRoute()
	{
		this.id = ID;
		this.type = "Segment";
		ID++;
	}
	
}
