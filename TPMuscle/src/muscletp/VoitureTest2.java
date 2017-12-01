package muscletp;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class VoitureTest2 {

	@Test
	public void test() {
		 //Test pour classe voiture   
		Voiture v = new Voiture();
		EtatCourant e = new EtatCourant();
		e.setVitesseCourante(566);
		v.setEtatCourant(e);
		v.setVitesseMax(78);
		ReseauRoutier r = new ReseauRoutier();
		FeuxTricolore s = new FeuxTricolore();
		FeuxTricolore s2 = new FeuxTricolore();
		PanneauLimitation pl = new PanneauLimitation();
		s.attribueCouleurOrange();
		s2.attribueCouleurVerte();
		SegmentRoute segment = new SegmentRoute();
		ArrayList<MorceauRoute> segments = new ArrayList<>();
		ArrayList<Semaphore> semaphores = new ArrayList<>();
		//semaphores.add(s);
		semaphores.add(s2);
		semaphores.add(pl);
		pl.setLimitation(45);
		segments.add(segment);
		r.setSesRoutes(segments);
		r.getSesRoutes().get(0).setSesSemaphores(semaphores);
		//System.out.println(r.getSesRoutes().get(0).getSesSemaphores());
		v.setReseau(r);
		v.setMorceauRoute(segment);
		v.calculeVitesseActuelle();
		//System.out.println(v.calculeVitesseActuelle());
	}
}
