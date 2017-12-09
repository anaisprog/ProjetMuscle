package muscletp;

import java.util.ArrayList;

public class Voie {
	
	protected ArrayList<Voiture> voitures = new ArrayList<Voiture>();
	protected String type;
	
	
	public Voie(String type)
	{
		this.type = type;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ArrayList<Voiture> getVoitures() {
		return voitures;
	}

	public void setVoitures(ArrayList<Voiture> voitures) {
		this.voitures = voitures;
	}

	public void addVoiture(Voiture v) {
		this.getVoitures().add(v);
	}
	


	
	
	
}
