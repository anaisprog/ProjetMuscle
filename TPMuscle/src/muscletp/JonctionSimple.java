package muscletp;


public class JonctionSimple extends Jonction{
	private SegmentRoute s1; 
	private SegmentRoute s2;
	// ou alors un tableau de deux elements? 
	
	
	public JonctionSimple()
	{
		this.nbSegmentPossible = 2;
		this.type = "JSimple";
	}


	@Override
	public void register(Observer o) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void unregister(Observer o) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		
	}
}
