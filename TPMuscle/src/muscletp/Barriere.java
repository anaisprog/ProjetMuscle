package muscletp;

public class Barriere extends Jonction{
	
	private SegmentRoute s1;
	
	public Barriere(ReseauRoutier r,SegmentRoute s)
	{
		super(r,s);
		this.s1 = s;
		this.type = "Barriere";
		this.nbSemaphore = 0;
		this.id = ID;
		ID++;
	}
	
	public SegmentRoute getS1() {
		return s1;
	}

	public void setS1(SegmentRoute s1) {
		this.s1 = s1;
	}
	
	@Override
	public void ajouterSemaphore()
	{
		
	}
}