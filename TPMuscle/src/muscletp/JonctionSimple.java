package muscletp;


public class JonctionSimple extends Jonction
{
	private SegmentRoute sOuest; 
	private SegmentRoute sEst;
	// ou alors un tableau de deux elements? 
	
	public JonctionSimple(SegmentRoute s1, SegmentRoute s2, boolean avecFeux)
	{
		super(s1,s2);
		this.sOuest = s1;
		this.sEst = s2;
		this.type = "JSimple";
		if(avecFeux)
		{
			this.ajouterSemaphore();
		}
	}
	
	public JonctionSimple(SegmentRoute s1, SegmentRoute s2, int id, boolean avecFeux)
	{
		super(id,s1,s2);
		this.sOuest = s1;
		this.sEst = s2;
		this.type = "JSimple";
		if(avecFeux)
		{
			this.ajouterSemaphore();
		}
	}
}
