package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	/**
	 * @return the roomNumber
	 */
	public Integer getRoomNumber() {
		return roomNumber;
	}
	/**
	 * @param roomNumber the roomNumber to set
	 */
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	/**
	 * @return the checkIn
	 */
	public Date getCheckIn() {
		return checkIn;
	}
	/**
	 * @param checkIn the checkIn to set
	 */
	
	/**
	 * @return the checkOut
	 */
	public Date getCheckOut() {
		return checkOut;
	}
	/**
	 * @param checkOut the checkOut to set
	 */
	public long duration() {
		long diff = checkOut.getTime()-checkIn.getTime();
		return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
	}
	public String updateDate(Date checkIn, Date checkOut) {
		
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) {
			return "Error in reservation: Reservation dates for update must be future dates";
		}
		if(!checkOut.after(checkIn)){
			return "Check-out date must be after check-in date";
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
		return null;
	}
	@Override
	public String toString() {
		return "Room:"
				+ roomNumber 
				+ ", checkIn=" 
				+ sdf.format(checkIn)
				+ ", checkOut=" 
				+ sdf.format(checkOut)
				+", "
				+ duration()
				+ " nights";
	}
	
	
}
