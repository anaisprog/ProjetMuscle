package muscletp;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class VoitureTest {

	@Test
	public void test() throws ClassNotFoundException {
//		fail("Not yet implemented");
		Voiture v = new Voiture();
		ReseauRoutier r = new ReseauRoutier();
		FeuxTricolore s = new FeuxTricolore();
		SegmentRoute segment = new SegmentRoute();
		ArrayList<MorceauRoute> segments = new ArrayList<>();
		ArrayList<Semaphore> semaphores = new ArrayList<>();
		semaphores.add(s);
		segments.add(segment);
		r.setSesRoutes(segments);
		r.getSesRoutes().get(0).setSesSemaphores(semaphores);
		System.out.println(r.getSesRoutes().get(0).getSesSemaphores());
		v.setReseau(r);
		v.setMorceauRoute(segment);
		v.calculeVitesseActuelle();
	}

}
