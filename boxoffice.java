package assignment6;	
public class boxoffice implements Runnable {
		private String boxname;
		private Integer numpeople;
		private  static Object syncObject= new Object();
		Theater theater;
		boxoffice(String box, Integer num, Theater theater){
			this.boxname = box;
			this.numpeople = num;
			this.theater = theater;
		}
			@Override
			public  void run() {
				for (int x = 0; x<numpeople; x++) {
					synchronized (syncObject){
						 
						Theater.Seat getseat = theater.bestAvailableSeat();
						theater.printTicket(boxname, getseat, theater.client1);
					
				}
				}	
			}

		}
	