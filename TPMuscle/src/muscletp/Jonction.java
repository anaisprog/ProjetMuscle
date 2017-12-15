package muscletp;

import java.util.ArrayList;

public abstract class Jonction extends MorceauRoute {
	
	protected ArrayList<SegmentRoute> sesSegments;
	protected static int ID = 1;
	protected int id;
	protected int nbSemaphore;
	protected ArrayList<Semaphore> sesSemaphores;
	protected ElementRegulation saRegulation;
	protected ReseauRoutier r;
	
	//Bloc d'initialisation
	{
		sesSegments = new ArrayList<SegmentRoute>();
		sesSemaphores = new ArrayList<Semaphore>();
	}
	
	public Jonction (ReseauRoutier r,SegmentRoute...segmentRoutes)
	{
		for(SegmentRoute s : segmentRoutes)
		{
			this.sesSegments.add(s);
		}
		this.id = ID;
		ID++;
		this.nbSemaphore = segmentRoutes.length;
		this.r = r;
		r.getListeJonctions().add(this);
		r.getSesRoutes().add(this);
		
	}
	
	public Jonction (boolean avecFeux,ElementRegulation er, ReseauRoutier r,SegmentRoute...segmentRoutes)
	{
		for(SegmentRoute s : segmentRoutes)
		{
			this.sesSegments.add(s);
		}
		this.id = ID;
		ID++;
		this.nbSemaphore = segmentRoutes.length;
		r.getListeJonctions().add(this);
		r.getSesRoutes().add(this);
		this.r = r;
		this.saRegulation = er;
		if(avecFeux)
		{
			this.ajouterSemaphore();
		}
		
		for(Semaphore s : this.getSesSemaphores())
		{
			er.getSesSemaphores().add(s);
		}
		
	}
	
	public Jonction (ElementRegulation er, ReseauRoutier r,SegmentRoute...segmentRoutes)
	{
		for(SegmentRoute s : segmentRoutes)
		{
			this.sesSegments.add(s);
		}
		this.id = ID;
		ID++;
		this.nbSemaphore = segmentRoutes.length;
		r.getListeJonctions().add(this);
		r.getSesRoutes().add(this);
		this.r = r;
		this.saRegulation = er;
		
		for(Semaphore s : this.getSesSemaphores())
		{
			er.getSesSemaphores().add(s);
		}
		
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
	
	
	public ReseauRoutier getR() {
		return r;
	}

	public void setR(ReseauRoutier r) {
		this.r = r;
	}

	public abstract void ajouterSemaphore();
	
	
	
	

}
