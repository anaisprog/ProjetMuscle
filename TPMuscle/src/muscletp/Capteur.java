package muscletp;

import java.util.ArrayList;

import javax.swing.text.Segment;

public class Capteur implements Observer{
	/* Un capteur est placé sur un troncon de route et associé a un element de regulation*/
	/* On part du principe que seul le capteur de Vitesse notifie l'element de régulation et 
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
			System.out.println(" Nouvelle voiture ajoutée en voie Gauche, identifiant : " + ((SegmentRoute)o).getIdentifiantVoitureVG());
		}
		else if(((SegmentRoute)o).isNouvelleVoitureVD()){
			System.out.println(" Nouvelle voiture ajoutée en voie Droite, identifiant : " + ((SegmentRoute)o).getIdentifiantVoitureVD());
		}
	}
	public static void main(String[] args){
		SegmentRoute sujet = new SegmentRoute();
		Capteur obs1 = new CapteurVitesse();
		sujet.register(obs1);
		Voiture v = new Voiture();
		v.setIdentifiant(34);
		VoieGauche vG = new VoieGauche();
		VoieDroite vD = new VoieDroite();
		//vG.addVoiture(v);
		//vG.addVoiture(v);
		//sujet.ajoutVoitureVG(v);
		sujet.ajoutVoiture(v, vG);
		sujet.ajoutVoiture(v, vD);
	}
}
