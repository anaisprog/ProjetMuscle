package muscletp;

public class Barriere extends Jonction{
	
	private SegmentRoute s1;
	
	public Barriere(SegmentRoute s)
	{
		super();
		this.s1 = s;
		this.type = "Barriere";
		this.id = ID;
		ID++;
	}
	
	public Barriere(SegmentRoute s, int id)
	{
		super(id);
		this.s1 = s;
		this.type = "Barriere";
	}

	public SegmentRoute getS1() {
		return s1;
	}

	public void setS1(SegmentRoute s1) {
		this.s1 = s1;
	}
}