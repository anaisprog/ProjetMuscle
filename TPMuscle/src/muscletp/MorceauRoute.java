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
	
	protected ArrayList<? extends Semaphore> sesSemaphores = new ArrayList<>();
	ArrayList<? extends Capteur> sesCapteurs = new ArrayList<>(); 
	
	{
		this.sesVoitures = new ArrayList<Voiture>();
	}
	
	public ArrayList<? extends Semaphore> getSesSemaphores() {
		return sesSemaphores;
	}
	public void setSesSemaphores(ArrayList<? extends Semaphore> sesSemaphores) {
		this.sesSemaphores = sesSemaphores;
	}
	public void setSesCapteurs(ArrayList<? extends Capteur> sesCapteurs) {
		this.sesCapteurs = sesCapteurs;
	}
	public ArrayList<? extends Capteur> getSesCapteurs() {
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
		for(Voiture v : sesVoitures)
		{	
			System.out.println(v.getSens());
			System.out.println(v.getPosition());
			if(v.getSens() == sens)
			{
					if(v.getPosition()== position)
					{
						System.out.println("je suis la ");
						return v;
					}
			}
		}
		return null;
	}	
}
	

