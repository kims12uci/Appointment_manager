package labs.lab6;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a calendar that manages appointments
 */
public class AppointmentCalendar {

	private ArrayList<Appointment> aps;


	public AppointmentCalendar() {
		aps = new ArrayList<Appointment>();
	}


	/**
	 * Adds an appointment to the calendar.
	 * 
	 * @param a the appointment to add
	 */
	public void add(Appointment a) {
		aps.add(a);
	}


	/**
	 * Cancels (removes) an appointment from the calendar.
	 * 
	 * @param a the appointment to cancel
	 */
	public void cancel(Appointment a) {
		aps.remove(a);
	}


	/**
	 * Gets all appointments for a certain date.
	 * 
	 * @param d the date
	 * @return the appointments for that day
	 */
	public List<Appointment> getAppointmentsForDay(AppointmentDate d) {
		ArrayList<Appointment> val = new ArrayList<Appointment>();
		for (Appointment a : aps) {
			if (a.fallsOn(d)) {
				val.add(a);
			}
		}
		
		return val;
	}
}
