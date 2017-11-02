import java.util.LinkedList;

public class Runway {
	public int ID;
	public Plane LastPlane;
	
	public Runway() {
		LastPlane = null;
	}
	
	public void takeNext(LinkedList<Plane> Queue) {
		LastPlane = Queue.poll();
		
	}

}
