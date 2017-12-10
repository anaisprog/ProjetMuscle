package muscletp;

public class CapteurPresence extends Capteur {
	boolean presence;
	
	public CapteurPresence( ElementRegulation sonElementRegulation, MorceauRoute sonMorceauRoute, Voie saVoie, int saPosition) {
		super(sonElementRegulation, sonMorceauRoute, saVoie, saPosition);
		// TODO Auto-generated constructor stub
	}
	
	//METHODE 1 : renvoie l'identifiant de la voiture qui passe devant le capteur de Presence // TEST OK
	
	public int idVoiture(){
		if(detectePresence()){
			return 	this.sonMorceauRoute.getVoiture(this.saPosition, this.saVoie).getIdentifiant();
		}
		return -1;
	}
	
	//METHODE 2 : renvoie true si une voiture a ete detectee sur le morceauRoute //TEST OK
	
	public boolean detectePresence(){
		if((this.sonMorceauRoute.getVoiture(this.saPosition, this.saVoie)!=null)){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args){
		ElementRegulation sonElementRegulation = new ElementRegulation();
		MorceauRoute sonMorceauRoute= new SegmentRoute();
		Voie saVoie = new Voie("Gauche");
		CapteurPresence c = new CapteurPresence(sonElementRegulation, sonMorceauRoute, saVoie, 1);
		System.out.println(c.detectePresence());
		Voiture v = new Voiture(2, sonMorceauRoute, 1, saVoie);
		//System.out.println("ID VOITURE :" + c.idVoiture());
		CapteurVitesse cv = new CapteurVitesse(sonElementRegulation, sonMorceauRoute, saVoie, 1);
		//System.out.println("ID VOITURE :" +v2.getIdentifiant());	
	}
 }
