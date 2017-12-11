package muscletp;

import java.util.ArrayList;

public class Voie {
	
	private Voiture[] voitures ;
	private String type;
	private SegmentRoute sonSegment;
	
	public Voie(String type, SegmentRoute s)
	{
		this.type = type;
		this.sonSegment =s;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Voiture[] getVoitures() {
		return voitures;
	}

	public void setVoitures(Voiture[] voitures) {
		this.voitures = voitures;
	}

	public void addVoiture(Voiture v, int pos) {
		this.voitures[pos]= v;
	}
	


	
	
	
}
