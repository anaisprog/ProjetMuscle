package muscletp;

import java.util.ArrayList;

public class ElementRegulation implements ObserverCapteurVitesse {
	//observer de capteur de vitesse
	/*elements logiciels bases sur capteurs et semaphores et regulent la circulation
	 * aux carrefours
	 */
	
	ArrayList<Capteur> sesCapteurs = new ArrayList<>();
	ArrayList<Semaphore> sesSemaphores = new ArrayList<>();
	
	
	public ArrayList<Capteur> getSesCapteurs() {
		return sesCapteurs;
	}
	public void setSesCapteurs(ArrayList<Capteur> sesCapteurs) {
		this.sesCapteurs = sesCapteurs;
	}
	public ArrayList<Semaphore> getSesSemaphores() {
		return sesSemaphores;
	}
	public void setSesSemaphores(ArrayList<Semaphore> sesSemaphores) {
		this.sesSemaphores = sesSemaphores;
	}
	
	@Override
	public void update(Voiture v) {
		System.out.println("--------Capteur de Vitesse--------");
		System.out.println("Identifiant Voiture : " + v.getIdentifiant());
		System.out.println("Vitesse Voiture : " + v.getVitesseCourante());
		if(v.getVitesseCourante()> 6)
		{
			System.out.println("Vitesse superieure a la vitesse reglementaire");
			for(int i =0; i<this.sesSemaphores.size(); i++)
			{
				if((this.sesSemaphores.get(i).getType()=="FeuxTricolore" || this.sesSemaphores.get(i).getType()=="FeuxBicolore"))
				{
					System.out.println("Le feu du segment numero " + this.sesSemaphores.get(i).getSegment().getId() + " passe au Rouge " );
					((Feux)(this.sesSemaphores.get(i))).attribueCouleurRouge();
				}
			}
		}
	}

}
