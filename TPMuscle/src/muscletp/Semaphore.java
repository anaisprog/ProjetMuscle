package muscletp;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Semaphore {

	Collection<Jonction> jonctionRegulees = new ArrayList<Jonction>();
	protected SegmentRoute segment;
	protected String type;
	protected int sens;
	
	public Collection<Jonction> getJonctionRegulees() {
		return jonctionRegulees;
	}
	
	public SegmentRoute getSegment() {
		return segment;
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

	public void setSegment(SegmentRoute segment) {
		this.segment = segment;
	}

}
