package assignment6;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
			Map<String, Integer> office  = new HashMap<String, Integer>();
			office.put("BX1", 15);
			office.put("BX3", 15);
		
			Theater theater = new Theater(50, 1, "Ouija");
			BookingClient start = new BookingClient(office, theater);
			start.simulate();
		
	}

}
