package muscletp;



public class Carrefour extends Jonction {
	// Cette m�thode permettra de choisir al�atoirement le segment sur lequel la voiture continuera
	
	/**
	 * Ce constructeur va nous permettre de construire des carrefour à 3, 4... segments
	 */
	public Carrefour (ElementRegulation er, ReseauRoutier r,SegmentRoute...segments)
	{
		super(er, r,segments);
		this.type = "Carrefour";
		this.ajouterSemaphore();
	
	}
	
	public Carrefour (ReseauRoutier r,SegmentRoute...segments)
	{
		super(r,segments);
		this.type = "Carrefour";
		this.ajouterSemaphore();
	
	}
	
	
	@Override
	public void ajouterSemaphore()
	{
		if(nbSemaphore == 4)
		{
			FeuxTricolore f1 = new FeuxTricolore();
			FeuxTricolore f2 = new FeuxTricolore();
			FeuxTricolore f3 = new FeuxTricolore();
			FeuxTricolore f4 = new FeuxTricolore();
			
			f1.setSegment(this.sesSegments.get(0));
			f2.setSegment(this.sesSegments.get(1));
			f3.setSegment(this.sesSegments.get(2));
			f4.setSegment(this.sesSegments.get(3));
			
			this.sesSemaphores.add(f1);
			this.sesSemaphores.add(f2);
			this.sesSemaphores.add(f3);
			this.sesSemaphores.add(f4);
			
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
			
			this.getR().getSesSemaphores().add(f1);
			this.getR().getSesSemaphores().add(f2);
			this.getR().getSesSemaphores().add(f3);
			this.getR().getSesSemaphores().add(f4);
			
			this.sesSegments.get(0).sesSemaphores.add(f1);
			this.sesSegments.get(1).sesSemaphores.add(f2);
			this.sesSegments.get(2).sesSemaphores.add(f3);
			this.sesSegments.get(3).sesSemaphores.add(f4);
		}
		
		else if(nbSemaphore == 3)
		{
			FeuxTricolore f1 = new FeuxTricolore();
			FeuxTricolore f2 = new FeuxTricolore();
			FeuxTricolore f3 = new FeuxTricolore();
			
			f1.setSegment(this.sesSegments.get(0));
			f2.setSegment(this.sesSegments.get(1));
			f3.setSegment(this.sesSegments.get(2));
			
			this.sesSemaphores.add(f1);
			this.sesSemaphores.add(f2);
			this.sesSemaphores.add(f3);

			f1.sens = -1;
			f1.setCouleurActuelle(Couleur.VERT);
			f2.sens = 1;
			f2.setCouleurActuelle(Couleur.VERT);
			f3.sens = 1;
			f3.setCouleurActuelle(Couleur.VERT);

			
			f1.jonctionRegulees.add(this);
			f2.jonctionRegulees.add(this);
			f3.jonctionRegulees.add(this);
			
			this.getR().getSesSemaphores().add(f1);
			this.getR().getSesSemaphores().add(f2);
			this.getR().getSesSemaphores().add(f3);
			
			this.sesSegments.get(0).sesSemaphores.add(f1);
			this.sesSegments.get(1).sesSemaphores.add(f2);
			this.sesSegments.get(2).sesSemaphores.add(f3);
		}

		
	}
	
	
}