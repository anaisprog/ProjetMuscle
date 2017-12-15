package muscletp;


public class JonctionSimple extends Jonction
{

	
	public JonctionSimple(ElementRegulation er, ReseauRoutier r,SegmentRoute s1, SegmentRoute s2, boolean avecFeux)
	{
		super(avecFeux,er,r,s1,s2);
		this.type = "JSimple";

	}
	
	public JonctionSimple(ReseauRoutier r,SegmentRoute s1, SegmentRoute s2, boolean avecFeux)
	{
		super(r,s1,s2);
		this.type = "JSimple";

	}

	
	@Override
	public void ajouterSemaphore()
	{
		//On crée les feux
		FeuxTricolore f1 = new FeuxTricolore();
		
		//On renseigne le segment au feux
		f1.setSegment(this.sesSegments.get(0));
		
		//On renseigne son orientation
		f1.sens = 1;
		f1.setCouleurActuelle(Couleur.VERT);
		
		//On renseigne leur jonction
		f1.jonctionRegulees.add(this);
		
		//On renseigne au segment leur feux
		this.sesSegments.get(0).sesSemaphores.add(f1);
		this.getSesSemaphores().add(f1);
		this.getR().getSesSemaphores().add(f1);
	}
}
