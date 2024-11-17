package labs.lab6;

/**
 * Represents a date for an appointment
 */
public class AppointmentDate {

	private int year;
	private int month;
	private int day;

	/**
	 * 
	 * @param s	the string from which to construct the AppointmentDate object
	 * 
	 * Expected format: YYYY/MM/DD
	 * 
	 * @throws RuntimeException with the message "Invalid date" if invalid input 
	 * format or date doesn't exist
	 */
	public AppointmentDate(String d) throws RuntimeException {
		if (d.isBlank()) {
			throw new RuntimeException("Invalid date");
		}
		
		String[] ds = d.split("/");
		if (ds.length != 3) {
			throw new RuntimeException("Invalid date");
		}
		
		year = Integer.valueOf(ds[0]);
		month = Integer.valueOf(ds[1]);
		day = Integer.valueOf(ds[2]);
		
		if (year < 0 || month < 0 || month > 12 || day < 0 || day > 31 || year > 9999) {
			throw new RuntimeException("Invalid date");
		}
		
		if (day > 30) {
			if (month == 2 || month == 4 || month == 6 || month == 9 || month == 11) {
				throw new RuntimeException("Invalid date");
			}
		}
		
		if (month == 2) {
			if (year % 4 == 0) {
				if (day > 29) {
					throw new RuntimeException("Invalid date");
				}
			} else {
				if (day > 28) {
					throw new RuntimeException("Invalid date");
				}
			}
		}
	}


	/**
	 * Determines if dates are equal.
	 * 
	 * @param the other date
	 * @return true if the dates are equal, false otherwise
	 */
	public boolean equals(Object other) {
		AppointmentDate oth = (AppointmentDate) other;
		if (this.year == oth.year && this.month == oth.month && this.day == oth.day) {
			return true;
		}
		return false;
	}


	/**
	 * Prints a string representation of the date in the format YYYY/MM/DD
	 * 
	 * @return the date
	 */
	public String toString() {
		String y = String.valueOf(year);
		for (int i = 4 - y.length(); i > 0; i --) {
			y = "0" + y;
		}
		
		String m = String.valueOf(month);
		if (month < 10) {
			m = "0" + m;
		}
		String d = String.valueOf(day);
		if (day < 10) {
			d = "0" + d;
		}
		return y + "/" + m + "/" + d;
	}
}
