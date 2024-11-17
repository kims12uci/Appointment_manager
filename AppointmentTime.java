package labs.lab6;

/**
 * Represents a time for an appointment
 */
public class AppointmentTime {

	private int hour;
	private int min;

	/**
	 * 
	 * @param t	the string from which to construct the AppointmentTime object
	 * 
	 * Expected format: HH:MM or H:MM
	 * 
	 * @throws RuntimeException with the message "Invalid time" if invalid input format 
	 * or time doesn't exist
	 */
	public AppointmentTime(String t) throws RuntimeException {
		if (t.isBlank()) {
			throw new RuntimeException("Invalid time");
		}
		String[] ts = t.split(":");
		
		if (ts.length != 2) {
			throw new RuntimeException("Invalid time");
		}
		
		hour = Integer.valueOf(ts[0]);
		min = Integer.valueOf(ts[1]);
		
		if (hour < 0 || hour > 23 || min < 0 || min > 59) {
			throw new RuntimeException("Invalid time");
		}
		
	}


	/**
	 * Determines if the appointment times are equal.
	 * 
	 * @param other the other time
	 * @return true if the appointment times are equal, false otherwise
	 */
	public boolean equals(Object other) {
		AppointmentTime oth = (AppointmentTime) other;
		if (this.hour == oth.hour && this.min == oth.min) {
			return true;
		}
		return false;
	}


	/**
	 * Prints a string representation of the time in the format HH:MM
	 * 
	 * @return the time
	 */
	public String toString() {
		String h = String.valueOf(hour);
		if (hour < 10) {
			h = "0" + h;
		}
		String m = String.valueOf(min);
		if (min < 10) {
			m = "0" + m;
		}
		return h + ":" + m;
	}

}
