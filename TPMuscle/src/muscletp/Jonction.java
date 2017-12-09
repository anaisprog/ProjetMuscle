package muscletp;

import java.util.ArrayList;

public abstract class Jonction extends MorceauRoute {
	
	protected ArrayList<SegmentRoute> sesSegments;
	protected static int ID = 1;
	protected int id;
	
	//Bloc d'initialisation
	{
		sesSegments = new ArrayList<SegmentRoute>();
	}
	
	public Jonction ()
	{
		this.id = ID;
		ID++;
	}
	public Jonction (int id)
	{
		this.id = id;

	}

	public ArrayList<SegmentRoute> getSesSegments() {
		return sesSegments;
	}

	public void setSesSegments(ArrayList<SegmentRoute> sesSegments) {
		this.sesSegments = sesSegments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	

}
