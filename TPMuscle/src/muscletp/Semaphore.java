package muscletp;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Semaphore {
	
	//A voir  peut etre de la g�n�ricit� � ce niveau ou avec element de r�gulation...
	Collection<Jonction> jonctionRegulees = new ArrayList<Jonction>();
	private SegmentRoute segment;
	private int position;
	protected String type;
	protected int sens;
	
	public Collection<Jonction> getJonctionRegulees() {
		return jonctionRegulees;
	}
	
	public SegmentRoute getSegment() {
		return segment;
	}
	
	public int getPosition() {
		return position;
	}
	public String getType() {
		return type;
	}

	public int getSens() {
		return sens;
	}

	public void setSens(int sens) {
		this.sens = sens;
	}
	
	
}
