package muscletp;

public class CapteurPresence extends Capteur {

	
	public CapteurPresence(ElementRegulation sonElementRegulation, MorceauRoute sonMorceauRoute, int sonSens, int saPosition) 
	{
		super(sonElementRegulation, sonMorceauRoute, sonSens, saPosition);
		this.type = "Presence";
	}
	
	//renvoie true si une voiture a ete detectee sur le morceauRoute
	
	@Override
	public boolean detecteVoiture()
	{
		if((this.sonMorceauRoute.getVoiture(this.saPosition, this.sonSens)!=null))
		{
			System.out.println("\n--------Capteur de Presence--------");
			System.out.println("La voiture " + this.sonMorceauRoute.getVoiture(this.saPosition, this.sonSens).getIdentifiant() + " a ete detectee.");
			System.out.println("------------------------------");
			return true;
		}
		return false;
	}

 }
