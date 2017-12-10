package muscletp;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Semaphore {
	
	//A voir  peut etre de la g�n�ricit� � ce niveau ou avec element de r�gulation...
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
