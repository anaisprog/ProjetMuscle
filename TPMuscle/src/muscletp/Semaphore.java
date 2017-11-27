package muscletp;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Semaphore {
	
	//A voir  peut etre de la généricité à ce niveau ou avec element de régulation...
	Collection<Jonction> jonctionRegulees = new ArrayList<Jonction>();
	private SegmentRoute segment;
	private PositionSegment position;
	protected String type;
	
	public Collection<Jonction> getJonctionRegulees() {
		return jonctionRegulees;
	}
	
	public SegmentRoute getSegment() {
		return segment;
	}
	
	public PositionSegment getPosition() {
		return position;
	}
	public String getType() {
		return type;
	}
}
