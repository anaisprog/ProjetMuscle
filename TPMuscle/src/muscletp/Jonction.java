package muscletp;

import java.util.ArrayList;

public abstract class Jonction extends MorceauRoute {
	
	protected ArrayList<SegmentRoute> sesSegments;
	protected static int ID = 1;
	protected int id;
	protected int nbSemaphore;
	
	//Bloc d'initialisation
	{
		sesSegments = new ArrayList<SegmentRoute>();
	}
	
	public Jonction (SegmentRoute...segmentRoutes)
	{
		for(SegmentRoute s : segmentRoutes)
		{
			this.sesSegments.add(s);
		}
		this.id = ID;
		ID++;
		this.nbSemaphore = segmentRoutes.length;
	}
	public Jonction (int id, SegmentRoute...segmentRoutes)
	{
		for(SegmentRoute s : segmentRoutes)
		{
			this.sesSegments.add(s);
		}
		this.id = id;
		this.nbSemaphore = segmentRoutes.length;

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
	
	public void ajouterSemaphore()
	{
		//Dans ce cas-ci on a besoin de deux feux, sur les deux segments qui se font face, 
		//un dans chaque sens
		if(this.type.equals("JSimple"))
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
			
			//System.out.println("La jonction simple n°" +this.id + " dispose d'un feux tricolore sur le segment : "+this.sesSegments.get(0).getId()+"\n");
			
		}
		else if(this.type.equals("Carrefour")&&(this.nbSemaphore ==4))
		{
			FeuxTricolore f1 = new FeuxTricolore();
			FeuxTricolore f2 = new FeuxTricolore();
			FeuxTricolore f3 = new FeuxTricolore();
			FeuxTricolore f4 = new FeuxTricolore();
			
			f1.setSegment(this.sesSegments.get(0));
			f2.setSegment(this.sesSegments.get(1));
			f3.setSegment(this.sesSegments.get(2));
			f4.setSegment(this.sesSegments.get(3));
			
			f1.sens = 1;
			f1.setCouleurActuelle(Couleur.VERT);
			f2.sens = -1;
			f2.setCouleurActuelle(Couleur.VERT);
			f3.sens = -1;
			f3.setCouleurActuelle(Couleur.ROUGE);
			f4.sens = 1;
			f4.setCouleurActuelle(Couleur.ROUGE);
			
			f1.jonctionRegulees.add(this);
			f2.jonctionRegulees.add(this);
			f3.jonctionRegulees.add(this);
			f4.jonctionRegulees.add(this);
			
			this.sesSegments.get(0).sesSemaphores.add(f1);
			this.sesSegments.get(1).sesSemaphores.add(f2);
			this.sesSegments.get(2).sesSemaphores.add(f3);
			this.sesSegments.get(3).sesSemaphores.add(f4);
			
			//System.out.println("Le carrefour à 4 segments n°" +this.id + " dispose de quatre feux tricolore sur les segments : "+this.sesSegments.get(0).getId()+" , "+ this.sesSegments.get(1).getId()+" , "+this.sesSegments.get(2).getId()+" , "+this.sesSegments.get(3).getId()+"\n");
			
		}
		
		else if(this.type.equals("Carrefour")&&(this.nbSemaphore ==3))
		{
			FeuxTricolore f1 = new FeuxTricolore();
			FeuxTricolore f2 = new FeuxTricolore();
			FeuxTricolore f3 = new FeuxTricolore();
			
			f1.setSegment(this.sesSegments.get(0));
			f2.setSegment(this.sesSegments.get(1));
			f3.setSegment(this.sesSegments.get(2));

			f1.sens = -1;
			f1.setCouleurActuelle(Couleur.VERT);
			f2.sens = 1;
			f2.setCouleurActuelle(Couleur.VERT);
			f3.sens = 1;
			f3.setCouleurActuelle(Couleur.VERT);

			
			f1.jonctionRegulees.add(this);
			f2.jonctionRegulees.add(this);
			f3.jonctionRegulees.add(this);
			
			this.sesSegments.get(0).sesSemaphores.add(f1);
			this.sesSegments.get(1).sesSemaphores.add(f2);
			this.sesSegments.get(2).sesSemaphores.add(f3);
			
			//System.out.println("Le carrefour à 3 segments n°" +this.id + " dispose de trois feux tricolore sur les segments : "+this.sesSegments.get(0).getId()+" , "+ this.sesSegments.get(1).getId()+" , "+this.sesSegments.get(2).getId()+"\n");

		}
		
	}
	
	
	
	

}
