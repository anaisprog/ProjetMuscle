package muscletp;
import java.util.ArrayList;
import java.util.Observer;

/* Les morceaux routes notifie les capteurs 
 * du passage de voitures
 */
public abstract class MorceauRoute 
{
	// On realise une liste d'observers qui suivent les notifications de MorceauRoute
	protected ArrayList<Observer> observers = new ArrayList<>();
	protected ArrayList<Voiture> sesVoitures;
	
	//Differents types : Segments, Jonction, JSimple, Barriere, Carrefour
	protected String type;
	
	protected ArrayList<Semaphore> sesSemaphores ;
	protected ArrayList<Capteur> sesCapteurs ;
	
	{
		this.sesVoitures = new ArrayList<Voiture>();
		this.sesSemaphores = new ArrayList<Semaphore>();
		this.sesCapteurs = new ArrayList<Capteur>();
	}
	
	
	public ArrayList<Semaphore> getSesSemaphores() {
		return sesSemaphores;
	}
	public void setSesSemaphores(ArrayList<Semaphore> sesSemaphores) {
		this.sesSemaphores = sesSemaphores;
	}
	public void setSesCapteurs(ArrayList<Capteur> sesCapteurs) {
		this.sesCapteurs = sesCapteurs;
	}
	public ArrayList<Capteur> getSesCapteurs() {
		return sesCapteurs;
	}
	
	public ArrayList<Voiture> getSesVoitures() {
		return sesVoitures;
	}
	public void setSesVoitures(ArrayList<Voiture> sesVoitures) {
		this.sesVoitures = sesVoitures;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	//METHODE 2 : permet de r�cuperer les voitures sur une position et une voie donnee
	
	public Voiture getVoiture (int position, int sens)
	{
		for(Voiture v : this.sesVoitures)
		{
			
			if(v.getSens() == sens)
			{
					if(v.getPosition()== position)
					{
						return v;
					}	
			}
			
		}
		
		return null;
	}
	
}
	

