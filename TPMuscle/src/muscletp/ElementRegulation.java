package muscletp;

import java.util.ArrayList;

public class ElementRegulation implements ObserverCapteurVitesse {
	//observer de capteur de vitesse
	/*elements logiciels bases sur capteurs et semaphores et regulent la circulation
	 * aux carrefours
	 */
	
	ArrayList<Capteur> sesCapteurs = new ArrayList<Capteur>();
	ArrayList<Semaphore> sesSemaphores = new ArrayList<Semaphore>();

	public ElementRegulation()
	{

	}
	public ElementRegulation(ArrayList<Semaphore> sem)
	{
		sesSemaphores.add(sem.get(0));
	}

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
	public void update(Voiture v, int vmax) 
	{
		System.out.println("\n--------Capteur de Vitesse--------");
		System.out.println("Identifiant Voiture : " + v.getIdentifiant());
		System.out.println("Vitesse Voiture : " + v.getVitesseCourante());
		if(v.getVitesseCourante()> vmax)
		{
			System.out.println("Vitesse superieure a la vitesse reglementaire : "+vmax);
			System.out.println("------------------------------");
			
			for(Semaphore s : this.sesSemaphores)
			{

				if((s.getType()=="FeuxTricolore" || s.getType()=="FeuxBicolore"))
				{
					
					System.out.println("La voiture n°"+v.getIdentifiant()+" roule trop vite :(. Le feu du segment n°" + s.getSegment().getId() + " passe au rouge " );
					((Feux)s).attribueCouleurRouge();
				}
			}
		}
	}
		
}
