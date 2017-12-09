package muscletp;

import java.util.ArrayList;

import javax.swing.text.Segment;

public class Capteur implements Observer{
	/* Un capteur est plac� sur un troncon de route et associ� a un element de regulation*/
	/* On part du principe que seul le capteur de Vitesse notifie l'element de r�gulation et 
	 * implementera l'interface Observable...
	 */
	protected ArrayList<Observer> observers = new ArrayList<>();
	
	ElementRegulation elemRegulationAssocie;
	MorceauRoute sonMorceauRoute;
	
	
	@Override
	public void update(Observable o) {
		// TODO Auto-generated method stub
		//Verifier si nouvelle voiture sur la voie de type "gauche"/ "droite"
		if(((SegmentRoute)o).isNouvelleVoitureVG()){
			System.out.println(" Nouvelle voiture ajout�e en voie Gauche, identifiant : " + ((SegmentRoute)o).getIdentifiantVoitureVG());
		}
		else if(((SegmentRoute)o).isNouvelleVoitureVD()){
			System.out.println(" Nouvelle voiture ajout�e en voie Droite, identifiant : " + ((SegmentRoute)o).getIdentifiantVoitureVD());
		}
	}
	public static void main(String[] args){
		SegmentRoute sujet = new SegmentRoute();
		Capteur obs1 = new CapteurVitesse();
		sujet.register(obs1);
		Voiture v = new Voiture();
		v.setIdentifiant(34);
		Voie vG = new Voie("Gauche");
		Voie vD = new Voie("Droite");
		//vG.addVoiture(v);
		//vG.addVoiture(v);
		//sujet.ajoutVoitureVG(v);
		sujet.ajoutVoiture(v, vG);
		sujet.ajoutVoiture(v, vD);
	}
}
