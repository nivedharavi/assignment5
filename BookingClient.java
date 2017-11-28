// Insert header here

package assignment6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.Thread;

public class BookingClient {
  /*
   * @param office maps box office id to number of customers in line
   * @param theater the theater where the show is playing
   */
	private Map<String, Integer> office;
	Theater theater;
	
  public BookingClient(Map<String, Integer> office, Theater theater) {
	  this.office = office; 
	  this.theater= theater;
	  
    // TODO: Implement this constructor
  }

  /*
   * Starts the box office simulation by creating (and starting) threads
   * for each box office to sell tickets for the given theater
   *
   * @return list of threads used in the simulation,
   *         should have as many threads as there are box offices
   */
	public List<Thread> simulate() {
		
		List<Thread> allboxoffice = new ArrayList<Thread>();
		
		for (String boxname: office.keySet()) {
			boxoffice check = new boxoffice(boxname, office.get(boxname), theater);
			Thread newthread = new Thread(check, boxname);
			allboxoffice.add(newthread);
			newthread.start();
		}
		//can i set psuedocode here? or in the run of the thread?
		
		return allboxoffice;
		//TODO: Implement this method
	}

	
}
