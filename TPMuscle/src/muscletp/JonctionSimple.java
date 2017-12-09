package muscletp;


public class JonctionSimple extends Jonction
{
	private SegmentRoute sOuest; 
	private SegmentRoute sEst;
	// ou alors un tableau de deux elements? 
	
	
	public JonctionSimple(SegmentRoute s1, SegmentRoute s2)
	{
		super();
		this.sOuest = s1;
		this.sEst = s2;
		this.type = "JSimple";
	}
	
	public JonctionSimple(SegmentRoute s1, SegmentRoute s2, int id)
	{
		super(id);
		this.sOuest = s1;
		this.sEst = s2;
		this.type = "JSimple";
	}

	@Override
	public void register(Observer o) 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void unregister(Observer o) 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void notifyObserver() 
	{
		// TODO Auto-generated method stub
	}
	
}
