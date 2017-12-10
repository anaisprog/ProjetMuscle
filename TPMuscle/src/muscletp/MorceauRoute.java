package muscletp;
import java.awt.List;
import java.util.ArrayList;

/* Les morceaux routes notifie les capteurs 
 * du passage de voitures
 */
public abstract class MorceauRoute{
	
	//Differents types : Segments, Jonction, JSimple, Barriere, Carrefour
	protected String type;
	// On realise une liste d'observers qui suivent les notifications de MorceauRoute
	protected ArrayList<Voiture> voieGauche;
	protected ArrayList<Voiture> voieDroite;
	protected ArrayList<Jonction> sesJonctions;
	
	protected int identifiantVoitureVG;
	protected int identifiantVoitureVD;
	protected boolean nouvelleVoitureVG;
	protected boolean nouvelleVoitureVD;
	
	{
		voieGauche = new ArrayList<Voiture>();
		voieDroite = new ArrayList<Voiture>();
		sesJonctions = new ArrayList<Jonction>();
	}
	
	//METHODE 1 : permet d'ajouter une voiture dans le morceauRoute sur une voie // A REPRENDRE SELON MODIF DE VOIE!
	
	public void ajoutVoiture(Voiture v, Voie voie){
		/*Dans tous les cas on notifie le capteur (observer)*/
		/* On traite sï¿½parement les cas des voies droites et gauches*/
		
		if(voie.getType().equals("Gauche")){
			voieGauche.add(v);
			identifiantVoitureVG = v.getIdentifiant();
			nouvelleVoitureVG = true;
		}
		else if(voie.getType().equals("Droite")){
			voieDroite.add(v);
			identifiantVoitureVD = v.getIdentifiant();
			nouvelleVoitureVD = true;
		}
	nouvelleVoitureVG = false;	
	nouvelleVoitureVD = false;
	}
	
	//METHODE 2 : permet de récuperer les voitures sur une position et une voie donnee
	
	public Voiture getVoiture (int position, Voie voie){
		if(voie.type.equals("Gauche")){
			for(Voiture v: voieGauche){
				if(v.getPosition()== position){
					return v;
				}
			}
		}
		else{
			for(Voiture v : voieDroite){
				if(v.getPosition() == position){
					return v;
				}
			}
		}
		return null;
	}
	
	
	ArrayList<? extends Semaphore> sesSemaphores = new ArrayList<>();
	
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
	ArrayList<? extends Capteur> sesCapteurs = new ArrayList<>(); 
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
