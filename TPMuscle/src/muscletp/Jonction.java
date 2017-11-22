package muscletp;

import java.util.ArrayList;

public abstract class Jonction extends MorceauRoute {
	
	protected int nbSegmentPossible;
	private ArrayList<SegmentRoute> sesSegments;
	
	//Bloc d'initialisation
	
	{
		sesSegments = new ArrayList<SegmentRoute>();
	}
	
	public Jonction ()
	{
		this.type = "Jonction";
	}

}
