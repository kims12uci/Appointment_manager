package labs.lab6;

/**
 * Represents an appointment. An appointment An appointment consists of a description, 
 * the date, starting time, and ending time; for example:
 * 
 * Dentist 2019/10/1 17:30 18:30
 * 45J Class 2019/10/02 8:30 10:00
 */
public class Appointment {

	private String description;
	private AppointmentDate day;
	private AppointmentTime startTime;
	private AppointmentTime endTime;


	/**
	 * 
	 * @param s	the string from which to construct the Appointment object
	 * 
	 * Expected format: Description Date StartTime EndTime
	 * 
	 * Date in YYYY/MM/DD format
	 * Times in military format (no AM/PM)
	 * Assume description will never be empty, nor consist of only whitespace
	 * Assume start time time will always come before end time
	 * 
	 * @throws RuntimeException if invalid input format
	 */
	public Appointment(String s) throws RuntimeException {
		String[] spl = s.split(" ");
		description = spl[0];
		if (spl.length > 5) {
			for (int i = 1; i < spl.length - 3; i++) {
				description += " " + spl[i];
			}
		}
		
		day = new AppointmentDate(spl[spl.length - 3]);
		startTime = new AppointmentTime(spl[spl.length - 2]);
		endTime = new AppointmentTime(spl[spl.length - 1]);
		
	}


	/**
	 * Determines if this appointment is the same as another appointment.
	 * 
	 * @param other the other appointment
	 * @return true if the appointments are equal, false otherwise
	 */
	public boolean equals(Object other) {
		Appointment oth = (Appointment) other;
		if (this.description.equals(oth.description) && this.day.equals(oth.day) && this.startTime.equals(oth.startTime) && this.endTime.equals(oth.endTime)) {
			return true;
		}
		return false;
	}


	/**
	 * Determines if an appointment falls on a certain day.
	 * 
	 * @param d the appointment date
	 * @return true if the appointment date falls on the date, false otherwise
	 */
	public boolean fallsOn(AppointmentDate d) {
		return day.equals(d);
	}


	/**
	 * Return a string representation in the format:
	 * Description Date StartTime EndTime
	 */
	public String toString() {
		return description + " " + day.toString() + " " + startTime.toString() + " " + endTime.toString();
	}

}
