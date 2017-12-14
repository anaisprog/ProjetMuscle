package muscletp;

public class CapteurPresence extends Capteur {
	boolean presence;
	
	public CapteurPresence( ElementRegulation sonElementRegulation, MorceauRoute sonMorceauRoute, int sonSens, int saPosition) 
	{
		super(sonElementRegulation, sonMorceauRoute, sonSens, saPosition);
		this.type = "Presence";
	}
	
	//renvoie true si une voiture a ete detectee sur le morceauRoute
	
	public boolean detecteVoiture()
	{
		if((this.sonMorceauRoute.getVoiture(this.saPosition, this.sonSens)!=null)){
			System.out.println("--------Capteur de Presence--------");
			System.out.println("La voiture " + this.sonMorceauRoute.getVoiture(this.saPosition, this.sonSens).getIdentifiant() + " a ete detectee.");
			return true;
		}
		return false;
	}
 }
