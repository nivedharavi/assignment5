// insert header here
package assignment6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Theater {
	/*
	 * Represents a seat in the theater
	 * A1, A2, A3, ... B1, B2, B3 ...
	 */
	static class Seat {
		private int rowNum;
		private int seatNum;
		private boolean flag;
		public int client;

		public Seat(int rowNum, int seatNum) {
			this.rowNum = rowNum;
			this.seatNum = seatNum;
			this.flag = false;
			this.client = 0;
		}

		public int getSeatNum() {
			return seatNum;
		}

		public int getRowNum() {
			return rowNum;
		}

		@Override
		public String toString() {
			int row = rowNum;
			String reverse;
			char let;
			String result = "";
			if (rowNum<=26) {
			//	System.out.println(rowNum);
				int numrow = (rowNum+64);
				char namerow = (char)numrow;
				reverse =  namerow+Integer.toString(seatNum);
			}
			else {
				while (row > 0) {
					int remainder = row % 26;
					if (remainder == 0) {
						let = 'Z';
						row = (row / 26) - 1; 
					} else {
						let = (char) ((remainder - 1) + 65);
						row = row / 26; 
					}
					result = result.concat(String.valueOf(let));
					
				}

				result = new StringBuffer(result).reverse().toString();
				reverse = result+Integer.toString(seatNum);
			}
						return reverse;
		}
	}

  /*
	 * Represents a ticket purchased by a client
	 */
	static class Ticket {
		private String show;
		private String boxOfficeId;
		private Seat seat;
	  private int client;

		public Ticket(String show, String boxOfficeId, Seat seat, int client) {
			this.show = show;
			this.boxOfficeId = boxOfficeId;
			this.seat = seat;
			this.client = client;
		}

		public Seat getSeat() {
			return seat;
		}

		public String getShow() {
			return show;
		}

		public String getBoxOfficeId() {
			return boxOfficeId;
		}

		public int getClient() {
			return client;
		}

		@Override
		public String toString() {
			 int showlength = show.length();
			 String showspace = "";
			 for (int i= 0; i <22-showlength;i++) {
				 showspace = showspace + " ";
			 }
			 
			 int boxid = boxOfficeId.length();
			 String boxspace = "";
			 for (int i =0; i<13-boxid; i++) {
				 boxspace = boxspace+" ";
			 }
			 
			 int seatlength = seat.toString().length();
			 String seatspace = "";
			 for (int i =0; i<22-seatlength;i++) {
				 seatspace = seatspace+" ";
			 }
			 
			 String cl = Integer.toString(client);
			 int length = cl.length();
			 String clspace = "";
			 for (int i =0 ; i<20-length; i++) {
				 clspace = clspace + " ";
			 }
			 
			 String output  = "-------------------------------\n" +
			 "| Show: " + show + showspace+"|\n"+
			"| Box Office Id: " + boxOfficeId +boxspace + "|\n"+
			 "| Seat: " + seat.toString()+seatspace+"|\n"+
			"| Client: " + Integer.toString(client)+  clspace+"|\n"+
			 "-------------------------------\n";
			 
			 return output;
		}
	}


private HashMap <Integer, ArrayList<Seat>> theatermap;
private int rownum;
private int seatnum;
public int totseats;
private String showname;
private List<Ticket> log;
public int client1;


	public Theater(int numRows, int seatsPerRow, String show) {
		//System.out.println(, seatsPerRow);
		this.rownum = numRows;
		this.seatnum= seatsPerRow;
		this.theatermap = new HashMap <Integer, ArrayList<Seat>>();
		this.showname = show;
		this.client1= 0;
		this.log = new ArrayList<Ticket>();
		//create a theater that indicates which seats are filled and which arent
		for (int i =1 ; i<=rownum; i++) {
			
			ArrayList<Seat> seatmap = new ArrayList<Seat>();
			for (int j =1 ; j<=seatnum; j++) {
				Seat addseat = new Seat(i,j);
				
				seatmap.add(addseat);
			}
			theatermap.put(Integer.valueOf(i),seatmap);
			
		}
		// TODO: Implement this constructor
	}

	/*
	 * Calculates the best seat not yet reserved
	 *
 	 * @return the best seat or null if theater is full
   */
	public Seat bestAvailableSeat() {
	for (ArrayList<Seat> seerows: theatermap.values()) {
		for(Seat find: seerows) {
			
			if (find.flag==true) {
				continue;
			}
			else {
				find.flag=true;
				client1++;
				find.client = client1;
				return find;
			}
		}
	}
	//seatStatus.set(true);
	return null;
	}
	private boolean printer = false;

	/*
	 * Prints a ticket for the client after they reserve a seat
   * Also prints the ticket to the console
	 *
   * @param seat a particular seat in the theater
   * @return a ticket or null if a box office failed to reserve the seat
   */
	public Ticket printTicket(String boxOfficeId, Seat seat, int client) {
		if (seat == null &&printer==false) {
			this.printer=true;
			System.out.println("Sorry, we are all sold out!");
			//printer = true;
			return null;
		}
		if (seat == null) {
			return null;
		}
		
		Ticket newtick = new Ticket(showname,boxOfficeId, seat,client);
		System.out.print(newtick.toString());
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		log.add(newtick);
		return newtick;
		
	}

	/*
	 * Lists all tickets sold for this theater in order of purchase
	 *
   * @return list of tickets sold
   */
	public List<Ticket> getTransactionLog() {
		return log;
	}
	
	
}
