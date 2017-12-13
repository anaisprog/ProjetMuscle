package muscletp;

import java.util.ArrayList;

public class ElementRegulation implements ObserverCapteurVitesse {
	//observer de capteur de vitesse
	/*elements logiciels bases sur capteurs et semaphores et regulent la circulation
	 * aux carrefours
	 */
	
	ArrayList<Capteur> sesCapteurs = new ArrayList<>();
	ArrayList<Semaphore> sesSemaphores = new ArrayList<>();
	@Override
	
	public void update(Voiture v) {
		System.out.println("--------Capteur de Vitesse--------");
		//System.out.println("Identifiant Voiture : " +identifiant);
		System.out.println("Identifiant Voiture : " + v.getIdentifiant());
		//System.out.println("Vitesse Voiture : " + vitesse);
		System.out.println("Vitesse Voiture : " + v.getVitesseCourante());
		/*Si la vitesse est superieure a la vitesse reglementaire*/
		//if(vitesse> 110){
		if(v.getVitesseCourante()> 7){
			System.out.println("Vitesse superieure a la vitesse reglementaire");
			for(int i =0; i<this.sesSemaphores.size(); i++){
				if((this.sesSemaphores.get(i).getType()=="FeuxTricolore" || this.sesSemaphores.get(i).getType()=="FeuxBicolore") && this.sesSemaphores.get(i).getSens()== v.getSens() && this.sesSemaphores.get(i).getPosition()== v.getPosition()){
					((Feux)(this.sesSemaphores.get(i))).attribueCouleurRouge();
				}
			}
		}
	}
	public static void main(String[] args){
		ElementRegulation er = new ElementRegulation();
		MorceauRoute m = new SegmentRoute();
		Voiture voit2 = new Voiture(278, m, 2, -1);
		m.sesVoitures.add(voit2);
		CapteurVitesse cv = new CapteurVitesse(er, m, -1, 2);
		voit2.setVitesseCourante(345);
		
		
		System.out.println("Apres ajout voiture:" + cv.capteurPresence.detectePresence());
		cv.register(er);
		cv.detectionVoiture();
		
	}
}
