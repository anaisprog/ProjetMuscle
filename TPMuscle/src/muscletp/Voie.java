package muscletp;

import java.util.ArrayList;

public abstract class Voie {

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	protected ArrayList<Voiture> voitures = new ArrayList<Voiture>();
	protected String type;

	public ArrayList<Voiture> getVoitures() {
		return voitures;
	}

	public void setVoitures(ArrayList<Voiture> voitures) {
		this.voitures = voitures;
	}

	public void addVoiture(Voiture v) {
		// TODO Auto-generated method stub
		this.getVoitures().add(v);
	}
	
	
	
}
